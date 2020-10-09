---
layout: docs
title: "Various math objects"
---

## {{page.title}}

The package ```com.github.artemkorsakov.objects``` contains various math objects. 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.objects.MatrixLine._
Seq(1L, 2L, -3L).mul(Seq(-7L, 4L, 6L)) 
Seq(1L, 2L, -3L) * Seq(-7L, 4L, 6L) 
Seq(1007, 2456, -3466).mulMod(Seq(-3347, 4343, 6445), 1000)
```
```scala mdoc
import com.github.artemkorsakov.objects.Matrix._
Seq(Seq(1, 2), Seq(3, 4), Seq(5, 6)).matrixTranspose
Seq(Seq(1, 3, 5), Seq(2, 4, 6)).matrixTranspose
Seq(Seq(1, 2), Seq(3, 4), Seq(5, 6)).matrixTranspose.matrixTranspose
Seq(Seq(-2, -1, -1, -4), Seq(-1, -2, -1, -6), Seq(-1, -1, 2, 4), Seq(2, 1, -3, -8)).minorMatrix(1, 2)
Seq(Seq(-2, -1, -1, -4), Seq(-1, -2, -1, -6), Seq(-1, -1, 2, 4), Seq(2, 1, -3, -8)).matrixDeterminant
Seq(Seq(-2, -1, -1, -4), Seq(-1, -2, -1, -6), Seq(-1, -1, 2, 4), Seq(2, 1, -3, -8)) + Seq(Seq(8, -5, -6, -4), Seq(-13, -22, -11, -65), Seq(45, 45, 34, 35), Seq(23, 12, -33, -82))
Seq(Seq(-2, -1, -1, -4), Seq(-1, -2, -1, -6), Seq(-1, -1, 2, 4), Seq(2, 1, -3, -8)).mul(7)
Seq(Seq(-2, -1, -1, -4), Seq(-1, -2, -1, -6), Seq(-1, -1, 2, 4), Seq(2, 1, -3, -8)) * 8
Seq(Seq(-2, -1, -1, -4), Seq(-1, -2, -1, -6), Seq(-1, -1, 2, 4), Seq(2, 1, -3, -8)).mulMod(10, 11)
Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0)).mul(Seq(Seq(1, 2, 3), Seq(-3, 5, 4), Seq(6, 2, 1), Seq(1, -1, 0)))
Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0)) * Seq(Seq(1, 2, 3), Seq(-3, 5, 4), Seq(6, 2, 1), Seq(1, -1, 0))
Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0)).mulMod(Seq(Seq(1, 2, 3), Seq(-3, 5, 4), Seq(6, 2, 1), Seq(1, -1, 0)), 7)
Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0)).mul(Seq(1, -3, 6, 1))
Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0)) * Seq(1, -3, 6, 1)
Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0)).mulMod(Seq(1, -3, 6, 1), 7)
Seq(1, -3, 6).mul(Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0)))
Seq(1, -3, 6) * Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0))
Seq(1, -3, 6).mulMod(Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0)), 7)
Seq(Seq(2, 0), Seq(-1, 3)).power(2)
val fibonacciMatrix = Seq(Seq(1, 1), Seq(1, 0))
fibonacciMatrix.power(20)
Seq(Seq(1, 2, 1, 0), Seq(1, 1, 0, -1), Seq(-2, 0, 1, 2), Seq(0, 2, 1, 1)).power(100)
fibonacciMatrix.powerMod(50, 1000000)
```
