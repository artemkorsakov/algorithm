package com.github.artemkorsakov.primes

object PhiFunction {
  import Primes._

  def totient(n: Int): Long = totient(n.toLong)

  /** Counts the positive integers up to a given integer n that are relatively prime to n.
    *
    * @see <a href="https://en.wikipedia.org/wiki/Euler%27s_totient_function">detailed description</a>
    */
  def totient(n: Long): Long =
    if (n < 1) {
      0
    } else {
      var mul    = n
      var number = n
      if (number % 2 == 0) {
        while (number % 2 == 0) number /= 2
        mul = mul / 2
      }
      if (number % 3 == 0) {
        while (number % 3 == 0) number /= 3
        mul = (mul / 3) * 2
      }
      var i = 5L
      while (number > 1 && i * i <= number) {
        if (number % i == 0) {
          while (number % i == 0) number /= i
          mul = (mul / i) * (i - 1)
        }
        i += (if (i % 6 == 5) 2 else 4)
      }
      if (number > 1) mul = (mul / number) * (number - 1)
      mul
    }

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
