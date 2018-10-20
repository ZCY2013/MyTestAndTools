import scala.collection.mutable

object examination_01{
  def main(args: Array[String]): Unit = {
    val nums = Array(2,7,11,15)
    val nums1 = Array(0,8,6,4,6,9,0)
    val result = findvalue(nums,9)
    result.foreach(r => println(r + ""))
    val result1 = findvalue(nums1,9)
    print("*"*20)
    result1.foreach(r => println(r + ""))
  }
  def findvalue(str:Array[Int],target:Int):Array[Int]={
      var x = new mutable.HashMap[Int,Int]()
      for(l <- str.indices){
        val tmp = target - str(l)
        if(x.contains(tmp)) return Array(l,x.getOrElse(tmp,0))
        x = x.++(Map(str(l)->l))
      }
    return null
  }
}