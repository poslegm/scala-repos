package foo {
  case class Opt[A](val get: A) extends AnyVal {}
  object Opt {
    def mkOpt = Opt("")
  }
}

object Test {
  def main(args: Array[String]): Unit = {
    foo.Opt.mkOpt
  }
}
