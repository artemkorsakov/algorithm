package com.github.artemkorsakov.objects

import com.github.artemkorsakov.objects.GenericOperation._
import com.github.artemkorsakov.objects.Matrix._

/** Matrix.
  *
  * @see <a href="https://en.wikipedia.org/wiki/Matrix_(mathematics)">detailed description</a>
  */
class Matrix[T](a: Seq[Seq[T]]) {

  /** <a href="https://en.wikipedia.org/wiki/Transpose">Transpose</a> of a matrix. */
  def matrixTranspose: Seq[Seq[T]] =
    a.head.indices.map(i => a.indices.map(j => a(j)(i)))

  /** New matrix without the given row and the given column. */
  def minorMatrix(row: Int, column: Int): Option[Seq[Seq[T]]] =
    if (a.isEmpty || a.exists(i => i.length != a.length) || row < 0 || row >= a.length || column < 0 || column >= a.head.length) {
      None
    } else {
      Some(a.indices.filter(_ != row).map(i => a.head.indices.filter(_ != column).map(j => a(i)(j))))
    }

  /** <a href="https://en.wikipedia.org/wiki/Determinant">Determinant</a> of a matrix. */
  def matrixDeterminant: Option[T] =
    if (a.isEmpty || a.exists(i => i.length != a.length)) {
      None
    } else {
      if (a.length == 1) {
        Some(a.head.head)
      } else {
        Some(a.head.indices.foldLeft(zeroT(a.head.head)) { (sum, i) =>
          val mul = mulT(a.head(i), a.minorMatrix(0, i).get.matrixDeterminant.get)
          if (i % 2 == 0) {
            addT(sum, mul)
          } else {
            subT(sum, mul)
          }
        })
      }
    }
}

/** Matrix.
  *
  * @see <a href="https://en.wikipedia.org/wiki/Matrix_(mathematics)">detailed description</a>
  */
object Matrix {
  implicit def seq2Matrix[T](a: Seq[Seq[T]]): Matrix[T] = new Matrix[T](a)
}

/*
public class Matrix {

    public static long[][] add(long[][] a, long[][] b) {
        if (a.length != b.length || IntStream.range(0, a.length).anyMatch(i -> a[i].length != b[i].length)) {
            throw new IllegalArgumentException("Matrix size must be the same");
        }

        long[][] c = new long[a.length][];
        for (int i = 0; i < c.length; i++) {
            c[i] = new long[a[0].length];
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        return c;
    }

    public static double[][] add(double[][] a, double[][] b) {
        if (a.length != b.length || IntStream.range(0, a.length).anyMatch(i -> a[i].length != b[i].length)) {
            throw new IllegalArgumentException("Matrix size must be the same");
        }

        double[][] c = new double[a.length][];
        for (int i = 0; i < c.length; i++) {
            c[i] = new double[a[0].length];
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        return c;
    }

    public static BigInteger[][] add(BigInteger[][] a, BigInteger[][] b) {
        if (a.length != b.length || IntStream.range(0, a.length).anyMatch(i -> a[i].length != b[i].length)) {
            throw new IllegalArgumentException("Matrix size must be the same");
        }

        BigInteger[][] c = new BigInteger[a.length][];
        for (int i = 0; i < c.length; i++) {
            c[i] = new BigInteger[a[0].length];
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = a[i][j].add(b[i][j]);
            }
        }

        return c;
    }

    public static long[][] mult(long[][] a, long b) {
        long[][] c = new long[a.length][];
        for (int i = 0; i < c.length; i++) {
            c[i] = new long[a[0].length];
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = b * a[i][j];
            }
        }

        return c;
    }

    public static double[][] mult(double[][] a, double b) {
        double[][] c = new double[a.length][];
        for (int i = 0; i < c.length; i++) {
            c[i] = new double[a[0].length];
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = b * a[i][j];
            }
        }

        return c;
    }

    public static BigInteger[][] mult(BigInteger[][] a, BigInteger b) {
        BigInteger[][] c = new BigInteger[a.length][];
        for (int i = 0; i < c.length; i++) {
            c[i] = new BigInteger[a[0].length];
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = a[i][j].multiply(b);
            }
        }

        return c;
    }

    public static long[][] multMod(long[][] a, long b, long module) {
        long[][] c = new long[a.length][];
        for (int i = 0; i < c.length; i++) {
            c[i] = new long[a[0].length];
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = b * a[i][j] % module;
            }
        }

        return c;
    }

    public static long[] mult(long[][] a, long[] b) {
        return Arrays.stream(mult(a, new long[][]{b})).mapToLong(r -> r[0]).toArray();
    }

    public static double[] mult(double[][] a, double[] b) {
        return Arrays.stream(mult(a, new double[][]{b})).mapToDouble(r -> r[0]).toArray();
    }

    public static BigInteger[] mult(BigInteger[][] a, BigInteger[] b) {
        return Arrays.stream(mult(a, new BigInteger[][]{b})).map(r -> r[0]).toArray(BigInteger[]::new);
    }

    public static long[] multMod(long[][] a, long[] b, long module) {
        return Arrays.stream(multMod(a, new long[][]{b}, module)).mapToLong(r -> r[0]).toArray();
    }

    public static long[] mult(long[] a, long[][] b) {
        return mult(new long[][]{a}, b)[0];
    }

    public static double[] mult(double[] a, double[][] b) {
        return mult(new double[][]{a}, b)[0];
    }

    public static BigInteger[] mult(BigInteger[] a, BigInteger[][] b) {
        return mult(new BigInteger[][]{a}, b)[0];
    }

    public static long[] multMod(long[] a, long[][] b, long module) {
        return multMod(new long[][]{a}, b, module)[0];
    }

    /**
 * <a href="https://en.wikipedia.org/wiki/Matrix_multiplication">multiplication</a>
 */
    public static long[][] mult(long[][] a, long[][] b) {
        if (a.length == 0 || b.length == 0 || Arrays.stream(a).anyMatch(i -> i.length != a[0].length)
                || Arrays.stream(b).anyMatch(i -> i.length != b[0].length) || a[0].length != b.length) {
            throw new IllegalArgumentException();
        }

        long[][] c = new long[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                long[] x = a[i];
                int finalJ = j;
                long[] y = Arrays.stream(b).mapToLong(col -> col[finalJ]).toArray();
                c[i][j] = dot(x, y);
            }
        }

        return c;
    }

    /**
 * {@link Matrix#mult(long[][], long[])} multiplication
 */
    public static double[][] mult(double[][] a, double[][] b) {
        if (a.length == 0 || b.length == 0 || Arrays.stream(a).anyMatch(i -> i.length != a[0].length)
                || Arrays.stream(b).anyMatch(i -> i.length != b[0].length) || a[0].length != b.length) {
            throw new IllegalArgumentException();
        }

        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                double[] x = a[i];
                int finalJ = j;
                double[] y = Arrays.stream(b).mapToDouble(col -> col[finalJ]).toArray();
                c[i][j] = dot(x, y);
            }
        }

        return c;
    }

    /**
 * {@link Matrix#mult(long[][], long[])} multiplication
 */
    public static BigInteger[][] mult(BigInteger[][] a, BigInteger[][] b) {
        if (a.length == 0 || b.length == 0 || Arrays.stream(a).anyMatch(i -> i.length != a[0].length)
                || Arrays.stream(b).anyMatch(i -> i.length != b[0].length) || a[0].length != b.length) {
            throw new IllegalArgumentException();
        }

        BigInteger[][] c = new BigInteger[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                BigInteger[] x = a[i];
                int finalJ = j;
                BigInteger[] y = Arrays.stream(b).map(col -> col[finalJ]).toArray(BigInteger[]::new);
                c[i][j] = dot(x, y);
            }
        }

        return c;
    }

    /**
 * {@link Matrix#mult(long[][], long[])} multiplication
 */
    public static long[][] multMod(long[][] a, long[][] b, long module) {
        if (a.length == 0 || b.length == 0 || Arrays.stream(a).anyMatch(i -> i.length != a[0].length)
                || Arrays.stream(b).anyMatch(i -> i.length != b[0].length) || a[0].length != b.length) {
            throw new IllegalArgumentException();
        }

        long[][] c = new long[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                long[] x = a[i];
                int finalJ = j;
                long[] y = Arrays.stream(b).parallel().mapToLong(col -> col[finalJ]).toArray();
                c[i][j] = dotMod(x, y, module);
            }
        }

        return c;
    }

    public static long[][] power(long[][] a, long b) {
        if (b < 1) {
            throw new IllegalArgumentException();
        }
        if (b == 1) {
            return a;
        }

        String powers = Long.toBinaryString(b);
        long[][][] powersC = new long[powers.length()][][];
        powersC[0] = a;
        for (int i = 1; i < powersC.length; i++) {
            powersC[i] = mult(powersC[i - 1], powersC[i - 1]);
        }

        long[][] c = powersC[powersC.length - 1];

        for (int i = 1; i < powers.length(); i++) {
            if (powers.charAt(i) == '1') {
                c = mult(c, powersC[powersC.length - 1 - i]);
            }
        }

        return c;
    }

    public static double[][] power(double[][] a, long b) {
        if (b < 1) {
            throw new IllegalArgumentException();
        }
        if (b == 1) {
            return a;
        }

        String powers = Long.toBinaryString(b);
        double[][][] powersC = new double[powers.length()][][];
        powersC[0] = a;
        for (int i = 1; i < powersC.length; i++) {
            powersC[i] = mult(powersC[i - 1], powersC[i - 1]);
        }

        double[][] c = powersC[powersC.length - 1];

        for (int i = 1; i < powers.length(); i++) {
            if (powers.charAt(i) == '1') {
                c = mult(c, powersC[powersC.length - 1 - i]);
            }
        }

        return c;
    }

    public static BigInteger[][] power(BigInteger[][] a, long b) {
        if (b < 1) {
            throw new IllegalArgumentException();
        }
        if (b == 1) {
            return a;
        }

        String powers = Long.toBinaryString(b);
        BigInteger[][][] powersC = new BigInteger[powers.length()][][];
        powersC[0] = a;
        for (int i = 1; i < powersC.length; i++) {
            powersC[i] = mult(powersC[i - 1], powersC[i - 1]);
        }

        BigInteger[][] c = powersC[powersC.length - 1];

        for (int i = 1; i < powers.length(); i++) {
            if (powers.charAt(i) == '1') {
                c = mult(c, powersC[powersC.length - 1 - i]);
            }
        }

        return c;
    }

    public static long[][] powerMod(long[][] a, long b, long module) {
        if (b < 1) {
            throw new IllegalArgumentException();
        }
        if (b == 1) {
            return a;
        }

        String powers = Long.toBinaryString(b);
        long[][][] powersC = new long[powers.length()][][];
        powersC[0] = a;
        for (int i = 1; i < powersC.length; i++) {
            powersC[i] = multMod(powersC[i - 1], powersC[i - 1], module);
        }

        long[][] c = powersC[powersC.length - 1];

        for (int i = 1; i < powers.length(); i++) {
            if (powers.charAt(i) == '1') {
                c = multMod(c, powersC[powersC.length - 1 - i], module);
            }
        }

        return c;
    }

}

 */
