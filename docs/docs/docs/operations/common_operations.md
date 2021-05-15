---
layout: docsplus
title: "Common operations"
realization: operations/CommonOperations.scala
---

Common simple operations.

### sumToGiven
The sum of the n first numbers.

**Algorithm**
1. ![formula](http://latex.codecogs.com/svg.latex?%7B%5Cdisplaystyle%20%5Csum%20_%7Bk=1%7D%5E%7Bn%7Dk=%7B%5Cfrac%20%7Bn(n&plus;1)%7D%7B2%7D%7D.%7D)

**Complexity** _O_(1)
     
**Sources** 
- [Sum](https://en.wikipedia.org/wiki/1_%2B_2_%2B_3_%2B_4_%2B_%E2%8B%AF)

**Using**
```scala mdoc
import com.github.artemkorsakov.operations.CommonOperations._
sumToGiven(1000000)
```

---

### sumOfSquaresTo
The sum of the n first square numbers.

**Algorithm**
1. ![formula](http://latex.codecogs.com/svg.latex?%7B%5Cdisplaystyle%20%5Csum%20_%7Bn=0%7D%5E%7BN%7Dn%5E%7B2%7D=0%5E%7B2%7D&plus;1%5E%7B2%7D&plus;2%5E%7B2%7D&plus;3%5E%7B2%7D&plus;4%5E%7B2%7D&plus;%5Ccdots%20&plus;N%5E%7B2%7D=%7B%5Cfrac%20%7BN(N&plus;1)(2N&plus;1)%7D%7B6%7D%7D.%7D)

**Complexity** _O_(1)
     
**Sources** 
- [Square number](https://en.wikipedia.org/wiki/Square_number)

**Using**
```scala mdoc
sumOfSquaresTo(1000)
```

---

### sumOfCubesTo
The sum of the n first cubes numbers.

**Algorithm**
1. ![formula](http://latex.codecogs.com/svg.latex?1%5E%7B3%7D&plus;2%5E%7B3%7D&plus;%5Cdots%20&plus;n%5E%7B3%7D=(1&plus;2&plus;%5Cdots%20&plus;n)%5E%7B2%7D=%5Cleft(%7B%5Cfrac%20%7Bn(n&plus;1)%7D%7B2%7D%7D%5Cright)%5E%7B2%7D.)

**Complexity** _O_(1)
     
**Sources** 
- [Cube](https://en.wikipedia.org/wiki/Cube_(algebra))

**Using**
```scala mdoc
sumOfCubesTo(1000)
```

---

### sqrt
A square root of a number x.

**Algorithm**

**Complexity**
     
**Sources** 
- [Square root](https://en.wikipedia.org/wiki/Square_root)

**Using**
```scala mdoc
sqrt(1000)
```

---

### isSquare
Is a number a square?

**Algorithm**

**Complexity**
     
**Sources** 

**Using**
```scala mdoc
isSquare(36)
```

---

### allSquares
All square numbers the number of digits in which is equal to the given.

All square numbers from start (inclusive) to finish (inclusive).

**Algorithm**

**Complexity**
     
**Sources** 

**Using**
```scala mdoc
allSquares(2)
allSquares(1024, 1444)
```

---

### allNumbersVariants
Returns a list of unique lists containing given numbers without repetition.

**Algorithm**

**Complexity**
     
**Sources** 

**Using**
```scala mdoc
allNumbersVariants(Set(2, 3, 5))
```

---
