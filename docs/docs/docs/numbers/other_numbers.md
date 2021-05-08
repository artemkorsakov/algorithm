---
layout: docsplus
title: "Other numbers"
realization: numbers/OtherNumbers.scala
---

### bernoulli

[Bernoulli number](https://en.wikipedia.org/wiki/Bernoulli_number)

**Algorithm**

**Complexity**

**Sources**
- [Bernoulli number](https://en.wikipedia.org/wiki/Bernoulli_number)

**Using**
```scala mdoc
import com.github.artemkorsakov.numbers.OtherNumbers.bernoulli
(0 to 5).map(bernoulli)
```

---

### padovan

Padovan sequence (or Padovan numbers):
**a<sub>n</sub> = a<sub>n-2</sub> + a<sub>n-3</sub>** with **a<sub>0</sub> = 1, a<sub>1</sub> = a<sub>2</sub> = 0**.

The beginning of the sequence is thus:

**1, 0, 0, 1, 0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12, 16, 21, 28, 37, 49, 65, 86, 114, 151, 200...**

**Algorithm**

**Complexity** 
     
**Sources** 
- [Padovan sequence](https://oeis.org/A000931)

**Using**
```scala mdoc
import com.github.artemkorsakov.numbers.OtherNumbers.padovan
(0 to 5).map(padovan)
```

---

### jacobsthal

Jacobsthal sequence (or Jacobsthal numbers):
**a<sub>n</sub> = a<sub>n-1</sub> + 2 * a<sub>n-2</sub>**
with **a<sub>0</sub> = 0, a<sub>1</sub> = 1**.

Also **a<sub>n</sub> = nearest integer to 2<sup>n</sup>/3**.

The beginning of the sequence is thus:

**0, 1, 1, 3, 5, 11, 21, 43, 85, 171, 341, 683, 1365, 2731, 5461, 10923, 21845, 43691, 87381, 174763, 349525...**

**Algorithm**

**Complexity**

**Sources**
- [Jacobsthal sequence](https://oeis.org/A001045)

**Using**
```scala mdoc
import com.github.artemkorsakov.numbers.OtherNumbers.jacobsthal
(0 to 5).map(jacobsthal)
```

---

### pell

Pell numbers: 
**a<sub>n</sub> = 2 * a<sub>n-1</sub> + a<sub>n-2</sub>**
with **a<sub>0</sub> = 0, a<sub>1</sub> = 1**.

The beginning of the sequence is thus:

**0, 1, 2, 5, 12, 29, 70, 169, 408, 985, 2378, 5741, 13860, 33461, 80782, 195025, 470832, 1136689...**

**Algorithm**

**Complexity**

**Sources**
- [Pell numbers](https://oeis.org/A000129)

**Using**
```scala mdoc
import com.github.artemkorsakov.numbers.OtherNumbers.pell
(0 to 5).map(pell)
```

---

### tribonacci

Tribonacci numbers: 
**a<sub>n</sub> = a<sub>n-1</sub> + a<sub>n-2</sub> + a<sub>n-3</sub>**
with **a<sub>0</sub> = a<sub>1</sub> = 0, a<sub>2</sub> = 1**.

The beginning of the sequence is thus:

**0, 0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504, 927, 1705, 3136, 5768, 10609, 19513, 35890, 66012, 121415...**

**Algorithm**

**Complexity**

**Sources**
- [Tribonacci numbers](https://oeis.org/A000073)

**Using**
```scala mdoc
import com.github.artemkorsakov.numbers.OtherNumbers.tribonacci
(0 to 5).map(tribonacci)
```

---

### tetranacci

Tetranacci numbers: 
**a<sub>n</sub> = a<sub>n-1</sub> + a<sub>n-2</sub> + a<sub>n-3</sub> + a<sub>n-4</sub>**
 with **a<sub>0</sub> = a<sub>1</sub> = a<sub>2</sub> = 0, a<sub>3</sub> = 1**.

The beginning of the sequence is thus:

**0, 0, 0, 1, 1, 2, 4, 8, 15, 29, 56, 108, 208, 401, 773, 1490, 2872, 5536, 10671, 20569, 39648, 76424...**

**Algorithm**

**Complexity**

**Sources**
- [Tetranacci numbers](https://oeis.org/A000078)

**Using**
```scala mdoc
import com.github.artemkorsakov.numbers.OtherNumbers.tetranacci
(0 to 5).map(tetranacci)
```

---
