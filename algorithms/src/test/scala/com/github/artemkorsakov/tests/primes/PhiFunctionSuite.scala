package com.github.artemkorsakov.tests.primes

import com.github.artemkorsakov.primes.PhiFunction._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class PhiFunctionSuite extends AnyFunSuiteLike {
  test("totient") {
    totient(1) shouldBe 1
    totient(2) shouldBe 1
    totient(3) shouldBe 2
    totient(4) shouldBe 2
    totient(5) shouldBe 4
    totient(6) shouldBe 2
    totient(7) shouldBe 6
    totient(8) shouldBe 4
    totient(9) shouldBe 6
    totient(10) shouldBe 4

    totient(87109) shouldBe 79180
    totient(284029) shouldBe 282940
    totient(9983167) shouldBe 9973816
    totient(5654317604L) shouldBe 2609145504L
  }

  test("totientArray") {
    val phiArray = totientArray(10000)
    phiArray.zipWithIndex.forall(t => t._1 == totient(t._2)) shouldBe true
  }
}
