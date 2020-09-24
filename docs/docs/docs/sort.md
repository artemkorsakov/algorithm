---
layout: docs
title: "Sorting"
---

## {{page.title}}

The package ```com.github.artemkorsakov.sort``` contains [sorting algorithms](https://en.wikipedia.org/wiki/Sorting_algorithm). 

You can use the package, for example, like this:
```scala
import com.github.artemkorsakov.sort.Sorting._

val res0 = Array(5, 2, 4, 6, 1, 3)
res0.insertionSort()
// res0: Array[Int] = Array(1, 2, 3, 4, 5, 6)

val res1 = Array(5, 2, 4, 6, 1, 3)
res1.insertionSortReverse()
// res1: Array[Int] = Array(6, 5, 4, 3, 2, 1)

val res2 = Array(5, 2, 4, 6, 1, 3)
res2.selectionSort()
// res2: Array[Int] = Array(1, 2, 3, 4, 5, 6)

val res3 = Array(5, 2, 4, 6, 1, 3)
res3.selectionSortReverse()
// res3: Array[Int] = Array(6, 5, 4, 3, 2, 1)

val res4 = Array(5, 2, 4, 6, 1, 3)
res4.mergeSort()
// res4: Array[Int] = Array(1, 2, 3, 4, 5, 6)
```