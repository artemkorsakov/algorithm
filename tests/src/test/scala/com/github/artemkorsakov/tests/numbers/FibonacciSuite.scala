package com.github.artemkorsakov.tests.numbers

import com.github.artemkorsakov.numbers.Fibonacci._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class FibonacciSuite extends AnyFunSuiteLike {
  test("fibonacci") {
    1.fibonacci.toInt shouldBe 1
    2.fibonacci.toInt shouldBe 1
    3.fibonacci.toInt shouldBe 2
    4.fibonacci.toInt shouldBe 3
    5.fibonacci.toInt shouldBe 5
    6.fibonacci.toInt shouldBe 8
    7.fibonacci.toInt shouldBe 13
    8.fibonacci.toInt shouldBe 21
    9.fibonacci.toInt shouldBe 34
    10.fibonacci.toInt shouldBe 55
    11.fibonacci.toInt shouldBe 89
    12.fibonacci.toInt shouldBe 144
    13.fibonacci.toInt shouldBe 233
    14.fibonacci.toInt shouldBe 377
    15.fibonacci.toInt shouldBe 610
    16.fibonacci.toInt shouldBe 987
    17.fibonacci.toInt shouldBe 1597
    18.fibonacci.toInt shouldBe 2584
    19.fibonacci.toInt shouldBe 4181
    20.fibonacci.toInt shouldBe 6765
    21.fibonacci.toInt shouldBe 10946
    100.fibonacci shouldBe BigInt("354224848179265190133")
  }

  test("fibonacciMatrix") {
    20.fibonacciMatrix shouldBe Some(Seq(Seq(21.fibonacci, 20.fibonacci), Seq(20.fibonacci, 19.fibonacci)))
  }

  test("fibonacciMatrix by module") {
    1000000000000000L.fibonacciMatrix(1307674368000L) shouldBe Some(
      Seq(Seq(73179529501L, 36651874875L), Seq(36651874875L, 36527654626L))
    )
  }
}
