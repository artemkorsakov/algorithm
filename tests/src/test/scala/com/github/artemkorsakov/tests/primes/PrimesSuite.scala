package com.github.artemkorsakov.tests.primes

import com.github.artemkorsakov.primes.Primes._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class PrimesSuite extends AnyFunSuiteLike {
  test("isPrime") {
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

  test("nextPrime") {
    2.nextPrime shouldBe 3
    3.nextPrime shouldBe 5
    5.nextPrime shouldBe 7
    7.nextPrime shouldBe 11
    11.nextPrime shouldBe 13
    13.nextPrime shouldBe 17
    1000999.nextPrime shouldBe 1001003

    val primesArray = primes(100)
    (0 until primesArray.length - 1).forall(i => primesArray(i).nextPrime == primesArray(i + 1)) shouldBe true
  }

  test("isPrimeArray") {
    isPrimeArray(20) shouldBe Array(false, false, true, true, false, true, false, true, false, false, false, true,
      false, true, false, false, false, true, false, true, false)
  }

  test("primes") {
    primes(30) shouldBe Array(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
    val prms = primes(1001003)
    prms startsWith Array(2, 3, 5, 7)
    prms endsWith Array(1000973, 1000981, 1000999, 1001003)
  }

  test("generatePrimes") {
    generatePrimes(10) shouldBe Array(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
    val prms = generatePrimes(10001)
    prms startsWith Array(2, 3, 5, 7, 11)
    prms endsWith Array(104711, 104717, 104723, 104729, 104743)
  }

  test("largestPrimeFactor") {
    6.largestPrimeFactor shouldBe 3
    104743.largestPrimeFactor shouldBe 104743
    1024.largestPrimeFactor shouldBe 2
    13195.largestPrimeFactor shouldBe 29
    600851475143L.largestPrimeFactor shouldBe 6857L
    5.largestPrimeFactor shouldBe 5
  }

  test("smallestPrimeFactor") {
    6.smallestPrimeFactor shouldBe 2
    104743.smallestPrimeFactor shouldBe 104743
    1024.smallestPrimeFactor shouldBe 2
    42.smallestPrimeFactor shouldBe 2
    10965021787L.smallestPrimeFactor shouldBe 104711
  }

  test("smallestPrimeFactorArray") {
    smallestPrimeFactorArray(10) shouldBe Array(0, 0, 2, 3, 2, 5, 2, 7, 2, 3, 2)
  }

  test("primeFactorsWithPow") {
    1000.primeFactorsWithPow shouldBe Map(2 -> 3, 5 -> 3)
    1024.primeFactorsWithPow shouldBe Map(2 -> 10)
    777111.primeFactorsWithPow shouldBe Map(3 -> 1, 37 -> 1, 7001 -> 1)
  }

  test("goldbach") {
    28.goldbach shouldBe ((5, 23))
  }

}
