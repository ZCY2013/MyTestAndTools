import NetEase.demo._

object SparkTest{
  def main(args: Array[String]): Unit = {
    val e= new Employee()
    e.sayHi()
    val m = new Manager();
    m.sayHi()
  }

  val t1 = scala.collection.mutable.Map("Tom" -> 1,"Test" ->1)

  t1("Test") = 10
  print(t1)
}