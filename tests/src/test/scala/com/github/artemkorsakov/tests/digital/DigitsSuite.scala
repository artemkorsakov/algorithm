package com.github.artemkorsakov.tests.digital

import com.github.artemkorsakov.digital.Digits._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class DigitsSuite extends AnyFunSuiteLike {
  test("containTheSameDigits") {
    containTheSameDigits(125874, 251748) shouldBe true
    containTheSameDigits(125874, 251744) shouldBe false
    containTheSameDigits(135796744L, 371694959L) shouldBe false
    containTheSameDigits(135796744L, 476379541L) shouldBe true
    containTheSameDigits(135796744L, 679151439L) shouldBe false
    containTheSameDigits(135796744L, 763551944L) shouldBe false
    containTheSameDigits(127035954683L, 352045367981L) shouldBe true
    containTheSameDigits(127035954683L, 373559126408L) shouldBe true
    containTheSameDigits(127035954683L, 569310543872L) shouldBe true
    containTheSameDigits(127035954683L, 589323567104L) shouldBe true
    containTheSameDigits("41063625", "56623104") shouldBe true
    containTheSameDigits("41063625", "66430125") shouldBe true
    containTheSameDigits("1234543", "1325434") shouldBe true
    containTheSameDigits("1234543", "1325433") shouldBe false
    containTheSameDigits("1234543", "132543") shouldBe false
    containTheSameDigits("125874", "251748") shouldBe true
    containTheSameDigits("125874", "251744") shouldBe false
  }

  test("digits") {
    1406357289L.digits shouldBe Array(1, 4, 0, 6, 3, 5, 7, 2, 8, 9)
    1234.digits shouldBe Array(1, 2, 3, 4)
    "0001234".digits shouldBe Array(1, 2, 3, 4)
    BigInt("12345678901234567890").digits shouldBe Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
  }

  test("sumOfDigits") {
    1457.sumOfDigits shouldBe 17
    1457L.sumOfDigits shouldBe 17
    "1457".sumOfDigits shouldBe 17
    BigInt(1457).sumOfDigits shouldBe 17
  }

}
/*

    @Test
    public void testHasEqualDigits() {
        Assert.assertTrue(Digits.hasEqualDigits(111));
        Assert.assertTrue(Digits.hasEqualDigits(112));
        Assert.assertFalse(Digits.hasEqualDigits(123));
        Assert.assertTrue(Digits.hasEqualDigits(56003));
        Assert.assertTrue(Digits.hasEqualDigits(56113));
        Assert.assertTrue(Digits.hasEqualDigits(56333));
        Assert.assertTrue(Digits.hasEqualDigits(56443));
        Assert.assertTrue(Digits.hasEqualDigits(56663));
        Assert.assertTrue(Digits.hasEqualDigits(56773));
        Assert.assertTrue(Digits.hasEqualDigits(56993));
        Assert.assertTrue(Digits.hasEqualDigits(569993, 3, 9));
        Assert.assertTrue(Digits.hasEqualDigits(56993, 2, 9));
        Assert.assertFalse(Digits.hasEqualDigits(56993, 3, 9));
    }

    @Test
    public void testGetPossibleVariants() {
        List<Integer> variants = Digits.getPossibleVariants(Arrays.asList(1, 3, 7));
        Assert.assertEquals(Arrays.asList(137, 173, 317, 371, 713, 731), variants);
        variants = Digits.getPossibleVariants(Arrays.asList(1, 1));
        Assert.assertEquals(Collections.singletonList(11), variants);
        variants = Digits.getPossibleVariants(Arrays.asList(1, 1, 5, 6));
        System.out.println(variants);
        Assert.assertEquals(Arrays.asList(1156, 1165, 1516, 1561, 1615, 1651, 5116, 5161, 5611, 6115, 6151, 6511), variants);
    }
 */
