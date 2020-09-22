---
layout: docs
title: "Realization: Operations with divisors"
parent_link: ../../divisors/divisors_oper.html
---

## {{page.title}}

Realizations for [Operations with divisors]({{ page.parent_link }}).

### gcd

[Algorithm]({{ page.parent_link }}{{ "#gcd" | downcase }})

**Realization**
```scala
  def gcd(u: Long, v: Long): Long =
    if (u == v) {
      u
    } else if (u == 0) {
      v
    } else if (v == 0) {
      u
    } else {
      (~u & 1, ~v & 1) match {
        case (1, 1) => gcd(u >> 1, v >> 1) << 1
        case (1, 0) => gcd(u >> 1, v)
        case (0, 1) => gcd(u, v >> 1)
        case (_, _) => if (u > v) gcd(u - v, v) else gcd(v - u, u)
      }
    }
```

---

### gcdex

[Algorithm]({{ page.parent_link }}{{ "#gcdex" | downcase }})

**Realization**
```scala
  def gcdex(a: Long, b: Long): (Long, Long, Long) =
    if (a == 0) {
      (b, 0, 1)
    } else {
      val temp = gcdex(b % a, a)
      (temp._1, temp._3 - (b / a) * temp._2, temp._2)
    }
```

---

### gcdInverse

[Algorithm]({{ page.parent_link }}{{ "#gcdInverse" | downcase }})

**Realization**
```scala
  def gcdInverse(a: Long, m: Long): Long = {
    val extraEuclid = gcdex(a, m)
    if (extraEuclid._1 == 1) {
      (extraEuclid._2 % m + m) % m
    } else {
      -1
    }
  }
```

---
