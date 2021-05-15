package com.github.artemkorsakov.tests.digital

import com.github.artemkorsakov.digital.Pandigital._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class PandigitalSuite extends AnyFunSuiteLike {
  test("isPandigital") {
    isPandigital(192384576L) shouldBe true
    isPandigital(918273645L) shouldBe true
    isPandigital(192384571L) shouldBe false
    isPandigital(192384570L) shouldBe false

    isPandigital(2134, 4) shouldBe true
    isPandigital(7652413, 7) shouldBe true
    isPandigital(2144, 4) shouldBe false
    isPandigital(2135, 4) shouldBe false
    isPandigital(2140, 4) shouldBe false

    isPandigital(1406357289L, Array(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)) shouldBe true
    isPandigital(140657289L, Array(9, 8, 7, 6, 5, 4, 2, 1, 0)) shouldBe true
    isPandigital(1406357289L, Array(9, 8, 7, 6, 5, 4, 2, 1, 0)) shouldBe false
    isPandigital(140657289L, Array(9, 8, 7, 6, 5, 4, 3, 1, 0)) shouldBe false
  }
}
