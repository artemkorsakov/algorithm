package com.github.artemkorsakov.tests.divisors

import com.github.artemkorsakov.divisors.PerfectNumbers._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class PerfectNumbersSuite extends AnyFunSuiteLike {
  test("perfectNumbersType") {
    6.perfectNumbersType shouldBe PerfectNumbersType.Perfect
    7.perfectNumbersType shouldBe PerfectNumbersType.Deficient
    12.perfectNumbersType shouldBe PerfectNumbersType.Abundant
  }
}
