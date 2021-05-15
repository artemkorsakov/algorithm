---
layout: docs
title: "Digital"
---

## {{page.title}}

The package ```com.github.artemkorsakov.digital``` contains operations with digits of a given number. 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.digital.Digits._
containTheSameDigits(127035954683L, 589323567104L)
digits(1406357289L)
sumOfDigits(1406357289L)
hasEqualDigits(56993)
hasEqualDigits(56993, 2, 9)
hasEqualDigits(56993, 3, 9)
possibleNumbers(IndexedSeq(1, 1, 5, 6))
```
```scala mdoc:reset
import com.github.artemkorsakov.digital.Pandigital._
isPandigital(192384576L)
isPandigital(2134, 4)
isPandigital(1406357289L, Array(9, 8, 7, 6, 5, 4, 3, 2, 1, 0))
```