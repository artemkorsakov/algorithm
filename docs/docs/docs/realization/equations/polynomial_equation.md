---
layout: docs
title: "Realization: Polynomial equation"
parent_link: ../../equations/polynomial_equation.html
---

## {{page.title}}

Realizations for [Polynomial equation]({{ page.parent_link }}).

### polynomialCoefficients

[Algorithm]({{ page.parent_link }}{{ "#polynomialCoefficients" | downcase }})

**Realization**
```scala
  def polynomialSolution(n: Int, aList: Seq[Long]): Long = {
    var number = 1L
    aList.indices.foldLeft(0L) { (sum, i) =>
      val s = sum + aList(aList.length - 1 - i) * number
      number *= n
      s
    }
  }

  def polynomialCoefficients(k: Int, solutions: Seq[Long]): Seq[Long] = {
    val aList = new Array[Long](k)

    val coefficientsList = coefficientsForSolutionSearching(k)
    for (i <- k - 1 to 0 by -1) {
      val coefficients = coefficientsList(i)
      val index        = k - coefficients.size
      var divisor      = 0L
      for (j <- coefficients.indices) {
        aList(index) += coefficients(j) * solutions(coefficients.size - 1 - j)
        (0 until index).foreach(m =>
          aList(index) -= aList(m) * coefficients(j) * math.pow(coefficients.size.toDouble - j, k - 1.0 - m).toLong
        )
        divisor += coefficients(j) * math.pow(coefficients.size.toDouble - j, coefficients.size.toDouble - 1).toLong
      }
      aList(index) = aList(index) / divisor
    }

    aList
  }

  private def coefficientsForSolutionSearching(k: Int): Seq[Seq[Long]] =
    if (k == 1)
      Seq(Seq(1L))
    else {
      val coefficients = coefficientsForSolutionSearching(k - 1)
      val last         = coefficients.last
      val current      = 1L +: (0 until last.size - 1).map(i => last(i + 1) - last(i)) :+ -last.last
      coefficients :+ current
    }
```

---
