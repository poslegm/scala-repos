/*
Copyright 2014 Twitter, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.twitter.scalding

import com.twitter.algebird.monad.Reader
import com.twitter.algebird.{Monoid, Monad, Semigroup}
import com.twitter.scalding.cascading_interop.FlowListenerPromise
import com.twitter.scalding.Dsl.flowDefToRichFlowDef
import java.util.concurrent.LinkedBlockingQueue
import scala.concurrent.{
  Await,
  Future,
  ExecutionContext => ConcurrentExecutionContext,
  Promise
}
import scala.util.{Failure, Success, Try}
import scala.util.control.NonFatal
import cascading.flow.{FlowDef, Flow}
import scala.collection.mutable

/**
  * Execution[T] represents and computation that can be run and
  * will produce a value T and keep track of counters incremented
  * inside of TypedPipes using a Stat.
  *
  * Execution[T] is the recommended way to compose multistep computations
  * that involve branching (if/then), intermediate calls to remote
  * services, file operations, or looping (e.g. testing for convergence).
  *
  * Library functions are encouraged to implement functions from
  * TypedPipes or ValuePipes to Execution[R] for some result R.
  * Refrain from calling run in library code. Let the caller
  * of your library call run.
  *
  * Note this is a Monad, meaning flatMap composes in series as you expect.
  * It is also an applicative functor, which means zip (called join
  * in some libraries) composes two Executions is parallel. Prefer
  * zip to flatMap if you want to run two Executions in parallel.
  */
sealed trait Execution[+T] extends java.io.Serializable {
  import Execution.{
    EvalCache,
    FlatMapped,
    GetCounters,
    ResetCounters,
    Mapped,
    OnComplete,
    RecoverWith,
    Zipped
  }

  /**
    * Lift an Execution into a Try
    *
    * When this function is called the Execution should never be failed
    * instead only the Try.
    */
  def liftToTry: Execution[Try[T]] =
    map(e => Success(e)).recoverWith {
      case throwable => Execution.from(Failure(throwable))
    }

  /**
    * Scala uses the filter method in for syntax for pattern matches that can fail.
    * If this filter is false, the result of run will be an exception in the future
    */
  def filter(pred: T => Boolean): Execution[T] =
    flatMap {
      case good if pred(good) => Execution.from(good)
      case failed =>
        Execution.from(sys.error("Filter failed on: " + failed.toString))
    }

  /**
    * First run this Execution, then move to the result
    * of the function
    */
  def flatMap[U](fn: T => Execution[U]): Execution[U] =
    FlatMapped(this, fn)

  /**
    * This is the same as flatMap(identity)
    */
  def flatten[U](implicit ev: T <:< Execution[U]): Execution[U] =
    flatMap(ev)

  /**
    * Apply a pure function to the result. This may not
    * be called if subsequently the result is discarded with .unit
    * For side effects see onComplete.
    */
  def map[U](fn: T => U): Execution[U] =
    Mapped(this, fn)

  /**
    * Reads the counters into the value, but does not reset them.
    * You may want .getAndResetCounters.
    */
  def getCounters: Execution[(T, ExecutionCounters)] =
    GetCounters(this)

  /**
    * Reads the counters and resets them to zero. Probably what
    * you want in a loop that is using counters to check for
    * convergence.
    */
  def getAndResetCounters: Execution[(T, ExecutionCounters)] =
    getCounters.resetCounters

  /**
    * This function is called when the current run is completed. This is
    * only a side effect (see unit return).
    *
    * ALSO You must .run the result. If
    * you throw away the result of this call, your fn will never be
    * called. When you run the result, the Future you get will not
    * be complete unless fn has completed running. If fn throws, it
    * will be handled be the scala.concurrent.ExecutionContext.reportFailure
    * NOT by returning a Failure in the Future.
    */
  def onComplete(fn: Try[T] => Unit): Execution[T] = OnComplete(this, fn)

  /**
    * This allows you to handle a failure by giving a replacement execution
    * in some cases. This execution may be a retry if you know that your
    * execution can have spurious errors, or it could be a constant or an
    * alternate way to compute. Be very careful creating looping retries that
    * could hammer your cluster when the data is missing or when
    * when there is some real problem with your job logic.
    */
  def recoverWith[U >: T](
      rec: PartialFunction[Throwable, Execution[U]]
  ): Execution[U] =
    RecoverWith(this, rec)

  /**
    * Resets the counters back to zero. This is useful if
    * you want to reset before a zip or a call to flatMap
    */
  def resetCounters: Execution[T] =
    ResetCounters(this)

  /**
    * This causes the Execution to occur. The result is not cached, so each call
    * to run will result in the computation being re-run. Avoid calling this
    * until the last possible moment by using flatMap, zip and recoverWith.
    *
    * Seriously: pro-style is for this to be called only once in a program.
    */
  final def run(conf: Config, mode: Mode)(implicit
      cec: ConcurrentExecutionContext
  ): Future[T] = {
    val ec = new EvalCache
    val confWithId =
      conf.setScaldingExecutionId(java.util.UUID.randomUUID.toString)
    val result = runStats(confWithId, mode, ec)(cec).map(_._1)
    // When the final future in complete we stop the submit thread
    result.onComplete { _ => ec.finished() }
    // wait till the end to start the thread in case the above throws
    ec.start()
    result
  }

  /**
    * This is the internal method that must be implemented
    * Given a config, mode, and cache of evaluations for this config and mode,
    * return the new cache with as much evaluation as possible before the future
    * completes, and a future of the result, counters and cache after the future
    * is complete
    */
  protected def runStats(conf: Config, mode: Mode, cache: EvalCache)(implicit
      cec: ConcurrentExecutionContext
  ): Future[(T, ExecutionCounters)]

  /**
    * This is convenience for when we don't care about the result.
    * like .map(_ => ())
    */
  def unit: Execution[Unit] = map(_ => ())

  /**
    * This waits synchronously on run, using the global execution context
    * Avoid calling this if possible, prefering run or just Execution
    * composition. Every time someone calls this, be very suspect. It is
    * always code smell. Very seldom should you need to wait on a future.
    */
  def waitFor(conf: Config, mode: Mode): Try[T] =
    Try(
      Await.result(
        run(conf, mode)(ConcurrentExecutionContext.global),
        scala.concurrent.duration.Duration.Inf
      )
    )

  /**
    * This is here to silence warnings in for comprehensions, but is
    * identical to .filter.
    *
    * Users should never directly call this method, call .filter
    */
  def withFilter(p: T => Boolean): Execution[T] = filter(p)
  /*
   * run this and that in parallel, without any dependency. This will
   * be done in a single cascading flow if possible.
   */
  def zip[U](that: Execution[U]): Execution[(T, U)] =
    Zipped(this, that)
}

/**
  * Execution has many methods for creating Execution[T] instances, which
  * are the preferred way to compose computations in scalding libraries.
  */
object Execution {
  private[Execution] class AsyncSemaphore(initialPermits: Int = 0) {
    private[this] val waiters = new mutable.Queue[() => Unit]
    private[this] var availablePermits = initialPermits

    private[Execution] class SemaphorePermit {
      def release() =
        AsyncSemaphore.this.synchronized {
          availablePermits += 1
          if (availablePermits > 0 && waiters.nonEmpty) {
            availablePermits -= 1
            waiters.dequeue()()
          }
        }
    }

    def acquire(): Future[SemaphorePermit] = {
      val promise = Promise[SemaphorePermit]()

      def setAcquired(): Unit =
        promise.success(new SemaphorePermit)

      synchronized {
        if (availablePermits > 0) {
          availablePermits -= 1
          setAcquired()
        } else {
          waiters.enqueue(setAcquired)
        }
      }

      promise.future
    }
  }

  /**
    * This is an instance of Monad for execution so it can be used
    * in functions that apply to all Monads
    */
  implicit object ExecutionMonad extends Monad[Execution] {
    override def apply[T](t: T): Execution[T] = Execution.from(t)
    override def map[T, U](e: Execution[T])(fn: T => U): Execution[U] =
      e.map(fn)
    override def flatMap[T, U](e: Execution[T])(
        fn: T => Execution[U]
    ): Execution[U] = e.flatMap(fn)
    override def join[T, U](
        t: Execution[T],
        u: Execution[U]
    ): Execution[(T, U)] = t.zip(u)
  }

  def withConfig[T](ex: Execution[T])(c: Config => Config): Execution[T] =
    TransformedConfig(ex, c)

  /**
    * This function allows running the passed execution with its own cache.
    * This will mean anything inside won't benefit from Execution's global attempts to avoid
    * repeated executions.
    *
    * The main use case here is when generating a lot of Execution results which are large.
    * Executions caching in this case can lead to out of memory errors as the cache keeps
    * references to many heap objects.
    *
    * Ex. (0 until 1000).map { _ => Execution.withNewCache(myLargeObjectProducingExecution)}
    */
  def withNewCache[T](ex: Execution[T]): Execution[T] =
    WithNewCache(ex)

  /**
    * This is the standard semigroup on an Applicative (zip, then inside the Execution do plus)
    */
  implicit def semigroup[T: Semigroup]: Semigroup[Execution[T]] =
    Semigroup.from[Execution[T]] { (a, b) =>
      a.zip(b).map { case (ta, tb) => Semigroup.plus(ta, tb) }
    }

  /**
    * This is the standard monoid on an Applicative (zip, then inside the Execution do plus)
    * useful to combine unit Executions:
    * Monoid.sum(ex1, ex2, ex3, ex4): Execution[Unit]
    * where each are exi are Execution[Unit]
    */
  implicit def monoid[T: Monoid]: Monoid[Execution[T]] =
    Monoid.from(Execution.from(Monoid.zero[T])) { (a, b) =>
      a.zip(b).map { case (ta, tb) => Monoid.plus(ta, tb) }
    }

  /**
    * This is a mutable state that is kept internal to an execution
    * as it is evaluating.
    */
  private[scalding] object EvalCache {

    /**
      * We send messages from other threads into the submit thread here
      */
    private[EvalCache] sealed trait FlowDefAction
    private[EvalCache] case class RunFlowDef(
        conf: Config,
        mode: Mode,
        fd: FlowDef,
        result: Promise[JobStats]
    ) extends FlowDefAction
    private[EvalCache] case object Stop extends FlowDefAction
  }

  private[scalding] class EvalCache {
    import EvalCache._
    private[this] val cache =
      new FutureCache[(Config, Execution[Any]), (Any, ExecutionCounters)]

    private[this] val toWriteCache =
      new FutureCache[(Config, ToWrite), ExecutionCounters]

    // This method with return a 'clean' cache, that shares
    // the underlying thread and message queue of the parent evalCache
    def cleanCache: EvalCache = {
      val self = this
      new EvalCache {
        override protected[EvalCache] val messageQueue
            : LinkedBlockingQueue[EvalCache.FlowDefAction] = self.messageQueue
        override def start(): Unit =
          sys.error("Invalid to start child EvalCache")
        override def finished(): Unit =
          sys.error("Invalid to finish child EvalCache")
      }
    }

    protected[EvalCache] val messageQueue =
      new LinkedBlockingQueue[EvalCache.FlowDefAction]()

    /**
      * Hadoop and/or cascading has some issues, it seems, with starting jobs
      * from multiple threads. This thread does all the Flow starting.
      */
    protected lazy val thread = new Thread(new Runnable {
      def run() {
        @annotation.tailrec
        def go(): Unit =
          messageQueue.take match {
            case Stop => ()
            case RunFlowDef(conf, mode, fd, promise) =>
              try {
                promise.completeWith(
                  ExecutionContext.newContext(conf)(fd, mode).run
                )
              } catch {
                case t: Throwable =>
                  // something bad happened, but this thread is a daemon
                  // that should only stop if all others have stopped or
                  // we have received the stop message.
                  // Stopping this thread prematurely can deadlock
                  // futures from the promise we have.
                  // In a sense, this thread does not exist logically and
                  // must forward all exceptions to threads that requested
                  // this work be started.
                  promise.tryFailure(t)
              }
              // Loop
              go()
          }

        // Now we actually run the recursive loop
        go()
      }
    })

    def runFlowDef(conf: Config, mode: Mode, fd: FlowDef): Future[JobStats] =
      try {
        val promise = Promise[JobStats]()
        val fut = promise.future
        messageQueue.put(RunFlowDef(conf, mode, fd, promise))
        // Don't do any work after the .put call, we want no chance for exception
        // after the put
        fut
      } catch {
        case NonFatal(e) =>
          Future.failed(e)
      }

    def start(): Unit = {
      // Make sure this thread can't keep us running if all others are gone
      thread.setDaemon(true)
      thread.start()
    }
    /*
     * This is called after we are done submitting all jobs
     */
    def finished(): Unit = messageQueue.put(Stop)

    def getOrLock(
        cfg: Config,
        write: ToWrite
    ): Either[Promise[ExecutionCounters], Future[ExecutionCounters]] =
      toWriteCache.getOrPromise((cfg, write))

    def getOrElseInsertWithFeedback[T](
        cfg: Config,
        ex: Execution[T],
        res: => Future[(T, ExecutionCounters)]
    ): (Boolean, Future[(T, ExecutionCounters)]) =
      // This cast is safe because we always insert with match T types
      cache
        .getOrElseUpdateIsNew((cfg, ex), res)
        .asInstanceOf[(Boolean, Future[(T, ExecutionCounters)])]

    def getOrElseInsert[T](
        cfg: Config,
        ex: Execution[T],
        res: => Future[(T, ExecutionCounters)]
    ): Future[(T, ExecutionCounters)] =
      getOrElseInsertWithFeedback(cfg, ex, res)._2
  }
  private case class FutureConst[T](
      get: ConcurrentExecutionContext => Future[T]
  ) extends Execution[T] {
    def runStats(conf: Config, mode: Mode, cache: EvalCache)(implicit
        cec: ConcurrentExecutionContext
    ) =
      cache.getOrElseInsert(
        conf,
        this,
        for {
          futt <- toFuture(Try(get(cec)))
          t <- futt
        } yield (t, ExecutionCounters.empty)
      )

    // Note that unit is not optimized away, since Futures are often used with side-effects, so,
    // we ensure that get is always called in contrast to Mapped, which assumes that fn is pure.
  }
  private case class FlatMapped[S, T](prev: Execution[S], fn: S => Execution[T])
      extends Execution[T] {
    def runStats(conf: Config, mode: Mode, cache: EvalCache)(implicit
        cec: ConcurrentExecutionContext
    ) =
      cache.getOrElseInsert(
        conf,
        this,
        for {
          (s, st1) <- prev.runStats(conf, mode, cache)
          next = fn(s)
          fut2 = next.runStats(conf, mode, cache)
          (t, st2) <- fut2
        } yield (t, Monoid.plus(st1, st2))
      )
  }

  private case class Mapped[S, T](prev: Execution[S], fn: S => T)
      extends Execution[T] {
    def runStats(conf: Config, mode: Mode, cache: EvalCache)(implicit
        cec: ConcurrentExecutionContext
    ) =
      cache.getOrElseInsert(
        conf,
        this,
        prev
          .runStats(conf, mode, cache)
          .map { case (s, stats) => (fn(s), stats) }
      )
  }
  private case class GetCounters[T](prev: Execution[T])
      extends Execution[(T, ExecutionCounters)] {
    def runStats(conf: Config, mode: Mode, cache: EvalCache)(implicit
        cec: ConcurrentExecutionContext
    ) =
      cache.getOrElseInsert(
        conf,
        this,
        prev.runStats(conf, mode, cache).map { case tc @ (t, c) => (tc, c) }
      )
  }
  private case class ResetCounters[T](prev: Execution[T]) extends Execution[T] {
    def runStats(conf: Config, mode: Mode, cache: EvalCache)(implicit
        cec: ConcurrentExecutionContext
    ) =
      cache.getOrElseInsert(
        conf,
        this,
        prev
          .runStats(conf, mode, cache)
          .map { case (t, _) => (t, ExecutionCounters.empty) }
      )
  }

  private case class TransformedConfig[T](
      prev: Execution[T],
      fn: Config => Config
  ) extends Execution[T] {
    def runStats(conf: Config, mode: Mode, cache: EvalCache)(implicit
        cec: ConcurrentExecutionContext
    ) = {
      val mutatedConfig = fn(conf)
      cache.getOrElseInsert(
        mutatedConfig,
        this,
        prev.runStats(mutatedConfig, mode, cache)
      )
    }
  }

  /**
    * This class allows running the passed execution with its own cache.
    * This will mean anything inside won't benefit from Execution's global attempts to avoid
    * repeated executions.
    *
    * The main use case here is when generating a lot of Execution results which are large.
    * Executions caching in this case can lead to out of memory errors as the cache keeps
    * references to many heap objects.
    *
    * We operate here by getting a copy of the super EvalCache, without its cache's.
    * This is so we can share the singleton thread for scheduling jobs against Cascading.
    */
  private case class WithNewCache[T](prev: Execution[T]) extends Execution[T] {
    def runStats(conf: Config, mode: Mode, cache: EvalCache)(implicit
        cec: ConcurrentExecutionContext
    ) = {
      // Share the runner thread, but have own cache
      val ec = cache.cleanCache

      val ret = prev.runStats(conf, mode, ec)
      ret
    }
  }

  private case class OnComplete[T](prev: Execution[T], fn: Try[T] => Unit)
      extends Execution[T] {
    def runStats(conf: Config, mode: Mode, cache: EvalCache)(implicit
        cec: ConcurrentExecutionContext
    ) =
      cache.getOrElseInsert(
        conf,
        this, {
          val res = prev.runStats(conf, mode, cache)

          /**
            * The result we give is only completed AFTER fn is run
            * so callers can wait on the result of this OnComplete
            */
          val finished = Promise[(T, ExecutionCounters)]()
          res.onComplete { tryT =>
            try {
              fn(tryT.map(_._1))
            } finally {
              // Do our best to signal when we are done
              finished.complete(tryT)
            }
          }
          finished.future
        }
      )
  }
  private case class RecoverWith[T](
      prev: Execution[T],
      fn: PartialFunction[Throwable, Execution[T]]
  ) extends Execution[T] {
    def runStats(conf: Config, mode: Mode, cache: EvalCache)(implicit
        cec: ConcurrentExecutionContext
    ) =
      cache.getOrElseInsert(
        conf,
        this,
        prev
          .runStats(conf, mode, cache)
          .recoverWith(fn.andThen(_.runStats(conf, mode, cache)))
      )
  }

  /**
    * Use our internal faster failing zip function rather than the standard one due to waiting
    */
  def failFastSequence[T](
      t: Iterable[Future[T]]
  )(implicit cec: ConcurrentExecutionContext): Future[List[T]] = {
    t.foldLeft(Future.successful(Nil: List[T])) { (f, i) =>
        failFastZip(f, i).map { case (tail, h) => h :: tail }
      }
      .map(_.reverse)
  }

  /**
    * Standard scala zip waits forever on the left side, even if the right side fails
    */
  def failFastZip[T, U](ft: Future[T], fu: Future[U])(implicit
      cec: ConcurrentExecutionContext
  ): Future[(T, U)] = {
    type State = Either[(T, Promise[U]), (U, Promise[T])]
    val middleState = Promise[State]()

    ft.onComplete {
      case f @ Failure(err) =>
        if (!middleState.tryFailure(err)) {
          // the right has already succeeded
          middleState.future.foreach {
            case Right((_, pt)) => pt.complete(f)
            case Left((t1, _)) => // This should never happen
              sys.error(
                s"Logic error: tried to set Failure($err) but Left($t1) already set"
              )
          }
        }
      case Success(t) =>
        // Create the next promise:
        val pu = Promise[U]()
        if (!middleState.trySuccess(Left((t, pu)))) {
          // we can't set, so the other promise beat us here.
          middleState.future.foreach {
            case Right((_, pt)) => pt.success(t)
            case Left((t1, _)) => // This should never happen
              sys.error(
                s"Logic error: tried to set Left($t) but Left($t1) already set"
              )
          }
        }
    }
    fu.onComplete {
      case f @ Failure(err) =>
        if (!middleState.tryFailure(err)) {
          // we can't set, so the other promise beat us here.
          middleState.future.foreach {
            case Left((_, pu)) => pu.complete(f)
            case Right((u1, _)) => // This should never happen
              sys.error(
                s"Logic error: tried to set Failure($err) but Right($u1) already set"
              )
          }
        }
      case Success(u) =>
        // Create the next promise:
        val pt = Promise[T]()
        if (!middleState.trySuccess(Right((u, pt)))) {
          // we can't set, so the other promise beat us here.
          middleState.future.foreach {
            case Left((_, pu)) => pu.success(u)
            case Right((u1, _)) => // This should never happen
              sys.error(
                s"Logic error: tried to set Right($u) but Right($u1) already set"
              )
          }
        }
    }

    middleState.future.flatMap {
      case Left((t, pu))  => pu.future.map((t, _))
      case Right((u, pt)) => pt.future.map((_, u))
    }
  }

  private case class Zipped[S, T](one: Execution[S], two: Execution[T])
      extends Execution[(S, T)] {
    def runStats(conf: Config, mode: Mode, cache: EvalCache)(implicit
        cec: ConcurrentExecutionContext
    ) =
      cache.getOrElseInsert(
        conf,
        this, {
          val f1 = one.runStats(conf, mode, cache)
          val f2 = two.runStats(conf, mode, cache)
          failFastZip(f1, f2).map {
            case ((s, ss), (t, st)) => ((s, t), Monoid.plus(ss, st))
          }
        }
      )
  }
  private case class UniqueIdExecution[T](fn: UniqueID => Execution[T])
      extends Execution[T] {
    def runStats(conf: Config, mode: Mode, cache: EvalCache)(implicit
        cec: ConcurrentExecutionContext
    ) =
      cache.getOrElseInsert(
        conf,
        this, {
          val (uid, nextConf) = conf.ensureUniqueId
          fn(uid).runStats(nextConf, mode, cache)
        }
      )
  }
  /*
   * This allows you to run any cascading flowDef as an Execution.
   */
  private case class FlowDefExecution(result: (Config, Mode) => FlowDef)
      extends Execution[Unit] {
    def runStats(conf: Config, mode: Mode, cache: EvalCache)(implicit
        cec: ConcurrentExecutionContext
    ) =
      cache.getOrElseInsert(
        conf,
        this,
        for {
          flowDef <- toFuture(Try(result(conf, mode)))
          _ = FlowStateMap.validateSources(flowDef, mode)
          jobStats <- cache.runFlowDef(conf, mode, flowDef)
          _ = FlowStateMap.clear(flowDef)
        } yield ((), ExecutionCounters.fromJobStats(jobStats))
      )
  }

  /*
   * This is here so we can call without knowing the type T
   * but with proof that pipe matches sink
   */

  private trait ToWrite {
    def write(config: Config, flowDef: FlowDef, mode: Mode): Unit
  }
  private case class SimpleWrite[T](pipe: TypedPipe[T], sink: TypedSink[T])
      extends ToWrite {
    def write(config: Config, flowDef: FlowDef, mode: Mode): Unit = {
      // This has the side effect of mutating flowDef
      pipe.write(sink)(flowDef, mode)
      ()
    }
  }

  private case class PreparedWrite[T](fn: (Config, Mode) => SimpleWrite[T])
      extends ToWrite {
    def write(config: Config, flowDef: FlowDef, mode: Mode): Unit =
      fn(config, mode).write(config, flowDef, mode)
  }

  /**
    * This is the fundamental execution that actually happens in TypedPipes, all the rest
    * are based on on this one. By keeping the Pipe and the Sink, can inspect the Execution
    * DAG and optimize it later (a goal, but not done yet).
    */
  private case class WriteExecution[T](
      head: ToWrite,
      tail: List[ToWrite],
      fn: (Config, Mode) => T
  ) extends Execution[T] {

    /**
      * Apply a pure function to the result. This may not
      * be called if subsequently the result is discarded with .unit
      * For side effects see onComplete.
      *
      * Here we inline the map operation into the presentation function so we can zip after map.
      */
    override def map[U](mapFn: T => U): Execution[U] =
      WriteExecution(
        head,
        tail,
        { (conf: Config, mode: Mode) => mapFn(fn(conf, mode)) }
      )

    /* Run a list of ToWrite elements */
    private[this] def scheduleToWrites(
        conf: Config,
        mode: Mode,
        cache: EvalCache,
        head: ToWrite,
        tail: List[ToWrite]
    )(implicit cec: ConcurrentExecutionContext): Future[ExecutionCounters] = {
      for {
        flowDef <- toFuture(Try {
          val fd =
            new FlowDef; (head :: tail).foreach(_.write(conf, fd, mode)); fd
        })
        _ = FlowStateMap.validateSources(flowDef, mode)
        jobStats <- cache.runFlowDef(conf, mode, flowDef)
        _ = FlowStateMap.clear(flowDef)
      } yield (ExecutionCounters.fromJobStats(jobStats))
    }

    def unwrapListEither[A, B, C](
        it: List[(A, Either[B, C])]
    ): (List[(A, B)], List[(A, C)]) =
      it match {
        case (a, Left(b)) :: tail =>
          val (l, r) = unwrapListEither(tail)
          ((a, b) :: l, r)
        case (a, Right(c)) :: tail =>
          val (l, r) = unwrapListEither(tail)
          (l, (a, c) :: r)
        case Nil => (Nil, Nil)
      }

    // We look up to see if any of our ToWrite elements have already been ran
    // if so we remove them from the cache.
    // Anything not already ran we run as part of a single flow def, using their combined counters for the others
    def runStats(conf: Config, mode: Mode, cache: EvalCache)(implicit
        cec: ConcurrentExecutionContext
    ) =
      cache.getOrElseInsert(
        conf,
        this, {
          val cacheLookup: List[
            (
                ToWrite,
                Either[Promise[ExecutionCounters], Future[ExecutionCounters]]
            )
          ] =
            (head :: tail).map { tw => (tw, cache.getOrLock(conf, tw)) }
          val (weDoOperation, someoneElseDoesOperation) =
            unwrapListEither(cacheLookup)

          val otherResult = failFastSequence(someoneElseDoesOperation.map(_._2))
          otherResult.value match {
            case Some(Failure(e)) => Future.failed(e)
            case _ => // Either successful or not completed yet
              val localFlowDefCountersFuture: Future[ExecutionCounters] =
                weDoOperation match {
                  case all @ (h :: tail) =>
                    val futCounters: Future[ExecutionCounters] =
                      scheduleToWrites(conf, mode, cache, h._1, tail.map(_._1))
                    // Complete all of the promises we put into the cache
                    // with this future counters set
                    weDoOperation.foreach {
                      case (toWrite, promise) =>
                        promise.completeWith(futCounters)
                    }
                    futCounters
                  case Nil =>
                    Future.successful(
                      ExecutionCounters.empty
                    ) // No work to do, provide a fulled set of 0 counters to operate on
                }

              failFastZip(otherResult, localFlowDefCountersFuture).map {
                case (lCounters, fdCounters) =>
                  val summedCounters: ExecutionCounters =
                    Monoid.sum(fdCounters :: lCounters)
                  (fn(conf, mode), summedCounters)
              }
          }
        }
      )

    /*
     * run this and that in parallel, without any dependency. This will
     * be done in a single cascading flow if possible.
     *
     * If both sides are write executions then merge them
     */
    override def zip[U](that: Execution[U]): Execution[(T, U)] =
      that match {
        case WriteExecution(h, t, otherFn) =>
          val newFn = { (conf: Config, mode: Mode) =>
            (fn(conf, mode), otherFn(conf, mode))
          }
          WriteExecution(head, h :: t ::: tail, newFn)
        case o => Zipped(this, that)
      }
  }

  /**
    * This is called Reader, because it just returns its input to run as the output
    */
  private case object ReaderExecution extends Execution[(Config, Mode)] {
    def runStats(conf: Config, mode: Mode, cache: EvalCache)(implicit
        cec: ConcurrentExecutionContext
    ) =
      Future.successful(((conf, mode), ExecutionCounters.empty))
  }

  private def toFuture[R](t: Try[R]): Future[R] =
    t match {
      case Success(s)   => Future.successful(s)
      case Failure(err) => Future.failed(err)
    }

  /**
    * This creates a definitely failed Execution.
    */
  def failed(t: Throwable): Execution[Nothing] = fromTry(Failure(t))

  /**
    * This makes a constant execution that runs no job.
    * Note this is a lazy parameter that is evaluated every
    * time run is called.
    */
  def from[T](t: => T): Execution[T] = fromTry(Try(t))
  def fromTry[T](t: => Try[T]): Execution[T] = fromFuture { _ => toFuture(t) }

  /**
    * The call to fn will happen when the run method on the result is called.
    * The ConcurrentExecutionContext will be the same one used on run.
    * This is intended for cases where you need to make asynchronous calls
    * in the middle or end of execution. Presumably this is used with flatMap
    * either before or after
    */
  def fromFuture[T](fn: ConcurrentExecutionContext => Future[T]): Execution[T] =
    FutureConst(fn)

  /** Returns a constant Execution[Unit] */
  val unit: Execution[Unit] = from(())

  /**
    * This converts a function into an Execution monad. The flowDef returned
    * is never mutated.
    */
  def fromFn(fn: (Config, Mode) => FlowDef): Execution[Unit] =
    FlowDefExecution(fn)

  /**
    * Creates an Execution to do a write
    *
    * This variant allows the user to supply a method using the config and mode to build a new
    * type U for the resultant execution.
    */
  private[scalding] def write[T, U](
      pipe: TypedPipe[T],
      sink: TypedSink[T],
      generatorFn: (Config, Mode) => U
  ): Execution[U] =
    WriteExecution(SimpleWrite(pipe, sink), Nil, generatorFn)

  /**
    * The simplest form, just sink the typed pipe into the sink and get a unit execution back
    */
  private[scalding] def write[T](
      pipe: TypedPipe[T],
      sink: TypedSink[T]
  ): Execution[Unit] =
    write(pipe, sink, ())

  private[scalding] def write[T, U](
      pipe: TypedPipe[T],
      sink: TypedSink[T],
      presentType: => U
  ): Execution[U] =
    WriteExecution(
      SimpleWrite(pipe, sink),
      Nil,
      { (_: Config, _: Mode) => presentType }
    )

  /**
    * Here we allow both the targets to write and the sources to be generated from the config and mode.
    * This allows us to merge things looking for the config and mode without using flatmap.
    */
  private[scalding] def write[T, U](
      fn: (Config, Mode) => (TypedPipe[T], TypedSink[T]),
      generatorFn: (Config, Mode) => U
  ): Execution[U] =
    WriteExecution(
      PreparedWrite({ (cfg: Config, m: Mode) =>
        val r = fn(cfg, m)
        SimpleWrite(r._1, r._2)
      }),
      Nil,
      generatorFn
    )

  /**
    * Convenience method to get the Args
    */
  def getArgs: Execution[Args] = ReaderExecution.map(_._1.getArgs)

  /**
    * Use this to read the configuration, which may contain Args or options
    * which describe input on which to run
    */
  def getConfig: Execution[Config] = ReaderExecution.map(_._1)

  /** Use this to get the mode, which may contain the job conf */
  def getMode: Execution[Mode] = ReaderExecution.map(_._2)

  /** Use this to get the config and mode. */
  def getConfigMode: Execution[(Config, Mode)] = ReaderExecution

  /**
    * This is convenience method only here to make it slightly cleaner
    * to get Args, which are in the Config
    */
  def withArgs[T](fn: Args => Execution[T]): Execution[T] =
    getConfig.flatMap { conf => fn(conf.getArgs) }

  /**
    * Use this to use counters/stats with Execution. You do this:
    * Execution.withId { implicit uid =>
    *   val myStat = Stat("myStat") // uid is implicitly pulled in
    *   pipe.map { t =>
    *     if(someCase(t)) myStat.inc
    *     fn(t)
    *   }
    *   .writeExecution(mySink)
    * }
    */
  def withId[T](fn: UniqueID => Execution[T]): Execution[T] =
    UniqueIdExecution(fn)

  /*
   * This runs a Flow using Cascading's built in threads. The resulting JobStats
   * are put into a promise when they are ready
   */
  def run[C](flow: Flow[C]): Future[JobStats] =
    // This is in Java because of the cascading API's raw types on FlowListener
    FlowListenerPromise.start(flow, { f: Flow[C] => JobStats(f.getFlowStats) })

  /*
   * This blocks the current thread until the job completes with either success or
   * failure.
   */
  def waitFor[C](flow: Flow[C]): Try[JobStats] =
    Try {
      flow.complete;
      JobStats(flow.getStats)
    }

  /**
    * combine several executions and run them in parallel when .run is called
    */
  def zip[A, B](ax: Execution[A], bx: Execution[B]): Execution[(A, B)] =
    ax.zip(bx)

  /**
    * combine several executions and run them in parallel when .run is called
    */
  def zip[A, B, C](
      ax: Execution[A],
      bx: Execution[B],
      cx: Execution[C]
  ): Execution[(A, B, C)] =
    ax.zip(bx).zip(cx).map { case ((a, b), c) => (a, b, c) }

  /**
    * combine several executions and run them in parallel when .run is called
    */
  def zip[A, B, C, D](
      ax: Execution[A],
      bx: Execution[B],
      cx: Execution[C],
      dx: Execution[D]
  ): Execution[(A, B, C, D)] =
    ax.zip(bx).zip(cx).zip(dx).map { case (((a, b), c), d) => (a, b, c, d) }

  /**
    * combine several executions and run them in parallel when .run is called
    */
  def zip[A, B, C, D, E](
      ax: Execution[A],
      bx: Execution[B],
      cx: Execution[C],
      dx: Execution[D],
      ex: Execution[E]
  ): Execution[(A, B, C, D, E)] =
    ax.zip(bx).zip(cx).zip(dx).zip(ex).map {
      case ((((a, b), c), d), e) => (a, b, c, d, e)
    }

  /*
   * If you have many Executions, it is better to combine them with
   * zip than flatMap (which is sequential). sequence just calls
   * zip on each item in the input sequence.
   *
   * Note, despite the name, which is taken from the standard scala Future API,
   * these executions are executed in parallel: run is called on all at the
   * same time, not one after the other.
   */
  def sequence[T](exs: Seq[Execution[T]]): Execution[Seq[T]] = {
    @annotation.tailrec
    def go(
        xs: List[Execution[T]],
        acc: Execution[List[T]]
    ): Execution[List[T]] =
      xs match {
        case Nil       => acc
        case h :: tail => go(tail, h.zip(acc).map { case (y, ys) => y :: ys })
      }
    // This pushes all of them onto a list, and then reverse to keep order
    go(exs.toList, from(Nil)).map(_.reverse)
  }

  /**
    * Run a sequence of executions but only permitting parallelism amount to run at the
    * same time.
    *
    * @param executions List of executions to run
    * @param parallelism Number to run in parallel
    * @return Execution Seq
    */
  def withParallelism[T](
      executions: Seq[Execution[T]],
      parallelism: Int
  ): Execution[Seq[T]] = {
    require(parallelism > 0, s"Parallelism must be > 0: $parallelism")

    val sem = new AsyncSemaphore(parallelism)

    def waitRun(e: Execution[T]): Execution[T] = {
      Execution
        .fromFuture(_ => sem.acquire())
        .flatMap(p => e.liftToTry.map((_, p)))
        .onComplete {
          case Success((_, p)) => p.release()
          case Failure(ex) =>
            throw ex // should never happen or there is a logic bug
        }
        .flatMap { case (ex, _) => fromTry(ex) }
    }

    Execution.sequence(executions.map(waitRun))
  }
}

/**
  * This represents the counters portion of the JobStats that are returned.
  * Counters are just a vector of longs with counter name, group keys.
  */
trait ExecutionCounters {

  /**
    * immutable set of the keys.
    */
  def keys: Set[StatKey]

  /**
    * Same as get(key).getOrElse(0L)
    * Note if a counter is never incremented, get returns None.
    * But you can't tell 0L that comes from None vs. a counter
    * that was incremented then decremented.
    */
  def apply(key: StatKey): Long = get(key).getOrElse(0L)

  /**
    * If the counter is present, return it.
    */
  def get(key: StatKey): Option[Long]
  def toMap: Map[StatKey, Long] =
    keys.map { k => (k, get(k).getOrElse(0L)) }.toMap
}

/**
  * The companion gives several ways to create ExecutionCounters from
  * other CascadingStats, JobStats, or Maps
  */
object ExecutionCounters {

  /**
    * This is the zero of the ExecutionCounter Monoid
    */
  def empty: ExecutionCounters =
    new ExecutionCounters {
      def keys = Set.empty
      def get(key: StatKey) = None
      override def toMap = Map.empty
    }

  /**
    * Just gets the counters from the CascadingStats and ignores
    * all the other fields present
    */
  def fromCascading(cs: cascading.stats.CascadingStats): ExecutionCounters =
    new ExecutionCounters {
      import scala.collection.JavaConverters._

      val keys = (for {
        group <- cs.getCounterGroups.asScala
        counter <- cs.getCountersFor(group).asScala
      } yield StatKey(counter, group)).toSet

      def get(k: StatKey) =
        if (keys(k)) {
          // Yes, cascading is reversed frow what we did in Stats. :/
          Some(cs.getCounterValue(k.group, k.counter))
        } else None
    }

  /**
    * Gets just the counters from the JobStats
    */
  def fromJobStats(js: JobStats): ExecutionCounters = {
    val counters = js.counters
    new ExecutionCounters {
      def keys =
        for {
          group <- counters.keySet
          counter <- counters(group).keys
        } yield StatKey(counter, group)

      def get(k: StatKey) = counters.get(k.group).flatMap(_.get(k.counter))
    }
  }

  /**
    * A Simple wrapper over a Map[StatKey, Long]
    */
  def fromMap(allValues: Map[StatKey, Long]): ExecutionCounters =
    new ExecutionCounters {
      def keys = allValues.keySet
      def get(k: StatKey) = allValues.get(k)
      override def toMap = allValues
    }

  /**
    * This allows us to merge the results of two computations. It just
    * does pointwise addition.
    */
  implicit def monoid: Monoid[ExecutionCounters] =
    new Monoid[ExecutionCounters] {
      override def isNonZero(that: ExecutionCounters) = that.keys.nonEmpty
      def zero = ExecutionCounters.empty
      def plus(left: ExecutionCounters, right: ExecutionCounters) = {
        fromMap((left.keys ++ right.keys).map { k =>
          (k, left(k) + right(k))
        }.toMap)
      }
    }
}
