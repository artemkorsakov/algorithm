---
layout: docs
title: "Realization: Chinese Remainder Theorem"
parent_link: ../../divisors/chinese_remainder_theorem.html
---

## {{page.title}}

Realizations for [Chinese Remainder Theorem]({{ page.parent_link }}).

### solution

[Algorithm]({{ page.parent_link }}{{ "#solution" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.divisors.Divisors._

  def solution(aArray: Array[Long], rArray: Array[Long]): BigInt = {
    val m            = aArray.product                                            // Step 1
    val mArray       = aArray.map(a => m / a)                                    // Step 2
    val mMinus1Array = mArray.indices.map(i => gcdInverse(mArray(i), aArray(i))) // Step 3
    mArray.indices.foldLeft(BigInt(0))((x, i) => x + (((rArray(i) * mArray(i)) % m) * mMinus1Array(i)) % m) // Step 4
  }
```

---
