def func() = throw new IllegalArgumentException("What's up")

try{
  val test = scala.io.Source.fromFile("/tmp/file").mkString
}catch {
  case ex: java.lang.IllegalArgumentException =>{
    println("IllegalArgumentException, say Hi")
  }
  case nf: java.io.FileNotFoundException =>{
    println("xxx file not found")
  }
  case _: Exception =>println("any exception")

}finally {
  println("do this, no matter what happend")
}
