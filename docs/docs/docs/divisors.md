---
layout: docs
title: "Divisors"
---

## {{page.title}}

The package ```com.github.artemkorsakov.divisors``` contains operations with divisors of a given number. 

You can use the package, for example, like this:
```scala
import com.github.artemkorsakov.divisors.Divisors._

val res0 = gcd(12121212L, 23422344L)
// res0: Long = 12

val res1 = gcdex(12121212L, 23422344L)
// res1: (Long, Long, Long) = (12,347845,-180012)

val res2 = gcdInverse(111, 10)
// res2: Long = 1
```