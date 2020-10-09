package com.github.artemkorsakov.objects

import cats.implicits._
import com.github.artemkorsakov.objects.GenericOperation._
import com.github.artemkorsakov.objects.Matrix._
import com.github.artemkorsakov.objects.MatrixLine._

/** Matrix.
  *
  * @see <a href="https://en.wikipedia.org/wiki/Matrix_(mathematics)">detailed description</a>
  */
case class Matrix[T](a: Seq[Seq[T]]) {

  /** <a href="https://en.wikipedia.org/wiki/Transpose">Transpose</a> of a matrix. */
  def matrixTranspose: Seq[Seq[T]] =
    a.head.indices.map(i => a.indices.map(j => a(j)(i)))

  /** New matrix without the given row and the given column. */
  def minorMatrix(row: Int, column: Int): Option[Seq[Seq[T]]] =
    if (
      a.isEmpty || a
        .exists(i => i.length != a.length) || row < 0 || row >= a.length || column < 0 || column >= a.head.length
    )
      None
    else
      Some(a.indices.filter(_ != row).map(i => a.head.indices.filter(_ != column).map(j => a(i)(j))))

  /** <a href="https://en.wikipedia.org/wiki/Determinant">Determinant</a> of a matrix. */
  def matrixDeterminant: Option[T] =
    if (a.isEmpty || a.exists(i => i.length != a.length))
      None
    else if (a.length == 1)
      Some(a.head.head)
    else
      Some(a.head.indices.foldLeft(zeroT(a.head.head)) { (sum, i) =>
        val mul = mulT(a.head(i), a.minorMatrix(0, i).get.matrixDeterminant.get)
        if (i % 2 == 0)
          addT(sum, mul)
        else
          subT(sum, mul)
      })

  def +(b: Seq[Seq[T]]): Option[Seq[Seq[T]]] = add(b)

  def add(b: Seq[Seq[T]]): Option[Seq[Seq[T]]] =
    if (a.length != b.length || a.indices.exists(i => a(i).length != b(i).length))
      None
    else
      Some(a.indices.map(i => a(i).indices.map(j => addT(a(i)(j), b(i)(j)))))

  def *(b: T): Seq[Seq[T]] = mul(b)

  def mul(b: T): Seq[Seq[T]] =
    a.indices.map(i => a(i).indices.map(j => mulT(a(i)(j), b)))

  def mulMod(b: T, module: T): Seq[Seq[T]] =
    a.indices.map(i => a(i).indices.map(j => modT(mulT(a(i)(j), b), module)))

  def *(b: Seq[Seq[T]]): Option[Seq[Seq[T]]] = mul(b)

  /** <a href="https://en.wikipedia.org/wiki/Matrix_multiplication">multiplication</a> */
  def mul(b: Seq[Seq[T]]): Option[Seq[Seq[T]]] =
    if (
      a.isEmpty || b.isEmpty || a
        .exists(_.length != a.head.length) || b.exists(_.length != b.head.length) || a.head.length != b.length
    )
      None
    else
      a.indices
        .map(i => b.head.indices.map(j => a(i).mul(b.indices.map(k => b(k)(j)))).toList.traverse(identity))
        .toList
        .traverse(identity)

  /** <a href="https://en.wikipedia.org/wiki/Matrix_multiplication">multiplication</a> */
  def mulMod(b: Seq[Seq[T]], module: T): Option[Seq[Seq[T]]] =
    if (
      a.isEmpty || b.isEmpty || a
        .exists(_.length != a.head.length) || b.exists(_.length != b.head.length) || a.head.length != b.length
    )
      None
    else
      a.indices
        .map(i => b.head.indices.map(j => a(i).mulMod(b.indices.map(k => b(k)(j)), module)).toList.traverse(identity))
        .toList
        .traverse(identity)

  def *(b: MatrixLine[T]): Option[Seq[T]] = mul(b)

  def mul(b: MatrixLine[T]): Option[Seq[T]] =
    for {
      seq <- mul(b.x.map(Seq(_)))
    } yield seq.map(s => s.head)

  def mulMod(b: MatrixLine[T], module: T): Option[Seq[T]] =
    for {
      seq <- mulMod(b.x.map(Seq(_)), module)
    } yield seq.map(s => s.head)

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
    public static long[] mult(long[] a, long[][] b) {
        return mult(new long[][]{a}, b)[0];
    }

    public static long[] multMod(long[] a, long[][] b, long module) {
        return multMod(new long[][]{a}, b, module)[0];
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
