package com.github.artemkorsakov.tests.objects

import com.github.artemkorsakov.objects.GenericOperation
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class GenericOperationSuite extends AnyFunSuiteLike {
  test("zeroT") {
    GenericOperation.zeroT(1) shouldBe 0
    GenericOperation.zeroT(1L) shouldBe 0L
    GenericOperation.zeroT(1.0) shouldBe 0.0
    GenericOperation.zeroT(BigInt(1)) shouldBe BigInt(0)
    GenericOperation.zeroT(BigDecimal(1.0)) shouldBe BigDecimal(0.0)
  }

  test("oneT") {
    GenericOperation.oneT(10) shouldBe 1
    GenericOperation.oneT(10L) shouldBe 1L
    GenericOperation.oneT(10.0) shouldBe 1.0
    GenericOperation.oneT(BigInt(10)) shouldBe BigInt(1)
    GenericOperation.oneT(BigDecimal(10.0)) shouldBe BigDecimal(1.0)
  }

  test("addT") {
    GenericOperation.addT(1, 1) shouldBe 2
    GenericOperation.addT(1L, 1L) shouldBe 2L
    GenericOperation.addT(1.1, 1.1) shouldBe 2.2
    GenericOperation.addT(BigInt(1), BigInt(1)) shouldBe BigInt(2)
    GenericOperation.addT(BigDecimal(1.1), BigDecimal(1.1)) shouldBe BigDecimal(2.2)
  }

  test("subT") {
    GenericOperation.subT(2, 1) shouldBe 1
    GenericOperation.subT(2L, 1L) shouldBe 1L
    GenericOperation.subT(2.2, 1.1) shouldBe 1.1
    GenericOperation.subT(BigInt(2), BigInt(1)) shouldBe BigInt(1)
    GenericOperation.subT(BigDecimal(2.2), BigDecimal(1.1)) shouldBe BigDecimal(1.1)
  }

  test("mulT") {
    GenericOperation.mulT(1, 1) shouldBe 1
    GenericOperation.mulT(1L, 1L) shouldBe 1L
    math.abs(GenericOperation.mulT(1.1, 1.1) - 1.21) <= 1e-5 shouldBe true
    GenericOperation.mulT(BigInt(1), BigInt(1)) shouldBe BigInt(1)
    math.abs(
      (GenericOperation.mulT(BigDecimal(1.1), BigDecimal(1.1)) - BigDecimal(1.21)).toDouble
    ) <= 1e-5 shouldBe true
  }

  test("modT") {
    GenericOperation.modT(15, 5) shouldBe 0
    GenericOperation.modT(15L, 6L) shouldBe 3L
    GenericOperation.modT(1.1, 1.1) shouldBe 0.0
    GenericOperation.modT(BigInt(15), BigInt(5)) shouldBe BigInt(0)
    GenericOperation.modT(BigDecimal(1.1), BigDecimal(1.1)) shouldBe BigDecimal(0.0)
  }

}
