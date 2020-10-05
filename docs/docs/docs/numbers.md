---
layout: docs
title: "Various numbers"
---

## {{page.title}}

The package ```com.github.artemkorsakov.numbers``` contains various numbers. 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.numbers.CyclicNumbers._
val res0 = (1 to 5).map(i => i.triangleNumber)
val res1 = (1 to 5).map(i => i.squareNumber)
val res2 = (1 to 5).map(i => i.pentagonalNumber)
val res3 = (1 to 5).map(i => i.hexagonalNumber)
val res4 = (1 to 5).map(i => i.heptagonalNumber)
val res5 = (1 to 5).map(i => i.octagonalNumber)
val res6 = 8256.isTriangle
val res7 = 5625.isSquare
val res8 = 2882.isPentagonal
val res9 = 8128.isHexagonal
val res10 = 2512.isHeptagonal
val res11 = 1281.isOctagonal
```
