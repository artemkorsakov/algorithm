package com.github.artemkorsakov.digital

class Pandigital(number: Long) {

  /** Is a number an integer that has among its significant digits each digit used exactly once?
    */
  def isPandigital: Boolean =
    number.toString.length == 9 && !number.toString.contains("0") && number.toString.toSeq.distinct.length == 9

  /** Is a number an integer that has among its significant digits (from 1 to n) each digit used exactly once?
    */
  def isPandigital(n: Int): Boolean =
    (number.toString.length == n) && (1 to n).forall(i => number.toString.contains(i.toString))

  /** Is a number an integer that has among its significant digits (from digits list) each digit used exactly once?
    */
  def isPandigital(digits: Array[Int]): Boolean =
    (number.toString.length == digits.length) && digits.forall(i => number.toString.contains(i.toString))

}

object Pandigital {
  implicit def int2Digits(n: Int): Pandigital       = new Pandigital(n.toLong)
  implicit def long2Digits(n: Long): Pandigital     = new Pandigital(n)
  implicit def string2Digits(n: String): Pandigital = new Pandigital(n.toLong)
}
