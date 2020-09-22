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
