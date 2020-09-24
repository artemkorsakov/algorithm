---
layout: docs
title: "Realization: Radicals"
parent_link: ../../primes/radicals.html
---

## {{page.title}}

Realizations for [Radicals]({{ page.parent_link }}).

### rad

[Algorithm]({{ page.parent_link }}{{ "#rad" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.primes.Primes._

class Radicals(n: Long) {
  def rad: Long =
    n.primeFactorsWithPow.keySet.product
}
```

---

### allRads

[Algorithm]({{ page.parent_link }}{{ "#allRads" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.primes.Primes._

  def allRads(limit: Int): Array[Int] = {
    val rads = new Array[Int](limit + 1)
    rads(1) = 1

    primes(limit).foreach(p =>
      (1 to limit / p).foreach(i => rads(i * p) = if (rads(i * p) == 0) p else rads(i * p) * p)
    )

    rads
  }
```

---

### isSquareFree

[Algorithm]({{ page.parent_link }}{{ "#isSquareFree" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.primes.Primes._

class Radicals(n: Long) {
  def isSquareFree: Boolean = {
    var p      = 2L
    val s      = math.sqrt(n.toDouble).toLong
    var isFree = true
    while (p <= s && isFree) {
      if (n % (p * p) == 0) {
        isFree = false
      }
      p = p.nextPrime
    }
    isFree
  }
}
```

---
