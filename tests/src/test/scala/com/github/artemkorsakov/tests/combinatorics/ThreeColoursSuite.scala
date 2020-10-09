package com.github.artemkorsakov.tests.combinatorics

import com.github.artemkorsakov.combinatorics.ThreeColours._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class ThreeColoursSuite extends AnyFunSuiteLike {
  test("countThreeColoursRows") {
    countABCRows(1, 1, 1) shouldBe 6
    countABCRows(2, 1, 1) shouldBe 12
    countABCRows(2, 2, 0) shouldBe 6
    countABCRows(2, 2, 1) shouldBe 30
    countABCRows(2, 2, 2) shouldBe 90
    countABCRows(0, 2, 2) shouldBe 6
    countABCRows(2, 0, 2) shouldBe 6
  }
}
