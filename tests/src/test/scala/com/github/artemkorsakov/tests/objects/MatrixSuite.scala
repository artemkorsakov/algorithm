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

}

/*
    @Test
    public void testAdd() {
        long[][] matrixA = new long[][]{new long[]{-2, -1, -1, -4}, new long[]{-1, -2, -1, -6}, new long[]{-1, -1, 2, 4}, new long[]{2, 1, -3, -8}};
        long[][] matrixB = new long[][]{new long[]{8, -5, -6, -4}, new long[]{-13, -22, -11, -65}, new long[]{45, 45, 34, 35}, new long[]{23, 12, -33, -82}};
        long[][] matrixC = new long[][]{new long[]{6, -6, -7, -8}, new long[]{-14, -24, -12, -71}, new long[]{44, 44, 36, 39}, new long[]{25, 13, -36, -90}};
        Assert.assertEquals(Matrix.add(matrixA, matrixB), matrixC);

        Assert.assertEquals(Matrix.add(toDouble(matrixA), toDouble(matrixB)), toDouble(matrixC));
        Assert.assertEquals(Matrix.add(toBigInteger(matrixA), toBigInteger(matrixB)), toBigInteger(matrixC));

    }

    @Test
    public void testMul() {
        long[][] matrixA = new long[][]{new long[]{3, 4, 2, 5}, new long[]{0, -1, 3, 2}, new long[]{1, 2, 3, 0}};
        long[][] matrixB = new long[][]{new long[]{1, 2, 3}, new long[]{-3, 5, 4}, new long[]{6, 2, 1}, new long[]{1, -1, 0}};
        long[][] matrixC = new long[][]{new long[]{8, 25, 27}, new long[]{23, -1, -1}, new long[]{13, 18, 14}};
        Assert.assertEquals(Matrix.mult(matrixA, matrixB), matrixC);
    }

    @Test
    public void testPower() {
        long[][] matrixA = new long[][]{new long[]{2, 0}, new long[]{-1, 3}};
        long[][] matrixB = new long[][]{new long[]{4, 0}, new long[]{-5, 9}};
        Assert.assertEquals(Matrix.power(matrixA, 2), matrixB);

        long[][] fibonacciMatrix = new long[][]{new long[]{1, 1}, new long[]{1, 0}};
        long[][] matrix = Matrix.power(fibonacciMatrix, 20);
        Assert.assertEquals(matrix, new long[][]{new long[]{10946, 6765}, new long[]{6765, 4181}});
        Assert.assertEquals(toDouble(matrix), toDouble(new long[][]{new long[]{10946, 6765}, new long[]{6765, 4181}}));
        Assert.assertEquals(toBigInteger(matrix), toBigInteger(new long[][]{new long[]{10946, 6765}, new long[]{6765, 4181}}));

        long[][] matrixC = new long[][]{new long[]{1, 2, 1, 0}, new long[]{1, 1, 0, -1}, new long[]{-2, 0, 1, 2}, new long[]{0, 2, 1, 1}};
        long[][] matrixD = new long[][]{new long[]{1, 200, 100, 0}, new long[]{100, 1, 0, -100}, new long[]{-200, 0, 1, 200}, new long[]{0, 200, 100, 1}};
        Assert.assertEquals(Matrix.power(matrixC, 100), matrixD);
    }

    @Test
    public void testPowerMod() {
        long[][] fibonacciMatrix = new long[][]{new long[]{1, 1}, new long[]{1, 0}};
        long[][] matrix = Matrix.powerMod(fibonacciMatrix, 50, 1_000_000);
        Assert.assertEquals(matrix, new long[][]{new long[]{11074, 269025}, new long[]{269025, 742049}});
    }

    private double[][] toDouble(long[][] matrix) {
        return Arrays.stream(matrix).map(m -> Arrays.stream(m).mapToDouble(t -> (double) t).toArray()).toArray(double[][]::new);
    }

    private BigInteger[][] toBigInteger(long[][] matrix) {
        return Arrays.stream(matrix).map(m -> Arrays.stream(m).mapToObj(BigInteger::valueOf).toArray(BigInteger[]::new)).toArray(BigInteger[][]::new);
    }

}

 */
