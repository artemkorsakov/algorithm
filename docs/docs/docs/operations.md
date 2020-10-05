---
layout: docs
title: "Different algorithms"
---

## {{page.title}}

The package ```com.github.artemkorsakov.operations``` contains various simple algorithms. 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.operations.CommonOperations._
val res0 = sumToGiven(1000000)
val res1 = sumOfSquaresTo(1000)
val res2 = sumOfCubesTo(1000)
val res3 = 1000.sqrt
val res4 = 36.isSquare
val res5 = allSquares(2)
val res6 = allSquares(1024, 1444)
val res7 = allNumbersVariants(Set(2, 3, 5))
```