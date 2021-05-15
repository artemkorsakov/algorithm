package com.github.artemkorsakov.numbers

import scala.collection.mutable

/** <a href="https://en.wikipedia.org/wiki/Collatz_conjecture">Collatz conjecture</a> */
object CollatzNumber {
  private val cache: mutable.Map[Int, Int] = mutable.Map(1 -> 0)

  def collatz(n: Int): Int =
    cache.getOrElseUpdate(n, if (n % 2 == 0) collatz(n / 2) + 1 else collatz((3 * n + 1) / 2) + 2)
}
