---
layout: docs
title: "Matrix"
realization_link: ../realization/objects/matrix.html
---

## {{page.title}}
[Matrix](https://en.wikipedia.org/wiki/Matrix_multiplication).

### mulRows
Product of two lines.

**Algorithm**
1. ![formula](http://latex.codecogs.com/svg.latex?%7Bproduct=a_%7Bi1%7Db_%7B1j%7D&plus;a_%7Bi2%7Db_%7B2j%7D&plus;%5Ccdots%20&plus;a_%7Bin%7Db_%7Bnj%7D=%5Csum%20_%7Bk=1%7D%5E%7Bn%7Da_%7Bik%7Db_%7Bkj%7D%7D)

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#mulRows" | downcase }})

**Sources** 

**Using**
```scala mdoc
import com.github.artemkorsakov.objects.MatrixLine._
Seq(1L, 2L, -3L).mul(Seq(-7L, 4L, 6L)) 
Seq(1L, 2L, -3L) * Seq(-7L, 4L, 6L) 
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

### add
Addition of two matrices.

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#add" | downcase }})

**Sources** 

**Using**
```scala mdoc
val matrixA = Seq(Seq(-2, -1, -1, -4), Seq(-1, -2, -1, -6), Seq(-1, -1, 2, 4), Seq(2, 1, -3, -8))
val matrixB = Seq(Seq(8, -5, -6, -4), Seq(-13, -22, -11, -65), Seq(45, 45, 34, 35), Seq(23, 12, -33, -82))
matrixA.add(matrixB)
matrixA + matrixB
```

---

### mulByNum
Matrix multiplication by number.

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#mulByNum" | downcase }})

**Sources** 

**Using**
```scala mdoc
Seq(Seq(-2, -1, -1, -4), Seq(-1, -2, -1, -6), Seq(-1, -1, 2, 4), Seq(2, 1, -3, -8)).mul(7)
Seq(Seq(-2, -1, -1, -4), Seq(-1, -2, -1, -6), Seq(-1, -1, 2, 4), Seq(2, 1, -3, -8)) * 8
Seq(Seq(-2, -1, -1, -4), Seq(-1, -2, -1, -6), Seq(-1, -1, 2, 4), Seq(2, 1, -3, -8)).mulMod(10, 11)
```

---

### mulMatrix
Matrix multiplication.

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#mulMatrix" | downcase }})

**Sources** 

**Using**
```scala mdoc
Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0)).mul(Seq(Seq(1, 2, 3), Seq(-3, 5, 4), Seq(6, 2, 1), Seq(1, -1, 0)))
Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0)) * Seq(Seq(1, 2, 3), Seq(-3, 5, 4), Seq(6, 2, 1), Seq(1, -1, 0))
Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0)).mulMod(Seq(Seq(1, 2, 3), Seq(-3, 5, 4), Seq(6, 2, 1), Seq(1, -1, 0)), 7)
```

---

### mulMatrixByRow
Matrix multiplication by row.

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#mulMatrixByRow" | downcase }})

**Sources** 

**Using**
```scala mdoc
Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0)).mul(Seq(1, -3, 6, 1))
Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0)) * Seq(1, -3, 6, 1)
Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0)).mulMod(Seq(1, -3, 6, 1), 7)
Seq(1, -3, 6).mul(Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0)))
Seq(1, -3, 6) * Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0))
Seq(1, -3, 6).mulMod(Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0)), 7)
```

---

### power
Matrix exponentiation.

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#power" | downcase }})

**Sources** 

**Using**
```scala mdoc
Seq(Seq(2, 0), Seq(-1, 3)).power(2)
val fibonacciMatrix = Seq(Seq(1, 1), Seq(1, 0))
fibonacciMatrix.power(20)
Seq(Seq(1, 2, 1, 0), Seq(1, 1, 0, -1), Seq(-2, 0, 1, 2), Seq(0, 2, 1, 1)).power(100)
fibonacciMatrix.powerMod(50, 1000000)
```

---
