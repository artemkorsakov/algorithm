package com.github.artemkorsakov.tests.objects

import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class MatrixSuite extends AnyFunSuiteLike {
  test("test") {
    1 shouldBe 1
  }
}

/*
package com.github.artemkorsakov.figure;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.Arrays;

public class MatrixTests {
    @Test
    public void testDot() {
        long[] x = new long[]{1, 2, -3};
        long[] y = new long[]{-7, 4, 6};
        Assert.assertEquals(Matrix.dot(x, y), -17);

        double[] xd = new double[]{1.5, 2, -3};
        double[] yd = new double[]{-7, 4, 6.2};
        Assert.assertEquals(Matrix.dot(xd, yd), -21.1);

        BigInteger[] xb = new BigInteger[]{BigInteger.valueOf(156744), BigInteger.valueOf(53453535), BigInteger.valueOf(-656464646)};
        BigInteger[] yb = new BigInteger[]{BigInteger.valueOf(-4324344), BigInteger.valueOf(455455455), BigInteger.valueOf(445354354)};
        Assert.assertEquals(Matrix.dot(xb, yb), BigInteger.valueOf(-268014362053361195L));
    }

    @Test
    public void testDotMod() {
        long[] x = new long[]{1007, 2456, -3466};
        long[] y = new long[]{-3347, 4343, 6445};
        Assert.assertEquals(Matrix.dotMod(x, y, 1000), 609);
    }

    @Test
    public void testTransposeLong() {
        long[][] matrix1 = new long[][]{new long[]{1, 2}};
        long[][] matrix2 = new long[][]{new long[]{1}, new long[]{2}};
        Assert.assertEquals(Matrix.transpose(matrix1), matrix2);
        Assert.assertEquals(Matrix.transpose(matrix2), matrix1);

        matrix1 = new long[][]{new long[]{1, 2}, new long[]{3, 4}};
        matrix2 = new long[][]{new long[]{1, 3}, new long[]{2, 4}};
        Assert.assertEquals(Matrix.transpose(matrix1), matrix2);
        Assert.assertEquals(Matrix.transpose(matrix2), matrix1);

        matrix1 = new long[][]{new long[]{1, 2}, new long[]{3, 4}, new long[]{5, 6}};
        matrix2 = new long[][]{new long[]{1, 3, 5}, new long[]{2, 4, 6}};
        Assert.assertEquals(Matrix.transpose(matrix1), matrix2);
        Assert.assertEquals(Matrix.transpose(matrix2), matrix1);

        Assert.assertEquals(Matrix.transpose(Matrix.transpose(matrix1)), matrix1);
    }

    @Test
    public void testTransposeDouble() {
        double[][] matrix1 = new double[][]{new double[]{1, 2}};
        double[][] matrix2 = new double[][]{new double[]{1}, new double[]{2}};
        Assert.assertEquals(Matrix.transpose(matrix1), matrix2);
        Assert.assertEquals(Matrix.transpose(matrix2), matrix1);

        matrix1 = new double[][]{new double[]{1, 2}, new double[]{3, 4}};
        matrix2 = new double[][]{new double[]{1, 3}, new double[]{2, 4}};
        Assert.assertEquals(Matrix.transpose(matrix1), matrix2);
        Assert.assertEquals(Matrix.transpose(matrix2), matrix1);

        matrix1 = new double[][]{new double[]{1, 2}, new double[]{3, 4}, new double[]{5, 6}};
        matrix2 = new double[][]{new double[]{1, 3, 5}, new double[]{2, 4, 6}};
        Assert.assertEquals(Matrix.transpose(matrix1), matrix2);
        Assert.assertEquals(Matrix.transpose(matrix2), matrix1);

        Assert.assertEquals(Matrix.transpose(Matrix.transpose(matrix1)), matrix1);
    }

    @Test
    public void testTransposeBigInteger() {
        BigInteger[][] matrix1 = new BigInteger[][]{new BigInteger[]{BigInteger.valueOf(1), BigInteger.valueOf(2)}};
        BigInteger[][] matrix2 = new BigInteger[][]{new BigInteger[]{BigInteger.valueOf(1)}, new BigInteger[]{BigInteger.valueOf(2)}};
        Assert.assertEquals(Matrix.transpose(matrix1), matrix2);
        Assert.assertEquals(Matrix.transpose(matrix2), matrix1);

        matrix1 = new BigInteger[][]{new BigInteger[]{BigInteger.valueOf(1), BigInteger.valueOf(2)}, new BigInteger[]{BigInteger.valueOf(3), BigInteger.valueOf(4)}};
        matrix2 = new BigInteger[][]{new BigInteger[]{BigInteger.valueOf(1), BigInteger.valueOf(3)}, new BigInteger[]{BigInteger.valueOf(2), BigInteger.valueOf(4)}};
        Assert.assertEquals(Matrix.transpose(matrix1), matrix2);
        Assert.assertEquals(Matrix.transpose(matrix2), matrix1);

        matrix1 = new BigInteger[][]{new BigInteger[]{BigInteger.valueOf(1), BigInteger.valueOf(2)}, new BigInteger[]{BigInteger.valueOf(3), BigInteger.valueOf(4)}, new BigInteger[]{BigInteger.valueOf(5), BigInteger.valueOf(6)}};
        matrix2 = new BigInteger[][]{new BigInteger[]{BigInteger.valueOf(1), BigInteger.valueOf(3), BigInteger.valueOf(5)}, new BigInteger[]{BigInteger.valueOf(2), BigInteger.valueOf(4), BigInteger.valueOf(6)}};
        Assert.assertEquals(Matrix.transpose(matrix1), matrix2);
        Assert.assertEquals(Matrix.transpose(matrix2), matrix1);

        Assert.assertEquals(Matrix.transpose(Matrix.transpose(matrix1)), matrix1);
    }

    @Test
    public void testDet() {
        long[][] matrix = new long[][]{new long[]{-2, -1, -1, -4}, new long[]{-1, -2, -1, -6}, new long[]{-1, -1, 2, 4}, new long[]{2, 1, -3, -8}};
        Assert.assertEquals(Matrix.det(matrix), -8);
        double[][] matrixD = Arrays.stream(matrix).map(m -> Arrays.stream(m).mapToDouble(t -> (double) t).toArray()).toArray(double[][]::new);
        Assert.assertEquals(Matrix.det(matrixD), -8);
        BigInteger[][] matrixB = Arrays.stream(matrix).map(m -> Arrays.stream(m).mapToObj(BigInteger::valueOf).toArray(BigInteger[]::new)).toArray(BigInteger[][]::new);
        Assert.assertEquals(Matrix.det(matrixB).longValueExact(), -8);

        matrix = new long[][]{new long[]{2, -1, 2, 1, -3}, new long[]{1, 2, 1, -1, 2}, new long[]{1, -1, -2, -1, -1}, new long[]{2, 1, -1, -2, -1}, new long[]{1, -2, -1, -1, 2}};
        Assert.assertEquals(Matrix.det(matrix), 36);
        matrixD = Arrays.stream(matrix).map(m -> Arrays.stream(m).mapToDouble(t -> (double) t).toArray()).toArray(double[][]::new);
        Assert.assertEquals(Matrix.det(matrixD), 36);
        matrixB = Arrays.stream(matrix).map(m -> Arrays.stream(m).mapToObj(BigInteger::valueOf).toArray(BigInteger[]::new)).toArray(BigInteger[][]::new);
        Assert.assertEquals(Matrix.det(matrixB).longValueExact(), 36);
    }

    @Test
    public void testMinor() {
        long[][] matrix = new long[][]{new long[]{-2, -1, -1, -4}, new long[]{-1, -2, -1, -6}, new long[]{-1, -1, 2, 4}, new long[]{2, 1, -3, -8}};
        Assert.assertEquals(Matrix.minor(matrix, 0, 0), new long[][]{new long[]{-2, -1, -6}, new long[]{-1, 2, 4}, new long[]{1, -3, -8}});
        Assert.assertEquals(Matrix.minor(matrix, 0, 1), new long[][]{new long[]{-1, -1, -6}, new long[]{-1, 2, 4}, new long[]{2, -3, -8}});
        Assert.assertEquals(Matrix.minor(matrix, 0, 2), new long[][]{new long[]{-1, -2, -6}, new long[]{-1, -1, 4}, new long[]{2, 1, -8}});
        Assert.assertEquals(Matrix.minor(matrix, 0, 3), new long[][]{new long[]{-1, -2, -1}, new long[]{-1, -1, 2}, new long[]{2, 1, -3}});
        Assert.assertEquals(Matrix.minor(matrix, 1, 0), new long[][]{new long[]{-1, -1, -4}, new long[]{-1, 2, 4}, new long[]{1, -3, -8}});
        Assert.assertEquals(Matrix.minor(matrix, 1, 1), new long[][]{new long[]{-2, -1, -4}, new long[]{-1, 2, 4}, new long[]{2, -3, -8}});
        Assert.assertEquals(Matrix.minor(matrix, 1, 2), new long[][]{new long[]{-2, -1, -4}, new long[]{-1, -1, 4}, new long[]{2, 1, -8}});
        Assert.assertEquals(Matrix.minor(matrix, 1, 3), new long[][]{new long[]{-2, -1, -1}, new long[]{-1, -1, 2}, new long[]{2, 1, -3}});
        Assert.assertEquals(Matrix.minor(matrix, 2, 0), new long[][]{new long[]{-1, -1, -4}, new long[]{-2, -1, -6}, new long[]{1, -3, -8}});
        Assert.assertEquals(Matrix.minor(matrix, 2, 1), new long[][]{new long[]{-2, -1, -4}, new long[]{-1, -1, -6}, new long[]{2, -3, -8}});
        Assert.assertEquals(Matrix.minor(matrix, 2, 2), new long[][]{new long[]{-2, -1, -4}, new long[]{-1, -2, -6}, new long[]{2, 1, -8}});
        Assert.assertEquals(Matrix.minor(matrix, 2, 3), new long[][]{new long[]{-2, -1, -1}, new long[]{-1, -2, -1}, new long[]{2, 1, -3}});
        Assert.assertEquals(Matrix.minor(matrix, 3, 0), new long[][]{new long[]{-1, -1, -4}, new long[]{-2, -1, -6}, new long[]{-1, 2, 4}});
        Assert.assertEquals(Matrix.minor(matrix, 3, 1), new long[][]{new long[]{-2, -1, -4}, new long[]{-1, -1, -6}, new long[]{-1, 2, 4}});
        Assert.assertEquals(Matrix.minor(matrix, 3, 2), new long[][]{new long[]{-2, -1, -4}, new long[]{-1, -2, -6}, new long[]{-1, -1, 4}});
        Assert.assertEquals(Matrix.minor(matrix, 3, 3), new long[][]{new long[]{-2, -1, -1}, new long[]{-1, -2, -1}, new long[]{-1, -1, 2}});

        Assert.assertEquals(Matrix.minor(toDouble(matrix), 2, 3), toDouble(new long[][]{new long[]{-2, -1, -1}, new long[]{-1, -2, -1}, new long[]{2, 1, -3}}));
        Assert.assertEquals(Matrix.minor(toBigInteger(matrix), 2, 3), toBigInteger(new long[][]{new long[]{-2, -1, -1}, new long[]{-1, -2, -1}, new long[]{2, 1, -3}}));
    }

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
