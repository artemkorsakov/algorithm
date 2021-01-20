package com.github.artemkorsakov.operations

import com.github.artemkorsakov.operations.CommonOperations._

import scala.annotation.tailrec
import scala.math._

class CommonOperations(x: Double) {
  def square: Double = x * x

  /** Returns a square root of a number x.
    *
    * @see <a href="https://en.wikipedia.org/wiki/Square_root">description</a>
    */
  def sqrt: Double = {
    @tailrec
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess else sqrtIter(improve(guess))

    def improve(guess: Double) =
      (guess + x / guess) / 2

    def isGoodEnough(guess: Double) =
      abs(guess.square - x) / x < 1e-10

    sqrtIter(1.0)
  }

  /** Is a number a square?
    */
  def isSquare: Boolean =
    abs(sqrt.toLong.toDouble.square - x) < 1e-10

}

object CommonOperations {
  implicit def int2CommonOperations(d: Int): CommonOperations       = new CommonOperations(d.toDouble)
  implicit def long2CommonOperations(d: Long): CommonOperations     = new CommonOperations(d.toDouble)
  implicit def double2CommonOperations(d: Double): CommonOperations = new CommonOperations(d)
  implicit def bigint2CommonOperations(d: BigInt): CommonOperations = new CommonOperations(d.toDouble)

  /** Returns the sum of numbers from 1 to a given.
    */
  def sumToGiven(n: Long): Long =
    n * (n + 1) / 2

  /** Returns the sum of squares of numbers from 1 to a given limit, inclusive.
    *
    * @see <a href="https://en.wikipedia.org/wiki/Square_number">description</a>
    */
  def sumOfSquaresTo(n: Long): Long =
    n * (n + 1) * (2 * n + 1) / 6

  /** Returns the sum of cubes first natural numbers.
    *
    * @see <a href="https://en.wikipedia.org/wiki/Cube_(algebra)">description</a>
    */
  def sumOfCubesTo(n: Long): Long =
    sumToGiven(n).toDouble.square.toLong

  /** Gets all square numbers the number of digits in which is equal to the given.
    */
  def allSquares(countOfDigits: Int): IndexedSeq[Int] = {
    val start  = pow(10.0, countOfDigits - 1.0).toInt
    val finish = start * 10 - 1
    allSquares(start, finish)
  }

  /** Gets all square numbers from start (inclusive) to finish (inclusive).
    */
  def allSquares(start: Int, finish: Int): IndexedSeq[Int] = {
    val first = if (start.toDouble.isSquare) sqrt(start.toDouble).toInt else sqrt(start.toDouble).toInt + 1
    (first to sqrt(finish.toDouble).toInt).map(i => i * i)
  }

  /** Returns a list of unique lists containing given numbers without repetition.
    */
  def allNumbersVariants(numbers: Set[Int]): Set[Set[Int]] =
    if (numbers.size <= 1)
      Set(numbers)
    else {
      val number                = numbers.head
      val allNumbersVariantTemp = allNumbersVariants(numbers.tail)
      Set(Set(number)) ++ allNumbersVariantTemp ++ allNumbersVariantTemp.map(tempVariant => tempVariant + number)
    }

}
