package com.github.artemkorsakov.numbers

import com.github.artemkorsakov.digital.Digits._
import com.github.artemkorsakov.primes.Primes._

/** <a href="https://en.wikipedia.org/wiki/Harshad_number">Harshad number</a> */
case class HarshadNumber(number: Long) {

  /** A harshad number is an integer that is divisible by the sum of its digits. */
  def isHarshadNumber: Boolean =
    number % number.sumOfDigits == 0

  /** A strong Harshad number is a harshad number that, when divided by the sum of its digits, results in a prime. */
  def isStrongHarshadNumber: Boolean = {
    val sumOfDigits = number.sumOfDigits
    number % sumOfDigits == 0 && (number / sumOfDigits).isPrime
  }
}

object HarshadNumber {
  implicit def int2HarshadNumber(n: Int): HarshadNumber  = new HarshadNumber(n.toLong)
  implicit def int2HarshadNumber(n: Long): HarshadNumber = new HarshadNumber(n)

  /** Return all strong, right truncatable Harshad primes less than 10<sup>p</sup>. */
  def getStrongRightTruncatableHarshadPrimes(p: Int): Seq[Long] = {
    var harshadNumbers = Seq(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L)
    (1 until p - 1).flatMap { _ =>
      harshadNumbers = rightTruncatableHarshadNumbers(harshadNumbers)
      harshadNumbers.withFilter(_.isStrongHarshadNumber).flatMap(strongRightTruncatableHarshadPrimes)
    }
  }

  /** Now take the number 2011 which is prime.
    * When we truncate the last digit from it we get 201, a strong Harshad number that is also right truncatable.
    * Let's call such primes strong, right truncatable Harshad primes.
    */
  private def strongRightTruncatableHarshadPrimes(strongHarshadNumber: Long): Seq[Long] =
    (1 to 9 by 2).withFilter(i => (strongHarshadNumber * 10 + i).isPrime).map(strongHarshadNumber * 10 + _)

  /** A Harshad or Niven number is a number that is divisible by the sum of its digits.
    * 201 is a Harshad number because it is divisible by 3 (the sum of its digits.)
    * When we truncate the last digit from 201, we get 20, which is a Harshad number.
    * When we truncate the last digit from 20, we get 2, which is also a Harshad number.
    * Let's call a Harshad number that, while recursively truncating the last digit,
    * always results in a Harshad number a right truncatable Harshad number.
    */
  private def rightTruncatableHarshadNumbers(harshadNumbers: Seq[Long]): Seq[Long] =
    harshadNumbers.flatMap(rightTruncatableHarshadNumbers)

  private def rightTruncatableHarshadNumbers(harshadNumber: Long): Seq[Long] = {
    val sumOfDigits = harshadNumber.sumOfDigits
    val newNumber   = harshadNumber * 10
    (0 to 9).withFilter(i => (newNumber + i) % (sumOfDigits + i) == 0).map(newNumber + _)
  }

}
