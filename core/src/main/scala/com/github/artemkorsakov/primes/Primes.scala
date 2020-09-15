package com.github.artemkorsakov.primes

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
      n % candidate != 0
    }

  /** Get next prime number for the given prime number.
    */
  def nextPrime: Long =
    if (n == 2) {
      3
    } else if (n == 3) {
      5
    } else {
      var nextPrime = if (n % 3 == 1) n + 4 else n + 2
      while (!nextPrime.isPrime) {
        nextPrime = if (nextPrime % 3 == 1) nextPrime + 4 else nextPrime + 2
      }
      nextPrime
    }
}

object Primes {
  implicit def long2PrimesLong(i: Long): Primes = new Primes(i)

  /** Array of boolean values whether the array index is a prime number (Sieve of Eratosthenes).
    */
  def isPrimeArray(n: Int): Array[Boolean] = {
    val result = Array.fill(n + 1)(true)
    result(0) = false
    result(1) = false

    var i  = 2
    var i2 = i * i
    while (i2 <= n) {
      if (result(i)) {
        (i2 to n by i).foreach(j => result(j) = false)
      }
      i += 1
      i2 = i * i
    }
    result
  }

  /** All prime numbers from 2 through n (inclusive).
    */
  def primes(n: Int): Array[Int] =
    isPrimeArray(n).zipWithIndex.filter(_._1).map(_._2)

}
