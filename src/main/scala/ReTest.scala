object ReTest{
  def main(args: Array[String]): Unit = {
    val str = "asd,dsa,qwe,kkk"
    val list = str.split("\\s*,\\s*").filter(v => !v.equals(""))
    list.foreach(println)
  }
}


class ReTest {


}
