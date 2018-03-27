/**
  * Cousera function programing  week3
  * class hierarchies
  */

object intsets{
  def main(args: Array[String]): Unit = {
    val t1 = new NonEmpty(3, Empty, Empty)
    val t2 = new NonEmpty(7, Empty, Empty)
    val t3 = t2.incl(5).incl(4).incl(9).incl(2)
    val t4 = t1.incl(1).incl(10)
    println(t1)
    println(t2)
    println(t3)
    println(t4)
    println(t3 union t4)
  }
}

abstract class IntSet{
  def incl(x:Int):IntSet
  def contains(x:Int):Boolean
  def union(s:IntSet):IntSet
}

object Empty extends IntSet{
  def contains(x: Int): Boolean = false
  def incl(x:Int):IntSet = new NonEmpty(x, Empty, Empty)
  def union(s:IntSet):IntSet = s

  override def toString: String = "."
}

class NonEmpty(elem:Int, left:IntSet, right:IntSet) extends IntSet{
  def contains(x:Int): Boolean = {
    if(x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }

  def incl(x:Int): IntSet =
    if(x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this


  def union(s: IntSet): IntSet = {
    println("left: " + left)
    println("right: " + right)
    ((left union right) union s) incl elem
  }

  override def toString: String = "{" + left + elem + right + "}"
}