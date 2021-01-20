package com.github.artemkorsakov.numbers

import com.github.artemkorsakov.primes.Primes.primes

/** A positive number is a generalised <a href="https://en.wikipedia.org/wiki/Regular_number">Hamming number</a> of type n,
  * if it has no prime factor larger than n.
  */
case class HammingNumber(number: Long) {
  def isHammingNumber(n: Int): Boolean =
    if (number < 2 || number <= n) {
      true
    } else if (n < 2) {
      false
    } else {
      var temp       = number
      val primesList = primes(n)
      var isHamming  = false
      var i          = 0
      while (i < primesList.length && !isHamming) {
        val prime = primesList(i)
        while (temp % prime == 0)
          temp /= prime
        if (temp == 1) {
          isHamming = true
        }
        i += 1
      }
      isHamming
    }
}

object HammingNumber {
  implicit def int2HammingNumber(number: Int): HammingNumber   = HammingNumber(number.toLong)
  implicit def long2HammingNumber(number: Long): HammingNumber = HammingNumber(number)
}
