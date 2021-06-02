package com.github.artemkorsakov.numbers

/** <a href="https://en.wikipedia.org/wiki/Palindrome">Palindrome</a> */
object Palindrome {
  def isPalindrome(number: BigInt, base: Int = 10): Boolean =
    number == 0 || number > 0 && number % base != 0 && {
      var revertedNumber = BigInt(0)
      var k              = number
      while (k > revertedNumber) {
        revertedNumber = revertedNumber * base + k % base
        k /= base
      }
      k == revertedNumber || k == revertedNumber / base
    }
}
