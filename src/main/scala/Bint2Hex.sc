//val str = "n=testName&u=testId&t=2018-09-03-16-04-50"
val str = "n=test&u=testid&t=2014-12-11-06-49-34&l=37"
val len = str.length
val str_str = str + "&l=" + len
val encrypt = encoderHex(str_str)
def encoderHex(str:String) :String = {
  val bytes = str.getBytes()
  val sb = new StringBuilder(bytes.length * 2)
  for(i <- 0 to bytes.length-1 )
    {
      sb.append(str.charAt((bytes(i) & 0xf0) >> 4))
      sb.append(str.charAt((bytes(i) & 0x0f)))
    }
  return sb.toString()
}