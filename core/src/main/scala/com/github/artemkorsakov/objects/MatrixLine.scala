package com.github.artemkorsakov.objects

import com.github.artemkorsakov.objects.GenericOperation._

class MatrixLine[T](x: Seq[T]) {
  def *(y: Seq[T]): Option[T] = mul(y)

  def mul(y: Seq[T]): Option[T] =
    if (x.length != y.length) {
      None
    } else {
      Some(x.indices.foldLeft(zeroT(x.head))((s, i) => addT(s, mulT(x(i), y(i)))))
    }

  def mulMod(y: Seq[T], module: T): Option[T] =
    if (x.length != y.length) {
      None
    } else {
      Some(x.indices.foldLeft(zeroT(x.head))((s, i) => modT(addT(s, mulT(x(i), y(i))), module)))
    }

}

object MatrixLine {
  implicit def seq2MatrixLine[T](x: Seq[T]): MatrixLine[T] = new MatrixLine[T](x)
}
