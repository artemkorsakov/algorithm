package com.github.artemkorsakov.tests.divisors

import com.github.artemkorsakov.divisors.Divisors._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

import scala.collection.LinearSeq

class DivisorsSuite extends AnyFunSuiteLike {
  test("gcd") {
    gcd(15, 12) shouldBe 3
    gcd(1, 12) shouldBe 1
    gcd(7, 12) shouldBe 1
    gcd(7, 49) shouldBe 7
    gcd(12121212L, 23422344L) shouldBe 12
    gcd(LinearSeq(14, 21, 28, 2, 49)) shouldBe 1
    gcd(LinearSeq(14, 21, 28, 49)) shouldBe 7
    gcd(-8, 21) shouldBe 1
    gcd(BigInt(-8), BigInt(24)) shouldBe 8
  }

  test("gcdex") {
    gcdex(15, 10) shouldBe ((5, 1, -1))
    gcdex(12121212L, 23422344L) shouldBe ((12, 347845, -180012))
  }

  test("gcdInverse") {
    gcdInverse(111, 10) shouldBe 1
  }

  test("divisors") {
    divisors(30) shouldBe Set(2, 15, 3, 10, 5, 6)
  }

  test("sumOfDivisors") {
    sumOfDivisors(220) shouldBe 504
    sumOfDivisors(284) shouldBe 504
  }

  test("countOfDivisors") {
    countOfDivisors(100) shouldBe 9
  }
}
