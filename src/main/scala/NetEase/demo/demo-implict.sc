
implicit def int2string(x:Int):String = x.toString

def addSome[T <% String](x:T, y:T) = {
  println(x + y)
}
addSome("a","b")
addSome(1,2)
