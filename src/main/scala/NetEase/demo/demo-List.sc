
val s = List("a", "b", "c")
val i = List(1,2,4,3,0)
val nullList = List()

val dim = List(List(1,2,3,4), List(2,3,4))

nullList.isEmpty

s.head
s.tail

3::s
6::i
6::(7::(8::i))
i.sum
i.drop(4)
i

import scala.collection.mutable
val lk = mutable.LinkedList(1,2,3)
lk(1) = 22
lk

