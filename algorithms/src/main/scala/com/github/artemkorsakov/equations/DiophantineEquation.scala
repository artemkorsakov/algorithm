package com.github.artemkorsakov.equations

import com.github.artemkorsakov.operations.CommonOperations._

/** x<sup>2</sup> – D*y<sup>2</sup> = 1 */
case class DiophantineEquation(d: Int) {

  /** The <a href="https://en.wikipedia.org/wiki/Chakravala_method">chakravala method</a>
    * is a cyclic algorithm to solve indeterminate quadratic equations.
    */
  def minimalEquation: Option[(BigInt, BigInt)] =
    if (d.isSquare) {
      None
    } else {
      val a         = BigInt(math.round(math.sqrt(d.toDouble)))
      val k         = a.pow(2) - d
      var iteration = Iteration(a, BigInt(1), k, d)
      while (!iteration.isSuccess)
        iteration = iteration.getNext
      Some((iteration.a, iteration.b))
    }

  /** Is x<sup>2</sup> – D*y<sup>2</sup> = 1? */
  def isSuccess(x: BigInt, y: BigInt): Boolean =
    x.pow(2) == y.pow(2) * d + 1
}

case class Iteration(a: BigInt, b: BigInt, k: BigInt, d: Int) {
  def isSuccess: Boolean =
    k == BigInt(1)

  /** Update a, b and k to (a*m + N*b)/|k|, (a + b*m)/|k|, (m<sup>2</sup> - N)/k */
  def getNext: Iteration =
    if (isSuccess) {
      this
    } else {
      val m    = getM
      val newA = (a * m + b * d) / k.abs
      val newB = (a + b * m) / k.abs
      val newK = (m.pow(2) - d) / k
      Iteration(newA, newB, newK, d)
    }

  /** At each iteration we find m > 0, such that k divides a + b*m and |m<sup>2</sup> − d| minimal. */
  def getM: BigInt = {
    var m    = BigInt(-1)
    var min  = d + 1
    val last = math.sqrt(2.0 * d).toInt
    for (i <- 1 to last)
      if (isMCorrect(BigInt(i))) {
        val tmp = math.abs(i * i - d)
        if (tmp < min) {
          min = tmp
          m = BigInt(i)
        }
      }

    if (m == BigInt(-1)) {
      m = BigInt(last + 1)
      while (!isMCorrect(m))
        m += 1
    }

    m
  }

  def isMCorrect(m: BigInt): Boolean =
    (a + b * m).abs % k.abs == BigInt(0)
}
