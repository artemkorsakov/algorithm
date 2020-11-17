package com.github.artemkorsakov.tests.combinatorics

import com.github.artemkorsakov.combinatorics.Factorials._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class FactorialsSuite extends AnyFunSuiteLike {
  test("factorial") {
    0.factorial shouldBe 1
    1.factorial shouldBe 1
    2.factorial shouldBe 2
    9.factorial shouldBe 362880
    15.factorial shouldBe BigInt("1307674368000")
    30.factorial shouldBe BigInt("265252859812191058636308480000000")
  }
}
