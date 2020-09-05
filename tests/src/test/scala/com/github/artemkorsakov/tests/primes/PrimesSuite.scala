package com.github.artemkorsakov.tests.primes

import com.github.artemkorsakov.primes.Primes._
import org.scalatest.Matchers
import org.scalatest.funsuite.AnyFunSuiteLike

class PrimesSuite extends AnyFunSuiteLike with Matchers {
  test("is a number a prime?") {
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

}
