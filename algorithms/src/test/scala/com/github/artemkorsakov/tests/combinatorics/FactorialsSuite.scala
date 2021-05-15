package com.github.artemkorsakov.tests.combinatorics

import com.github.artemkorsakov.combinatorics.Factorials._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class FactorialsSuite extends AnyFunSuiteLike {
  test("factorial") {
    factorial(0) shouldBe 1
    factorial(1) shouldBe 1
    factorial(2) shouldBe 2
    factorial(9) shouldBe 362880
    factorial(15) shouldBe BigInt("1307674368000")
    factorial(30) shouldBe BigInt("265252859812191058636308480000000")
  }
}
