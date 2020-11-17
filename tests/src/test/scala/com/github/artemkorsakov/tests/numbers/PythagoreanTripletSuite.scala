package com.github.artemkorsakov.tests.numbers

import com.github.artemkorsakov.numbers.PythagoreanTriplet
import com.github.artemkorsakov.numbers.PythagoreanTriplet._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

import scala.collection.mutable.ArrayBuffer

class PythagoreanTripletSuite extends AnyFunSuiteLike {
  test("nextPythagoreanTriplet") {
    primitivePythagoreanTriplet shouldBe PythagoreanTriplet(3, 4, 5)
    val nextTriplet = primitivePythagoreanTriplet.nextPythagoreanTriplet
    nextTriplet shouldBe Seq(
      PythagoreanTriplet(5, 12, 13),
      PythagoreanTriplet(21, 20, 29),
      PythagoreanTriplet(15, 8, 17)
    )
    nextTriplet.flatMap(_.nextPythagoreanTriplet) shouldBe Seq(
      PythagoreanTriplet(7, 24, 25),
      PythagoreanTriplet(55, 48, 73),
      PythagoreanTriplet(45, 28, 53),
      PythagoreanTriplet(39, 80, 89),
      PythagoreanTriplet(119, 120, 169),
      PythagoreanTriplet(77, 36, 85),
      PythagoreanTriplet(33, 56, 65),
      PythagoreanTriplet(65, 72, 97),
      PythagoreanTriplet(35, 12, 37)
    )
  }

  test("pythagoreanTripletsWithGivenSum") {
    pythagoreanTripletsWithGivenSum(1000) shouldBe ArrayBuffer(PythagoreanTriplet(375, 200, 425))
  }
}
