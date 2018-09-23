val v = Vector(1,2,3,4,5,6)

v(3)
v.updated(2,100)
v
v.toList //transform to other data type

//range
val a = Range(0,9)
val b = 0 until 9
val c = 0 to 9
a(0)
b(2)
c(8)
c(9)
// b(9) /index out of range exception
a == b
b == c

(0 to 9) ++ (9 to 13)

a.toList

