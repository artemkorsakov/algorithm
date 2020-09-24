---
layout: docs
title: "Realization: Binomial Coefficient"
parent_link: ../../combinatorics/binomial_coefficient.html
---

## {{page.title}}

Realizations for [Binomial Coefficient]({{ page.parent_link }}).

### binomialCoefficient

[Algorithm]({{ page.parent_link }}{{ "#binomialCoefficient" | downcase }})

**Realization**
```scala
  import scala.annotation.tailrec

  @tailrec
  def binomialCoefficient(n: Int, k: Int): BigInt =
    if (k < 0 || k > n) {
      BigInt(0)
    } else if (k > n / 2) {
      binomialCoefficient(n, n - k)
    } else {
      val tup = (0 until k).foldLeft((BigInt(1), BigInt(1)))((t, i) => (t._1 * BigInt(n - i), t._2 * BigInt(k - i)))
      tup._1 / tup._2
    }

  def binomialCoefficient(n: Int, k: Int, mod: BigInt): BigInt =
    binomialCoefficient(n, k).mod(mod)
```

---