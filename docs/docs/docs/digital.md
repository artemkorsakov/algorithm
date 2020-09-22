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

val res3 = 56993.hasEqualDigits
// res3: Boolean = true

val res4 = 56993.hasEqualDigits(2, 9)
// res4: Boolean = true

val res5 = 56993.hasEqualDigits(3, 9)
// res5: Boolean = false

val res6 = possibleNumbers(Seq(1, 1, 5, 6))
// res6: Set[String] = Set(5116, 1516, 1165, 6511, 1156, 5161, 6151, 1615, 5611, 6115, 1651, 1561)

val res7 = 192384576L.isPandigital
// res7: Boolean = true

val res8 = 2134.isPandigital(4)
// res8: Boolean = true

val res9 = 1406357289L.isPandigital(Array(9, 8, 7, 6, 5, 4, 3, 2, 1, 0))
// res9: Boolean = true
```