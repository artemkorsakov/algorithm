package com.github.artemkorsakov.str

import cats.implicits._
import com.github.artemkorsakov.str.RomanNumeralSymbol._
import com.github.artemkorsakov.str.RomanNumerals._

/** Roman Numerals.
  *
  * @see <a href="https://en.wikipedia.org/wiki/Roman_numerals">Roman Numerals</a>
  * @see <a href="https://projecteuler.net/about=roman_numerals">About Roman Numerals</a>
  */
class RomanNumerals(roman: String) {

  lazy val toMinimalRomanNumeral: Option[String] = {
    if (roman.exists(ch => toRomanNumeralSymbol(ch.toString).isEmpty)) {
      None
    } else {
      roman.toUpperCase
        .replaceAll("IIIII", "V")
        .replaceAll("VV", "X")
        .replaceAll("XXXXX", "L")
        .replaceAll("LL", "C")
        .replaceAll("CCCCC", "D")
        .replaceAll("DD", "M")
        .replaceAll("VIIII", "IX")
        .replaceAll("IIII", "IV")
        .replaceAll("LXXXX", "XC")
        .replaceAll("XXXX", "XL")
        .replaceAll("DCCCC", "CM")
        .replaceAll("CCCC", "CD")
        .some
    }
  }

  lazy val toArabic: Option[Long] = {
    val min = toMinimalRomanNumeral
    if (min.isEmpty) {
      None
    } else {
      val temp = min.get + "  "
      var i    = 0
      var sum  = 0L
      while (i < min.get.length) {
        val symbol = toRomanNumeralSymbol(temp.substring(i, i + 2)).get
        sum += symbol.id
        i += symbol.toString.length
      }
      sum.some
    }
  }

}

class ArabicNumerals(number: Long) {
  lazy val toRoman: Option[String] =
    if (number < 0) {
      None
    } else if (number == 0) {
      "".some
    } else {
      val max = RomanNumeralSymbol.values.filter(v => v.id <= number).maxBy(_.id)
      max.toString.some |+| (number - max.id).toRoman
    }
}

object RomanNumerals {
  implicit def string2RomanNumerals(roman: String): RomanNumerals = new RomanNumerals(roman)
  implicit def long2ArabicNumerals(arabic: Long): ArabicNumerals  = new ArabicNumerals(arabic)
}
