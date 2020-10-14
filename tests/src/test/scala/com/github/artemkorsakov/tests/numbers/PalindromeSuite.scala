package com.github.artemkorsakov.tests.numbers

import com.github.artemkorsakov.numbers.Palindrome._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class PalindromeSuite extends AnyFunSuiteLike {
  test("isPalindrome") {
    1100.isPalindrome shouldBe false
    10.isPalindrome shouldBe false
    4994.isPalindrome shouldBe true
    BigInt("4668731596684224866951378664").isPalindrome shouldBe true
    BigInt("4668731596684224866951378665").isPalindrome shouldBe false
  }

  test("isPalindromeByBase") {
    3.isPalindrome(2) shouldBe true
    4.isPalindrome(2) shouldBe false
    15.isPalindrome(2) shouldBe true
    26.isPalindrome(3) shouldBe true
    63.isPalindrome(4) shouldBe true
    4994.isPalindrome(2) shouldBe false
  }
}
