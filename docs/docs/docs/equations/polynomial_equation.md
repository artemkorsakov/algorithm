---
layout: docsplus
title: "Polynomial equation"
realization: equations/PolynomialEquation.scala
---

### polynomialCoefficients
Returns the coefficients of a polynomial equation with the given power and array of solutions.

For example, there is a equation **a<sub>0</sub>*x<sup>2</sup> + a<sub>1</sub>*x + a<sub>2</sub> = b**.
<br>If **[b<sub>0</sub>, b<sub>1</sub>, b<sub>2</sub>]** are solutions for **x &#8712; [1,2,3]** then
**PolynomialEquation.polynomialCoefficients(3, Seq(b<sub>0</sub>, b<sub>1</sub>, b<sub>2</sub>))** 
returns coefficients **[a<sub>0</sub>, a<sub>1</sub>, a<sub>2</sub>]**.

**Algorithm**

**Complexity**
     
**Sources** 
- [Polynomial](https://en.wikipedia.org/wiki/Polynomial)

**Using**
```scala mdoc
import com.github.artemkorsakov.equations.PolynomialEquation
PolynomialEquation.polynomialCoefficients(3, Array(1, 8, 27))
```

---
