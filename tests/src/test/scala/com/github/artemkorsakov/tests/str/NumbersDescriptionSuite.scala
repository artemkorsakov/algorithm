package com.github.artemkorsakov.tests.str

import cats.implicits._
import com.github.artemkorsakov.str.NumbersDescription._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class NumbersDescriptionSuite extends AnyFunSuiteLike {
  test("inEnglish") {
    (-1).inEnglish shouldBe None
    1000000000000000L.inEnglish shouldBe None
    11.inEnglish shouldBe "eleven".some
    32.inEnglish shouldBe "thirty-two".some
    111.inEnglish shouldBe "one hundred and eleven".some
    115.inEnglish shouldBe "one hundred and fifteen".some
    342.inEnglish shouldBe "three hundred and forty-two".some
    500.inEnglish shouldBe "five hundred".some
    5000.inEnglish shouldBe "five thousand".some
    1435.inEnglish shouldBe "one thousand four hundred and thirty-five".some
    999999.inEnglish shouldBe "nine hundred and ninety-nine thousand nine hundred and ninety-nine".some
    999999999999999L.inEnglish shouldBe "nine hundred and ninety-nine trillion nine hundred and ninety-nine billion nine hundred and ninety-nine million nine hundred and ninety-nine thousand nine hundred and ninety-nine".some
  }
}
