---
layout: docs
title: "Common operations"
realization_link: ../realization/operations/common_operations.html
---

## {{page.title}}

Common simple operations.

### sumToGiven
The sum of the n first numbers.

**Algorithm**
1. ![formula](http://latex.codecogs.com/svg.latex?%7B%5Cdisplaystyle%20%5Csum%20_%7Bk=1%7D%5E%7Bn%7Dk=%7B%5Cfrac%20%7Bn(n&plus;1)%7D%7B2%7D%7D.%7D)

**Complexity** _O_(1)
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#sumToGiven" | downcase }})

**Sources** 
- [Sum](https://en.wikipedia.org/wiki/1_%2B_2_%2B_3_%2B_4_%2B_%E2%8B%AF)

**Using**
```scala
import com.github.artemkorsakov.operations.CommonOperations._

val res0 = sumToGiven(1000000)
// res0: Long = 500000500000
```

---

### sumOfSquaresTo
The sum of the n first square numbers.

**Algorithm**
1. ![formula](http://latex.codecogs.com/svg.latex?%7B%5Cdisplaystyle%20%5Csum%20_%7Bn=0%7D%5E%7BN%7Dn%5E%7B2%7D=0%5E%7B2%7D&plus;1%5E%7B2%7D&plus;2%5E%7B2%7D&plus;3%5E%7B2%7D&plus;4%5E%7B2%7D&plus;%5Ccdots%20&plus;N%5E%7B2%7D=%7B%5Cfrac%20%7BN(N&plus;1)(2N&plus;1)%7D%7B6%7D%7D.%7D)

**Complexity** _O_(1)
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#sumOfSquaresTo" | downcase }})

**Sources** 
- [Square number](https://en.wikipedia.org/wiki/Square_number)

**Using**
```scala
import com.github.artemkorsakov.operations.CommonOperations._

val res1 = sumOfSquaresTo(1000)
// res1: Long = 333833500
```

---

### sumOfCubesTo
The sum of the n first cubes numbers.

**Algorithm**
1. ![formula](http://latex.codecogs.com/svg.latex?1%5E%7B3%7D&plus;2%5E%7B3%7D&plus;%5Cdots%20&plus;n%5E%7B3%7D=(1&plus;2&plus;%5Cdots%20&plus;n)%5E%7B2%7D=%5Cleft(%7B%5Cfrac%20%7Bn(n&plus;1)%7D%7B2%7D%7D%5Cright)%5E%7B2%7D.)

**Complexity** _O_(1)
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#sumOfCubesTo" | downcase }})

**Sources** 
- [Cube](https://en.wikipedia.org/wiki/Cube_(algebra))

**Using**
```scala
import com.github.artemkorsakov.operations.CommonOperations._

val res2 = sumOfCubesTo(1000)
// res2: Long = 250500250000
```

---

### sqrt
A square root of a number x.

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#sqrt" | downcase }})

**Sources** 
- [Square root](https://en.wikipedia.org/wiki/Square_root)

**Using**
```scala
import com.github.artemkorsakov.operations.CommonOperations._

val res3 = 1000.sqrt
// res3: Double = 31.622776601684336
```

---

### isSquare
Is a number a square?

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#isSquare" | downcase }})

**Sources** 

**Using**
```scala
import com.github.artemkorsakov.operations.CommonOperations._

val res4 = 36.isSquare
// res4: Boolean = true
```

---

### allSquares
All square numbers the number of digits in which is equal to the given.

All square numbers from start (inclusive) to finish (inclusive).

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#allSquares" | downcase }})

**Sources** 

**Using**
```scala
import com.github.artemkorsakov.operations.CommonOperations._

val res5 = allSquares(2)
// res5: List[Int] = List(16, 25, 36, 49, 64, 81)

val res6 = allSquares(1024, 1444)
// res6: List[Int] = List(1024, 1089, 1156, 1225, 1296, 1369, 1444)
```

---

### allNumbersVariants
Returns a list of unique lists containing given numbers without repetition.

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#allNumbersVariants" | downcase }})

**Sources** 

**Using**
```scala
import com.github.artemkorsakov.operations.CommonOperations._

val res7 = allNumbersVariants(Set(2, 3, 5))
// res7: Set[Set[Int]] = Set(Set(2), Set(3, 2), Set(5), Set(3), Set(5, 3, 2), Set(5, 3), Set(5, 2))
```

---
