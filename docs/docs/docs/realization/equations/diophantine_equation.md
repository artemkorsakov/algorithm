---
layout: docs
title: "Realization: Diophantine equation"
parent_link: ../../equations/diophantine_equation.html
---

## {{page.title}}

Realizations for [Diophantine equation]({{ page.parent_link }}).

### minimalEquation

[Algorithm]({{ page.parent_link }}{{ "#minimalEquation" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.operations.CommonOperations._

case class DiophantineEquation(d: Int) {
  def minimalEquation: Option[(BigInt, BigInt)] =
    if (d.isSquare)
      None
    else {
      val a         = BigInt(math.round(math.sqrt(d.toDouble)))
      val k         = a.pow(2) - d
      var iteration = Iteration(a, BigInt(1), k, d)
      while (!iteration.isSuccess)
        iteration = iteration.getNext
      Some((iteration.a, iteration.b))
    }

  def isSuccess(x: BigInt, y: BigInt): Boolean =
    x.pow(2) == y.pow(2) * d + 1
}

object DiophantineEquation {}

case class Iteration(a: BigInt, b: BigInt, k: BigInt, d: Int) {
  def isSuccess: Boolean =
    k == BigInt(1)

  def getNext: Iteration =
    if (isSuccess)
      this
    else {
      val m    = getM
      val newA = (a * m + b * d) / k.abs
      val newB = (a + b * m) / k.abs
      val newK = (m.pow(2) - d) / k
      Iteration(newA, newB, newK, d)
    }

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
```

---
