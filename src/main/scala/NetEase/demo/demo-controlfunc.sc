//chose
val test = if(true) "true" else "false"

test

val a = 12
if(a<10)print("littal than 10")
else if (a>=10 && a < 20) print("(10,20)")
else print("others")


// loop

val l = List("a","b","c")

for(x<-l) println(x)
for {
  s <- l
  if (s == "a")
}println(s)

for(x <- l if x =="b") println(x)

for(i <- 1 to 10) yield  i % 3

for (i <- 1 to 3; j <- 2 to 4 if i != j) println(i, j)

  //while
var i = 0
while(i < l.length)
  {
    println(l(i))
    i += 1
  }

//do while
var j = 0
do{
  println(l(j))
  j += 1
}while(j < l.length)

l.foreach(print)


