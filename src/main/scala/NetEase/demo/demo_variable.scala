//逆变和协变
class Stationery
class Pen extends Stationery
class Pen2Stationery[+T] (x:T){}
class Stationery2Pen[-T] (x:T){}

object demo_variable{
  def main(args: Array[String]): Unit = {
    val pen: Pen2Stationery[Pen] = new Pen2Stationery[Pen](new Pen)
    val box: Pen2Stationery[Stationery] = pen
    val box1: Pen2Stationery[Stationery] = new Pen2Stationery[Pen](new Pen) //通过类型参数为子类Pen的泛型类Pen2Stationery,实例化出了类型参数为父类Stationery的泛型类对象

    val stationery: Stationery2Pen[Stationery] = new Stationery2Pen[Stationery](new Stationery)
    val pencil:Stationery2Pen[Pen] = stationery
    val pencil1: Stationery2Pen[Pen] = new Stationery2Pen[Stationery](new Stationery)

    class test[T]
    class xxx[T] extends test[T]
    //object yyy[T] extends test[T] 对象不能使用泛型
  }
}
