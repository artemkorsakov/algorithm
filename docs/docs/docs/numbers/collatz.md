---
layout: docs
title: "Collatz number"
realization_link: ../realization/numbers/collatz.html
---

## {{page.title}}

Returns count of Collatz conjecture's steps.

### collatz

**Algorithm**
1. ![f](http://latex.codecogs.com/svg.latex?%7B%5Cdisplaystyle%20f(n)=%7B%5Cbegin%7Bcases%7D%7B%5Cfrac%20%7Bn%7D%7B2%7D%7D&%7B%5Ctext%7Bif%20%7D%7Dn%5Cequiv%200%7B%5Cpmod%20%7B2%7D%7D%5C%5C%5B4px%5D3n&plus;1&%7B%5Ctext%7Bif%20%7D%7Dn%5Cequiv%201%7B%5Cpmod%20%7B2%7D%7D%5Cend%7Bcases%7D%7D%7D)

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#collatz" | downcase }})

**Sources** 
- [Collatz conjecture](https://en.wikipedia.org/wiki/Collatz_conjecture)

**Using**
```scala mdoc
import com.github.artemkorsakov.numbers.CollatzNumber._
1.collatz
3.collatz
19.collatz
27.collatz
```

---
