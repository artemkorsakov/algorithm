package com.github.artemkorsakov.numbers

import com.github.artemkorsakov.objects.Matrix._

/** A Pythagorean triplet is a set of three natural numbers, a &lt; b &lt; c,
  * for which, a<sup>2</sup> + b<sup>2</sup> = c<sup>2</sup>,
  * a=m<sup>2</sup> - n<sup>2</sup>,
  * b=2*m*n,
  * c=m<sup>2</sup> + n<sup>2</sup>.
  * (m,n) - Pythagorean deuce.
  */
case class PythagoreanDeuce(m: Long, n: Long) {
  val a: Long                          = m * m - n * n
  val b: Long                          = 2 * m * n
  val c: Long                          = m * m + n * n
  val triplet: PythagoreanTriplet      = PythagoreanTriplet(a, b, c)
  val columnVector                     = Seq(Seq(m), Seq(n))
  private val a_matrix: Seq[Seq[Long]] = Seq(Seq(2, -1), Seq(1, 0))
  private val b_matrix: Seq[Seq[Long]] = Seq(Seq(2, 1), Seq(1, 0))
  private val c_matrix: Seq[Seq[Long]] = Seq(Seq(1, 2), Seq(0, 1))
  private val matrices                 = Seq(a_matrix, b_matrix, c_matrix)

  /** <a href="https://en.wikipedia.org/wiki/Tree_of_primitive_Pythagorean_triples">Tree of primitive Pythagorean triples</a> */
  def nextPythagoreanDeuce: Seq[PythagoreanDeuce] =
    matrices.flatMap(mat =>
      mat.mul(columnVector: Seq[Seq[Long]]).map(seq => PythagoreanDeuce(seq.head.head, seq.last.head))
    )
}

object PythagoreanDeuce {
  implicit def tuple2PythagoreanDeuce(t: (Long, Long)): PythagoreanDeuce = PythagoreanDeuce(t._1, t._2)
  val primitivePythagoreanDeuce: PythagoreanDeuce                        = PythagoreanDeuce(2, 1)
}
