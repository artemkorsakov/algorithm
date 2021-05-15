package com.github.artemkorsakov.tests.primes

import com.github.artemkorsakov.primes.Primes._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class PrimesSuite extends AnyFunSuiteLike {
  test("isPrime") {
    isPrime(-1) shouldBe false
    isPrime(0) shouldBe false
    isPrime(1) shouldBe false
    isPrime(2) shouldBe true
    isPrime(3) shouldBe true
    isPrime(4) shouldBe false
    isPrime(5) shouldBe true
    isPrime(6) shouldBe false
    isPrime(7) shouldBe true
    isPrime(8) shouldBe false
    isPrime(9) shouldBe false
    isPrime(10) shouldBe false
    isPrime(1000999) shouldBe true
  }

  test("nextPrime") {
    nextPrime(2) shouldBe 3
    nextPrime(3) shouldBe 5
    nextPrime(5) shouldBe 7
    nextPrime(7) shouldBe 11
    nextPrime(11) shouldBe 13
    nextPrime(13) shouldBe 17
    nextPrime(1000999) shouldBe 1001003

    val primesArray = primes(100)
    (0 until primesArray.length - 1).forall(i => nextPrime(primesArray(i)) == primesArray(i + 1)) shouldBe true
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
    largestPrimeFactor(6) shouldBe 3
    largestPrimeFactor(104743) shouldBe 104743
    largestPrimeFactor(1024) shouldBe 2
    largestPrimeFactor(13195) shouldBe 29
    largestPrimeFactor(600851475143L) shouldBe 6857L
    largestPrimeFactor(5) shouldBe 5
  }

  test("smallestPrimeFactor") {
    smallestPrimeFactor(6) shouldBe 2
    smallestPrimeFactor(104743) shouldBe 104743
    smallestPrimeFactor(1024) shouldBe 2
    smallestPrimeFactor(42) shouldBe 2
    smallestPrimeFactor(10965021787L) shouldBe 104711
  }

  test("smallestPrimeFactorArray") {
    smallestPrimeFactorArray(10) shouldBe Array(0, 0, 2, 3, 2, 5, 2, 7, 2, 3, 2)
  }

  test("primeFactorsWithPow") {
    primeFactorsWithPow(1000) shouldBe Map(2 -> 3, 5 -> 3)
    primeFactorsWithPow(1024) shouldBe Map(2 -> 10)
    primeFactorsWithPow(777111) shouldBe Map(3 -> 1, 37 -> 1, 7001 -> 1)
  }

  test("primeFactors") {
    primeFactors(1000) shouldBe Set(2, 5)
    primeFactors(1024) shouldBe Set(2)
    primeFactors(777111) shouldBe Set(3, 37, 7001)
  }

  test("goldbach") {
    goldbach(28) shouldBe ((5, 23))
  }

  test("isKPrime") {
    isKPrime(2627408, 6) shouldBe true
    isKPrime(2627416, 6) shouldBe true
    isKPrime(2627440, 6) shouldBe true
    isKPrime(2627448, 6) shouldBe true
  }
}
