package com.github.artemkorsakov.digital

object Pandigital {

  /** Is a number an integer that has among its significant digits each digit used exactly once?
    */
  def isPandigital(number: Long): Boolean = {
    val num = number.toString
    num.length == 9 && !num.contains("0") && num.toSeq.distinct.length == 9
  }

  /** Is a number an integer that has among its significant digits (from 1 to n) each digit used exactly once?
    */
  def isPandigital(number: Long, n: Int): Boolean = {
    val num = number.toString
    (num.length == n) && (1 to n).forall(i => num.contains(i.toString))
  }

  /** Is a number an integer that has among its significant digits (from digits list) each digit used exactly once?
    */
  def isPandigital(number: Long, digits: Array[Int]): Boolean = {
    val num = number.toString
    (num.length == digits.length) && digits.forall(i => num.contains(i.toString))
  }
}
