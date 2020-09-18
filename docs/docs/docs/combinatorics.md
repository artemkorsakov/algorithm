---
layout: docs
title: "Combinatorics"
---

## {{page.title}}

The package ```com.github.artemkorsakov.combinatorics``` contains [Combinatorics algorithms](https://en.wikipedia.org/wiki/Combinatorics). 

You can use the package, for example, like this:
```scala
import com.github.artemkorsakov.combinatorics.BinomialCoefficient._
import com.github.artemkorsakov.combinatorics.Factorials._

val res0 = binomialCoefficient(100, 68)
// res0: BigInt = 143012501349174257560226775

val res1 = binomialCoefficient(100, 68, 1000000)
// res1: BigInt = 226775

val res2 = 30.factorial
// res2: BigInt = 265252859812191058636308480000000
```