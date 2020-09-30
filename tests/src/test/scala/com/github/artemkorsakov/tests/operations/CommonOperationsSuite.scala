package com.github.artemkorsakov.tests.operations

import com.github.artemkorsakov.operations.CommonOperations._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class CommonOperationsSuite extends AnyFunSuiteLike {
  test("sumToGiven") {
    sumToGiven(1000000) shouldBe 500000500000L
  }

  test("sumOfSquaresTo") {
    sumOfSquaresTo(1000) shouldBe 333833500
  }

  test("sumOfCubesTo") {
    sumOfCubesTo(1000) shouldBe 250500250000L
  }

  test("sqrt") {
    (81.sqrt - 9) < 1e-5 shouldBe true
  }

  test("isSquare") {
    36.isSquare shouldBe true
    35.isSquare shouldBe false
    37.isSquare shouldBe false
  }

  test("allSquares") {
    allSquares(2) shouldBe Array(16, 25, 36, 49, 64, 81)
    allSquares(4) shouldBe Array(1024, 1089, 1156, 1225, 1296, 1369, 1444, 1521, 1600, 1681, 1764, 1849, 1936, 2025,
      2116, 2209, 2304, 2401, 2500, 2601, 2704, 2809, 2916, 3025, 3136, 3249, 3364, 3481, 3600, 3721, 3844, 3969, 4096,
      4225, 4356, 4489, 4624, 4761, 4900, 5041, 5184, 5329, 5476, 5625, 5776, 5929, 6084, 6241, 6400, 6561, 6724, 6889,
      7056, 7225, 7396, 7569, 7744, 7921, 8100, 8281, 8464, 8649, 8836, 9025, 9216, 9409, 9604, 9801)
    allSquares(36, 49) shouldBe Array(36, 49)
    allSquares(1023, 1445) shouldBe Array(1024, 1089, 1156, 1225, 1296, 1369, 1444)
    allSquares(1024, 1444) shouldBe Array(1024, 1089, 1156, 1225, 1296, 1369, 1444)
    allSquares(1025, 1443) shouldBe Array(1089, 1156, 1225, 1296, 1369)
  }

  test("allNumbersVariants") {
    allNumbersVariants(Set(2, 3)) shouldBe Set(Set(2), Set(3), Set(2, 3))
    allNumbersVariants(Set(2, 3, 5, 7)) shouldBe Set(
      Set(2),
      Set(3),
      Set(5),
      Set(7),
      Set(5, 7),
      Set(3, 5),
      Set(3, 7),
      Set(3, 5, 7),
      Set(2, 3),
      Set(2, 5),
      Set(2, 7),
      Set(2, 5, 7),
      Set(2, 3, 5),
      Set(2, 3, 7),
      Set(2, 3, 5, 7)
    )
  }

}
