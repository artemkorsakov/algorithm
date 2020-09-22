---
layout: docs
title: "Realization: Chinese Remainder Theorem"
parent_link: ../../divisors/chinese_remainder_theorem.html
---

## {{page.title}}

Realizations for [Chinese Remainder Theorem]({{ page.parent_link }}).

### isPrime

[Algorithm]({{ page.parent_link }}{{ "#isPrime" | downcase }})

**Realization**
```scala
  def isPrime: Boolean =
    if (n < 2) false
    else if (n < 4) true
    else if (n % 2 == 0) false
    else if (n < 9) true
    else if (n % 3 == 0) false
    else {
      val sqrt      = math.sqrt(n.toDouble).toLong
      var candidate = 5
      while (candidate <= sqrt && n % candidate != 0) candidate += (if (candidate % 6 == 5) 2 else 4)
      n % candidate != 0
    }
```

---
