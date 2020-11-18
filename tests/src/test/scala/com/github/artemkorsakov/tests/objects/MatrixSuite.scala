package com.github.artemkorsakov.tests.objects

import com.github.artemkorsakov.objects.Matrix._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class MatrixSuite extends AnyFunSuiteLike {
  test("matrixTranspose") {
    val matrix1 = Seq(Seq(1, 2))
    val matrix2 = Seq(Seq(1), Seq(2))
    matrix1.matrixTranspose shouldBe matrix2
    matrix2.matrixTranspose shouldBe matrix1
    matrix1.matrixTranspose.matrixTranspose shouldBe matrix1
    matrix2.matrixTranspose.matrixTranspose shouldBe matrix2

    val matrix3 = Seq(Seq(1, 2), Seq(3, 4))
    val matrix4 = Seq(Seq(1, 3), Seq(2, 4))
    matrix3.matrixTranspose shouldBe matrix4
    matrix4.matrixTranspose shouldBe matrix3
    matrix3.matrixTranspose.matrixTranspose shouldBe matrix3
    matrix4.matrixTranspose.matrixTranspose shouldBe matrix4

    val matrix5 = Seq(Seq(1, 2), Seq(3, 4), Seq(5, 6))
    val matrix6 = Seq(Seq(1, 3, 5), Seq(2, 4, 6))
    matrix5.matrixTranspose shouldBe matrix6
    matrix6.matrixTranspose shouldBe matrix5
    matrix5.matrixTranspose.matrixTranspose shouldBe matrix5
    matrix6.matrixTranspose.matrixTranspose shouldBe matrix6

    val matrix7 = Seq(Seq(1.1, 2.2), Seq(3.3, 4.4))
    val matrix8 = Seq(Seq(1.1, 3.3), Seq(2.2, 4.4))
    matrix7.matrixTranspose shouldBe matrix8
    matrix8.matrixTranspose shouldBe matrix7
    matrix7.matrixTranspose.matrixTranspose shouldBe matrix7
    matrix8.matrixTranspose.matrixTranspose shouldBe matrix8

    val matrix9  = Seq(Seq(BigInt(1), BigInt(2)), Seq(BigInt(3), BigInt(4)), Seq(BigInt(5), BigInt(6)))
    val matrix10 = Seq(Seq(BigInt(1), BigInt(3), BigInt(5)), Seq(BigInt(2), BigInt(4), BigInt(6)))
    matrix9.matrixTranspose shouldBe matrix10
    matrix10.matrixTranspose shouldBe matrix9
    matrix9.matrixTranspose.matrixTranspose shouldBe matrix9
    matrix10.matrixTranspose.matrixTranspose shouldBe matrix10

    val matrix11 = Seq(Seq(1L, 2L), Seq(3L, 4L), Seq(5L, 6L))
    val matrix12 = Seq(Seq(1L, 3L, 5L), Seq(2L, 4L, 6L))
    matrix11.matrixTranspose shouldBe matrix12
    matrix12.matrixTranspose shouldBe matrix11
    matrix11.matrixTranspose.matrixTranspose shouldBe matrix11
    matrix12.matrixTranspose.matrixTranspose shouldBe matrix12
  }

  test("minorMatrix") {
    val matrix = Seq(Seq(-2, -1, -1, -4), Seq(-1, -2, -1, -6), Seq(-1, -1, 2, 4), Seq(2, 1, -3, -8))
    matrix.minorMatrix(0, 0) shouldBe Some(Seq(Seq(-2, -1, -6), Seq(-1, 2, 4), Seq(1, -3, -8)))
    matrix.minorMatrix(0, 1) shouldBe Some(Seq(Seq(-1, -1, -6), Seq(-1, 2, 4), Seq(2, -3, -8)))
    matrix.minorMatrix(0, 2) shouldBe Some(Seq(Seq(-1, -2, -6), Seq(-1, -1, 4), Seq(2, 1, -8)))
    matrix.minorMatrix(0, 3) shouldBe Some(Seq(Seq(-1, -2, -1), Seq(-1, -1, 2), Seq(2, 1, -3)))
    matrix.minorMatrix(1, 0) shouldBe Some(Seq(Seq(-1, -1, -4), Seq(-1, 2, 4), Seq(1, -3, -8)))
    matrix.minorMatrix(1, 1) shouldBe Some(Seq(Seq(-2, -1, -4), Seq(-1, 2, 4), Seq(2, -3, -8)))
    matrix.minorMatrix(1, 2) shouldBe Some(Seq(Seq(-2, -1, -4), Seq(-1, -1, 4), Seq(2, 1, -8)))
    matrix.minorMatrix(1, 3) shouldBe Some(Seq(Seq(-2, -1, -1), Seq(-1, -1, 2), Seq(2, 1, -3)))
    matrix.minorMatrix(2, 0) shouldBe Some(Seq(Seq(-1, -1, -4), Seq(-2, -1, -6), Seq(1, -3, -8)))
    matrix.minorMatrix(2, 1) shouldBe Some(Seq(Seq(-2, -1, -4), Seq(-1, -1, -6), Seq(2, -3, -8)))
    matrix.minorMatrix(2, 2) shouldBe Some(Seq(Seq(-2, -1, -4), Seq(-1, -2, -6), Seq(2, 1, -8)))
    matrix.minorMatrix(2, 3) shouldBe Some(Seq(Seq(-2, -1, -1), Seq(-1, -2, -1), Seq(2, 1, -3)))
    matrix.minorMatrix(3, 0) shouldBe Some(Seq(Seq(-1, -1, -4), Seq(-2, -1, -6), Seq(-1, 2, 4)))
    matrix.minorMatrix(3, 1) shouldBe Some(Seq(Seq(-2, -1, -4), Seq(-1, -1, -6), Seq(-1, 2, 4)))
    matrix.minorMatrix(3, 2) shouldBe Some(Seq(Seq(-2, -1, -4), Seq(-1, -2, -6), Seq(-1, -1, 4)))
    matrix.minorMatrix(3, 3) shouldBe Some(Seq(Seq(-2, -1, -1), Seq(-1, -2, -1), Seq(-1, -1, 2)))

    val matrixD = Seq(
      Seq(-2.2, -1.1, -1.1, -4.4),
      Seq(-1.1, -2.2, -1.1, -6.6),
      Seq(-1.1, -1.1, 2.2, 4.4),
      Seq(2.2, 1.1, -3.3, -8.8)
    )
    matrixD.minorMatrix(2, 3) shouldBe Some(Seq(Seq(-2.2, -1.1, -1.1), Seq(-1.1, -2.2, -1.1), Seq(2.2, 1.1, -3.3)))

    val matrixL = matrix.map(_.map(_.toLong))
    matrixL.minorMatrix(2, 3) shouldBe Some(Seq(Seq(-2L, -1L, -1L), Seq(-1L, -2L, -1L), Seq(2L, 1L, -3L)))

    val matrixBI = matrix.map(_.map(BigInt(_)))
    matrixBI.minorMatrix(2, 3) shouldBe Some(
      Seq(
        Seq(BigInt(-2L), BigInt(-1L), BigInt(-1L)),
        Seq(BigInt(-1L), BigInt(-2L), BigInt(-1L)),
        Seq(BigInt(2L), BigInt(1L), BigInt(-3L))
      )
    )
  }

  test("matrixDeterminant") {
    Seq(Seq(-2, -1), Seq(-1, -2)).matrixDeterminant shouldBe Some(3)
    val matrix = Seq(Seq(-2, -1, -1, -4), Seq(-1, -2, -1, -6), Seq(-1, -1, 2, 4), Seq(2, 1, -3, -8))
    matrix.matrixDeterminant shouldBe Some(-8)
    matrix.map(_.map(_.toLong)).matrixDeterminant shouldBe Some(-8L)
    matrix.map(_.map(_.toDouble)).matrixDeterminant shouldBe Some(-8.0)
    matrix.map(_.map(BigInt(_))).matrixDeterminant shouldBe Some(BigInt(-8))
  }

  test("add") {
    val matrixA = Seq(Seq(-2, -1, -1, -4), Seq(-1, -2, -1, -6), Seq(-1, -1, 2, 4), Seq(2, 1, -3, -8))
    val matrixB = Seq(Seq(8, -5, -6, -4), Seq(-13, -22, -11, -65), Seq(45, 45, 34, 35), Seq(23, 12, -33, -82))
    val matrixC = Seq(Seq(6, -6, -7, -8), Seq(-14, -24, -12, -71), Seq(44, 44, 36, 39), Seq(25, 13, -36, -90))
    matrixA.add(matrixB) shouldBe Some(matrixC)
    matrixA + matrixB shouldBe Some(matrixC)
  }

  test("matrix multiplication by number") {
    Seq(Seq(-2, -1, -1, -4), Seq(-1, -2, -1, -6), Seq(-1, -1, 2, 4), Seq(2, 1, -3, -8)).mul(10) shouldBe Seq(
      Seq(-20, -10, -10, -40),
      Seq(-10, -20, -10, -60),
      Seq(-10, -10, 20, 40),
      Seq(20, 10, -30, -80)
    )
    Seq(Seq(-2, -1, -1, -4), Seq(-1, -2, -1, -6), Seq(-1, -1, 2, 4), Seq(2, 1, -3, -8)) * 10 shouldBe Seq(
      Seq(-20, -10, -10, -40),
      Seq(-10, -20, -10, -60),
      Seq(-10, -10, 20, 40),
      Seq(20, 10, -30, -80)
    )
    Seq(Seq(-2, -1, -1, -4), Seq(-1, -2, -1, -6), Seq(-1, -1, 2, 4), Seq(2, 1, -3, -8))
      .mulMod(10, 11) shouldBe Seq(Seq(2, 1, 1, 4), Seq(1, 2, 1, 6), Seq(1, 1, 9, 7), Seq(9, 10, 3, 8))
  }

  test("matrix multiplication") {
    val matrixA = Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0))
    val matrixB = Seq(Seq(1, 2, 3), Seq(-3, 5, 4), Seq(6, 2, 1), Seq(1, -1, 0))
    val matrixC = Seq(Seq(8, 25, 27), Seq(23, -1, -1), Seq(13, 18, 14))
    matrixA.mul(matrixB) shouldBe Some(matrixC)
    matrixA * matrixB shouldBe Some(matrixC)
    matrixA.mulMod(matrixB, 7) shouldBe Some(Seq(Seq(1, 4, 6), Seq(2, 6, 6), Seq(6, 4, 0)))
  }

  test("matrix multiplication by row") {
    val matrixA = Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0))
    val matrixB = Seq(1, -3, 6, 1)
    val matrixC = Seq(8, 23, 13)
    matrixA.mul(matrixB) shouldBe Some(matrixC)
    matrixA * matrixB shouldBe Some(matrixC)
    matrixA.mulMod(matrixB, 7) shouldBe Some(Seq(1, 2, 6))
  }

  test("power") {
    Seq(Seq(2, 0), Seq(-1, 3)).power(2) shouldBe Some(Seq(Seq(4, 0), Seq(-5, 9)))

    val fibonacciMatrix = Seq(Seq(1, 1), Seq(1, 0))
    fibonacciMatrix.power(20) shouldBe Some(Seq(Seq(10946, 6765), Seq(6765, 4181)))

    Seq(Seq(1, 2, 1, 0), Seq(1, 1, 0, -1), Seq(-2, 0, 1, 2), Seq(0, 2, 1, 1)).power(100) shouldBe Some(
      Seq(Seq(1, 200, 100, 0), Seq(100, 1, 0, -100), Seq(-200, 0, 1, 200), Seq(0, 200, 100, 1))
    )

    fibonacciMatrix.powerMod(50, 1000000) shouldBe Some(Seq(Seq(11074, 269025), Seq(269025, 742049)))
  }
}
