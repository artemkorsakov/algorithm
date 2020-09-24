---
layout: docs
title: "Realization: Sorting Algorithms"
parent_link: ../../sort/sorting.html
---

## {{page.title}}

Realizations for [Sorting Algorithms]({{ page.parent_link }}).

### insertionSort

[Algorithm]({{ page.parent_link }}{{ "#insertionSort" | downcase }})

**Realization**
```scala
class Sorting(array: Array[Int]) {
  def insertionSort(): Unit =
    for (j <- 1 until array.length) {
      val key = array(j)
      var i   = j - 1
      while (i >= 0 && array(i) > key) {
        array(i + 1) = array(i)
        i -= 1
      }
      array(i + 1) = key
    }
}
```

---

### insertionSortReverse

[Algorithm]({{ page.parent_link }}{{ "#insertionSortReverse" | downcase }})

**Realization**
```scala
class Sorting(array: Array[Int]) {
  def insertionSortReverse(): Unit =
    for (j <- 1 until array.length) {
      val key = array(j)
      var i   = j - 1
      while (i >= 0 && array(i) < key) {
        array(i + 1) = array(i)
        i -= 1
      }
      array(i + 1) = key
    }
}
```

---

### selectionSort

[Algorithm]({{ page.parent_link }}{{ "#selectionSort" | downcase }})

**Realization**
```scala
class Sorting(array: Array[Int]) {
  def selectionSort(): Unit =
    for (i <- 0 until array.length - 1) {
      var jMin = i
      for (j <- i + 1 until array.length) {
        if (array(j) < array(jMin)) {
          jMin = j
        }
      }
      swap(i, jMin)
    }

  private def swap(i: Int, j: Int): Unit =
    if (j != i) {
      val temp = array(j)
      array(j) = array(i)
      array(i) = temp
    }
}
```

---

### selectionSortReverse

[Algorithm]({{ page.parent_link }}{{ "#selectionSortReverse" | downcase }})

**Realization**
```scala
class Sorting(array: Array[Int]) {
  def selectionSortReverse(): Unit =
    for (i <- 0 until array.length - 1) {
      var jMax = i
      for (j <- i + 1 until array.length) {
        if (array(j) > array(jMax)) {
          jMax = j
        }
      }
      swap(i, jMax)
    }

  private def swap(i: Int, j: Int): Unit =
    if (j != i) {
      val temp = array(j)
      array(j) = array(i)
      array(i) = temp
    }
}
```

---

### mergeSort

[Algorithm]({{ page.parent_link }}{{ "#mergeSort" | downcase }})

**Realization**
```scala
class Sorting(array: Array[Int]) {
  def mergeSort(): Unit =
    mergeSort(0, array.length - 1)

  private def mergeSort(first: Int, last: Int): Unit =
    if (last > first) {
      val mid = first + (last - first) / 2
      mergeSort(first, mid)
      mergeSort(mid + 1, last)

      val buf = new Array[Int](array.length)
      array.copyToArray(buf)
      if (last + 1 - first >= 0) {
        System.arraycopy(array, first, buf, first, last + 1 - first)
      }

      var i = first
      var j = mid + 1
      for (k <- first to last) {
        if (i > mid) {
          array(k) = buf(j)
          j += 1
        } else if (j > last) {
          array(k) = buf(i)
          i += 1
        } else if (buf(j) < buf(i)) {
          array(k) = buf(j)
          j += 1
        } else {
          array(k) = buf(i)
          i += 1
        }
      }
    }
}
```

---
