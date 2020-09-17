---
layout: docs
title: "Realization: Euler's totient function"
parent_link: ../../primes/phi_function.html
---

## {{page.title}}

Realizations for [Euler's totient function]({{ page.parent_link }}).

### phiFunction

[Algorithm]({{ page.parent_link }}{{ "#phiFunction" | downcase }})

**Realization**
```scala
  def phiFunction: Long =
    n.primeFactorsWithPow.keySet.foldLeft(n)((b, p) => b * (p - 1) / p)
```

---

### phiFunctionArray

[Algorithm]({{ page.parent_link }}{{ "#phiFunctionArray" | downcase }})

**Realization**
```scala
  def phiFunctionArray(limit: Int): Array[Long] = {
    val phiArray = new Array[Long](limit + 1)
    phiArray(1) = 1

    val primesArray = primes(limit)
    for (n <- 1 to limit / 2) {
      var i = 0
      while (i < primesArray.length && n * primesArray(i) <= limit) {
        val p = primesArray(i)
        phiArray(n * p) = phiArray(n) * (if (n % p == 0) p else p - 1)
        i += 1
      }
    }

    phiArray
  }
```

---
