package com.github.artemkorsakov.tests.divisors

import com.github.artemkorsakov.divisors.Divisors._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class DivisorsSuite extends AnyFunSuiteLike {
  test("gcd") {
    gcd(15, 12) shouldBe 3
    gcd(1, 12) shouldBe 1
    gcd(7, 12) shouldBe 1
    gcd(7, 49) shouldBe 7
    gcd(12121212L, 23422344L) shouldBe 12
    gcd(Array(14, 21, 28, 2, 49)) shouldBe 1
    gcd(Array(14, 21, 28, 49)) shouldBe 7
  }

  test("gcdex") {
    gcdex(15, 10) shouldBe ((5, 1, -1))
    gcdex(12121212L, 23422344L) shouldBe ((12, 347845, -180012))
  }

  test("gcdInverse") {
    gcdInverse(111, 10) shouldBe 1
  }

}

/*
public class DivisorsTests {
    @Test
    public void testGetDivisors() {
        Assert.assertEquals(Divisors.getDivisors(30), Arrays.asList(2L, 15L, 3L, 10L, 5L, 6L));
    }

    @Test
    public void testGetSumOfDivisors() {
        Assert.assertEquals(284, Divisors.getSumOfDivisorsLessThanN(220));
        Assert.assertEquals(220, Divisors.getSumOfDivisorsLessThanN(284));
        Assert.assertEquals(504, Divisors.getSumOfDivisors(220L).intValueExact());
        Assert.assertEquals(504, Divisors.getSumOfDivisors(284L).intValueExact());
    }

    @Test
    public void testGetCountOfDivisors() {
        Assert.assertEquals(Divisors.getCountOfDivisors(100), 9);
    }
}

 */
