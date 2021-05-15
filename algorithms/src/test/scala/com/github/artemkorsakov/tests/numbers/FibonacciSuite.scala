package com.github.artemkorsakov.tests.numbers

import com.github.artemkorsakov.numbers.Fibonacci._
import org.scalatest.Inspectors.forAll
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class FibonacciSuite extends AnyFunSuiteLike {
  test("approximateFibonacci") {
    approximateFibonacci(1) shouldBe 1
    approximateFibonacci(2) shouldBe 1
    approximateFibonacci(3) shouldBe 2
    approximateFibonacci(4) shouldBe 3
    approximateFibonacci(5) shouldBe 5
    approximateFibonacci(6) shouldBe 8
    approximateFibonacci(7) shouldBe 13
    approximateFibonacci(8) shouldBe 21
    approximateFibonacci(9) shouldBe 34
    approximateFibonacci(10) shouldBe 55
    approximateFibonacci(11) shouldBe 89
    approximateFibonacci(12) shouldBe 144
    approximateFibonacci(13) shouldBe 233
    approximateFibonacci(14) shouldBe 377
    approximateFibonacci(15) shouldBe 610
    approximateFibonacci(16) shouldBe 987
    approximateFibonacci(17) shouldBe 1597
    approximateFibonacci(18) shouldBe 2584
    approximateFibonacci(19) shouldBe 4181
    approximateFibonacci(20) shouldBe 6765
    approximateFibonacci(21) shouldBe 10946
    approximateFibonacci(100) shouldBe BigInt("354224848179265190133")
  }

  test("fibonacci") {
    forAll(1 to 21)(i => fibonacci(i).contains(approximateFibonacci(i)))
  }

  test("fibonacciMatrix") {
    val fib19 = approximateFibonacci(19)
    val fib20 = approximateFibonacci(20)
    val fib21 = approximateFibonacci(21)
    fibonacciMatrix(20) shouldBe Some(Seq(Seq(fib21, fib20), Seq(fib20, fib19)))
  }

  test("fibonacciMatrix by module") {
    fibonacciMatrix(1000000000000000L, 1307674368000L) shouldBe Some(
      Seq(Seq(73179529501L, 36651874875L), Seq(36651874875L, 36527654626L))
    )
  }
}
