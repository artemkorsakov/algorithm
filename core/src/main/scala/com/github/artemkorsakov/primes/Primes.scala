package com.github.artemkorsakov.primes

import scala.collection.mutable

class Primes(n: Long) {
  import Primes._

  /** Determines if the given integer is prime.
    */
  def isPrime: Boolean =
    if (n < 2) false
    else if (n < 4) true
    else if (n % 2 == 0) false
    else if (n < 9) true
    else if (n % 3 == 0) false
    else {
      val sqrt      = math.sqrt(n.toDouble).toLong
      var candidate = 5
      while (candidate <= sqrt && n % candidate != 0) candidate += (if (candidate % 6 == 5) 2 else 4)
      n                             % candidate != 0
    }

  /** Get next prime number for the given prime number.
    */
  def nextPrime: Long =
    if (n == 2)
      3
    else if (n == 3)
      5
    else {
      var nextPrime = if (n % 3 == 1) n + 4 else n + 2
      while (!nextPrime.isPrime)
        nextPrime = if (nextPrime % 3 == 1) nextPrime + 4 else nextPrime + 2
      nextPrime
    }

  /** Get the largest prime factor.
    */
  def largestPrimeFactor: Long = {
    var max    = 1L
    var i      = 2L
    var number = n
    while (i <= number) {
      if (number % i == 0) {
        max = i
        while (number % i == 0)
          number /= i
      }
      i = i.nextPrime
    }

    max
  }

  /** Get the smallest prime factor.
    */
  def smallestPrimeFactor: Long =
    (2L to math.sqrt(n.toDouble).toLong).find(n % _ == 0).getOrElse(n)

  /** For a given number return all its prime factors with powers.
    */
  def primeFactorsWithPow: Map[Long, Long] = {
    val map = mutable.Map.empty[Long, Long]

    var i      = 2L
    var number = n
    while (number > 1) {
      if (i.isPrime && number % i == 0) {
        var pow = 0L
        while (number % i == 0) {
          number /= i
          pow += 1
        }
        map += i -> pow
      }
      i += 1
    }

    map.toMap
  }

  /**
    * Goldbach's conjecture.
    * Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers.
    * E.g. 28 = 5 + 23. It is one of the most famous facts in number theory that has not been proved to be correct in the general case.
    * It has been numerically confirmed up to very large numbers (much larger than Scala's Int can represent).
    * Write a function to find the two prime numbers that sum up to a given even integer.
    */
  def goldbach: (Long, Long) = {
    val p = (2L to n / 2).find(p => p.isPrime && (n - p).isPrime).getOrElse(0L)
    (p, n - p)
  }
}

object Primes {
  implicit def long2PrimesLong(i: Long): Primes = new Primes(i)
  implicit def int2PrimesLong(i: Int): Primes   = new Primes(i.toLong)

  /** Array of boolean values whether the array index is a prime number (Sieve of Eratosthenes).
    */
  def isPrimeArray(n: Int): Array[Boolean] = {
    val result = Array.fill(n + 1)(true)
    result(0) = false
    result(1) = false

    var i  = 2
    var i2 = i * i
    while (i2 <= n) {
      if (result(i))
        (i2 to n by i).foreach(j => result(j) = false)
      i += 1
      i2 = i * i
    }
    result
  }

  /** All prime numbers from 2 through n (inclusive).
    */
  def primes(n: Int): Array[Int] =
    isPrimeArray(n).zipWithIndex.withFilter(_._1).map(_._2)

  /** Get the given number of primes.
    */
  def generatePrimes(count: Int): Array[Int] =
    if (count <= 0)
      Array.empty[Int]
    else if (count == 1)
      Array(2)
    else if (count == 2)
      Array(2, 3)
    else {
      val result = new Array[Int](count)
      result(0) = 2
      result(1) = 3

      var candidate = 5
      var tempCount = 2
      while (tempCount < count) {
        if (candidate.isPrime) {
          result(tempCount) = candidate
          tempCount += 1
        }
        candidate += 2
        if (tempCount < count && candidate.isPrime) {
          result(tempCount) = candidate
          tempCount += 1
        }
        candidate += 4
      }

      result
    }

  /** Returns an array spf where spf(k) is the smallest prime factor of k, valid for 2 &#8804; k &#8804; n.
    * For example: spf = {0, 0, 2, 3, 2, 5, 2, 7, 2, 3, 2}.
    */
  def smallestPrimeFactorArray(count: Int): Array[Int] = {
    val result = new Array[Int](count + 1)

    val limit = math.sqrt(count.toDouble).toInt
    for (i <- 2 until result.length)
      if (result(i) == 0) {
        result(i) = i
        if (i <= limit)
          for (j <- i * i to count by i)
            if (result(j) == 0)
              result(j) = i
      }

    result
  }

}
