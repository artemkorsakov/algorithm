package com.github.artemkorsakov.tests.numbers

import com.github.artemkorsakov.numbers.RationalNumber
import com.github.artemkorsakov.numbers.RationalNumber._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class RationalNumberSuite extends AnyFunSuiteLike {
  test("add, sub, mul, div and upend") {
    val x = RationalNumber(1, 3)
    val y = RationalNumber(5, 7)
    x.add(y) shouldBe RationalNumber(22, 21)
    x.sub(y) shouldBe RationalNumber(-8, 21)
    x.mul(y) shouldBe RationalNumber(5, 21)
    x.div(y) shouldBe RationalNumber(7, 15)
    (x + y) shouldBe RationalNumber(22, 21)
    (x + 2) shouldBe RationalNumber(7, 3)
    (2 + x) shouldBe RationalNumber(7, 3)
    (x - y) shouldBe RationalNumber(-8, 21)
    (x - 2) shouldBe RationalNumber(-5, 3)
    (2 - x) shouldBe RationalNumber(5, 3)
    (x * y) shouldBe RationalNumber(5, 21)
    (x * 2) shouldBe RationalNumber(2, 3)
    (2 * x) shouldBe RationalNumber(2, 3)
    (x / y) shouldBe RationalNumber(7, 15)
    (x / 2) shouldBe RationalNumber(1, 6)
    (2 / x) shouldBe RationalNumber(6)
    x.upend shouldBe RationalNumber(3, 1)
    y.upend shouldBe RationalNumber(7, 5)
  }

  test("equal") {
    val x = RationalNumber(1, 3)
    x.equal(RationalNumber(1, 3)) shouldBe true
    x.equal(RationalNumber(-2, -6)) shouldBe true
    x.equal(RationalNumber(3, 9)) shouldBe true
    x.equal(RationalNumber(1, 4)) shouldBe false
    x == RationalNumber(1, 3) shouldBe true
    x == RationalNumber(-2, -6) shouldBe true
    x == RationalNumber(3, 9) shouldBe true
    x == RationalNumber(1, 4) shouldBe false
    RationalNumber(3) == RationalNumber(3, 1) shouldBe true
    RationalNumber(3L) == RationalNumber(3, 1) shouldBe true
    RationalNumber(BigInt(3)) == RationalNumber(3, 1) shouldBe true
  }

  test("compare") {
    val x = RationalNumber(1, 3)
    val y = RationalNumber(5, 7)

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

    max(x, y) shouldBe y
    max(x, x) shouldBe x
    max(y, y) shouldBe y
    (x max y) shouldBe y
    (x max x) shouldBe x
    (y max y) shouldBe y

    RationalNumber(2, 5) < RationalNumber(3, 7) shouldBe true
    RationalNumber(1, 2) > RationalNumber(3, 7) shouldBe true
  }

  test("toPercent") {
    math.round(RationalNumber(5, 7).toPercent * 10000) shouldBe 7143
  }

}
