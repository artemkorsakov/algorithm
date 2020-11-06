---
layout: docsplus
title: "Three colours"
realization: combinatorics/ThreeColours.scala
---

### countABCRows
We have A white balls, B black balls and C grey balls.
How many different options to arrange these balls in a row?

**Algorithm**
1. Let's define **min**, **mid**, **max** as the values of **a**, **b**, **c** in ascending order.
2. If **min** is less than **0** then return **0**.
3. If **min** and **mid** are **0** then return **1**.
4. Else **countABCRows(min, mid, max) = countABCRows(min - 1, mid, max) + countABCRows(min, mid - 1, max) + countABCRows(min, mid, max - 1)**

**Complexity**
     
**Sources** 

**Using**
```scala mdoc
import com.github.artemkorsakov.combinatorics.ThreeColours._
countABCRows(2, 2, 2)
```

---