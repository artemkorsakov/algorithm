---
layout: docs
title: "Hamming number"
realization_link: ../realization/numbers/hamming.html
---

## {{page.title}}

A positive number is a generalised [Hamming number](https://en.wikipedia.org/wiki/Regular_number) of type n,
if it has no prime factor larger than n.

### isHammingNumber

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#isHammingNumber" | downcase }})

**Sources** 

**Using**
```scala mdoc
import com.github.artemkorsakov.numbers.HammingNumber._
2125764000.isHammingNumber(5)
2125764000.isHammingNumber(7)
2125764000.isHammingNumber(3)
```

---
