package com.github.artemkorsakov.tests.combinatorics

import com.github.artemkorsakov.combinatorics.BinomialCoefficient._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class BinomialCoefficientSuite extends AnyFunSuiteLike {
  test("binomialCoefficient") {
    binomialCoefficient(100, -1) shouldBe BigInt(0)
    binomialCoefficient(-1, 100) shouldBe BigInt(0)
    binomialCoefficient(100, 0) shouldBe BigInt(1)
    binomialCoefficient(100, 1) shouldBe BigInt(100)
    binomialCoefficient(100, 32) shouldBe BigInt("143012501349174257560226775")
    binomialCoefficient(100, 50) shouldBe BigInt("100891344545564193334812497256")
    binomialCoefficient(100, 68) shouldBe BigInt("143012501349174257560226775")
    binomialCoefficient(100, 99) shouldBe BigInt(100)
    binomialCoefficient(100, 100) shouldBe BigInt(1)
    binomialCoefficient(100, 101) shouldBe BigInt(0)
    binomialCoefficient(100, 32, BigInt(1000000)) shouldBe BigInt(226775)
    binomialCoefficient(100, 50, BigInt(1000000)) shouldBe BigInt(497256)
  }
}
