val t1 = (1,"a",3.14)
val a1 = Array(1,"a",3.14)
val l1 = List(1,"a", 3.14)

t1._2
a1(2)

for(x <- t1.productIterator) println(x)

t1.productIterator.foreach(print)
