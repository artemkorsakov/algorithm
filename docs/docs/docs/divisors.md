---
layout: docs
title: "Divisors"
---

## {{page.title}}

The package ```com.github.artemkorsakov.divisors``` contains operations with divisors of a given number. 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.divisors.Divisors._
gcd(12121212L, 23422344L)
gcdex(12121212L, 23422344L)
gcdInverse(111, 10)
30.divisors
220.sumOfDivisors
100.countOfDivisors
```
```scala mdoc
import com.github.artemkorsakov.divisors.ChineseRemainderTheorem
ChineseRemainderTheorem.solution(Array(707, 527), Array(0, 5))
```
```scala mdoc
import com.github.artemkorsakov.divisors.PerfectNumbers._
8128.perfectNumbersType
```