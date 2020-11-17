package com.github.artemkorsakov.tests.numbers

import com.github.artemkorsakov.numbers.CollatzNumber._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class CollatzNumberSuite extends AnyFunSuiteLike {
  test("collatz") {
    1.collatz shouldBe 0
    3.collatz shouldBe 7
    19.collatz shouldBe 20
    27.collatz shouldBe 111
  }
}
