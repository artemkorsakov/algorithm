package com.github.artemkorsakov.numbers

/** <a href="https://en.wikipedia.org/wiki/Palindrome">Palindrome</a> */
case class Palindrome(number: BigInt) {
  def isPalindrome: Boolean =
    isPalindrome(10)

  def isPalindrome(base: Int): Boolean =
    number == reversed(base)

  private def reversed(base: Int): BigInt = {
    var reversed = BigInt(0)
    var k        = number
    while (k > 0) {
      reversed = base * reversed + k % base
      k /= base
    }
    reversed
  }
}

object Palindrome {
  implicit def int2Palindrome(n: Int): Palindrome       = new Palindrome(BigInt(n))
  implicit def long2Palindrome(n: Long): Palindrome     = new Palindrome(BigInt(n))
  implicit def bigint2Palindrome(n: BigInt): Palindrome = new Palindrome(n)
}
