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
    (1 to 13).forall(i => triangleNumber(i) == FIRST_TRIANGLES(i - 1)) shouldBe true
    (1 to 9).forall(i => squareNumber(i) == FIRST_SQUARE(i - 1)) shouldBe true
    (1 to 8).forall(i => pentagonalNumber(i) == FIRST_PENTAGONALS(i - 1)) shouldBe true
    (1 to 7).forall(i => hexagonalNumber(i) == FIRST_HEXAGONALS(i - 1)) shouldBe true
    (1 to 6).forall(i => heptagonalNumber(i) == FIRST_HEPTAGONAL(i - 1)) shouldBe true
    (1 to 6).forall(i => octagonalNumber(i) == FIRST_OCTAGONAL(i - 1)) shouldBe true

    for (i <- 1 until 100) {
      isTriangle(i) shouldBe FIRST_TRIANGLES.contains(i)
      isSquare(i) shouldBe FIRST_SQUARE.contains(i)
      isPentagonal(i) shouldBe FIRST_PENTAGONALS.contains(i)
      isHexagonal(i) shouldBe FIRST_HEXAGONALS.contains(i)
      isHeptagonal(i) shouldBe FIRST_HEPTAGONAL.contains(i)
      isOctagonal(i) shouldBe FIRST_OCTAGONAL.contains(i)
    }

    isPentagonal(5482660) shouldBe true
    isPentagonal(7042750) shouldBe true
    isPentagonal(1560090) shouldBe true
    isPentagonal(8602840) shouldBe true

    isPentagonal(40755) shouldBe true
    isTriangle(40755) shouldBe true
    isHexagonal(40755) shouldBe true

    isTriangle(8256) shouldBe true
    isSquare(5625) shouldBe true
    isPentagonal(2882) shouldBe true
    isHexagonal(8128) shouldBe true
    isHeptagonal(2512) shouldBe true
    isOctagonal(1281) shouldBe true
  }

}
