package com.github.artemkorsakov.tests.primes

import com.github.artemkorsakov.primes.PhiFunction._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class PhiFunctionSuite extends AnyFunSuiteLike {
  test("totient") {
    1.totient shouldBe 1
    2.totient shouldBe 1
    3.totient shouldBe 2
    4.totient shouldBe 2
    5.totient shouldBe 4
    6.totient shouldBe 2
    7.totient shouldBe 6
    8.totient shouldBe 4
    9.totient shouldBe 6
    10.totient shouldBe 4

    87109.totient shouldBe 79180
    284029.totient shouldBe 282940
    9983167.totient shouldBe 9973816
  }

  test("totientArray") {
    val phiArray = totientArray(10000)
    phiArray.zipWithIndex.forall(t => t._1 == t._2.totient) shouldBe true
  }
}
