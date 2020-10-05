---
layout: docs
title: "Matrix"
realization_link: ../realization/objects/matrix.html
---

## {{page.title}}
[Matrix](https://en.wikipedia.org/wiki/Matrix_multiplication).

### dot
Product of two lines.

**Algorithm**
1. ![formula](http://latex.codecogs.com/svg.latex?%7Bproduct=a_%7Bi1%7Db_%7B1j%7D&plus;a_%7Bi2%7Db_%7B2j%7D&plus;%5Ccdots%20&plus;a_%7Bin%7Db_%7Bnj%7D=%5Csum%20_%7Bk=1%7D%5E%7Bn%7Da_%7Bik%7Db_%7Bkj%7D%7D)

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#dot" | downcase }})

**Sources** 

**Using**
```scala mdoc
import com.github.artemkorsakov.objects.Matrix._
dot(Array(1L, 2L, -3L), Array(-7L, 4L, 6L))
dot(Array(1.5, 2, -3), Array(-7, 4, 6.2))
dot(Array(BigInt(156744), BigInt(53453535), BigInt(-656464646)), Array(BigInt(-4324344), BigInt(455455455), BigInt(445354354)))
```

---

### dotMod
Product by module of two lines.

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#dotMod" | downcase }})

**Sources** 

**Using**
```scala mdoc
dotMod(Array(1007, 2456, -3466), Array(-3347, 4343, 6445), 1000)
```

---
