package com.github.artemkorsakov.tests.numbers

import com.github.artemkorsakov.numbers.CollatzNumber._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class CollatzNumberSuite extends AnyFunSuiteLike {
  test("collatz") {
    collatz(1) shouldBe 0
    collatz(3) shouldBe 7
    collatz(19) shouldBe 20
    collatz(27) shouldBe 111
  }
}
