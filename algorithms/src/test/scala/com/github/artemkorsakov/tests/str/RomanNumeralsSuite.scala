package com.github.artemkorsakov.tests.str

import cats.implicits._
import com.github.artemkorsakov.str.ArabicNumerals.toRoman
import com.github.artemkorsakov.str.RomanNumerals._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class RomanNumeralsSuite extends AnyFunSuiteLike {
  test("toMinimalRomanNumeral") {
    toMinimalRomanNumeral("XXXXVIIII") shouldBe "XLIX".some
    toMinimalRomanNumeral("XXXXIIIIIIIII") shouldBe "XLIX".some
    toMinimalRomanNumeral("XXXXVIIII") shouldBe "XLIX".some
    toMinimalRomanNumeral("XXXXIX") shouldBe "XLIX".some
    toMinimalRomanNumeral("XLIIIIIIIII") shouldBe "XLIX".some
    toMinimalRomanNumeral("XLVIIII") shouldBe "XLIX".some
    toMinimalRomanNumeral("MCCCCCCVI") shouldBe "MDCVI".some
    toMinimalRomanNumeral("XIIIIII") shouldBe "XVI".some
    toMinimalRomanNumeral("VVVI") shouldBe "XVI".some
    toMinimalRomanNumeral("VIIIIIIIIIII") shouldBe "XVI".some
    toMinimalRomanNumeral("") shouldBe "".some
    toMinimalRomanNumeral("VIIIAIIIIIIII") shouldBe None
    toMinimalRomanNumeral("MCMLAXXXIV") shouldBe None
  }

  test("toArabic") {
    toArabic("XLIX") shouldBe 49.some
    toArabic("MCMLXXXIV") shouldBe 1984.some
    toArabic("VIIIIIIIIIII") shouldBe 16.some
    toArabic("MCMLAXXXIV") shouldBe None
  }

  test("toRoman") {
    toRoman(-1) shouldBe None
    toRoman(0) shouldBe "".some
    toRoman(49) shouldBe "XLIX".some
    toRoman(1984) shouldBe "MCMLXXXIV".some
  }

}
