package com.github.artemkorsakov.tests.numbers

import com.github.artemkorsakov.numbers.ComplexNumber
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class ComplexNumberSuite extends AnyFunSuiteLike {
  test("add, sub, mul") {
    ComplexNumber(2, 3).add(ComplexNumber(1, 4)) shouldBe ComplexNumber(3.0, 7.0)
    ComplexNumber(2, 3) + ComplexNumber(1, 4) shouldBe ComplexNumber(3.0, 7.0)
    ComplexNumber(2, 3).sub(ComplexNumber(1, 4)) shouldBe ComplexNumber(1.0, -1.0)
    ComplexNumber(2, 3) - ComplexNumber(1, 4) shouldBe ComplexNumber(1.0, -1.0)
    ComplexNumber(2, 3).mul(ComplexNumber(1, 4)) shouldBe ComplexNumber(-10.0, 11.0)
    ComplexNumber(2, 3) * ComplexNumber(1, 4) shouldBe ComplexNumber(-10.0, 11.0)
  }

  test("div") {
    var complexNumber = ComplexNumber(2, 3).div(ComplexNumber(1, 4))
    assert(complexNumber.a === 14.0 / 17.0 +- 0.01)
    assert(complexNumber.b === -5.0 / 17.0 +- 0.01)

    complexNumber = ComplexNumber(2, 3) / ComplexNumber(1, 4)
    assert(complexNumber.a === 14.0 / 17.0 +- 0.01)
    assert(complexNumber.b === -5.0 / 17.0 +- 0.01)

    complexNumber = (ComplexNumber(1, 1) * ComplexNumber(2, 1) * ComplexNumber(3, 1)) / ComplexNumber(1, -1)
    assert(complexNumber.a === -5.0 +- 0.01)
    assert(complexNumber.b === 5.0 +- 0.01)

    complexNumber = ComplexNumber(1, 1) / ComplexNumber(1, -1)
    assert(complexNumber.a === 0.0 +- 0.01)
    assert(complexNumber.b === 1.0 +- 0.01)

    complexNumber = ComplexNumber(1, 1) / ComplexNumber(2, -1)
    assert(complexNumber.a === 1.0 / 5.0 +- 0.01)
    assert(complexNumber.b === 3.0 / 5.0 +- 0.01)

    complexNumber = ComplexNumber(1, 0) / ComplexNumber(0, 1)
    assert(complexNumber.a === 0.0 +- 0.01)
    assert(complexNumber.b === -1.0 +- 0.01)

    complexNumber = (ComplexNumber(1, 0) / ComplexNumber(-2, 1)) / ComplexNumber(1, -3)
    assert(complexNumber.a === 1.0 / 50.0 +- 0.01)
    assert(complexNumber.b === -7.0 / 50.0 +- 0.01)
  }

  test("abs") {
    ComplexNumber(5, 6).abs shouldBe ComplexNumber(5.0, 6.0)
    ComplexNumber(-5, 6).abs shouldBe ComplexNumber(5.0, 6.0)
    ComplexNumber(5, -6).abs shouldBe ComplexNumber(5.0, 6.0)
    ComplexNumber(-5, -6).abs shouldBe ComplexNumber(5.0, 6.0)
  }

  test("conjugate") {
    ComplexNumber(5, 6).conjugate shouldBe ComplexNumber(5.0, -6.0)
    ComplexNumber(5, 6).conjugate.conjugate shouldBe ComplexNumber(5.0, 6.0)
  }

  test("productWithConjugate") {
    ComplexNumber(5.0, 12.0).productWithConjugate shouldBe 169.0
  }

  test("sqrt") {
    val roots = ComplexNumber(5.0, 12.0).sqrt
    assert(roots.length === 2)
    assert(roots.head.a === 3.0 +- 0.01)
    assert(roots.head.b === 2.0 +- 0.01)
    assert(roots.last.a === 3.0 +- 0.01)
    assert(roots.last.b === -2.0 +- 0.01)
  }

  test("power2") {
    var complexNumber = ComplexNumber(5.0, 3.0).power2
    assert(complexNumber.a === 16.0 +- 0.01)
    assert(complexNumber.b === 30.0 +- 0.01)

    complexNumber = complexNumber.power2
    assert(complexNumber.a === -644.0 +- 0.01)
    assert(complexNumber.b === 960.0 +- 0.01)

    complexNumber = complexNumber.power2
    assert(complexNumber.a === -506864.0 +- 0.01)
    assert(complexNumber.b === -1236480.0 +- 0.01)

    complexNumber = ComplexNumber(-0.5, Math.sqrt(3.0) / 2.0).power2
    assert(complexNumber.a === -0.5 +- 0.01)
    assert(complexNumber.b === -math.sqrt(3.0) / 2.0 +- 0.01)
  }

  test("power") {
    var complexNumber = ComplexNumber(5.0, 3.0).power(8)
    assert(complexNumber.a === -506864.0 +- 0.01)
    assert(complexNumber.b === -1236480.0 +- 0.01)

    complexNumber = ComplexNumber(-1.0 / 2.0, Math.sqrt(3.0) / 2.0).power(3)
    assert(complexNumber.a === 1.0 +- 0.01)
    assert(complexNumber.b === 0.0 +- 0.01)
  }
}
