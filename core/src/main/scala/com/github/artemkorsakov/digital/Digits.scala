package com.github.artemkorsakov.digital

import com.github.artemkorsakov.str.StringAlgorithms

class Digits(number: BigInt) {

  /** Returns the digits of a number.
    */
  def digits: Array[Int] = {
    val digits = new Array[Int](number.toString.length)
    var i      = 1
    var n      = number
    while (i <= digits.length) {
      digits(digits.length - i) = (n % 10).toInt
      n /= 10
      i += 1
    }
    digits
  }

  /** Returns the sum of the digits of a number.
    */
  def sumOfDigits: Int = {
    var sum = 0
    var n   = number
    while (n > 0) {
      sum += (n % 10).toInt
      n /= 10
    }
    sum
  }

  /** Is the given digit in the given number at least countOfEqual times?
    */
  def hasEqualDigits(countOfEqual: Int, digit: Int): Boolean =
    digits.count(d => d == digit) >= countOfEqual

  /** Has equal digits?
    */
  def hasEqualDigits: Boolean = {
    val dgs = digits
    dgs.length != dgs.distinct.length
  }

}

object Digits {
  implicit def int2Digits(n: Int): Digits       = new Digits(BigInt(n))
  implicit def long2Digits(n: Long): Digits     = new Digits(BigInt(n))
  implicit def string2Digits(n: String): Digits = new Digits(BigInt(n))
  implicit def bigint2Digits(n: BigInt): Digits = new Digits(n)

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
