package com.github.artemkorsakov.tests.numbers

import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class PalindromeSuite extends AnyFunSuiteLike{
  test("test") {
    1 shouldBe 1
  }
}

/*
package com.github.artemkorsakov.numbers;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigInteger;

public class PalindromeTests {
    @Test
    public void testIsPalindrome() {
        Assert.assertFalse(Palindrome.isPalindrome(1100));
        Assert.assertFalse(Palindrome.isPalindrome(10));
        Assert.assertTrue(Palindrome.isPalindrome(4994));
        Assert.assertTrue(Palindrome.isPalindrome(new BigInteger("4668731596684224866951378664")));
        Assert.assertFalse(Palindrome.isPalindrome(new BigInteger("4668731596684224866951378665")));
    }
}

 */
