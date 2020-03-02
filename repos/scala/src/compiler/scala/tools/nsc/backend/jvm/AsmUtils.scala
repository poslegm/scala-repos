/* NSC -- new Scala compiler
 * Copyright 2005-2014 LAMP/EPFL
 * @author  Martin Odersky
 */

package scala.tools.nsc.backend.jvm

import scala.tools.asm.tree.{InsnList, AbstractInsnNode, ClassNode, MethodNode}
import java.io.{StringWriter, PrintWriter}
import scala.tools.asm.util.{
  CheckClassAdapter,
  TraceClassVisitor,
  TraceMethodVisitor,
  Textifier
}
import scala.tools.asm.{ClassReader, ClassWriter, Attribute}
import scala.collection.convert.decorateAsScala._
import scala.collection.convert.decorateAsJava._
import scala.tools.nsc.backend.jvm.analysis.InitialProducer
import scala.tools.nsc.backend.jvm.opt.InlineInfoAttributePrototype

object AsmUtils {

  /**
    * Print the bytecode of methods generated by GenBCode to the standard output. Only methods
    * whose name contains `traceMethodPattern` are traced.
    */
  final val traceMethodEnabled = false
  final val traceMethodPattern = ""

  /**
    * Print the bytecode of classes generated by GenBCode to the standard output.
    */
  final val traceClassEnabled = false
  final val traceClassPattern = ""

  /**
    * Print the bytedcode of classes as they are serialized by the ASM library. The serialization
    * performed by `asm.ClassWriter` can change the code generated by GenBCode. For example, it
    * introduces stack map frames, it computes the maximal stack sizes, and it replaces dead
    * code by NOPs (see also https://github.com/scala/scala/pull/3726#issuecomment-42861780).
    */
  final val traceSerializedClassEnabled = false
  final val traceSerializedClassPattern = ""

  def traceMethod(mnode: MethodNode): Unit = {
    println(s"Bytecode for method ${mnode.name}")
    println(textify(mnode))
  }

  def traceClass(cnode: ClassNode): Unit = {
    println(s"Bytecode for class ${cnode.name}")
    println(textify(cnode))
  }

  def traceClass(bytes: Array[Byte]): Unit = traceClass(readClass(bytes))

  def readClass(bytes: Array[Byte]): ClassNode = {
    val node = new ClassNode()
    new ClassReader(bytes)
      .accept(node, Array[Attribute](InlineInfoAttributePrototype), 0)
    node
  }

  def readClass(filename: String): ClassNode = readClass(classBytes(filename))

  def classBytes(file: String): Array[Byte] = {
    val f     = new java.io.RandomAccessFile(file, "r")
    val bytes = new Array[Byte](f.length.toInt)
    f.read(bytes)
    bytes
  }

  def textifyClassStably(bytes: Array[Byte]): Unit = {
    val node = new ClassNode()
    new ClassReader(bytes)
      .accept(node, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES)

    node.fields = node.fields.asScala.sortBy(_.name).asJava
    node.methods = node.methods.asScala.sortBy(_.name).asJava
    node.visibleAnnotations = null
    node.attrs = null
    node.invisibleAnnotations = null

    println(textify(node))
  }

  def main(args: Array[String]): Unit =
    textifyClassStably(classBytes(args.head))

  /**
    * Returns a human-readable representation of the cnode ClassNode.
    */
  def textify(cnode: ClassNode): String = {
    val trace = new TraceClassVisitor(new PrintWriter(new StringWriter))
    cnode.accept(trace)
    val sw = new StringWriter
    val pw = new PrintWriter(sw)
    trace.p.print(pw)
    sw.toString
  }

  /**
    * Returns a human-readable representation of the code in the mnode MethodNode.
    */
  def textify(mnode: MethodNode): String = {
    val trace = new TraceClassVisitor(new PrintWriter(new StringWriter))
    mnode.accept(trace)
    val sw = new StringWriter
    val pw = new PrintWriter(sw)
    trace.p.print(pw)
    sw.toString
  }

  /**
    * Returns a human-readable representation of the given instruction.
    */
  def textify(insn: AbstractInsnNode): String = insn match {
    case _: InitialProducer =>
      insn.toString
    case _ =>
      val trace = new TraceMethodVisitor(new Textifier)
      insn.accept(trace)
      val sw = new StringWriter
      val pw = new PrintWriter(sw)
      trace.p.print(pw)
      sw.toString.trim
  }

  /**
    * Returns a human-readable representation of the given instruction sequence.
    */
  def textify(insns: Iterator[AbstractInsnNode]): String = {
    val trace = new TraceMethodVisitor(new Textifier)
    insns.foreach(_.accept(trace))
    val sw: StringWriter = new StringWriter
    val pw: PrintWriter  = new PrintWriter(sw)
    trace.p.print(pw)
    sw.toString.trim
  }

  /**
    * Returns a human-readable representation of the given instruction sequence.
    */
  def textify(insns: InsnList): String = textify(insns.iterator().asScala)

  /**
    * Run ASM's CheckClassAdapter over a class. Returns None if no problem is found, otherwise
    * Some(msg) with the verifier's error message.
    */
  def checkClass(
      classNode: ClassNode,
      dumpNonErroneous: Boolean = false
  ): Option[String] = {
    val cw = new ClassWriter(ClassWriter.COMPUTE_MAXS)
    classNode.accept(cw)
    val sw = new StringWriter()
    val pw = new PrintWriter(sw)
    CheckClassAdapter.verify(
      new ClassReader(cw.toByteArray),
      dumpNonErroneous,
      pw
    )
    val res = sw.toString
    if (res.isEmpty) None else Some(res)
  }
}
