---
layout: docs
title: "Matrix"
realization_link: ../realization/objects/matrix.html
---

## {{page.title}}
[Matrix](https://en.wikipedia.org/wiki/Matrix_multiplication).

### mul
Product of two lines.

**Algorithm**
1. ![formula](http://latex.codecogs.com/svg.latex?%7Bproduct=a_%7Bi1%7Db_%7B1j%7D&plus;a_%7Bi2%7Db_%7B2j%7D&plus;%5Ccdots%20&plus;a_%7Bin%7Db_%7Bnj%7D=%5Csum%20_%7Bk=1%7D%5E%7Bn%7Da_%7Bik%7Db_%7Bkj%7D%7D)

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#mul" | downcase }})

**Sources** 

**Using**
```scala mdoc
import com.github.artemkorsakov.objects.MatrixLine._
Seq(1L, 2L, -3L).mul(Seq(-7L, 4L, 6L)) 
Seq(1L, 2L, -3L) * Seq(-7L, 4L, 6L) 
```

---

### mulMod
Product by module of two lines.

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#mulMod" | downcase }})

**Sources** 

**Using**
```scala mdoc
Seq(1007, 2456, -3466).mulMod(Seq(-3347, 4343, 6445), 1000)
```

---

### matrixTranspose
[Transpose of a matrix](https://en.wikipedia.org/wiki/Transpose).

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#matrixTranspose" | downcase }})

**Sources** 
- [Transpose](https://en.wikipedia.org/wiki/Transpose)

**Using**
```scala mdoc
import com.github.artemkorsakov.objects.Matrix._
Seq(Seq(1, 2), Seq(3, 4), Seq(5, 6)).matrixTranspose
Seq(Seq(1, 3, 5), Seq(2, 4, 6)).matrixTranspose
Seq(Seq(1, 2), Seq(3, 4), Seq(5, 6)).matrixTranspose.matrixTranspose
```

---

### minorMatrix
New matrix without the given row and the given column.

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#minorMatrix" | downcase }})

**Sources** 

**Using**
```scala mdoc
Seq(Seq(-2, -1, -1, -4), Seq(-1, -2, -1, -6), Seq(-1, -1, 2, 4), Seq(2, 1, -3, -8)).minorMatrix(1, 2)
```

---

### matrixDeterminant
[Determinant of a matrix](https://en.wikipedia.org/wiki/Determinant).

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#matrixDeterminant" | downcase }})

**Sources** 
- [Determinant](https://en.wikipedia.org/wiki/Determinant)

**Using**
```scala mdoc
Seq(Seq(-2, -1, -1, -4), Seq(-1, -2, -1, -6), Seq(-1, -1, 2, 4), Seq(2, 1, -3, -8)).matrixDeterminant
```

---
