package com.github.artemkorsakov.tests.objects

import com.github.artemkorsakov.objects.Triangle
import com.github.artemkorsakov.objects.Triangle._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class TriangleSuite extends AnyFunSuiteLike {
  test("getPointOnTriangleType") {
    Triangle((-340, 495), (-153, -910), (835, -947)).getPointOnTriangleType(
      (0, 0)
    ) shouldBe Inside
    Triangle((-175, 41), (-421, -714), (574, -645)).getPointOnTriangleType(
      (0, 0)
    ) shouldBe Outside
    Triangle((-175, 41), (-421, -714), (574, -645)).getPointOnTriangleType(
      (-175, 41)
    ) shouldBe OnTheSide
  }

  test("isZeroPointInside") {
    Triangle((-340, 495), (-153, -910), (835, -947)).isZeroPointInside shouldBe true
    Triangle((-175, 41), (-421, -714), (574, -645)).isZeroPointInside shouldBe false
  }
}
