---
layout: docs
title: "Digital"
---

## {{page.title}}

The package ```com.github.artemkorsakov.digital``` contains operations with digits of a given number. 

You can use the package, for example, like this:
```scala
import com.github.artemkorsakov.digital.Digits._
import com.github.artemkorsakov.digital.Pandigital._

val res0 = containTheSameDigits(127035954683L, 589323567104L)
// res0: Boolean = true

val res1 = 1406357289L.digits
// res1: Array[Int] = Array(1, 4, 0, 6, 3, 5, 7, 2, 8, 9)

val res2 = 1406357289L.sumOfDigits
// res2: Int = 45
```