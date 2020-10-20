package com.github.artemkorsakov.tests.games.darts

import com.github.artemkorsakov.games.darts.Darts
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class DartsSuite extends AnyFunSuiteLike {
  test("allDistinctWaysToCheckOut") {
    val result = Darts.allDistinctWaysToCheckOut
    result(6) shouldBe 11
    result.values.sum shouldBe 42336
    (2 to 99).map(result.getOrElse(_, 0)).sum shouldBe 38182
  }
}
