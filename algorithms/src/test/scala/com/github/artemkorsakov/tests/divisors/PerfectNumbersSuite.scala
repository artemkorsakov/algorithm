package com.github.artemkorsakov.tests.divisors

import com.github.artemkorsakov.divisors.PerfectNumbers._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class PerfectNumbersSuite extends AnyFunSuiteLike {
  test("perfectNumbersType") {
    perfectNumbersType(6) shouldBe Perfect
    perfectNumbersType(7) shouldBe Deficient
    perfectNumbersType(12) shouldBe Abundant
  }
}
