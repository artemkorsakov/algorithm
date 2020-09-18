package com.github.artemkorsakov.tests.primes

import com.github.artemkorsakov.primes.Radicals._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class RadicalsSuite extends AnyFunSuiteLike {
  test("rad") {
    100.rad shouldBe 10
    7.rad shouldBe 7
    8.rad shouldBe 2
    12.rad shouldBe 6
  }

  test("allRads") {
    allRads(100) shouldBe Array(0, 1, 2, 3, 2, 5, 6, 7, 2, 3, 10, 11, 6, 13, 14, 15, 2, 17, 6, 19, 10, 21, 22, 23, 6, 5,
      26, 3, 14, 29, 30, 31, 2, 33, 34, 35, 6, 37, 38, 39, 10, 41, 42, 43, 22, 15, 46, 47, 6, 7, 10, 51, 26, 53, 6, 55,
      14, 57, 58, 59, 30, 61, 62, 21, 2, 65, 66, 67, 34, 69, 70, 71, 6, 73, 74, 15, 38, 77, 78, 79, 10, 3, 82, 83, 42,
      85, 86, 87, 22, 89, 30, 91, 46, 93, 94, 95, 6, 97, 14, 33, 10)
  }

  test("isSquareFree") {
    10.isSquareFree shouldBe true
    20.isSquareFree shouldBe false
    100.isSquareFree shouldBe false
  }
}
