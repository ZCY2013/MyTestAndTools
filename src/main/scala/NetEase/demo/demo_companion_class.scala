package NetEase.demo

class demo_companion_class {
  var sth = "Scala"
  private val p = "private"
  def sayHi(): Unit ={
    println("hello " + sth)
  }

  def settSTH(s:String): Unit = {
    this.sth = s"this.sth = $s"
  }
}

object demo_companion_class{
  def main(args: Array[String]): Unit = {
    val testObject = new demo_companion_class
    testObject.sayHi()
    println(testObject.sth)
    testObject.sth = "ZCY"
    println("after setter :" + testObject.sth)

    println("testObject.p = " + testObject.p)//companion object require same name

  }
}
