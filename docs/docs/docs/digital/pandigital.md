---
layout: docsplus
title: "Pandigital"
realization: digital/Pandigital.scala
---

### isPandigital
- Is a number an integer that has among its significant digits each digit used exactly once?
- Is a number an integer that has among its significant digits (from 1 to n) each digit used exactly once?
- Is a number an integer that has among its significant digits (from digits list) each digit used exactly once?

**Algorithm**

**Complexity**
     
**Sources** 

**Using**
```scala mdoc
import com.github.artemkorsakov.digital.Pandigital._
isPandigital(192384576L)
isPandigital(2134, 4)
isPandigital(1406357289L, Array(9, 8, 7, 6, 5, 4, 3, 2, 1, 0))
```

---