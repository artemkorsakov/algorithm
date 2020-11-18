package com.github.artemkorsakov.primes

/** The radical of n, rad(n), is the product of distinct prime factors of n.
  * For example, 504 = 2<sup>3</sup> × 3<sup>2</sup> × 7, so rad(504) = 2 × 3 × 7 = 42.
  */
class Radicals(n: Long) {
  import Primes._

  /** Return the product of distinct prime factors of n.
    */
  def rad: Long =
    n.primeFactorsWithPow.keySet.product

  /** Is square-free integer?
    * @see <a href="https://en.wikipedia.org/wiki/Square-free_integer">detailed description</a>
    */
  def isSquareFree: Boolean = {
    var p      = 2L
    val s      = math.sqrt(n.toDouble).toLong
    var isFree = true
    while (p <= s && isFree) {
      if (n % (p * p) == 0) {
        isFree = false
      }
      p = p.nextPrime
    }
    isFree
  }
}

object Radicals {
  import Primes._
  implicit def long2Radicals(i: Long): Radicals = new Radicals(i)
  implicit def int2Radicals(i: Int): Radicals   = new Radicals(i.toLong)

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
