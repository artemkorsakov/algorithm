package com.github.artemkorsakov.tests.objects

import com.github.artemkorsakov.objects.Default
import com.github.artemkorsakov.objects.Default._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

import scala.collection.immutable

class DefaultSuite extends AnyFunSuiteLike {
  test("Default.value") {
    Default.value[Double] shouldBe 0.0
    Default.value[Float] shouldBe 0.0f
    Default.value[Int] shouldBe 0
    Default.value[Long] shouldBe 0L
    Default.value[Short] shouldBe 0
    Default.value[Byte] shouldBe 0
    Default.value[Char] shouldBe '\u0000'
    Default.value[Boolean] shouldBe false
    Default.value[BigInt] shouldBe BigInt(0)
    Default.value[BigDecimal] shouldBe BigDecimal(0.0)
    Default.value[immutable.Seq[Int]] shouldBe immutable.Seq()
    Default.value[Set[Int]] shouldBe Set()
    Default.value[Map[Int, String]] shouldBe Map[Int, String]()
    Default.value[Option[Int]] shouldBe None
  }
}
