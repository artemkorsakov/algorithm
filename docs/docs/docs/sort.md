---
layout: docs
title: "Sorting"
---

## {{page.title}}

The package ```com.github.artemkorsakov.sort``` contains [sorting algorithms](https://en.wikipedia.org/wiki/Sorting_algorithm). 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.sort.Sorting._
{
  val array = Array(5, 2, 4, 6, 1, 3)
  insertionSort(array)
  array
}
{
  val array = Array(5, 2, 4, 6, 1, 3)
  insertionSortReverse(array)
  array
}
{
  val array = Array(5, 2, 4, 6, 1, 3)
  selectionSort(array)
  array
}
{
  val array = Array(5, 2, 4, 6, 1, 3)
  selectionSortReverse(array)
  array
}
{
  val array = Array(5, 2, 4, 6, 1, 3)
  mergeSort(array)
  array
}
```