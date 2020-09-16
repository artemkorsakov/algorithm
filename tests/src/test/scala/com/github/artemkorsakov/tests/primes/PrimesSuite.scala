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

  test("primes method") {
    primes(30) shouldBe Array(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
    val prms = primes(1001003)
    prms startsWith Array(2, 3, 5, 7)
    prms endsWith Array(1000973, 1000981, 1000999, 1001003)
  }

  test("givenCountOfPrimes method") {
    givenCountOfPrimes(10) shouldBe Array(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
    val prms = givenCountOfPrimes(10001)
    prms startsWith Array(2, 3, 5, 7, 11)
    prms endsWith Array(104711, 104717, 104723, 104729, 104743)
  }

  test("largestPrimeFactor method") {
    6.largestPrimeFactor shouldBe 3
    104743.largestPrimeFactor shouldBe 104743
    1024.largestPrimeFactor shouldBe 2
    13195.largestPrimeFactor shouldBe 29
    600851475143L.largestPrimeFactor shouldBe 6857L
    5.largestPrimeFactor shouldBe 5
  }

  test("smallestPrimeFactors method") {
    smallestPrimeFactors(10) shouldBe Array(0, 0, 2, 3, 2, 5, 2, 7, 2, 3, 2)
  }

  test("smallestPrimeFactor method") {
    6.smallestPrimeFactor shouldBe 2
    104743.smallestPrimeFactor shouldBe 104743
    1024.smallestPrimeFactor shouldBe 2
    42.smallestPrimeFactor shouldBe 2
    10965021787L.smallestPrimeFactor shouldBe 104711
  }

}
