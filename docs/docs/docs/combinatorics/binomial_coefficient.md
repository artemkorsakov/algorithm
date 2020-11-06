---
layout: docsplus
title: "Binomial Coefficient"
realization: combinatorics/BinomialCoefficient.scala
---

Operations with [binomial coefficient](https://en.wikipedia.org/wiki/Binomial_coefficient).

### binomialCoefficient
Calculate binomial coefficient ![binomial coefficient](https://latex.codecogs.com/svg.latex?{\displaystyle%20{\binom%20{n}{k}}})

**Algorithm**
1. if **k < 0** or **k > n** return **0**.
2. ![formula](http://latex.codecogs.com/svg.latex?%7B%5Cbinom%20%7Bn%7D%7Bk%7D%7D=%7B%5Cbegin%7Bcases%7Dn%5E%7B%5Cunderline%20%7Bk%7D%7D/k!&%7B%5Ctext%7Bif%20%7D%7D%5C%20k%5Cleq%20%7B%5Cfrac%20%7Bn%7D%7B2%7D%7D%5C%5Cn%5E%7B%5Cunderline%20%7Bn-k%7D%7D/(n-k)!&%7B%5Ctext%7Bif%20%7D%7D%5C%20k%3E%7B%5Cfrac%20%7Bn%7D%7B2%7D%7D%5Cend%7Bcases%7D%20%5Ctext%7B%20where%20%7D%20%5Cdisplaystyle%20%7B%5Cfrac%20%7Bn%5E%7B%5Cunderline%20%7Bk%7D%7D%7D%7Bk!%7D%7D=%7B%5Cfrac%20%7Bn(n-1)(n-2)%5Ccdots%20(n-(k-1))%7D%7Bk(k-1)(k-2)%5Ccdots%201%7D%7D=%5Cprod%20_%7Bi=1%7D%5E%7Bk%7D%7B%5Cfrac%20%7Bn&plus;1-i%7D%7Bi%7D%7D%7D) 
 
**Complexity** _O_(n)
     
**Sources** 
- [Wikipedia](https://en.wikipedia.org/wiki/Binomial_coefficient)

**Using**
```scala mdoc
import com.github.artemkorsakov.combinatorics.BinomialCoefficient._
binomialCoefficient(100, 68)
binomialCoefficient(100, 68, 1000000)
```

---