package com.github.artemkorsakov.tests.digital

import com.github.artemkorsakov.digital.Digits._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class DigitsSuite extends AnyFunSuiteLike {
  test("containTheSameDigits") {
    containTheSameDigits(125874, 251748) shouldBe true
    containTheSameDigits(125874, 251744) shouldBe false
    containTheSameDigits(135796744L, 371694959L) shouldBe false
    containTheSameDigits(135796744L, 476379541L) shouldBe true
    containTheSameDigits(135796744L, 679151439L) shouldBe false
    containTheSameDigits(135796744L, 763551944L) shouldBe false
    containTheSameDigits(127035954683L, 352045367981L) shouldBe true
    containTheSameDigits(127035954683L, 373559126408L) shouldBe true
    containTheSameDigits(127035954683L, 569310543872L) shouldBe true
    containTheSameDigits(127035954683L, 589323567104L) shouldBe true
    containTheSameDigits("41063625", "56623104") shouldBe true
    containTheSameDigits("41063625", "66430125") shouldBe true
    containTheSameDigits("1234543", "1325434") shouldBe true
    containTheSameDigits("1234543", "1325433") shouldBe false
    containTheSameDigits("1234543", "132543") shouldBe false
    containTheSameDigits("125874", "251748") shouldBe true
    containTheSameDigits("125874", "251744") shouldBe false
  }

  test("digits") {
    digits(1406357289L) shouldBe Array(1, 4, 0, 6, 3, 5, 7, 2, 8, 9)
    digits(1234) shouldBe Array(1, 2, 3, 4)
    digits("1234") shouldBe Array(1, 2, 3, 4)
    digits("01234") shouldBe Array(1, 2, 3, 4)
    digits("0001234") shouldBe Array(1, 2, 3, 4)
    digits("1234000") shouldBe Array(1, 2, 3, 4, 0, 0, 0)
    digits(BigInt("12345678901234567890")) shouldBe Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
  }

  test("sumOfDigits") {
    sumOfDigits(1457) shouldBe 17
    sumOfDigits(1457L) shouldBe 17
    sumOfDigits("1457") shouldBe 17
    sumOfDigits(BigInt(1457)) shouldBe 17
  }

  test("hasEqualDigits") {
    hasEqualDigits(111) shouldBe true
    hasEqualDigits(112) shouldBe true
    hasEqualDigits(123) shouldBe false
    hasEqualDigits(56003) shouldBe true
    hasEqualDigits(56113) shouldBe true
    hasEqualDigits(56333) shouldBe true
    hasEqualDigits(56443) shouldBe true
    hasEqualDigits(56663) shouldBe true
    hasEqualDigits(56773) shouldBe true
    hasEqualDigits(56993) shouldBe true
    hasEqualDigits(569993, 3, 9) shouldBe true
    hasEqualDigits(56993, 2, 9) shouldBe true
    hasEqualDigits(56993, 3, 9) shouldBe false
  }

  test("possibleNumbers") {
    possibleNumbers(IndexedSeq(1, 3, 7)) shouldBe Set("713", "731", "317", "137", "173", "371")
    possibleNumbers(IndexedSeq(1, 0, 7)) shouldBe Set("710", "170", "107", "701", "071", "017")
    possibleNumbers(IndexedSeq(1, 1)) shouldBe Set("11")
    possibleNumbers(IndexedSeq(1, 1, 5, 6)) shouldBe Set(
      "1156",
      "1165",
      "1516",
      "1561",
      "1615",
      "1651",
      "5116",
      "5161",
      "5611",
      "6115",
      "6151",
      "6511"
    )
  }
}
