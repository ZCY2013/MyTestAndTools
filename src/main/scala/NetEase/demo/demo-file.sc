import java.io.{File, PrintWriter}

import scala.io.Source

val writer = new PrintWriter(new File("E:\\\\test.txt"))
writer.write("Line1 content in text.test\n")
writer.write("Line2 content in text.test\n")
writer.write("Line3 content in text.test\n")
writer.write("Line4 content in text.test\n")
writer.close()

val source = Source.fromFile("E:\\\\test.txt")
for (l <- source.getLines())println(l)

source.mkString
source.close()

val source2 = Source.fromFile("E:\\\\test.txt")
source2.mkString
source2.close()

import java.nio.file.Paths
val dir = "E:\\\\"
val path = Paths.get(dir)
print(path.toString)
println(path.getParent)