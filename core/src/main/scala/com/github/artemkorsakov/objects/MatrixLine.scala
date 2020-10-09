package com.github.artemkorsakov.objects

import com.github.artemkorsakov.objects.GenericOperation._

case class MatrixLine[T](x: Seq[T]) {
  def *(y: Seq[T]): Option[T] = mul(y)

  def mul(y: Seq[T]): Option[T] =
    if (x.length != y.length)
      None
    else
      Some(x.indices.foldLeft(zeroT(x.head))((s, i) => addT(s, mulT(x(i), y(i)))))

  def mulMod(y: Seq[T], module: T): Option[T] =
    if (x.length != y.length)
      None
    else
      Some(x.indices.foldLeft(zeroT(x.head))((s, i) => modT(addT(s, mulT(x(i), y(i))), module)))

  def toMatrix: Matrix[T] = new Matrix[T](Seq(x))

  def *(b: Matrix[T]): Option[Seq[T]] = mul(b)

  def mul(b: Matrix[T]): Option[Seq[T]] =
    for {
      seq <- toMatrix.mul(b.a)
    } yield seq.head

  def mulMod(b: Matrix[T], module: T): Option[Seq[T]] =
    for {
      seq <- toMatrix.mulMod(b.a, module)
    } yield seq.head
}

object MatrixLine {
  implicit def seq2MatrixLine[T](x: Seq[T]): MatrixLine[T] = new MatrixLine[T](x)
}
