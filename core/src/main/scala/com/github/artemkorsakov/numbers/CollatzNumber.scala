package com.github.artemkorsakov.numbers

import com.github.artemkorsakov.numbers.CollatzNumber._

import scala.collection.mutable

/** <a href="https://en.wikipedia.org/wiki/Collatz_conjecture">Collatz conjecture</a> */
case class CollatzNumber(n: Int) {
  private val cache: mutable.Map[Int, Int] = mutable.Map(1 -> 0)

  def collatz: Int =
    cache.getOrElseUpdate(n, if (n % 2 == 0) (n / 2).collatz + 1 else ((3 * n + 1) / 2).collatz + 2)
}

object CollatzNumber {
  implicit def int2CollatzNumber(n: Int): CollatzNumber = new CollatzNumber(n)
}
