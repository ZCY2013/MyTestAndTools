trait List[T] {
  def isEmpty:Boolean
  def head:T
  def tail:List[T]
}
class Cons[T](val _head:T, val _tail:List[T])extends List[T]{
  override def isEmpty: Boolean =  false
  def head = _head
  def tail = _tail
}

class Nil[T] extends List[T]{
  override def isEmpty: Boolean = true
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("Nil.tail")
}

object ClassHierarchies_List{
  def main(args: Array[String]): Unit = {
    singleton(1)
    singleton(true)
  }

  def singleton[T](elem:T) = new Cons[T](elem,new Nil[T])

}