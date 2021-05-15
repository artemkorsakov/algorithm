package com.github.artemkorsakov.tests.numbers

import com.github.artemkorsakov.numbers.Palindrome._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class PalindromeSuite extends AnyFunSuiteLike {
  test("isPalindrome") {
    isPalindrome(1100) shouldBe false
    isPalindrome(10) shouldBe false
    isPalindrome(4994) shouldBe true
    isPalindrome(BigInt("4668731596684224866951378664")) shouldBe true
    isPalindrome(BigInt("4668731596684224866951378665")) shouldBe false
  }

  test("isPalindromeByBase") {
    isPalindrome(3, 2) shouldBe true
    isPalindrome(4, 2) shouldBe false
    isPalindrome(15, 2) shouldBe true
    isPalindrome(26, 3) shouldBe true
    isPalindrome(63, 4) shouldBe true
    isPalindrome(4994, 2) shouldBe false
  }
}
