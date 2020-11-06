---
layout: docsplus
title: "Cyclic numbers"
realization: numbers/CyclicNumbers.scala
---

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
     
**Sources** 
- [Triangular number](https://en.wikipedia.org/wiki/Triangular_number)
- [Square number](https://en.wikipedia.org/wiki/Square_number)
- [Pentagonal number](https://en.wikipedia.org/wiki/Pentagonal_number)
- [Hexagonal number](https://en.wikipedia.org/wiki/Hexagonal_number)
- [Heptagonal number](https://en.wikipedia.org/wiki/Heptagonal_number)
- [Octagonal number](https://en.wikipedia.org/wiki/Octagonal_number)

**Using**
```scala mdoc
import com.github.artemkorsakov.numbers.CyclicNumbers._
(1 to 5).map(i => i.triangleNumber)
(1 to 5).map(i => i.squareNumber)
(1 to 5).map(i => i.pentagonalNumber)
(1 to 5).map(i => i.hexagonalNumber)
(1 to 5).map(i => i.heptagonalNumber)
(1 to 5).map(i => i.octagonalNumber)
8256.isTriangle
5625.isSquare
2882.isPentagonal
8128.isHexagonal
2512.isHeptagonal
1281.isOctagonal
```

---
