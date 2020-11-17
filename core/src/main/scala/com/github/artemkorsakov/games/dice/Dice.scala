package com.github.artemkorsakov.games.dice

import com.github.artemkorsakov.numbers.RationalNumber

import scala.collection.mutable

case class Dice(maxCube: Int) {
  private val cache: mutable.Map[(Int, Int), Int] = mutable.Map.empty[(Int, Int), Int]

  /** An array of probabilities to get the given sums from the cube with the maximum face maxCube and for a given count of steps. */
  def probabilities(step: Int): Seq[RationalNumber] = {
    val sums  = (1 to maxCube * step).map(i => cubeCount(step, i))
    val total = sums.sum
    sums.map(RationalNumber(_, total))
  }

  private def cubeCount(steps: Int, sum: Int): Int =
    if (steps < 0 || sum < steps)
      0
    else if (steps == sum)
      1
    else if (steps == 0)
      0
    else
      cache.getOrElseUpdate((steps, sum), (1 to maxCube).map(i => cubeCount(steps - 1, sum - i)).sum)
}
