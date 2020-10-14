package com.github.artemkorsakov.tests.numbers

import com.github.artemkorsakov.numbers.RationalNumber
import com.github.artemkorsakov.numbers.RationalNumber._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class RationalNumberSuite extends AnyFunSuiteLike {
  test("add, sub, mul, div and upend") {
    val x = new RationalNumber(1, 3)
    val y = new RationalNumber(5, 7)
    x.add(y) equal new RationalNumber(22, 21) shouldBe true
    x.sub(y) equal new RationalNumber(-8, 21) shouldBe true
    x.mul(y) equal new RationalNumber(5, 21) shouldBe true
    x.div(y) equal new RationalNumber(7, 15) shouldBe true
    (x + y) == new RationalNumber(22, 21) shouldBe true
    (x - y) == new RationalNumber(-8, 21) shouldBe true
    (x * y) == new RationalNumber(5, 21) shouldBe true
    (x / y) == new RationalNumber(7, 15) shouldBe true
    x.upend == new RationalNumber(3, 1) shouldBe true
    y.upend == new RationalNumber(7, 5) shouldBe true
  }

  test("equal") {
    val x = new RationalNumber(1, 3)
    x.equal(new RationalNumber(1, 3)) shouldBe true
    x.equal(new RationalNumber(-2, -6)) shouldBe true
    x.equal(new RationalNumber(3, 9)) shouldBe true
    x.equal(new RationalNumber(1, 4)) shouldBe false
    x == new RationalNumber(1, 3) shouldBe true
    x == new RationalNumber(-2, -6) shouldBe true
    x == new RationalNumber(3, 9) shouldBe true
    x == new RationalNumber(1, 4) shouldBe false
    new RationalNumber(3) == new RationalNumber(3, 1) shouldBe true
    new RationalNumber(3L) == new RationalNumber(3, 1) shouldBe true
    new RationalNumber(BigInt(3)) == new RationalNumber(3, 1) shouldBe true
  }

  test("compare") {
    val x = new RationalNumber(1, 3)
    val y = new RationalNumber(5, 7)

    x < y shouldBe true
    y < x shouldBe false
    x < x shouldBe false
    x <= y shouldBe true
    x <= x shouldBe true

    x > y shouldBe false
    y > x shouldBe true
    x > x shouldBe false
    x >= y shouldBe false
    x >= x shouldBe true

    max(x, y) == y shouldBe true
    max(x, x) == x shouldBe true
    max(y, y) == y shouldBe true

    new RationalNumber(2, 5) < new RationalNumber(3, 7) shouldBe true
    new RationalNumber(1, 2) > new RationalNumber(3, 7) shouldBe true
  }

  test("toPercent") {
    math.round(new RationalNumber(5, 7).toPercent * 10000) shouldBe 7143
  }

}
