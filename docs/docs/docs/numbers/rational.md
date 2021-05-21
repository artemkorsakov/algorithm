---
layout: docsplus
title: "Rational number/Fraction"
realization: numbers/RationalNumber.scala
---

A [rational number](https://en.wikipedia.org/wiki/Rational_number) is a number that can be expressed as the quotient 
or [fraction](https://en.wikipedia.org/wiki/Fraction) p/q of two integers, a numerator p and a non-zero denominator q.

### addSubMulDiv
Fraction operations: [Addition](https://en.wikipedia.org/wiki/Rational_number#Addition), 
[subtraction](https://en.wikipedia.org/wiki/Rational_number#Subtraction),
[multiplication](https://en.wikipedia.org/wiki/Rational_number#Multiplication),
[division](https://en.wikipedia.org/wiki/Rational_number#Division) and 
[upend/reciprocal](https://en.wikipedia.org/wiki/Rational_number#Inverse).

**Algorithm**
1. ![f](http://latex.codecogs.com/svg.latex?%7B%5Cfrac%20%7Ba%7D%7Bb%7D%7D&plus;%7B%5Cfrac%20%7Bc%7D%7Bd%7D%7D=%7B%5Cfrac%20%7Bad&plus;bc%7D%7Bbd%7D%7D)
2. ![f](http://latex.codecogs.com/svg.latex?%7B%5Cfrac%20%7Ba%7D%7Bb%7D%7D-%7B%5Cfrac%20%7Bc%7D%7Bd%7D%7D=%7B%5Cfrac%20%7Bad-bc%7D%7Bbd%7D%7D)
3. ![f](http://latex.codecogs.com/svg.latex?%7B%5Cfrac%20%7Ba%7D%7Bb%7D%7D%5Ccdot%20%7B%5Cfrac%20%7Bc%7D%7Bd%7D%7D=%7B%5Cfrac%20%7Bac%7D%7Bbd%7D%7D)
4. ![f](http://latex.codecogs.com/svg.latex?%7B%5Cdisplaystyle%20%7B%5Cfrac%20%7B%5Cfrac%20%7Ba%7D%7Bb%7D%7D%7B%5Cfrac%20%7Bc%7D%7Bd%7D%7D%7D=%7B%5Cfrac%20%7Bad%7D%7Bbc%7D%7D%7D)
5. ![f](http://latex.codecogs.com/svg.latex?%7B%5Cdisplaystyle%20%5Cleft(%7B%5Cfrac%20%7Ba%7D%7Bb%7D%7D%5Cright)%5E%7B-1%7D=%7B%5Cfrac%20%7Bb%7D%7Ba%7D%7D%7D)

**Complexity** 
     
**Sources** 
- [Rational number](https://en.wikipedia.org/wiki/Rational_number)
- [Fraction](https://en.wikipedia.org/wiki/Fraction)

**Using**
```scala mdoc
import com.github.artemkorsakov.numbers.RationalNumber
val x = RationalNumber(1, 3)
val y = RationalNumber(5, 7)
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
```

---

### equal

Returns **true** if the rational numbers are equal.

**Algorithm**

**Complexity** 
     
**Sources** 

**Using**
```scala mdoc
x.equal(RationalNumber(1, 3))
x.equal(RationalNumber(-2, -6))
x.equal(RationalNumber(3, 9))
x.equal(RationalNumber(1, 4))
x == RationalNumber(1, 3)
x == RationalNumber(-2, -6)
x == RationalNumber(3, 9)
x == RationalNumber(1, 4)
```

---

### compare

Comparison of two fractions.

**Algorithm**

**Complexity** 
     
**Sources** 

**Using**
```scala mdoc
import com.github.artemkorsakov.numbers.RationalNumber._
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
x max y
x max x
y max y
```

---

### toPercent

Fraction to percent.

**Algorithm**

**Complexity** 
     
**Sources** 

**Using**
```scala mdoc
import com.github.artemkorsakov.numbers.RationalNumber
RationalNumber(5, 7).toPercent
```

---
