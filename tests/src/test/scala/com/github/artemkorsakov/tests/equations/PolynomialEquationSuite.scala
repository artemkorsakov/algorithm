package com.github.artemkorsakov.tests.equations

import com.github.artemkorsakov.equations.PolynomialEquation
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class PolynomialEquationSuite extends AnyFunSuiteLike {
  val goodPolynomialArrayTemp: Array[Long] = (1L to 10L).map(i => i * i * i).toArray

  test("polynomialCoefficients") {
    val aList0 = PolynomialEquation.polynomialCoefficients(2, goodPolynomialArrayTemp)
    PolynomialEquation.polynomialSolution(1, aList0) shouldBe 1
    PolynomialEquation.polynomialSolution(2, aList0) shouldBe 8
    PolynomialEquation.polynomialSolution(3, aList0) shouldBe 15

    val aList1 = PolynomialEquation.polynomialCoefficients(3, goodPolynomialArrayTemp)
    PolynomialEquation.polynomialSolution(1, aList1) shouldBe 1
    PolynomialEquation.polynomialSolution(2, aList1) shouldBe 8
    PolynomialEquation.polynomialSolution(3, aList1) shouldBe 27
    PolynomialEquation.polynomialSolution(4, aList1) shouldBe 58

    val expected = Array(1, 683, 44287, 838861, 8138021, 51828151, 247165843, 954437177, 3138105961L, 9090909091L,
      23775972551L, 57154490053L, 128011456717L, 269971011311L, 540609741211L, 1034834473201L, 1903994239313L,
      3382547898907L, 5824512944911L)
    var aList = PolynomialEquation.polynomialCoefficients(1, expected)
    PolynomialEquation.polynomialSolution(1, aList) shouldBe 1
    PolynomialEquation.polynomialSolution(2, aList) shouldBe 1

    aList = PolynomialEquation.polynomialCoefficients(2, expected)
    PolynomialEquation.polynomialSolution(1, aList) shouldBe 1
    PolynomialEquation.polynomialSolution(2, aList) shouldBe 683
    PolynomialEquation.polynomialSolution(3, aList) shouldBe 1365

    aList = PolynomialEquation.polynomialCoefficients(3, expected)
    PolynomialEquation.polynomialSolution(1, aList) shouldBe 1
    PolynomialEquation.polynomialSolution(2, aList) shouldBe 683
    PolynomialEquation.polynomialSolution(3, aList) shouldBe 44287
    PolynomialEquation.polynomialSolution(4, aList) shouldBe 130813

    aList = PolynomialEquation.polynomialCoefficients(4, expected)
    PolynomialEquation.polynomialSolution(1, aList) shouldBe 1
    PolynomialEquation.polynomialSolution(2, aList) shouldBe 683
    PolynomialEquation.polynomialSolution(3, aList) shouldBe 44287
    PolynomialEquation.polynomialSolution(4, aList) shouldBe 838861
    PolynomialEquation.polynomialSolution(5, aList) shouldBe 3092453

    aList = PolynomialEquation.polynomialCoefficients(5, expected)
    PolynomialEquation.polynomialSolution(1, aList) shouldBe 1
    PolynomialEquation.polynomialSolution(2, aList) shouldBe 683
    PolynomialEquation.polynomialSolution(3, aList) shouldBe 44287
    PolynomialEquation.polynomialSolution(4, aList) shouldBe 838861
    PolynomialEquation.polynomialSolution(5, aList) shouldBe 8138021
    PolynomialEquation.polynomialSolution(6, aList) shouldBe 32740951

    aList = PolynomialEquation.polynomialCoefficients(6, expected)
    PolynomialEquation.polynomialSolution(1, aList) shouldBe 1
    PolynomialEquation.polynomialSolution(2, aList) shouldBe 683
    PolynomialEquation.polynomialSolution(3, aList) shouldBe 44287
    PolynomialEquation.polynomialSolution(4, aList) shouldBe 838861
    PolynomialEquation.polynomialSolution(5, aList) shouldBe 8138021
    PolynomialEquation.polynomialSolution(6, aList) shouldBe 51828151
    PolynomialEquation.polynomialSolution(7, aList) shouldBe 205015603

    aList = PolynomialEquation.polynomialCoefficients(7, expected)
    PolynomialEquation.polynomialSolution(1, aList) shouldBe 1
    PolynomialEquation.polynomialSolution(2, aList) shouldBe 683
    PolynomialEquation.polynomialSolution(3, aList) shouldBe 44287
    PolynomialEquation.polynomialSolution(4, aList) shouldBe 838861
    PolynomialEquation.polynomialSolution(5, aList) shouldBe 8138021
    PolynomialEquation.polynomialSolution(6, aList) shouldBe 51828151
    PolynomialEquation.polynomialSolution(7, aList) shouldBe 247165843
    PolynomialEquation.polynomialSolution(8, aList) shouldBe 898165577

    aList = PolynomialEquation.polynomialCoefficients(8, expected)
    PolynomialEquation.polynomialSolution(1, aList) shouldBe 1
    PolynomialEquation.polynomialSolution(2, aList) shouldBe 683
    PolynomialEquation.polynomialSolution(3, aList) shouldBe 44287
    PolynomialEquation.polynomialSolution(4, aList) shouldBe 838861
    PolynomialEquation.polynomialSolution(5, aList) shouldBe 8138021
    PolynomialEquation.polynomialSolution(6, aList) shouldBe 51828151
    PolynomialEquation.polynomialSolution(7, aList) shouldBe 247165843
    PolynomialEquation.polynomialSolution(8, aList) shouldBe 954437177
    PolynomialEquation.polynomialSolution(9, aList) shouldBe 3093310441L

    aList = PolynomialEquation.polynomialCoefficients(9, expected)
    PolynomialEquation.polynomialSolution(1, aList) shouldBe 1
    PolynomialEquation.polynomialSolution(2, aList) shouldBe 683
    PolynomialEquation.polynomialSolution(3, aList) shouldBe 44287
    PolynomialEquation.polynomialSolution(4, aList) shouldBe 838861
    PolynomialEquation.polynomialSolution(5, aList) shouldBe 8138021
    PolynomialEquation.polynomialSolution(6, aList) shouldBe 51828151
    PolynomialEquation.polynomialSolution(7, aList) shouldBe 247165843
    PolynomialEquation.polynomialSolution(8, aList) shouldBe 954437177
    PolynomialEquation.polynomialSolution(9, aList) shouldBe 3138105961L
    PolynomialEquation.polynomialSolution(10, aList) shouldBe 9071313571L

    aList = PolynomialEquation.polynomialCoefficients(10, expected)
    PolynomialEquation.polynomialSolution(1, aList) shouldBe 1
    PolynomialEquation.polynomialSolution(2, aList) shouldBe 683
    PolynomialEquation.polynomialSolution(3, aList) shouldBe 44287
    PolynomialEquation.polynomialSolution(4, aList) shouldBe 838861
    PolynomialEquation.polynomialSolution(5, aList) shouldBe 8138021
    PolynomialEquation.polynomialSolution(6, aList) shouldBe 51828151
    PolynomialEquation.polynomialSolution(7, aList) shouldBe 247165843
    PolynomialEquation.polynomialSolution(8, aList) shouldBe 954437177
    PolynomialEquation.polynomialSolution(9, aList) shouldBe 3138105961L
    PolynomialEquation.polynomialSolution(10, aList) shouldBe 9090909091L
    PolynomialEquation.polynomialSolution(11, aList) shouldBe 23772343751L
  }

}
