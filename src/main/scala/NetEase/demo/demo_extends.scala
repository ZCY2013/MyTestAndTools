package NetEase.demo
trait furture{
  val name:String
  def showname:String
}
trait feature{
  val feature:String
  def test1():Unit
}
class demo_extends extends  feature  with furture{
  val name = "demo"
  override def showname():String={
    print("hello")
  "hello"
  }
  val feature = "feature"

  def  test1={
    println("test test1")
  }

}
object demo_extends{
  def main(args: Array[String]): Unit = {
      val de = new demo_extends
      de.showname()
      de.test1
    }

}