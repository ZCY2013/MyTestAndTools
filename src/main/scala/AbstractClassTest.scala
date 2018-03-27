import java.io.PrintWriter

trait Logger{
  println("init Logger")
  def log(msg:String):Unit
}

trait FileLogger extends Logger{
  println("FileLogger")
  //增加了抽象成员变量
  val fileName:String
  //将抽象成员变量作为PrintWriter参数
  lazy val fileOutput=new PrintWriter(fileName:String)
//  fileOutput.println("#")

  def log(msg:String):Unit={
    fileOutput.print(msg)
    fileOutput.flush()
  }
}

class Person{
  println("init Person")
}
class Student extends Person with FileLogger{
  println("init student")
  //Student类对FileLogger中的抽象字段进行重写
  val fileName="file.log"
}

object TraitDemo{
  def main(args: Array[String]): Unit = {
    new Student().log("trait demo")
  }
}

/**
  *class initial order:
  * Person -> Logger -> FileLogger -> Student
  */
