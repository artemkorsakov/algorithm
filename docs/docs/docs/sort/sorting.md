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
```scala
import com.github.artemkorsakov.sort.Sorting._

val res0 = Array(5, 2, 4, 6, 1, 3)
res0.insertionSort()
// res0: Array[Int] = Array(1, 2, 3, 4, 5, 6)
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
```scala
import com.github.artemkorsakov.sort.Sorting._

val res1 = Array(5, 2, 4, 6, 1, 3)
res1.insertionSortReverse()
// res1: Array[Int] = Array(6, 5, 4, 3, 2, 1)
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
```scala
import com.github.artemkorsakov.sort.Sorting._

val res2 = Array(5, 2, 4, 6, 1, 3)
res2.selectionSort()
// res2: Array[Int] = Array(1, 2, 3, 4, 5, 6)
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
```scala
import com.github.artemkorsakov.sort.Sorting._

val res3 = Array(5, 2, 4, 6, 1, 3)
res3.selectionSortReverse()
// res3: Array[Int] = Array(6, 5, 4, 3, 2, 1)
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
```scala
import com.github.artemkorsakov.sort.Sorting._

val res4 = Array(5, 2, 4, 6, 1, 3)
res4.mergeSort()
// res4: Array[Int] = Array(1, 2, 3, 4, 5, 6)
```

---