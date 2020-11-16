---
layout: docsplus
title: "Quadratic equation"
realization: equations/QuadraticEquation.scala
---

Solutions to [a quadratic equation](https://en.wikipedia.org/wiki/Quadratic_equation).

### solutionsInIntegers
Integer solutions to a quadratic equation.

**Algorithm**
1. ![formula](http://latex.codecogs.com/svg.latex?x=%7B%5Cfrac%20%7B-b%5Cpm%20%7B%5Csqrt%20%7Bb%5E%7B2%7D-4ac%7D%7D%7D%7B2a%7D%7D)

**Complexity**
     
**Sources** 
- [Quadratic equation](https://en.wikipedia.org/wiki/Quadratic_equation)

**Using**
```scala mdoc
import com.github.artemkorsakov.equations._
QuadraticEquation(1, -5, -6).solutionsInIntegers
```

---

### solutions
Solutions to a quadratic equation in real numbers.

**Algorithm**
1. ![formula](http://latex.codecogs.com/svg.latex?x=%7B%5Cfrac%20%7B-b%5Cpm%20%7B%5Csqrt%20%7Bb%5E%7B2%7D-4ac%7D%7D%7D%7B2a%7D%7D)

**Complexity**
     
**Sources** 
- [Quadratic equation](https://en.wikipedia.org/wiki/Quadratic_equation)

**Using**
```scala mdoc
QuadraticEquation(1, -5, 5).solutions
```

---

### solutionsInComplexNumbers
Solutions to a quadratic equation in complex numbers.

**Algorithm**
1. Let ![formula](http://latex.codecogs.com/svg.latex?%5CDelta%20=%20b%5E2%20-%204ac.)
2. If &#916; >= 0 then ![formula](http://latex.codecogs.com/svg.latex?x=%7B%5Cfrac%20%7B-b%5Cpm%20%7B%5Csqrt%20%7Bb%5E%7B2%7D-4ac%7D%7D%7D%7B2a%7D%7D)
3. Else ![formula](http://latex.codecogs.com/svg.latex?-%7B%5Cfrac%20%7Bb%7D%7B2a%7D%7D%20%5Cpm%20i%7B%5Cfrac%20%7B%5Csqrt%20%7B-%5CDelta%7D%7D%7B2a%7D%7D%5Cquad)

**Complexity**
     
**Sources** 
- [Quadratic equation](https://en.wikipedia.org/wiki/Quadratic_equation)

**Using**
```scala mdoc
QuadraticEquation(1, -2, 2).solutionsInComplexNumbers
```

---
