package com.github.artemkorsakov.tests.numbers

import com.github.artemkorsakov.numbers.HammingNumber._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class HammingNumberSuite extends AnyFunSuiteLike {
  test("isHammingNumber") {
    isHammingNumber(2125764000, 5) shouldBe true
    isHammingNumber(2125764000, 7) shouldBe true
    isHammingNumber(2125764000, 3) shouldBe false
  }
}
