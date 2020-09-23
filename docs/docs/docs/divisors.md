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

val res3 = 30.divisors
// res3: Set[Long] = Set(5, 10, 6, 2, 3, 15)

val res4 = 220.sumOfDivisors
// res4: BigInt = 504

val res5 = 100.countOfDivisors
// res5: Long = 9
```