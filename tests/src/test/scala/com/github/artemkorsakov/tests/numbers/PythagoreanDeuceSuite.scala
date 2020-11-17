package com.github.artemkorsakov.tests.numbers

import com.github.artemkorsakov.numbers.PythagoreanDeuce._
import com.github.artemkorsakov.numbers.PythagoreanTriplet
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class PythagoreanDeuceSuite extends AnyFunSuiteLike {
  test("nextPythagoreanDeuce") {
    primitivePythagoreanDeuce.triplet shouldBe PythagoreanTriplet(3, 4, 5)
    val nextDeuces = primitivePythagoreanDeuce.nextPythagoreanDeuce
    nextDeuces.map(_.triplet) shouldBe Seq(
      PythagoreanTriplet(5, 12, 13),
      PythagoreanTriplet(21, 20, 29),
      PythagoreanTriplet(15, 8, 17)
    )
    nextDeuces.flatMap(_.nextPythagoreanDeuce.map(_.triplet)) shouldBe Seq(
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
}
