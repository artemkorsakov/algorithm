---
layout: docs
title: "Realization: Three colours"
parent_link: ../../combinatorics/three_colours.html
---

## {{page.title}}

Realizations for [Three colours]({{ page.parent_link }}).

### countABCRows

[Algorithm]({{ page.parent_link }}{{ "#countABCRows" | downcase }})

**Realization**
```scala
  import scala.collection.mutable

  private val memoryMap: mutable.Map[(Int, Int, Int), Long] = mutable.Map.empty[(Int, Int, Int), Long]

  def countABCRows(a: Int, b: Int, c: Int): Long = {
    val min = math.min(math.min(a, b), c)
    if (min < 0) {
      0
    } else {
      val max = math.max(math.max(a, b), c)
      val mid = a + b + c - min - max
      if (!memoryMap.contains((min, mid, max))) {
        val count =
          if (min == 0 && mid == 0) 1
          else countABCRows(min - 1, mid, max) + countABCRows(min, mid - 1, max) + countABCRows(min, mid, max - 1)
        memoryMap += (min, mid, max) -> count
      }
      memoryMap((min, mid, max))
    }
  }
```

---