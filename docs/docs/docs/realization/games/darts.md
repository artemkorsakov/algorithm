---
layout: docs
title: "Realization: Darts"
parent_link: ../../games/darts.html
---

## {{page.title}}

Realizations for [Darts]({{ page.parent_link }}).

### allDistinctWaysToCheckOut

[Algorithm]({{ page.parent_link }}{{ "#allDistinctWaysToCheckOut" | downcase }})

**Realization**
```scala
object Darts {
  private val singlePoints: Seq[Int] = (1 to 20) :+ 25
  private val doublePoints: Seq[Int] = (2 to 40 by 2) :+ 50
  private val triplePoints: Seq[Int] = 3 to 60 by 3
  private val points: Seq[Int]       = singlePoints ++ doublePoints ++ triplePoints

  val allDistinctWaysToCheckOut: Map[Int, Int] = {
    // First step checkout
    var integerMap = doublePoints.map(point => point -> 1).toMap
    
    // Second step checkout
    points.foreach(value =>
      doublePoints.foreach { doublePoint =>
        val point = value + doublePoint
        integerMap += (point -> (integerMap.getOrElse(point, 0) + 1))
      }
    )

    // Third step checkout
    points.indices.foreach(i =>
      (i until points.length).foreach(j =>
        doublePoints.foreach { doublePoint =>
          val point = points(i) + points(j) + doublePoint
          integerMap += (point -> (integerMap.getOrElse(point, 0) + 1))
        }
      )
    )

    integerMap
  }
}
```

---
