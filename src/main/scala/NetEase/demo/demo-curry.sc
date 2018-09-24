val add = (x:Int,y :Int) => x+y

val add_kr = (x:Int) => ((y:Int) => x+y)
val add_kr_1 = add_kr(3)
val result = add_kr_1(7)



//high order function
List(List(1,2,3,4),List(3,4)).flatten
List(List(1,2,3,4),List(3,4)) flatMap(_.map(_*2))
List(List(1,2,3,4),List(3,4)).flatMap(x =>List(1,2,3))

List(1,2,3,4).map(x=>1)