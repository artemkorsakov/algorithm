package com.github.artemkorsakov.divisors

import com.github.artemkorsakov.divisors.Divisors._
import com.github.artemkorsakov.divisors.PerfectNumbers._

class PerfectNumbers(n: Long) {

  /** Return numberType:
    *
    * Perfect: a perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself.
    *
    * Deficient: a deficient number is a positive integer that is less to the sum of its positive divisors, excluding the number itself.
    *
    * Abundant: an abundant number is a positive integer that is more to the sum of its positive divisors, excluding the number itself.
    *
    * @see <a href="https://en.wikipedia.org/wiki/Perfect_number">Perfect number</a>
    */
  def perfectNumbersType: PerfectNumbersType = {
    val sum = n.sumOfDivisors - n
    if (sum == n) {
      Perfect
    } else if (sum < n) {
      Deficient
    } else {
      Abundant
    }
  }
}

object PerfectNumbers {
  implicit def long2PerfectNumbers(i: Long): PerfectNumbers = new PerfectNumbers(i)
  implicit def int2PerfectNumbers(i: Int): PerfectNumbers   = new PerfectNumbers(i.toLong)

  sealed trait PerfectNumbersType
  case object Perfect   extends PerfectNumbersType
  case object Deficient extends PerfectNumbersType
  case object Abundant  extends PerfectNumbersType
}
