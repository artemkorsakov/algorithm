package com.github.artemkorsakov.primes

class PhiFunction(n: Long) {
  import Primes._

  /** Counts the positive integers up to a given integer n that are relatively prime to n.
    *
    * @see <a href="https://en.wikipedia.org/wiki/Euler%27s_totient_function">detailed description</a>
    */
  def totient: Long =
    n.primeFactorsWithPow.keySet.foldLeft(n)((b, p) => b * (p - 1) / p)
}

object PhiFunction {
  import Primes._

  implicit def long2PhiFunction(i: Long): PhiFunction = new PhiFunction(i)
  implicit def int2PhiFunction(i: Int): PhiFunction   = new PhiFunction(i.toLong)

  /** Euler's totient function array
    */
  def totientArray(limit: Int): Array[Long] = {
    val phiArray = new Array[Long](limit + 1)
    phiArray(1) = 1

    val primesArray = primes(limit)
    for (n <- 1 to limit / 2) {
      var i = 0
      while (i < primesArray.length && n * primesArray(i) <= limit) {
        val p = primesArray(i)
        phiArray(n * p) = phiArray(n) * (if (n % p == 0) p else p - 1)
        i += 1
      }
    }

    phiArray
  }
}
