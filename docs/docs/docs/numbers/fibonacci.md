---
layout: docs
title: "Fibonacci"
realization_link: ../realization/numbers/fibonacci.html
---

## {{page.title}}

In mathematics, [the Fibonacci numbers](https://en.wikipedia.org/wiki/Fibonacci_number), 
commonly denoted **F<sub>n</sub>**, form a sequence, called the Fibonacci sequence, 
such that each number is the sum of the two preceding ones, starting from **0** and **1**. 
That is, **F<sub>0</sub>=0**, **F<sub>1</sub>=1** and
**F<sub>n</sub>=F<sub>n-1</sub>+F<sub>n-2</sub>**
for **n > 1**.

The beginning of the sequence is thus:

**0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...**

### fibonacci

**Algorithm**
1. ![formula](http://latex.codecogs.com/svg.latex?%7B%5Cdisplaystyle%20F_%7Bn%7D=%5Cleft%5B%7B%5Cfrac%20%7B%5Cvarphi%20%5E%7Bn%7D%7D%7B%5Csqrt%20%7B5%7D%7D%7D%5Cright%5D,%5C%20n%5Cgeq%200.%7D)

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#fibonacci" | downcase }})

**Sources** 
- [Fibonacci number](https://en.wikipedia.org/wiki/Fibonacci_number)

**Using**
```scala mdoc
import com.github.artemkorsakov.numbers.Fibonacci._
(1 to 6).map(i => i.fibonacci)
100.fibonacci
```

---

### fibonacciMatrix

**Algorithm**
1. ![formula](http://latex.codecogs.com/svg.latex?%7B%5Cdisplaystyle%20%7B%5Cbegin%7Bpmatrix%7D1&1%5C%5C1&0%5Cend%7Bpmatrix%7D%7D%5E%7Bn%7D=%7B%5Cbegin%7Bpmatrix%7DF_%7Bn&plus;1%7D&F_%7Bn%7D%5C%5CF_%7Bn%7D&F_%7Bn-1%7D%5Cend%7Bpmatrix%7D%7D%7D)

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#fibonacciMatrix" | downcase }})

**Sources** 
- [Fibonacci number](https://en.wikipedia.org/wiki/Fibonacci_number)

**Using**
```scala mdoc
20.fibonacciMatrix
1000000000000000L.fibonacciMatrix(1307674368000L)
```

---
