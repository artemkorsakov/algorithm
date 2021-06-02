package com.github.artemkorsakov.tests.str

import com.github.artemkorsakov.str.ArabicNumerals.toRoman
import com.github.artemkorsakov.str.RomanNumerals._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class RomanNumeralsSuite extends AnyFunSuiteLike {
  test("toMinimalRomanNumeral") {
    toMinimalRomanNumeral("XXXXVIIII") shouldBe Some("XLIX")
    toMinimalRomanNumeral("XXXXIIIIIIIII") shouldBe Some("XLIX")
    toMinimalRomanNumeral("XXXXVIIII") shouldBe Some("XLIX")
    toMinimalRomanNumeral("XXXXIX") shouldBe Some("XLIX")
    toMinimalRomanNumeral("XLIIIIIIIII") shouldBe Some("XLIX")
    toMinimalRomanNumeral("XLVIIII") shouldBe Some("XLIX")
    toMinimalRomanNumeral("MCCCCCCVI") shouldBe Some("MDCVI")
    toMinimalRomanNumeral("XIIIIII") shouldBe Some("XVI")
    toMinimalRomanNumeral("VVVI") shouldBe Some("XVI")
    toMinimalRomanNumeral("VIIIIIIIIIII") shouldBe Some("XVI")
    toMinimalRomanNumeral("") shouldBe Some("")
    toMinimalRomanNumeral("VIIIAIIIIIIII") shouldBe None
    toMinimalRomanNumeral("MCMLAXXXIV") shouldBe None
  }

  test("toArabic") {
    toArabic("XLIX") shouldBe Some(49)
    toArabic("MCMLXXXIV") shouldBe Some(1984)
    toArabic("VIIIIIIIIIII") shouldBe Some(16)
    toArabic("MCMLAXXXIV") shouldBe None
  }

  test("toRoman") {
    toRoman(-1) shouldBe None
    toRoman(0) shouldBe Some("")
    toRoman(49) shouldBe Some("XLIX")
    toRoman(1984) shouldBe Some("MCMLXXXIV")
  }

}
