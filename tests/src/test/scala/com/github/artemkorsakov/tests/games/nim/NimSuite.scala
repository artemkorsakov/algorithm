package com.github.artemkorsakov.tests.games.nim

import com.github.artemkorsakov.games.nim.Nim
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class NimSuite extends AnyFunSuiteLike {
  test("Nim.getX") {
    Nim.getX(0, 0, 0) shouldBe 0
    Nim.getX(0, 0, 3) > 0 shouldBe true
    Nim.getX(0, 5, 5) shouldBe 0
    Nim.getX(0, 5, 6) > 0 shouldBe true
    Nim.getX(1, 2, 3) shouldBe 0
    Nim.getX(1, 2, 6) > 0 shouldBe true
    (1L to math.pow(2, 10).toLong).count(i => Nim.getX(i, 2 * i, 3 * i) == 0) shouldBe 144
  }
}
