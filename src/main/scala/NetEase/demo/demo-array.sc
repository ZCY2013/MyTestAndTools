
val nums = new Array[Int](10)

val str = new Array[String](10)

val s = Array("a", "b")
s(1)
s(0)

//s+=1 //array is immutable
s.foreach(a=>println(a + ""))

import scala.collection.mutable.ArrayBuffer
val d =ArrayBuffer[Int]()

d += 1
d
d += (2,3,4)
d ++= Array(2,3,4)
d.trimEnd(3)
d
d.insert(2,9)
d
d.remove(1)
d


s.toBuffer
d.toArray
s
val b = for(x <- s) yield (x.toUpperCase)

val a1 = Array(1,4,2,6,8,7,0,1,2)
a1.max
a1.min
a1.sum
a1.sortWith(_<_)
val matrix = Array.ofDim[Int](3,4)
matrix(2)
matrix(2)(3) = 7
matrix(2)(3)
matrix(1)(2)

val m2 = new Array[Array[Int]](10)

val b1 = ArrayBuffer("a", "b", "c")
import scala.collection.JavaConversions.bufferAsJavaList
val c = new ProcessBuilder(b1)
c.command
b1

println("#"*20)
import scala.collection.JavaConverters._
val javaList = b1.asJava
javaList.asScala


