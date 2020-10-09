---
layout: docs
title: "Factorials"
realization_link: ../realization/combinatorics/factorials.html
---

## {{page.title}}

[Factorial](https://en.wikipedia.org/wiki/Factorial)

### factorial
Calculate factorial.

**Algorithm**
1. ![formula](http://latex.codecogs.com/svg.latex?%7B%5Cdisplaystyle%20n!=n%5Ctimes%20(n-1)%5Ctimes%20(n-2)%5Ctimes%20(n-3)%5Ctimes%20%5Ccdots%20%5Ctimes%203%5Ctimes%202%5Ctimes%201%5C,%7D)
 
**Complexity** _O_(n)
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#factorial" | downcase }})

**Sources** 
- [Wikipedia](https://en.wikipedia.org/wiki/Factorial)

**Using**
```scala mdoc
import com.github.artemkorsakov.combinatorics.Factorials._
30.factorial
```

---