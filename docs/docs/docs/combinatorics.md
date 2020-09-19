---
layout: docs
title: "Combinatorics"
---

## {{page.title}}

The package ```com.github.artemkorsakov.combinatorics``` contains [Combinatorics algorithms](https://en.wikipedia.org/wiki/Combinatorics). 

You can use the package, for example, like this:
```scala
import com.github.artemkorsakov.combinatorics.BinomialCoefficient._
import com.github.artemkorsakov.combinatorics.Coins._
import com.github.artemkorsakov.combinatorics.Factorials._

val res0 = binomialCoefficient(100, 68)
// res0: BigInt = 143012501349174257560226775

val res1 = binomialCoefficient(100, 68, 1000000)
// res1: BigInt = 226775

val res3 = countWays(Array(1, 2, 5, 10, 20, 50, 100, 200), 200)
// res3: Long = 73682

val res4 = 1000.partition
// res4: BigInt = 24061467864032622473692149727991

val res5 = optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(100)
// res5: BigInt = 190569291

val res10 = 30.factorial
// res10: BigInt = 265252859812191058636308480000000
```