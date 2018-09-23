
val a = Set(1,2,1,1,1,1,2,2,2,2,3,3,3,3,0)

val b = Set(1,2,3,4,5,6)
for(x <- b) println(x)

val mset = scala.collection.mutable.Set(2,0)

mset += 1
mset += 3
val lset = scala.collection.mutable.LinkedHashSet(1,2,3,4,5,6)
lset.foreach(print)


b
Set(1,2,3).subsetOf(b)
Set(1,2,3).intersect(Set(2,3,4))
Set(1,2,3).union(Set(2,3,4))

Set(1,2,3).diff(Set(2,3,4))
Set(2,3,4).diff(Set(1,2,3))

