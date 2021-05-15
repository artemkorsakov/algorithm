package com.github.artemkorsakov.primes

/** The radical of n, rad(n), is the product of distinct prime factors of n.
  * For example, 504 = 2<sup>3</sup> × 3<sup>2</sup> × 7, so rad(504) = 2 × 3 × 7 = 42.
  */
object Radicals {
  import Primes._

  /** Return the product of distinct prime factors of n.
    */
  def rad(n: Long): Long = primeFactors(n).product

  /** Is square-free integer?
    * @see <a href="https://en.wikipedia.org/wiki/Square-free_integer">detailed description</a>
    */
  def isSquareFree(n: Long): Boolean = {
    var p      = 2L
    val s      = math.sqrt(n.toDouble).toLong
    var isFree = true
    while (p <= s && isFree) {
      if (n % (p * p) == 0) {
        isFree = false
      }
      p = nextPrime(p)
    }
    isFree
  }

  /** Return array of products of distinct prime factors of any n not more limit.
    */
  def allRads(limit: Int): Array[Int] = {
    val rads = new Array[Int](limit + 1)
    rads(1) = 1

    primes(limit).foreach(p =>
      (1 to limit / p).foreach(i => rads(i * p) = if (rads(i * p) == 0) p else rads(i * p) * p)
    )

    rads
  }
}
