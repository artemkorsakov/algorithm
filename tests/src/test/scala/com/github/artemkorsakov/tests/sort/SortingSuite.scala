package com.github.artemkorsakov.tests.sort

import com.github.artemkorsakov.sort.Sorting._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class SortingSuite extends AnyFunSuiteLike {
  test("insertionSort") {
    val array = Array(5, 2, 4, 6, 1, 3)
    array.insertionSort()
    array shouldBe Array(1, 2, 3, 4, 5, 6)
    array.insertionSortReverse()
    array shouldBe Array(6, 5, 4, 3, 2, 1)
  }

  test("selectionSort") {
    val array = Array(5, 2, 4, 6, 1, 3)
    array.selectionSort()
    array shouldBe Array(1, 2, 3, 4, 5, 6)
    array.selectionSortReverse()
    array shouldBe Array(6, 5, 4, 3, 2, 1)
  }

  test("mergeSort") {
    val array = Array(5, 2, 4, 6, 1, 3)
    array.mergeSort()
    array shouldBe Array(1, 2, 3, 4, 5, 6)
  }
}
