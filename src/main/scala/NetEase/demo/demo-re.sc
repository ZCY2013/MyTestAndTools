val str = "Abc123"

str.matches("A.*\\d+$")

val numPartern = "[0-9]+".r
val strString = "Abc!!@#$456QweRW789^&*{&"
for(r<-numPartern.findAllIn(strString))println(r)

numPartern.findAllIn(strString).toArray

numPartern.findFirstIn(strString)
numPartern.findFirstMatchIn(strString)

numPartern.replaceFirstIn(strString,"888").toString

val partern = new scala.util.matching.Regex("[S|s]cala")
val str2 = "Scala is scalable and cool"
partern.findAllIn(str2).mkString(",")


val b = Array("a","b")
b.mkString(",")

val numItermPartern = "([0-9]+) ([a-z]+)".r
val src2 = "10 cups, 20 cups"
for(m <- numItermPartern.findAllMatchIn(src2)) println(m.group(1 + "/" + m.group(2)))
