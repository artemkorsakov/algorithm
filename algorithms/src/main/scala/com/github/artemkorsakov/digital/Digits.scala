package com.github.artemkorsakov.digital

import com.github.artemkorsakov.str.StringAlgorithms

object Digits {

  /** Returns the digits of a number.
    */
  def digits(number: BigInt): IndexedSeq[Int] = digits(number.toString)

  /** Returns the digits of a number.
    */
  def digits(number: String): IndexedSeq[Int] = number.replaceFirst("^0+", "").trim.map(_.asDigit)

  /** Returns the sum of the digits of a number.
    */
  def sumOfDigits(number: BigInt): Int = sumOfDigits(number.toString)

  /** Returns the sum of the digits of a number.
    */
  def sumOfDigits(number: String): Int = number.foldLeft(0)((s, ch) => s + ch.asDigit)

  /** Is the given digit in the given number at least countOfEqual times?
    */
  def hasEqualDigits(number: BigInt, countOfEqual: Int, digit: Int): Boolean =
    digits(number).count(_ == digit) >= countOfEqual

  /** Has equal digits?
    */
  def hasEqualDigits(number: BigInt): Boolean = {
    val dgs = digits(number)
    dgs.length != dgs.distinct.length
  }

  /** Do two numbers contain the same digits?
    */
  def containTheSameDigits(number1: Long, number2: Long): Boolean =
    containTheSameDigits(String.valueOf(number1), String.valueOf(number2))

  /** Do two numbers contain the same digits?
    */
  def containTheSameDigits(number1: String, number2: String): Boolean =
    StringAlgorithms.areAnagrams(number1, number2)

  /** Returns all numbers made up of given digits.
    */
  def possibleNumbers(digits: IndexedSeq[Int]): Set[String] =
    if (digits.length == 1) {
      digits.map(_.toString).toSet
    } else {
      var products = Set.empty[String]
      for (i <- digits.indices) {
        val digit       = digits(i).toString
        val tmpDigits   = digits.take(i) ++ digits.takeRight(digits.length - i - 1)
        val tmpVariants = possibleNumbers(tmpDigits)
        for (tmpVariant <- tmpVariants) {
          val newProduct = digit + tmpVariant
          products += newProduct
        }
      }
      products
    }

}
