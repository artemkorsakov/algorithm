---
layout: docs
title: "Different algorithms"
---

## {{page.title}}

The package ```com.github.artemkorsakov.operations``` contains various simple algorithms. 

You can use the package, for example, like this:
```scala
import com.github.artemkorsakov.operations.CommonOperations._

val res0 = sumToGiven(1000000)
// res0: Long = 500000500000

val res1 = sumOfSquaresTo(1000)
// res1: Long = 333833500

val res2 = sumOfCubesTo(1000)
// res2: Long = 250500250000

val res3 = 1000.sqrt
// res3: Double = 31.622776601684336

val res4 = 36.isSquare
// res4: Boolean = true

val res5 = allSquares(2)
// res5: List[Int] = List(16, 25, 36, 49, 64, 81)

val res6 = allSquares(1024, 1444)
// res6: List[Int] = List(1024, 1089, 1156, 1225, 1296, 1369, 1444)

val res7 = allNumbersVariants(Set(2, 3, 5))
// res7: Set[Set[Int]] = Set(Set(2), Set(3, 2), Set(5), Set(3), Set(5, 3, 2), Set(5, 3), Set(5, 2))
```