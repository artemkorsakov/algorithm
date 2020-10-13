---
layout: docs
title: "Various numbers"
---

## {{page.title}}

The package ```com.github.artemkorsakov.numbers``` contains various numbers. 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.numbers.RationalNumber
import com.github.artemkorsakov.numbers.RationalNumber._
val x = new RationalNumber(1, 3)
val y = new RationalNumber(5, 7)
x.add(y)
x.sub(y)
x.mul(y)
x.div(y)
x + y
x - y
x * y
x / y
x.upend
y.upend
x.equal(new RationalNumber(1, 3))
x.equal(new RationalNumber(-2, -6))
x.equal(new RationalNumber(3, 9))
x.equal(new RationalNumber(1, 4))
x == new RationalNumber(1, 3)
x == new RationalNumber(-2, -6)
x == new RationalNumber(3, 9)
x == new RationalNumber(1, 4)
x < y
y < x
x < x
x <= y
x <= x
x > y
y > x
x > x
x >= y
x >= x
max(x, y) == y
max(x, x) == x
max(y, y) == y
new RationalNumber(5, 7).toPercent
```
```scala mdoc
import com.github.artemkorsakov.numbers.ComplexNumber
ComplexNumber(2, 3).add(ComplexNumber(1, 4))
ComplexNumber(2, 3) + ComplexNumber(1, 4)
ComplexNumber(2, 3).sub(ComplexNumber(1, 4))
ComplexNumber(2, 3) - ComplexNumber(1, 4)
ComplexNumber(2, 3).mul(ComplexNumber(1, 4))
ComplexNumber(2, 3) * ComplexNumber(1, 4)
ComplexNumber(2, 3).div(ComplexNumber(1, 4))
ComplexNumber(2, 3) / ComplexNumber(1, 4)
(ComplexNumber(1, 1) * ComplexNumber(2, 1) * ComplexNumber(3, 1)) / ComplexNumber(1, -1)
ComplexNumber(1, 1) / ComplexNumber(1, -1)
ComplexNumber(1, 1) / ComplexNumber(2, -1)
ComplexNumber(1, 0) / ComplexNumber(0, 1)
(ComplexNumber(1, 0) / ComplexNumber(-2, 1)) / ComplexNumber(1, -3)
ComplexNumber(5, 6).abs
ComplexNumber(-5, 6).abs
ComplexNumber(5, -6).abs
ComplexNumber(-5, -6).abs
ComplexNumber(5, 6).conjugate
ComplexNumber(5, 6).conjugate.conjugate
ComplexNumber(5.0, 12.0).productWithConjugate
ComplexNumber(5.0, 12.0).sqrt
ComplexNumber(5.0, 3.0).power2
ComplexNumber(5.0, 3.0).power2.power2
ComplexNumber(5.0, 3.0).power2.power2.power2
ComplexNumber(5.0, 3.0).power(8)
ComplexNumber(-1.0 / 2.0, Math.sqrt(3.0) / 2.0).power(3)
```
```scala mdoc
import com.github.artemkorsakov.numbers.Fibonacci._
(1 to 6).map(i => i.fibonacci)
100.fibonacci
20.fibonacciMatrix
1000000000000000L.fibonacciMatrix(1307674368000L)
```
```scala mdoc
import com.github.artemkorsakov.numbers.HammingNumber._
2125764000.isHammingNumber(5)
2125764000.isHammingNumber(7)
2125764000.isHammingNumber(3)
```
```scala mdoc
import com.github.artemkorsakov.numbers.HarshadNumber._
1728.isHarshadNumber
1729.isHarshadNumber
1730.isHarshadNumber
198.isStrongHarshadNumber
1728.isStrongHarshadNumber
1729.isStrongHarshadNumber
getStrongRightTruncatableHarshadPrimes(3)
getStrongRightTruncatableHarshadPrimes(4).sum
```
```scala mdoc
import com.github.artemkorsakov.numbers.CollatzNumber._
1.collatz
3.collatz
19.collatz
27.collatz
```
```scala mdoc
import com.github.artemkorsakov.numbers.CyclicNumbers._
(1 to 5).map(i => i.triangleNumber)
(1 to 5).map(i => i.squareNumber)
(1 to 5).map(i => i.pentagonalNumber)
(1 to 5).map(i => i.hexagonalNumber)
(1 to 5).map(i => i.heptagonalNumber)
(1 to 5).map(i => i.octagonalNumber)
8256.isTriangle
5625.isSquare
2882.isPentagonal
8128.isHexagonal
2512.isHeptagonal
1281.isOctagonal
```
