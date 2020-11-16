package com.github.artemkorsakov.tests.divisors

import com.github.artemkorsakov.divisors.ChineseRemainderTheorem._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class ChineseRemainderTheoremSuite extends AnyFunSuiteLike {
  test("solution") {
    solution(Array(2, 3), Array(1, 2)) shouldBe 5
    solution(Array(707, 527), Array(0, 5)) shouldBe 258762
  }
}
