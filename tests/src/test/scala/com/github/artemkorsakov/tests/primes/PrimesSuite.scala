package com.github.artemkorsakov.tests.primes

import com.github.artemkorsakov.primes.Primes._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class PrimesSuite extends AnyFunSuiteLike {
  test("isPrime method") {
    (-1).isPrime shouldBe false
    0.isPrime shouldBe false
    1.isPrime shouldBe false
    2.isPrime shouldBe true
    3.isPrime shouldBe true
    4.isPrime shouldBe false
    5.isPrime shouldBe true
    6.isPrime shouldBe false
    7.isPrime shouldBe true
    8.isPrime shouldBe false
    9.isPrime shouldBe false
    10.isPrime shouldBe false
    1000999.isPrime shouldBe true
  }

  test("nextPrime method") {
    2.nextPrime shouldBe 3
    3.nextPrime shouldBe 5
    5.nextPrime shouldBe 7
    7.nextPrime shouldBe 11
    11.nextPrime shouldBe 13
    13.nextPrime shouldBe 17
    1000999.nextPrime shouldBe 1001003
  }

  test("isPrimeArray method") {
    isPrimeArray(20) shouldBe Array(false, false, true, true, false, true, false, true, false, false, false, true,
      false, true, false, false, false, true, false, true, false)
  }
}
