package com.github.artemkorsakov.tests.equations

import com.github.artemkorsakov.equations._
import com.github.artemkorsakov.numbers._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class QuadraticEquationSuite extends AnyFunSuiteLike {
  test("solutionsInIntegers") {
    QuadraticEquation(1, -5, 6).solutionsInIntegers shouldBe Seq(3, 2)
    QuadraticEquation(1, -5, -6).solutionsInIntegers shouldBe Seq(6, -1)
    QuadraticEquation(4, -8, 4).solutionsInIntegers shouldBe Seq(1)
    QuadraticEquation(1, -5, 7).solutionsInIntegers shouldBe Seq()
    QuadraticEquation(1, -5, 5).solutionsInIntegers shouldBe Seq()
    QuadraticEquation(3, -4, 1).solutionsInIntegers shouldBe Seq(1)
    QuadraticEquation(3, 4, 1).solutionsInIntegers shouldBe Seq(-1)
  }

  test("solutions") {
    QuadraticEquation(1, -5, 6).solutions shouldBe Seq(3.0, 2.0)
    QuadraticEquation(1, -5, -6).solutions shouldBe Seq(6.0, -1.0)
    QuadraticEquation(1, -2, 1).solutions shouldBe Seq(1.0)
    QuadraticEquation(1, -5, 7).solutions shouldBe Seq()
    QuadraticEquation(1, -5, 5).solutions shouldBe Seq((5.0 + math.sqrt(5.0)) / 2.0, (5.0 - math.sqrt(5.0)) / 2.0)
    QuadraticEquation(3, -4, 1).solutions shouldBe Seq(1.0, 1.0 / 3.0)
    QuadraticEquation(3, 4, 1).solutions shouldBe Seq(-1.0 / 3.0, -1)
  }

  test("solutionsInComplexNumbers") {
    QuadraticEquation(1, -2, 2).solutionsInComplexNumbers shouldBe Seq(ComplexNumber(1, 1), ComplexNumber(1, -1))
    QuadraticEquation(3, 4, 1).solutionsInComplexNumbers shouldBe Seq(
      ComplexNumber(-1.0 / 3.0, 0.0),
      ComplexNumber(-1, 0.0)
    )
  }

}
