---
layout: docs
title: "Cyclic numbers"
realization_link: ../realization/numbers/cyclic_numbers.html
---

## {{page.title}}

The term [figurate number](https://en.wikipedia.org/wiki/Figurate_number) is used by different writers for members of different sets of numbers, 
generalizing from triangular numbers to different shapes (polygonal numbers) 
and different dimensions (polyhedral numbers).

### figurateNumbers

**Algorithm**
1. Triangular number - ![formula](http://latex.codecogs.com/svg.latex?%7B%5Cdisplaystyle%20T_%7Bn%7D=%7B%5Cfrac%20%7Bn(n&plus;1)%7D%7B2%7D%7D%7D)

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#figurateNumbers" | downcase }})

**Sources** 
- [Triangular number](https://en.wikipedia.org/wiki/Triangular_number)

**Using**
```scala mdoc
import com.github.artemkorsakov.numbers.CyclicNumbers._
(1 to 5).map(i => i.triangleNumber)
```

---
