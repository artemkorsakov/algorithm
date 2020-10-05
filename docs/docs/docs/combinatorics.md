---
layout: docs
title: "Combinatorics"
---

## {{page.title}}

The package ```com.github.artemkorsakov.combinatorics``` contains [Combinatorics algorithms](https://en.wikipedia.org/wiki/Combinatorics). 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.combinatorics.BinomialCoefficient._
import com.github.artemkorsakov.combinatorics.Coins._
import com.github.artemkorsakov.combinatorics.Factorials._
import com.github.artemkorsakov.combinatorics.ThreeColours._
val res0 = binomialCoefficient(100, 68)
val res1 = binomialCoefficient(100, 68, 1000000)
val res2 = countWays(Array(1, 2, 5, 10, 20, 50, 100, 200), 200)
val res3 = 1000.partition
val res4 = optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(100)
val res5 = 30.factorial
val res6 = countABCRows(2, 2, 2)
```