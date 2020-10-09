package com.github.artemkorsakov.combinatorics

import scala.annotation.tailrec

object BinomialCoefficient {

  /** Get Binomial Coefficient
    *
    * @see <a href="https://en.wikipedia.org/wiki/Binomial_coefficient">detailed description</a>
    */
  @tailrec
  def binomialCoefficient(n: Int, k: Int): BigInt =
    if (k < 0 || k > n) {
      BigInt(0)
    } else if (k > n / 2) {
      binomialCoefficient(n, n - k)
    } else {
      val tup = (0 until k).foldLeft((BigInt(1), BigInt(1)))((t, i) => (t._1 * BigInt(n - i), t._2 * BigInt(k - i)))
      tup._1 / tup._2
    }

  /**
    * Get Binomial Coefficient by modulus
    *
    * @see <a href="https://en.wikipedia.org/wiki/Binomial_coefficient">detailed description</a>
    */
  def binomialCoefficient(n: Int, k: Int, mod: BigInt): BigInt =
    binomialCoefficient(n, k).mod(mod)

}
