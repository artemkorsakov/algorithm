package com.github.artemkorsakov.tests.numbers

import com.github.artemkorsakov.numbers.HammingNumber._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class HammingNumberSuite extends AnyFunSuiteLike {
  test("isHammingNumber") {
    2125764000.isHammingNumber(5) shouldBe true
    2125764000.isHammingNumber(7) shouldBe true
    2125764000.isHammingNumber(3) shouldBe false
  }
}
