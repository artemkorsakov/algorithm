---
layout: docs
title: "Realization: Pandigital"
parent_link: ../../digital/pandigital.html
---

## {{page.title}}

Realizations for [Pandigital]({{ page.parent_link }}).

### isPandigital

[Algorithm]({{ page.parent_link }}{{ "#isPandigital" | downcase }})

**Realization**
```scala
  def isPandigital: Boolean =
    number.toString.length == 9 && !number.toString.contains("0") && number.toString.toSeq.distinct.length == 9

  def isPandigital(n: Int): Boolean =
    (number.toString.length == n) && (1 to n).forall(i => number.toString.contains(i.toString))

  def isPandigital(digits: Array[Int]): Boolean =
    (number.toString.length == digits.length) && digits.forall(i => number.toString.contains(i.toString))
```

---
