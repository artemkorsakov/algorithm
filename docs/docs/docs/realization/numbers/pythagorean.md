---
layout: docs
title: "Realization: Pythagorean triplet"
parent_link: ../../numbers/pythagorean.html
---

## {{page.title}}

Realizations for [Pythagorean triplet]({{ page.parent_link }}).

### nextPythagoreanDeuce

[Algorithm]({{ page.parent_link }}{{ "#nextPythagoreanDeuce" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.objects.Matrix._
import com.github.artemkorsakov.numbers.PythagoreanTriplet

case class PythagoreanDeuce(m: Long, n: Long) {
  val a: Long                     = m * m - n * n
  val b: Long                     = 2 * m * n
  val c: Long                     = m * m + n * n
  val triplet: PythagoreanTriplet = PythagoreanTriplet(a, b, c)
  val columnVector                = Seq(Seq(m), Seq(n))
  private val a_matrix            = Seq(Seq(2L, -1L), Seq(1L, 0L))
  private val b_matrix            = Seq(Seq(2L, 1L), Seq(1L, 0L))
  private val c_matrix            = Seq(Seq(1L, 2L), Seq(0L, 1L))
  private val matrices            = Seq(a_matrix, b_matrix, c_matrix)

  def nextPythagoreanDeuce: Seq[PythagoreanDeuce] =
    matrices.flatMap(mat =>
      mat.mul(columnVector: Seq[Seq[Long]]).map(seq => PythagoreanDeuce(seq.head.head, seq.last.head))
    )
}
```

---

### nextPythagoreanTriplet

[Algorithm]({{ page.parent_link }}{{ "#nextPythagoreanTriplet" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.objects.Matrix._

case class PythagoreanTriplet(a: Long, b: Long, c: Long) {
  val columnVector                     = Seq(Seq(a), Seq(b), Seq(c))
  private val a_matrix: Seq[Seq[Long]] = Seq(Seq(1, -2, 2), Seq(2, -1, 2), Seq(2, -2, 3))
  private val b_matrix: Seq[Seq[Long]] = Seq(Seq(1, 2, 2), Seq(2, 1, 2), Seq(2, 2, 3))
  private val c_matrix: Seq[Seq[Long]] = Seq(Seq(-1, 2, 2), Seq(-2, 1, 2), Seq(-2, 2, 3))
  private val matrices                 = Seq(a_matrix, b_matrix, c_matrix)

  def nextPythagoreanTriplet: Seq[PythagoreanTriplet] =
    matrices.flatMap(mat =>
      mat.mul(columnVector: Seq[Seq[Long]]).map(seq => PythagoreanTriplet(seq.head.head, seq(1).head, seq.last.head))
    )
}
```

---

### pythagoreanTripletsWithGivenSum

[Algorithm]({{ page.parent_link }}{{ "#pythagoreanTripletsWithGivenSum" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.numbers.PythagoreanTriplet
import scala.collection.mutable
import com.github.artemkorsakov.divisors.Divisors.gcd

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

    arrayBuffer
  }
```

---
