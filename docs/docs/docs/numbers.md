---
layout: docs
title: "Various numbers"
---

## {{page.title}}

The package ```com.github.artemkorsakov.numbers``` contains various numbers. 

You can use the package, for example, like this:
```scala
import com.github.artemkorsakov.numbers.CyclicNumbers._

val res0 = (1 to 5).map(i => i.triangleNumber)
// res0: scala.collection.immutable.IndexedSeq[Long] = Vector(1, 3, 6, 10, 15)

val res1 = (1 to 5).map(i => i.squareNumber)
// res1: scala.collection.immutable.IndexedSeq[Long] = Vector(1, 4, 9, 16, 25)

val res2 = (1 to 5).map(i => i.pentagonalNumber)
// res2: scala.collection.immutable.IndexedSeq[Long] = Vector(1, 5, 12, 22, 35)

val res3 = (1 to 5).map(i => i.hexagonalNumber)
// res3: scala.collection.immutable.IndexedSeq[Long] = Vector(1, 6, 15, 28, 45)

val res4 = (1 to 5).map(i => i.heptagonalNumber)
// res4: scala.collection.immutable.IndexedSeq[Long] = Vector(1, 7, 18, 34, 55)

val res5 = (1 to 5).map(i => i.octagonalNumber)
// res5: scala.collection.immutable.IndexedSeq[Long] = Vector(1, 8, 21, 40, 65)

val res6 = 8256.isTriangle
// res6: Boolean = true

val res7 = 5625.isSquare
// res7: Boolean = true

val res8 = 2882.isPentagonal
// res8: Boolean = true

val res9 = 8128.isHexagonal
// res9: Boolean = true

val res10 = 2512.isHeptagonal
// res10: Boolean = true

val res11 = 1281.isOctagonal
// res11: Boolean = true
```
