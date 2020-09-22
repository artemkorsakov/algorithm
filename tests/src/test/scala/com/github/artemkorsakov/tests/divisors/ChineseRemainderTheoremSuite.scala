package com.github.artemkorsakov.tests.divisors

import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class ChineseRemainderTheoremSuite extends AnyFunSuiteLike {
  test("temp") {
    1 shouldBe 1
  }
}

/*
public class ChineseRemainderTheoremTests {
    private static final BigInteger A = BigInteger.valueOf(1_504_170_715_041_707L);
    private static final BigInteger MOD = BigInteger.valueOf(4_503_599_627_370_517L);

    @Test
    public void testGetSolution() {
        long n = ChineseRemainderTheorem.getSolution(new long[]{707, 527}, new long[]{0, 5});
        Assert.assertEquals(n, 258762);
        n = ChineseRemainderTheorem.getSolution(new BigInteger[]{A, MOD}, new BigInteger[]{BigInteger.ZERO, BigInteger.valueOf(8912517754604L)}).divide(A).longValueExact();
        Assert.assertEquals(n, 3);
        n = ChineseRemainderTheorem.getSolution(new BigInteger[]{A, MOD}, new BigInteger[]{BigInteger.ZERO, BigInteger.valueOf(2044785486369L)}).divide(A).longValueExact();
        Assert.assertEquals(n, 506);
        n = ChineseRemainderTheorem.getSolution(new BigInteger[]{A, MOD}, new BigInteger[]{BigInteger.ZERO, BigInteger.valueOf(1311409677241L)}).divide(A).longValueExact();
        Assert.assertEquals(n, 2527);
        n = ChineseRemainderTheorem.getSolution(new BigInteger[]{A, MOD}, new BigInteger[]{BigInteger.ZERO, BigInteger.valueOf(578033868113L)}).divide(A).longValueExact();
        Assert.assertEquals(n, 4548);
        n = ChineseRemainderTheorem.getSolution(new BigInteger[]{A, MOD}, new BigInteger[]{BigInteger.ZERO, BigInteger.valueOf(422691927098L)}).divide(A).longValueExact();
        Assert.assertEquals(n, 11117);
        n = ChineseRemainderTheorem.getSolution(new BigInteger[]{A, MOD}, new BigInteger[]{BigInteger.ZERO, BigInteger.valueOf(267349986083L)}).divide(A).longValueExact();
        Assert.assertEquals(n, 17686);
        n = ChineseRemainderTheorem.getSolution(new BigInteger[]{A, MOD}, new BigInteger[]{BigInteger.ZERO, BigInteger.valueOf(112008045068L)}).divide(A).longValueExact();
        Assert.assertEquals(n, 24255);
        n = ChineseRemainderTheorem.getSolution(new BigInteger[]{A, MOD}, new BigInteger[]{BigInteger.ZERO, BigInteger.valueOf(111054189)}).divide(A).longValueExact();
        Assert.assertEquals(n, 12263410);
        n = ChineseRemainderTheorem.getSolution(new BigInteger[]{A, MOD}, new BigInteger[]{BigInteger.ZERO, BigInteger.valueOf(15806432)}).divide(A).longValueExact();
        Assert.assertEquals(n, 42298633);
        n = ChineseRemainderTheorem.getSolution(new BigInteger[]{A, MOD}, new BigInteger[]{BigInteger.ZERO, BigInteger.valueOf(15397267)}).divide(A).longValueExact();
        Assert.assertEquals(n, 326125654);
        n = ChineseRemainderTheorem.getSolution(new BigInteger[]{A, MOD}, new BigInteger[]{BigInteger.ZERO, BigInteger.valueOf(14988102)}).divide(A).longValueExact();
        Assert.assertEquals(n, 609952675);
        n = ChineseRemainderTheorem.getSolution(new BigInteger[]{A, MOD}, new BigInteger[]{BigInteger.ZERO, BigInteger.valueOf(14578937)}).divide(A).longValueExact();
        Assert.assertEquals(n, 893779696);
    }

    @Test
    public void testGetSolution2() {
        long n = ChineseRemainderTheorem.getSolution(new long[]{2, 3}, new long[]{1, 2});
        Assert.assertEquals(n, 5);
    }
}

 */
