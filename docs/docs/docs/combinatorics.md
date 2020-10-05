---
layout: docs
title: "Combinatorics"
---

## {{page.title}}

The package ```com.github.artemkorsakov.combinatorics``` contains [Combinatorics algorithms](https://en.wikipedia.org/wiki/Combinatorics). 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.combinatorics.BinomialCoefficient._
binomialCoefficient(100, 68)
binomialCoefficient(100, 68, 1000000)
```
```scala mdoc
import com.github.artemkorsakov.combinatorics.Coins._
countWays(Array(1, 2, 5, 10, 20, 50, 100, 200), 200)
1000.partition
optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(100)
```
```scala mdoc
import com.github.artemkorsakov.combinatorics.Factorials._
30.factorial
```
```scala mdoc
import com.github.artemkorsakov.combinatorics.ThreeColours._
countABCRows(2, 2, 2)
```