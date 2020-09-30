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
2. Square number - ![formula](http://latex.codecogs.com/svg.latex?%7B%5Cdisplaystyle%20P_%7B4,n%7D=%7Bn%5E2%7D%7D)
3. Pentagonal number - ![formula](http://latex.codecogs.com/svg.latex?%7B%5Cdisplaystyle%20P_%7B5,n%7D=%7B%5Cfrac%20%7B3n%5E%7B2%7D-n%7D%7B2%7D%7D%7D)
4. Hexagonal number - ![formula](http://latex.codecogs.com/svg.latex?%7B%5Cdisplaystyle%20H_%7Bn%7D=n(2n-1)%7D)
5. Heptagonal number - ![formula](http://latex.codecogs.com/svg.latex?%7B%5Cdisplaystyle%20P_%7B7,n%7D=%5Cfrac%7B5n%5E2%20-%203n%7D%7B2%7D%7D)
6. Octagonal number - ![formula](http://latex.codecogs.com/svg.latex?%7B%5Cdisplaystyle%20P_%7B8,n%7D=3n%5E2%20-%202n%7D)

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#figurateNumbers" | downcase }})

**Sources** 
- [Triangular number](https://en.wikipedia.org/wiki/Triangular_number)
- [Square number](https://en.wikipedia.org/wiki/Square_number)
- [Pentagonal number](https://en.wikipedia.org/wiki/Pentagonal_number)
- [Hexagonal number](https://en.wikipedia.org/wiki/Hexagonal_number)
- [Heptagonal number](https://en.wikipedia.org/wiki/Heptagonal_number)
- [Octagonal number](https://en.wikipedia.org/wiki/Octagonal_number)

**Using**
```scala
import com.github.artemkorsakov.numbers.CyclicNumbers._

val res0 = (1 to 5).map(i => i.triangleNumber)
// res0: scala.collection.immutable.IndexedSeq[Long] = Vector(1, 3, 6, 10, 15)

val res1 = (1 to 5).map(i => i.squareNumber)
// res1: scala.collection.immutable.IndexedSeq[Long] = Vector(1, 4, 9, 16, 25)

val res2 = (1 to 5).map(i => i.pentagonalNumber)
// res2: scala.collection.immutable.IndexedSeq[Long] = Vector(1, 5, 12, 22, 35)

val res3 = (1 to 5).map(i => i.hexagonalNumber)
// res3: scala.collection.immutable.IndexedSeq[Long] = Vector(1, 6, 15, 28, 45)

val res4 = (1 to 5).map(i => i.heptagonalNumber)
// res4: scala.collection.immutable.IndexedSeq[Long] = Vector(1, 7, 18, 34, 55)

val res5 = (1 to 5).map(i => i.octagonalNumber)
// res5: scala.collection.immutable.IndexedSeq[Long] = Vector(1, 8, 21, 40, 65)

val res6 = 8256.isTriangle
// res6: Boolean = true

val res7 = 5625.isSquare
// res7: Boolean = true

val res8 = 2882.isPentagonal
// res8: Boolean = true

val res9 = 8128.isHexagonal
// res9: Boolean = true

val res10 = 2512.isHeptagonal
// res10: Boolean = true

val res11 = 1281.isOctagonal
// res11: Boolean = true
```

---
