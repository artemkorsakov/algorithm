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
(1 to 6).map(fibonacci)
fibonacci(100)
(1 to 6).map(approximateFibonacci)
approximateFibonacci(100)
fibonacciMatrix(20)
fibonacciMatrix(1000000000000000L, 1307674368000L)
```
```scala mdoc
import com.github.artemkorsakov.numbers.HammingNumber._
isHammingNumber(2125764000, 5)
isHammingNumber(2125764000, 7)
isHammingNumber(2125764000, 3)
```
```scala mdoc
import com.github.artemkorsakov.numbers.HarshadNumber._
isHarshadNumber(1728)
isHarshadNumber(1729)
isHarshadNumber(1730)
isStrongHarshadNumber(198)
isStrongHarshadNumber(1728)
isStrongHarshadNumber(1729)
getStrongRightTruncatableHarshadPrimes(3)
getStrongRightTruncatableHarshadPrimes(4).sum
```
```scala mdoc
import com.github.artemkorsakov.numbers.CollatzNumber._
collatz(1)
collatz(3)
collatz(19)
collatz(27)
```
```scala mdoc
import com.github.artemkorsakov.numbers.Palindrome._
isPalindrome(BigInt("4668731596684224866951378664"))
isPalindrome(4994)
isPalindrome(4994, 2)
isPalindrome(15, 2)
isPalindrome(26, 3)
isPalindrome(63, 4)
```
```scala mdoc
import com.github.artemkorsakov.numbers.PythagoreanDeuce._
import com.github.artemkorsakov.numbers.PythagoreanTriplet._
primitivePythagoreanDeuce
primitivePythagoreanDeuce.triplet
primitivePythagoreanDeuce.nextPythagoreanDeuce.map(_.triplet)
primitivePythagoreanDeuce.nextPythagoreanDeuce.flatMap(_.nextPythagoreanDeuce.map(_.triplet)) 
primitivePythagoreanTriplet
primitivePythagoreanTriplet.nextPythagoreanTriplet
primitivePythagoreanTriplet.nextPythagoreanTriplet.flatMap(_.nextPythagoreanTriplet)
pythagoreanTripletsWithGivenSum(1000)
```
```scala mdoc
import com.github.artemkorsakov.numbers.CyclicNumbers._
(1 to 5).map(triangleNumber)
(1 to 5).map(squareNumber)
(1 to 5).map(pentagonalNumber)
(1 to 5).map(hexagonalNumber)
(1 to 5).map(heptagonalNumber)
(1 to 5).map(octagonalNumber)
isTriangle(8256)
isSquare(5625)
isPentagonal(2882)
isHexagonal(8128)
isHeptagonal(2512)
isOctagonal(1281)
```
```scala mdoc
import com.github.artemkorsakov.numbers.OtherNumbers._
(0 to 5).map(padovan)
(0 to 5).map(jacobsthal)
(0 to 5).map(pell)
(0 to 5).map(tribonacci)
(0 to 5).map(tetranacci)
(0 to 5).map(bernoulli)
```
