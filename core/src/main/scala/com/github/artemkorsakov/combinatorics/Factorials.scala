package com.github.artemkorsakov.combinatorics

class Factorials(n: Int) {

  /** Factorial
    *
    * @see <a href="https://en.wikipedia.org/wiki/Factorial">detailed description</a>
    */
  def factorial: BigInt = (2 to n).foldLeft(BigInt(1))((f, i) => f * BigInt(i))
}

object Factorials {
  implicit def int2Factorials(i: Int): Factorials = new Factorials(i)
}
