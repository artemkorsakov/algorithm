---
layout: docs
title: "Realization: Nim"
parent_link: ../../games/nim.html
---

## {{page.title}}

Realizations for [Nim]({{ page.parent_link }}).

### getX

[Algorithm]({{ page.parent_link }}{{ "#getX" | downcase }})

**Realization**
```scala
object Nim {
  def getX(params: Long*): Long =
    (1 until params.length).foldLeft(params.head)((res, i) => res ^ params(i))
}
```

---
