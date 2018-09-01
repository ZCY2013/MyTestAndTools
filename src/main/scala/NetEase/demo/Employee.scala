package NetEase.demo

class Employee {
  def sayHi()= print("I'm Employee")
}

object Employee{
  def main(args: Array[String]): Unit = {
    val e = new Employee()
    e.sayHi()
  }
}
