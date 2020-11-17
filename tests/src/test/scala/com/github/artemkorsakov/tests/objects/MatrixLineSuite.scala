package com.github.artemkorsakov.tests.objects

import com.github.artemkorsakov.objects.Matrix._
import com.github.artemkorsakov.objects.MatrixLine._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class MatrixLineSuite extends AnyFunSuiteLike {
  test("mul") {
    Seq(1, 2, -3).mul(Seq(-7, 4, 6)) shouldBe Some(-17)
    Seq(1, 2, -3) * Seq(-7, 4, 6) shouldBe Some(-17)
    Seq(1L, 2L, -3L).mul(Seq(-7L, 4L, 6L)) shouldBe Some(-17L)
    Seq(1L, 2L, -3L) * Seq(-7L, 4L, 6L) shouldBe Some(-17L)
    Seq(1.5, 2, -3).mul(Seq(-7, 4, 6.2)) shouldBe Some(-21.1)
    Seq(1.5, 2, -3) * Seq(-7, 4, 6.2) shouldBe Some(-21.1)
    Seq(BigInt(156744), BigInt(53453535), BigInt(-656464646))
      .mul(Seq(BigInt(-4324344), BigInt(455455455), BigInt(445354354))) shouldBe Some(BigInt(-268014362053361195L))
    Seq(BigInt(156744), BigInt(53453535), BigInt(-656464646)) * Seq(
      BigInt(-4324344),
      BigInt(455455455),
      BigInt(445354354)
    ) shouldBe Some(BigInt(-268014362053361195L))
  }

  test("mulMod") {
    Seq(1007, 2456, -3466).mulMod(Seq(-3347, 4343, 6445), 1000) shouldBe Some(609)
    Seq(1007L, 2456L, -3466L).mulMod(Seq(-3347L, 4343L, 6445L), 1000L) shouldBe Some(609L)
    Seq(1007.0, 2456.0, -3466.0).mulMod(Seq(-3347.0, 4343.0, 6445.0), 1000.0) shouldBe Some(609.0)
    Seq(BigInt(1007), BigInt(2456), BigInt(-3466))
      .mulMod(Seq(BigInt(-3347), BigInt(4343), BigInt(6445)), BigInt(1000)) shouldBe Some(BigInt(609))
  }

  test("toMatrix") {
    Seq(1007, 2456, -3466).toMatrix shouldBe seq2Matrix(Seq(Seq(1007, 2456, -3466)))
  }

  test("matrix multiplication by row") {
    val matrixA = Seq(1, -3, 6)
    val matrixB = Seq(Seq(3, 4, 2, 5), Seq(0, -1, 3, 2), Seq(1, 2, 3, 0))
    val matrixC = Seq(9, 19, 11, -1)
    matrixA.mul(matrixB) shouldBe Some(matrixC)
    matrixA * matrixB shouldBe Some(matrixC)
    matrixA.mulMod(matrixB, 7) shouldBe Some(Seq(2, 5, 4, 6))
  }
}
