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
```
