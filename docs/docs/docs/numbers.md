---
layout: docs
title: "Various numbers"
---

## {{page.title}}

The package ```com.github.artemkorsakov.numbers``` contains various numbers. 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.numbers.CyclicNumbers._
(1 to 5).map(i => i.triangleNumber)
(1 to 5).map(i => i.squareNumber)
(1 to 5).map(i => i.pentagonalNumber)
(1 to 5).map(i => i.hexagonalNumber)
(1 to 5).map(i => i.heptagonalNumber)
(1 to 5).map(i => i.octagonalNumber)
8256.isTriangle
5625.isSquare
2882.isPentagonal
8128.isHexagonal
2512.isHeptagonal
1281.isOctagonal
```
