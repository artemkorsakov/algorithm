package com.github.artemkorsakov.str

/**
  * I = 1
  * V = 5
  * X = 10
  * L = 50
  * C = 100
  * D = 500
  * M = 1000
  */
object RomanNumeralSymbol extends Enumeration {
  val I: RomanNumeralSymbol.Value  = Value(1)
  val IV: RomanNumeralSymbol.Value = Value(4)
  val V: RomanNumeralSymbol.Value  = Value(5)
  val IX: RomanNumeralSymbol.Value = Value(9)
  val X: RomanNumeralSymbol.Value  = Value(10)
  val XL: RomanNumeralSymbol.Value = Value(40)
  val L: RomanNumeralSymbol.Value  = Value(50)
  val XC: RomanNumeralSymbol.Value = Value(90)
  val C: RomanNumeralSymbol.Value  = Value(100)
  val CD: RomanNumeralSymbol.Value = Value(400)
  val D: RomanNumeralSymbol.Value  = Value(500)
  val CM: RomanNumeralSymbol.Value = Value(900)
  val M: RomanNumeralSymbol.Value  = Value(1000)

  def toRomanNumeralSymbol(twoChars: String): Option[RomanNumeralSymbol.Value] =
    RomanNumeralSymbol.values
      .find(v => v.toString.equals(twoChars))
      .orElse(RomanNumeralSymbol.values.find(v => v.toString.equals(twoChars.head.toString)))
}
