

object Application extends App{
  def mapPattern(t:Int)=l.contains(t) match {
    case true => println(true);true
    case false => println("None");-1
  }

  val l=List(1,2,3,4,5,6)
  val m=Map("hive"->2,"spark"->3,"Spark MLlib"->4)

  println(mapPattern(0))
}
