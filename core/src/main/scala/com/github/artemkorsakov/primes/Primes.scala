package com.github.artemkorsakov.primes

class Primes(n: Long) {

  /**
    * Determines if the given integer is prime.
    *
    * Some useful facts:
    *
    *  - A prime number greater than 1.
    *  - All primes except 2 are odd.
    *  - All primes greater than 3 can be written in the form 6*k*&#177;1.
    *  - Any number n can have only one primefactor greater than &#8730;n.
    *  - The consequence for primality testing of a number n is: if we cannot find a number f less than
    *     or equal &#8730;n that divides n then n is prime: the only primefactor of n is n itself
    *
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

}

object Primes {
  implicit def long2PrimesLong(i: Long): Primes = new Primes(i)
}
