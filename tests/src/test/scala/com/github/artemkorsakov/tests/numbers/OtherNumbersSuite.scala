package com.github.artemkorsakov.tests.numbers

import com.github.artemkorsakov.numbers.OtherNumbers._
import org.scalatest.Inspectors.forAll
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class OtherNumbersSuite extends AnyFunSuiteLike {
  test("padovan") {
    val expected: IndexedSeq[BigInt] = IndexedSeq(1, 0, 0, 1, 0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12, 16, 21, 28, 37, 49,
      65, 86, 114, 151, 200, 265, 351, 465, 616, 816, 1081, 1432, 1897, 2513, 3329, 4410, 5842, 7739, 10252, 13581,
      17991, 23833, 31572, 41824, 55405, 73396, 97229, 128801, 170625)

    forAll(expected.indices) { i =>
      padovan(i).shouldBe(expected(i))
    }
  }

  test("jacobsthal") {
    val expected: IndexedSeq[BigInt] = IndexedSeq(0, 1, 1, 3, 5, 11, 21, 43, 85, 171, 341, 683, 1365, 2731, 5461, 10923,
      21845, 43691, 87381, 174763, 349525, 699051, 1398101, 2796203, 5592405, 11184811, 22369621, 44739243, 89478485,
      178956971, 357913941, 715827883, 1431655765, 2863311531L, 5726623061L)

    forAll(expected.indices) { i =>
      jacobsthal(i).shouldBe(expected(i))
    }
  }

  test("pell") {
    val expected: IndexedSeq[BigInt] = IndexedSeq(0, 1, 2, 5, 12, 29, 70, 169, 408, 985, 2378, 5741, 13860, 33461,
      80782, 195025, 470832, 1136689, 2744210, 6625109, 15994428, 38613965, 93222358, 225058681, 543339720, 1311738121,
      3166815962L, 7645370045L, 18457556052L, 44560482149L, 107578520350L, 259717522849L)

    forAll(expected.indices) { i =>
      pell(i).shouldBe(expected(i))
    }
  }

  test("tribonacci") {
    val expected: IndexedSeq[BigInt] = IndexedSeq(0, 0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504, 927, 1705, 3136,
      5768, 10609, 19513, 35890, 66012, 121415, 223317, 410744, 755476, 1389537, 2555757, 4700770, 8646064, 15902591,
      29249425, 53798080, 98950096, 181997601, 334745777, 615693474, 1132436852L)

    forAll(expected.indices) { i =>
      tribonacci(i).shouldBe(expected(i))
    }
  }

  test("tetranacci") {
    val expected: IndexedSeq[BigInt] = IndexedSeq(0, 0, 0, 1, 1, 2, 4, 8, 15, 29, 56, 108, 208, 401, 773, 1490, 2872,
      5536, 10671, 20569, 39648, 76424, 147312, 283953, 547337, 1055026, 2033628, 3919944, 7555935, 14564533, 28074040,
      54114452, 104308960, 201061985, 387559437, 747044834, 1439975216, 2775641472L)

    forAll(expected.indices) { i =>
      tetranacci(i).shouldBe(expected(i))
    }
  }

}
