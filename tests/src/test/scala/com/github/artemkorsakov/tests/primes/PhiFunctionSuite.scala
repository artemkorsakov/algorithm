package com.github.artemkorsakov.tests.primes

import com.github.artemkorsakov.primes.PhiFunction._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class PhiFunctionSuite extends AnyFunSuiteLike {
  test("phiFunction") {
    1.phiFunction shouldBe 1
    2.phiFunction shouldBe 1
    3.phiFunction shouldBe 2
    4.phiFunction shouldBe 2
    5.phiFunction shouldBe 4
    6.phiFunction shouldBe 2
    7.phiFunction shouldBe 6
    8.phiFunction shouldBe 4
    9.phiFunction shouldBe 6
    10.phiFunction shouldBe 4

    87109.phiFunction shouldBe 79180
    284029.phiFunction shouldBe 282940
    9983167.phiFunction shouldBe 9973816
  }

  test("phiFunctionArray") {
    val phiArray = phiFunctionArray(10000)
    phiArray.zipWithIndex.forall(t => t._1 == t._2.phiFunction) shouldBe true
  }
}
