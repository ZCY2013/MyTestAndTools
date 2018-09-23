val scores = Map("Tom" -> 90, "Jerry" -> 75, "Mikey" -> 100)
scores("Tom")
//scores("Tom1") //no such element exception

if(scores.contains("Tom1"))
  println(scores("Mikey"))
else printf("%s not found \n", "Mikey123")

scores.getOrElse("Mikey", -1)
scores.getOrElse("Mikey123", -1)

val scores_mtMap = scala.collection.mutable.Map("Tom" -> 90, "Jerry" -> 75, "Mikey" -> 100)
//scores("Mikey")=60
//scores
scores_mtMap.contains("Tom")
scores_mtMap.keys
//
scores_mtMap.values
//
scores_mtMap("Tom")
//scores_mtMap("Tom")=10   //? why error come up 
scores_mtMap
for(s <- scores)
  println(s)

scores
scores_mtMap
import scala.collection.JavaConverters._
val javaMap = scores.asJava
val java = scores_mtMap.asJava