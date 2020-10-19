---
layout: docs
title: "Equations"
---

## {{page.title}}

The package ```com.github.artemkorsakov.equations``` contains algorithms for solving equations. 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.equations._
QuadraticEquation(1, -5, -6).solutionsInIntegers
QuadraticEquation(1, -5, 5).solutions
QuadraticEquation(1, -2, 2).solutionsInComplexNumbers
```
```scala mdoc
import com.github.artemkorsakov.equations.DiophantineEquation
DiophantineEquation(61).minimalEquation
```
```scala mdoc
import com.github.artemkorsakov.equations.PolynomialEquation
PolynomialEquation.polynomialCoefficients(3, Seq(1, 8, 27))
```