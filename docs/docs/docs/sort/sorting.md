---
layout: docs
title: "Sorting Algorithms"
realization_link: ../realization/sort/sorting.html
---

## {{page.title}}

[Sorting algorithms](https://en.wikipedia.org/wiki/Sorting_algorithm)

### insertionSort
[Insertion sort](https://en.wikipedia.org/wiki/Insertion_sort).

**Algorithm**

**Complexity** _O_(n<sup>2</sup>)
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#insertionSort" | downcase }})

**Sources** 
- [Insertion sort](https://en.wikipedia.org/wiki/Insertion_sort)

**Using**
```scala mdoc
import com.github.artemkorsakov.sort.Sorting._
{
  val array = Array(5, 2, 4, 6, 1, 3)
  array.insertionSort()
  array
}
```

---

### insertionSortReverse
[Insertion sort](https://en.wikipedia.org/wiki/Insertion_sort).

**Algorithm**

**Complexity** _O_(n<sup>2</sup>)
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#insertionSortReverse" | downcase }})

**Sources** 
- [Insertion sort](https://en.wikipedia.org/wiki/Insertion_sort)

**Using**
```scala mdoc
{
  val array = Array(5, 2, 4, 6, 1, 3)
  array.insertionSortReverse()
  array
}
```

---

### selectionSort
[Selection sort](https://en.wikipedia.org/wiki/Selection_sort).

**Algorithm**

**Complexity** _О_(n<sup>2</sup>) comparisons, _О_(n) swaps
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#selectionSort" | downcase }})

**Sources** 
- [Selection sort](https://en.wikipedia.org/wiki/Selection_sort)

**Using**
```scala mdoc
{
  val array = Array(5, 2, 4, 6, 1, 3)
  array.selectionSort()
  array
}
```

---

### selectionSortReverse
[Selection sort](https://en.wikipedia.org/wiki/Selection_sort).

**Algorithm**

**Complexity** _О_(n<sup>2</sup>) comparisons, _О_(n) swaps
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#selectionSortReverse" | downcase }})

**Sources** 
- [Selection sort](https://en.wikipedia.org/wiki/Selection_sort)

**Using**
```scala mdoc
{
  val array = Array(5, 2, 4, 6, 1, 3)
  array.selectionSortReverse()
  array
}
```

---

### mergeSort
[Merge sort](https://en.wikipedia.org/wiki/Merge_sort).

**Algorithm**

**Complexity** _О_(n<sup>2</sup>) comparisons, _О_(n) swaps
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#mergeSort" | downcase }})

**Sources** 
- [Merge sort](https://en.wikipedia.org/wiki/Merge_sort)

**Using**
```scala mdoc
{
  val array = Array(5, 2, 4, 6, 1, 3)
  array.mergeSort()
  array
}
```

---