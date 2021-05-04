package com.github.artemkorsakov.tests.numbers

import com.github.artemkorsakov.numbers.HarshadNumber._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class HarshadNumberSuite extends AnyFunSuiteLike {
  test("isHarshadNumber") {
    1728.isHarshadNumber shouldBe true
    1729.isHarshadNumber shouldBe true
    1730.isHarshadNumber shouldBe false
    val first50HarshadNumbers = Array(10, 12, 18, 20, 21, 24, 27, 30, 36, 40, 42, 45, 48, 50, 54, 60, 63, 70, 72, 80,
      81, 84, 90, 100, 102, 108, 110, 111, 112, 114, 117, 120, 126, 132, 133, 135, 140, 144, 150, 152, 153, 156, 162,
      171, 180, 190, 192, 195, 198, 200)
    first50HarshadNumbers.forall(n => n.isHarshadNumber) shouldBe true
  }

  test("isStrongHarshadNumber") {
    198.isStrongHarshadNumber shouldBe true
    1728.isStrongHarshadNumber shouldBe false
    1729.isStrongHarshadNumber shouldBe false
    1730.isStrongHarshadNumber shouldBe false
  }

  test("getStrongRightTruncatableHarshadPrimes") {
    getStrongRightTruncatableHarshadPrimes(3) shouldBe Seq(181, 211, 271, 277, 421, 457, 631)
    getStrongRightTruncatableHarshadPrimes(4).sum shouldBe 90619
    getStrongRightTruncatableHarshadPrimes(5).sum shouldBe 388207
  }

}
