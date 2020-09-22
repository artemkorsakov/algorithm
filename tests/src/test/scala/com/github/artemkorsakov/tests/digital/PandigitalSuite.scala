package com.github.artemkorsakov.tests.digital

import com.github.artemkorsakov.digital.Pandigital._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class PandigitalSuite extends AnyFunSuiteLike {
  test("isPandigital") {
    192384576L.isPandigital shouldBe true
    "192384576".isPandigital shouldBe true
    918273645L.isPandigital shouldBe true
    "918273645".isPandigital shouldBe true
    192384571L.isPandigital shouldBe false
    "192384571".isPandigital shouldBe false
    192384570L.isPandigital shouldBe false
    "192384570".isPandigital shouldBe false

    2134.isPandigital(4) shouldBe true
    "2134".isPandigital(4) shouldBe true
    7652413.isPandigital(7) shouldBe true
    "7652413".isPandigital(7) shouldBe true
    2144.isPandigital(4) shouldBe false
    "2144".isPandigital(4) shouldBe false
    2135.isPandigital(4) shouldBe false
    "2135".isPandigital(4) shouldBe false
    2140.isPandigital(4) shouldBe false
    "2140".isPandigital(4) shouldBe false

    1406357289L.isPandigital(Array(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)) shouldBe true
    140657289L.isPandigital(Array(9, 8, 7, 6, 5, 4, 2, 1, 0)) shouldBe true
    "1406357289".isPandigital(Array(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)) shouldBe true
    "140657289".isPandigital(Array(9, 8, 7, 6, 5, 4, 2, 1, 0)) shouldBe true
    1406357289L.isPandigital(Array(9, 8, 7, 6, 5, 4, 2, 1, 0)) shouldBe false
    140657289L.isPandigital(Array(9, 8, 7, 6, 5, 4, 3, 1, 0)) shouldBe false
    "1406357289".isPandigital(Array(9, 8, 7, 6, 5, 4, 2, 1, 0)) shouldBe false
    "140657289".isPandigital(Array(9, 8, 7, 6, 5, 4, 3, 1, 0)) shouldBe false
  }
}
