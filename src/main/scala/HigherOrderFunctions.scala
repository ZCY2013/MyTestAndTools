/**
  * Cousera function programing  week2
  * higher order functions
  */

class Rational(x:Int, y:Int){
  def numer = x
  def denom = y

  def addRational(r:Rational, s:Rational):Rational =
    new Rational(
      r.numer * s.denom + s.numer * r.denom,
      r.denom * s.denom
    )

  def makeString(r:Rational)=
    r.numer + "/" + r.denom

  def neg :Rational = new Rational(-numer, denom)

  def sub(that:Rational):Rational = addRational(this, that.neg)
}

object Test{
  def main(args: Array[String]): Unit = {
//    [1/x,2/y][][new Rational(1,2)/this] x
  }
}
