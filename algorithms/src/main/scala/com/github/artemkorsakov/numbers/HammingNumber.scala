package com.github.artemkorsakov.numbers

import com.github.artemkorsakov.primes.Primes.primes

/** A positive number is a generalised <a href="https://en.wikipedia.org/wiki/Regular_number">Hamming number</a> of type n,
  * if it has no prime factor larger than n.
  */
object HammingNumber {
  def isHammingNumber(number: Int, n: Int): Boolean = isHammingNumber(number.toLong, n)

  def isHammingNumber(number: Long, n: Int): Boolean =
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
