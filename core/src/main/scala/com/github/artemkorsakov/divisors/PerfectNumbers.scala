package com.github.artemkorsakov.divisors

import com.github.artemkorsakov.divisors.Divisors._
import com.github.artemkorsakov.divisors.PerfectNumbers.PerfectNumbersType

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
  def perfectNumbersType: PerfectNumbersType.Value = {
    val sum = n.sumOfDivisors - n
    if (sum == n) {
      PerfectNumbersType.Perfect
    } else if (sum < n) {
      PerfectNumbersType.Deficient
    } else {
      PerfectNumbersType.Abundant
    }
  }
}

object PerfectNumbers {
  implicit def long2PerfectNumbers(i: Long): PerfectNumbers = new PerfectNumbers(i)
  implicit def int2PerfectNumbers(i: Int): PerfectNumbers   = new PerfectNumbers(i.toLong)

  object PerfectNumbersType extends Enumeration {
    val Perfect, Deficient, Abundant = Value
  }
}
