package com.github.artemkorsakov.tests.str

import com.github.artemkorsakov.str.RomanNumeralSymbol
import com.github.artemkorsakov.str.RomanNumeralSymbol._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class RomanNumeralSymbolSuite extends AnyFunSuiteLike {
  test("RomanNumeralSymbol enum") {
    RomanNumeralSymbol.I.id shouldBe 1
    RomanNumeralSymbol.IV.id shouldBe 4
    RomanNumeralSymbol.V.id shouldBe 5
    RomanNumeralSymbol.IX.id shouldBe 9
    RomanNumeralSymbol.X.id shouldBe 10
    RomanNumeralSymbol.XL.id shouldBe 40
    RomanNumeralSymbol.L.id shouldBe 50
    RomanNumeralSymbol.XC.id shouldBe 90
    RomanNumeralSymbol.C.id shouldBe 100
    RomanNumeralSymbol.CD.id shouldBe 400
    RomanNumeralSymbol.D.id shouldBe 500
    RomanNumeralSymbol.CM.id shouldBe 900
    RomanNumeralSymbol.M.id shouldBe 1000
  }

  test("toRomanNumeralSymbol") {
    Some(RomanNumeralSymbol.I) shouldBe toRomanNumeralSymbol("I")
    Some(RomanNumeralSymbol.I) shouldBe toRomanNumeralSymbol("II")
    Some(RomanNumeralSymbol.I) shouldBe toRomanNumeralSymbol("IL")
    Some(RomanNumeralSymbol.I) shouldBe toRomanNumeralSymbol("III")
    Some(RomanNumeralSymbol.I) shouldBe toRomanNumeralSymbol("IIIL")
    Some(RomanNumeralSymbol.IV) shouldBe toRomanNumeralSymbol("IV")
    Some(RomanNumeralSymbol.V) shouldBe toRomanNumeralSymbol("V")
    Some(RomanNumeralSymbol.V) shouldBe toRomanNumeralSymbol("VV")
    Some(RomanNumeralSymbol.IX) shouldBe toRomanNumeralSymbol("IX")
    Some(RomanNumeralSymbol.X) shouldBe toRomanNumeralSymbol("X")
    Some(RomanNumeralSymbol.XL) shouldBe toRomanNumeralSymbol("XL")
    Some(RomanNumeralSymbol.L) shouldBe toRomanNumeralSymbol("L")
    Some(RomanNumeralSymbol.XC) shouldBe toRomanNumeralSymbol("XC")
    Some(RomanNumeralSymbol.C) shouldBe toRomanNumeralSymbol("C")
    Some(RomanNumeralSymbol.CD) shouldBe toRomanNumeralSymbol("CD")
    Some(RomanNumeralSymbol.D) shouldBe toRomanNumeralSymbol("D")
    Some(RomanNumeralSymbol.CM) shouldBe toRomanNumeralSymbol("CM")
    Some(RomanNumeralSymbol.M) shouldBe toRomanNumeralSymbol("M")
    toRomanNumeralSymbol("A") shouldBe None
    toRomanNumeralSymbol("AB") shouldBe None
    toRomanNumeralSymbol("ABC") shouldBe None
  }

}
