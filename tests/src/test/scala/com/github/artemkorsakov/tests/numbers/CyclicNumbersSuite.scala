package com.github.artemkorsakov.tests.numbers

import com.github.artemkorsakov.numbers.CyclicNumbers._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class CyclicNumbersSuite extends AnyFunSuiteLike {
  private val FIRST_TRIANGLES   = Array(1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91)
  private val FIRST_SQUARE      = Array(1, 4, 9, 16, 25, 36, 49, 64, 81)
  private val FIRST_PENTAGONALS = Array(1, 5, 12, 22, 35, 51, 70, 92)
  private val FIRST_HEXAGONALS  = Array(1, 6, 15, 28, 45, 66, 91)
  private val FIRST_HEPTAGONAL  = Array(1, 7, 18, 34, 55, 81)
  private val FIRST_OCTAGONAL   = Array(1, 8, 21, 40, 65, 96)

  test("check methods") {
    (1 to 13).forall(i => i.triangleNumber == FIRST_TRIANGLES(i - 1)) shouldBe true
    (1 to 9).forall(i => i.squareNumber == FIRST_SQUARE(i - 1)) shouldBe true
    (1 to 8).forall(i => i.pentagonalNumber == FIRST_PENTAGONALS(i - 1)) shouldBe true
    (1 to 7).forall(i => i.hexagonalNumber == FIRST_HEXAGONALS(i - 1)) shouldBe true
    (1 to 6).forall(i => i.heptagonalNumber == FIRST_HEPTAGONAL(i - 1)) shouldBe true
    (1 to 6).forall(i => i.octagonalNumber == FIRST_OCTAGONAL(i - 1)) shouldBe true

    for (i <- 1 until 100) {
      i.isTriangle shouldBe FIRST_TRIANGLES.contains(i)
      i.isSquare shouldBe FIRST_SQUARE.contains(i)
      i.isPentagonal shouldBe FIRST_PENTAGONALS.contains(i)
      i.isHexagonal shouldBe FIRST_HEXAGONALS.contains(i)
      i.isHeptagonal shouldBe FIRST_HEPTAGONAL.contains(i)
      i.isOctagonal shouldBe FIRST_OCTAGONAL.contains(i)
    }

    5482660.isPentagonal shouldBe true
    7042750.isPentagonal shouldBe true
    1560090.isPentagonal shouldBe true
    8602840.isPentagonal shouldBe true

    40755.isPentagonal shouldBe true
    40755.isTriangle shouldBe true
    40755.isHexagonal shouldBe true

    8256.isTriangle shouldBe true
    5625.isSquare shouldBe true
    2882.isPentagonal shouldBe true
    8128.isHexagonal shouldBe true
    2512.isHeptagonal shouldBe true
    1281.isOctagonal shouldBe true
  }
}
