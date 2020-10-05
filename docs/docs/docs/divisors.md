---
layout: docs
title: "Divisors"
---

## {{page.title}}

The package ```com.github.artemkorsakov.divisors``` contains operations with divisors of a given number. 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.divisors.Divisors._
import com.github.artemkorsakov.divisors.ChineseRemainderTheorem
import com.github.artemkorsakov.divisors.PerfectNumbers._
val res0 = gcd(12121212L, 23422344L)
val res1 = gcdex(12121212L, 23422344L)
val res2 = gcdInverse(111, 10)
val res3 = 30.divisors
val res4 = 220.sumOfDivisors
val res5 = 100.countOfDivisors
val res6 = ChineseRemainderTheorem.solution(Array(707, 527), Array(0, 5))
val res7 = 8128.perfectNumbersType
```