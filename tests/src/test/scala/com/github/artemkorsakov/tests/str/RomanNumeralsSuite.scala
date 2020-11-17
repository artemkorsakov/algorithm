package com.github.artemkorsakov.tests.str

import cats.implicits._
import com.github.artemkorsakov.str.RomanNumerals._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class RomanNumeralsSuite extends AnyFunSuiteLike {
  test("toMinimalRomanNumeral") {
    "XXXXVIIII".toMinimalRomanNumeral shouldBe "XLIX".some
    "XXXXIIIIIIIII".toMinimalRomanNumeral shouldBe "XLIX".some
    "XXXXVIIII".toMinimalRomanNumeral shouldBe "XLIX".some
    "XXXXIX".toMinimalRomanNumeral shouldBe "XLIX".some
    "XLIIIIIIIII".toMinimalRomanNumeral shouldBe "XLIX".some
    "XLVIIII".toMinimalRomanNumeral shouldBe "XLIX".some
    "MCCCCCCVI".toMinimalRomanNumeral shouldBe "MDCVI".some
    "XIIIIII".toMinimalRomanNumeral shouldBe "XVI".some
    "VVVI".toMinimalRomanNumeral shouldBe "XVI".some
    "VIIIIIIIIIII".toMinimalRomanNumeral shouldBe "XVI".some
    "".toMinimalRomanNumeral shouldBe "".some
    "VIIIAIIIIIIII".toMinimalRomanNumeral shouldBe None
    "MCMLAXXXIV".toMinimalRomanNumeral shouldBe None
  }

  test("toArabic") {
    "XLIX".toArabic shouldBe 49.some
    "MCMLXXXIV".toArabic shouldBe 1984.some
    "VIIIIIIIIIII".toArabic shouldBe 16.some
    "MCMLAXXXIV".toArabic shouldBe None
  }

  test("toRoman") {
    -1.toRoman shouldBe None
    0.toRoman shouldBe "".some
    49.toRoman shouldBe "XLIX".some
    1984.toRoman shouldBe "MCMLXXXIV".some
  }

}
