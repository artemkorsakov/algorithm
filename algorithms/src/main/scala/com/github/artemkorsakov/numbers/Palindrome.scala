package com.github.artemkorsakov.numbers

/** <a href="https://en.wikipedia.org/wiki/Palindrome">Palindrome</a> */
object Palindrome {
  def isPalindrome(number: BigInt): Boolean = isPalindrome(number, 10)

  def isPalindrome(number: BigInt, base: Int): Boolean = number == reversed(number, base)

  private def reversed(number: BigInt, base: Int): BigInt = {
    var reversed = BigInt(0)
    var k        = number
    while (k > 0) {
      reversed = base * reversed + k % base
      k /= base
    }
    reversed
  }
}
