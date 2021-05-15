package com.github.artemkorsakov.sort

object Sorting {

  /** Insertion sort algorithm.
    *
    * @see <a href="https://en.wikipedia.org/wiki/Insertion_sort">Insertion sort</a>
    * О(n<sup>2</sup>) comparisons and swaps
    */
  def insertionSort(array: Array[Int]): Unit =
    for (j <- 1 until array.length) {
      val key = array(j)
      var i   = j - 1
      while (i >= 0 && array(i) > key) {
        array(i + 1) = array(i)
        i -= 1
      }
      array(i + 1) = key
    }

  /** Reverse insertion sort algorithm.
    *
    * @see <a href="https://en.wikipedia.org/wiki/Insertion_sort">Insertion sort</a>
    * О(n<sup>2</sup>) comparisons and swaps
    */
  def insertionSortReverse(array: Array[Int]): Unit =
    for (j <- 1 until array.length) {
      val key = array(j)
      var i   = j - 1
      while (i >= 0 && array(i) < key) {
        array(i + 1) = array(i)
        i -= 1
      }
      array(i + 1) = key
    }

  /** Selection sort algorithm.
    *
    * @see <a href="https://en.wikipedia.org/wiki/Selection_sort">Selection sort</a>
    * О(n<sup>2</sup>) comparisons, О(n) swaps
    */
  def selectionSort(array: Array[Int]): Unit =
    for (i <- 0 until array.length - 1) {
      var jMin = i
      for (j <- i + 1 until array.length)
        if (array(j) < array(jMin)) {
          jMin = j
        }
      swap(array, i, jMin)
    }

  /** Reverse selection sort algorithm.
    *
    * @see <a href="https://en.wikipedia.org/wiki/Selection_sort">Selection sort</a>
    * О(n<sup>2</sup>) comparisons, О(n) swaps
    */
  def selectionSortReverse(array: Array[Int]): Unit =
    for (i <- 0 until array.length - 1) {
      var jMax = i
      for (j <- i + 1 until array.length)
        if (array(j) > array(jMax)) {
          jMax = j
        }
      swap(array, i, jMax)
    }

  /** Merge sort.
    *
    * @see <a href="https://en.wikipedia.org/wiki/Merge_sort">Merge sort</a>
    * О(n<sup>2</sup>) comparisons, О(n) swaps
    */
  def mergeSort(array: Array[Int]): Unit =
    mergeSort(array, 0, array.length - 1)

  private def swap(array: Array[Int], i: Int, j: Int): Unit =
    if (j != i) {
      val temp = array(j)
      array(j) = array(i)
      array(i) = temp
    }

  private def mergeSort(array: Array[Int], first: Int, last: Int): Unit =
    if (last > first) {
      val mid = first + (last - first) / 2
      mergeSort(array, first, mid)
      mergeSort(array, mid + 1, last)

      val buf = new Array[Int](array.length)
      array.copyToArray(buf)
      if (last + 1 - first >= 0) {
        System.arraycopy(array, first, buf, first, last + 1 - first)
      }

      var i = first
      var j = mid + 1
      for (k <- first to last)
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
