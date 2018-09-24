//internal function

import scala.math._
max(1,2)
sqrt(9)

//custom function

def helloScala(name :String) : String = s"Hello Scala, This is ${name}"

helloScala("ZCY")

val simon = helloScala("ZCY2013")

println(simon)
//
def Procedure(name:String){
s"Hello Scala, This is $name"
}
val empt = Procedure("Pocedure Test")
empt

def testParm(name:String, age:Int, city:String="BJ"):String = {
  s"Name: $name,Age:$age, City:$city"
}

testParm("Simon", 18)
testParm(name="Tom",18)
testParm(name="Jerry",19,"hongkong")
def sum(args:Int *):Int = {
  var res = 0
  for(arg <- args) res+=arg
  res
}
sum(1,2,3,4)
sum(8,9)
sum(10)
sum(1 to 10:_*)


def recSum(args: Int *):Int ={
  if(args.length == 0){
    0
  }else args.head + recSum(args.tail:_*)
}


recSum(1 to 10:_*)


