---
layout: docs
title: "Pandigital"
realization_link: ../realization/digital/pandigital.html
---

## {{page.title}}

### isPandigital
- Is a number an integer that has among its significant digits each digit used exactly once?
- Is a number an integer that has among its significant digits (from 1 to n) each digit used exactly once?
- Is a number an integer that has among its significant digits (from digits list) each digit used exactly once?

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#isPandigital" | downcase }})

**Sources** 

**Using**
```scala mdoc
import com.github.artemkorsakov.digital.Pandigital._
192384576L.isPandigital
2134.isPandigital(4)
1406357289L.isPandigital(Array(9, 8, 7, 6, 5, 4, 3, 2, 1, 0))
```

---