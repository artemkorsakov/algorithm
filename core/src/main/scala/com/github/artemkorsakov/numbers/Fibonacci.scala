package com.github.artemkorsakov.numbers

import com.github.artemkorsakov.objects.Matrix._

/** <a href="https://en.wikipedia.org/wiki/Fibonacci_number">Fibonacci number</a> */
case class Fibonacci(n: Long) {
  private val PHI: BigDecimal                    = BigDecimal((1.0 + math.sqrt(5.0)) / 2.0)
  private val fibonacci_matrix: Seq[Seq[BigInt]] = Seq(Seq(1, 1), Seq(1, 0))

  /** Returns F<sub>n</sub> - n-th fibonacci number */
  def fibonacci: BigInt =
    (PHI.pow(n.toInt) / BigDecimal(math.sqrt(5))).setScale(0, BigDecimal.RoundingMode.HALF_UP).toBigInt

  def fibonacciMatrix: Option[Seq[Seq[BigInt]]] =
    fibonacci_matrix.power(n)

  def fibonacciMatrix(module: BigInt): Option[Seq[Seq[BigInt]]] =
    fibonacci_matrix.powerMod(n, module)

}

object Fibonacci {
  implicit def int2Fibonacci(n: Int): Fibonacci   = Fibonacci(n.toLong)
  implicit def long2Fibonacci(n: Long): Fibonacci = Fibonacci(n)
}
