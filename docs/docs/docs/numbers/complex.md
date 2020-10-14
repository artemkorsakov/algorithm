---
layout: docs
title: "Complex number"
realization_link: ../realization/numbers/complex.html
---

## {{page.title}}

A [complex number](https://en.wikipedia.org/wiki/Complex_number) is a number that can be expressed in the form **a + bi**, 
where **a** and **b** are real numbers, and **i** represents the imaginary unit, 
satisfying the equation **i<sup>2</sup> = -1**.

### complexOperations

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#complexOperations" | downcase }})

**Sources** 
- [Complex number](https://en.wikipedia.org/wiki/Complex_number)

**Using**
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

---
