package com.github.artemkorsakov.equations

/** <a href="https://en.wikipedia.org/wiki/Polynomial">Polynomial equation</a>. */
object PolynomialEquation {

  /** Solution of a polynomial equation with given coefficients for a given n. */
  def polynomialSolution(n: Int, aList: Seq[Long]): Long = {
    var number = 1L
    aList.indices.foldLeft(0L) { (sum, i) =>
      val s = sum + aList(aList.length - 1 - i) * number
      number *= n
      s
    }
  }

  /**
    * Returns the coefficients of a polynomial equation.
    *
    * @param k         - the power of equation + 1: a[1]*n<sup>k-1</sup> + ... + a[i]*n<sup>k-i</sup> + ... + a[k]
    * @param solutions - known solutions for 1, 2, 3, ... , k
    * @return a[1], a[2], ..., a[k]
    */
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

    aList.toIndexedSeq
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

}
