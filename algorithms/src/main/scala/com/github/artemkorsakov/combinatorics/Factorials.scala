package com.github.artemkorsakov.combinatorics

object Factorials {

  /** Factorial
    *
    * @see <a href="https://en.wikipedia.org/wiki/Factorial">detailed description</a>
    */
  def factorial(n: Int): BigInt = (2 to n).foldLeft(BigInt(1))((f, i) => f * BigInt(i))
}
