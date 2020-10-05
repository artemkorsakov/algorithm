---
layout: docs
title: "Various math objects"
---

## {{page.title}}

The package ```com.github.artemkorsakov.objects``` contains various math objects. 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.objects.Matrix._
dot(Array(1L, 2L, -3L), Array(-7L, 4L, 6L))
dot(Array(1.5, 2, -3), Array(-7, 4, 6.2))
dot(Array(BigInt(156744), BigInt(53453535), BigInt(-656464646)), Array(BigInt(-4324344), BigInt(455455455), BigInt(445354354)))
dotMod(Array(1007, 2456, -3466), Array(-3347, 4343, 6445), 1000)
```