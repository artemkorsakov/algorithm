package com.github.artemkorsakov.tests.str

import cats.implicits._
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
    RomanNumeralSymbol.I.some shouldBe toRomanNumeralSymbol("I")
    RomanNumeralSymbol.I.some shouldBe toRomanNumeralSymbol("II")
    RomanNumeralSymbol.I.some shouldBe toRomanNumeralSymbol("IL")
    RomanNumeralSymbol.I.some shouldBe toRomanNumeralSymbol("III")
    RomanNumeralSymbol.I.some shouldBe toRomanNumeralSymbol("IIIL")
    RomanNumeralSymbol.IV.some shouldBe toRomanNumeralSymbol("IV")
    RomanNumeralSymbol.V.some shouldBe toRomanNumeralSymbol("V")
    RomanNumeralSymbol.V.some shouldBe toRomanNumeralSymbol("VV")
    RomanNumeralSymbol.IX.some shouldBe toRomanNumeralSymbol("IX")
    RomanNumeralSymbol.X.some shouldBe toRomanNumeralSymbol("X")
    RomanNumeralSymbol.XL.some shouldBe toRomanNumeralSymbol("XL")
    RomanNumeralSymbol.L.some shouldBe toRomanNumeralSymbol("L")
    RomanNumeralSymbol.XC.some shouldBe toRomanNumeralSymbol("XC")
    RomanNumeralSymbol.C.some shouldBe toRomanNumeralSymbol("C")
    RomanNumeralSymbol.CD.some shouldBe toRomanNumeralSymbol("CD")
    RomanNumeralSymbol.D.some shouldBe toRomanNumeralSymbol("D")
    RomanNumeralSymbol.CM.some shouldBe toRomanNumeralSymbol("CM")
    RomanNumeralSymbol.M.some shouldBe toRomanNumeralSymbol("M")
    toRomanNumeralSymbol("A") shouldBe None
    toRomanNumeralSymbol("AB") shouldBe None
    toRomanNumeralSymbol("ABC") shouldBe None
  }

}
