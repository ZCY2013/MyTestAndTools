package NetEase.demo

class Manager {
  def sayHi()= print("Hi!")

}
object Manager{
  def main(args:Array[String]):Unit = {
    val m = new Manager()
    m.sayHi()
  }
}