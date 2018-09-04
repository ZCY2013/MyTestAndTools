import joptsimple.OptionParser

import scala.math.ScalaNumber

object OptionParserTest {
  def main(args: Array[String]): Unit = {
    val optionParser = new OptionParser(false)
    val overrideOpt = optionParser.accepts("override", "Optional property that should override values set in server.properties file")
      .withRequiredArg()
      .ofType(classOf[String])
    val Testobject = TestObject.run()
//    System.err.println("USAGE: java [options] %s server.properties [--override property=value]*".format("KafkaServer"))
    optionParser.printHelpOn(System.err)
    val options = optionParser.parse(args.slice(1, args.length): _*)
//    print(args.length)
//    System.nanoTime();
    print(options.nonOptionArguments())
//    println("server:" map unwrapArg :_*)
//    print(java.lang.String.format("1 %s 2 %s 3 %s 4 %s 5%s 6 %s 7%s ", "server:" map unwrapArg:_*))
//    print("server:" map unwrapArg: _*)
  }
//  private def unwrapArg(arg: Any): AnyRef = arg match {
//    case x: ScalaNumber => x.underlying
//    case x              => x.asInstanceOf[AnyRef]
//  }
}
