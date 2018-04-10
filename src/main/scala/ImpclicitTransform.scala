package cn.scala.xtwy
import java.io.File
import scala.io.Source

package implicitConversion{
  object ImplicitConversion{
    implicit def file2RichFile(file:File)=new RichFile(file)
    implicit def richFile2RichFileAnother(file:RichFile)=new RichFileAnother(file)
  }

}
class RichFile(val file:File){
  def read=Source.fromFile(file).getLines().mkString
}

class RichFileAnother(val file:RichFile){
  def read2=file.read
}

object ImplicitFunction extends App{
  import cn.scala.xtwy.implicitConversion.ImplicitConversion._
  val f=new File("file.log").read
  println(f)
}