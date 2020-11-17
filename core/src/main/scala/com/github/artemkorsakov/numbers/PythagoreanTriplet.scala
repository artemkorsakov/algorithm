package com.github.artemkorsakov.numbers

import com.github.artemkorsakov.divisors.Divisors.gcd
import com.github.artemkorsakov.objects.Matrix._

import scala.collection.mutable

/** A Pythagorean triplet is a set of three natural numbers, a &lt; b &lt; c,
  * for which, a<sup>2</sup> + b<sup>2</sup> = c<sup>2</sup>.
  */
case class PythagoreanTriplet(a: Long, b: Long, c: Long) {
  val columnVector                     = Seq(Seq(a), Seq(b), Seq(c))
  private val a_matrix: Seq[Seq[Long]] = Seq(Seq(1, -2, 2), Seq(2, -1, 2), Seq(2, -2, 3))
  private val b_matrix: Seq[Seq[Long]] = Seq(Seq(1, 2, 2), Seq(2, 1, 2), Seq(2, 2, 3))
  private val c_matrix: Seq[Seq[Long]] = Seq(Seq(-1, 2, 2), Seq(-2, 1, 2), Seq(-2, 2, 3))
  private val matrices                 = Seq(a_matrix, b_matrix, c_matrix)

  /** <a href="https://en.wikipedia.org/wiki/Tree_of_primitive_Pythagorean_triples">Tree of primitive Pythagorean triples</a> */
  def nextPythagoreanTriplet: Seq[PythagoreanTriplet] =
    matrices.flatMap(mat =>
      mat.mul(columnVector: Seq[Seq[Long]]).map(seq => PythagoreanTriplet(seq.head.head, seq(1).head, seq.last.head))
    )
}

object PythagoreanTriplet {
  implicit def tupleInt2PythagoreanTriplet(t: (Int, Int, Int)): PythagoreanTriplet =
    PythagoreanTriplet(t._1.toLong, t._2.toLong, t._3.toLong)
  implicit def tupleLong2PythagoreanTriplet(t: (Long, Long, Long)): PythagoreanTriplet =
    PythagoreanTriplet(t._1, t._2, t._3)
  val primitivePythagoreanTriplet: PythagoreanTriplet = PythagoreanTriplet(3, 4, 5)

  /** Return all Pythagorean triplets such as a+b+c = sum.
    * @see <a href="https://projecteuler.net/overview=009">detailed description</a>
    */
  def pythagoreanTripletsWithGivenSum(sum: Long): Seq[PythagoreanTriplet] = {
    val arrayBuffer = mutable.ArrayBuffer.empty[PythagoreanTriplet]
    val s2          = sum / 2
    val sqrt        = math.sqrt(s2.toDouble).toLong
    val mLimit      = if (sqrt * sqrt == s2) sqrt - 1 else sqrt

    for (m <- 2L to mLimit)
      if (s2 % m == 0) {
        var sm = s2 / m
        while (sm % 2 == 0) // reduce the search space by
          sm /= 2 // removing all factors 2
        var k = if (m % 2 == 1) m + 2 else m + 1
        while (k < 2 * m && k <= sm) {
          if (sm % k == 0 && gcd(k, m) == 1) {
            val d = s2 / (k * m)
            val n = k - m
            val a = d * (m * m - n * n)
            val b = 2 * d * m * n
            val c = d * (m * m + n * n)
            arrayBuffer += PythagoreanTriplet(a, b, c)
          }
          k += 2
        }
      }

    arrayBuffer.toSeq
  }
}
