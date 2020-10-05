---
layout: docs
title: "Three colours"
realization_link: ../realization/combinatorics/three_colours.html
---

## {{page.title}}

### countABCRows
We have A white balls, B black balls and C grey balls.
How many different options to arrange these balls in a row?

**Algorithm**
1. Let's define **min**, **mid**, **max** as the values of **a**, **b**, **c** in ascending order.
2. If **min** is less than **0** then return **0**.
3. If **min** and **mid** are **0** then return **1**.
4. Else **countABCRows(min, mid, max) = countABCRows(min - 1, mid, max) + countABCRows(min, mid - 1, max) + countABCRows(min, mid, max - 1)**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#countABCRows" | downcase }})

**Sources** 

**Using**
```scala mdoc
import com.github.artemkorsakov.combinatorics.ThreeColours._
val res0 = countABCRows(2, 2, 2)
```

---