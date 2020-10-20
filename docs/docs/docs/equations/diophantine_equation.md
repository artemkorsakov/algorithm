---
layout: docs
title: "Diophantine equation"
realization_link: ../realization/equations/diophantine_equation.html
---

## {{page.title}}

Solving an equation x<sup>2</sup> – D*y<sup>2</sup> = 1 by [Chakravala method](https://en.wikipedia.org/wiki/Chakravala_method).

### minimalEquation

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#minimalEquation" | downcase }})

**Sources** 
- [Chakravala method](https://en.wikipedia.org/wiki/Chakravala_method)

**Using**
```scala mdoc
import com.github.artemkorsakov.equations.DiophantineEquation
DiophantineEquation(61).minimalEquation
```

---
