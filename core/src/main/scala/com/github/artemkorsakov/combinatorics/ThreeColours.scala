package com.github.artemkorsakov.combinatorics

import scala.collection.mutable

object ThreeColours {
  private val cache: mutable.Map[(Int, Int, Int), Long] = mutable.Map.empty[(Int, Int, Int), Long]

  /** We have A white balls, B black balls and C grey balls.
    * How many different options to arrange these balls in a row?
    */
  def countABCRows(a: Int, b: Int, c: Int): Long = {
    val seq = Seq(a, b, c)
    val min = seq.min
    if (min < 0) {
      0
    } else {
      val max = seq.max
      val mid = seq.sum - min - max
      cache.getOrElseUpdate((min, mid, max), count(min, mid, max))
    }
  }

  private def count(min: Int, mid: Int, max: Int): Long =
    if (min == 0 && mid == 0) 1
    else countABCRows(min - 1, mid, max) + countABCRows(min, mid - 1, max) + countABCRows(min, mid, max - 1)
}
