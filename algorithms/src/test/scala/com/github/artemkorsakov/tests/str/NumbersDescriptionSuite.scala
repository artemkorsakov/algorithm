package com.github.artemkorsakov.tests.str

import cats.implicits._
import com.github.artemkorsakov.str.NumbersDescription._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class NumbersDescriptionSuite extends AnyFunSuiteLike {
  test("inEnglish") {
    inEnglish(-1) shouldBe None
    inEnglish(1000000000000000L) shouldBe None
    inEnglish(11) shouldBe "eleven".some
    inEnglish(32) shouldBe "thirty-two".some
    inEnglish(111) shouldBe "one hundred and eleven".some
    inEnglish(115) shouldBe "one hundred and fifteen".some
    inEnglish(342) shouldBe "three hundred and forty-two".some
    inEnglish(500) shouldBe "five hundred".some
    inEnglish(5000) shouldBe "five thousand".some
    inEnglish(1435) shouldBe "one thousand four hundred and thirty-five".some
    inEnglish(999999) shouldBe "nine hundred and ninety-nine thousand nine hundred and ninety-nine".some
    inEnglish(
      999999999999999L
    ) shouldBe ("nine hundred and ninety-nine trillion nine hundred and ninety-nine billion nine hundred and " +
    "ninety-nine million nine hundred and ninety-nine thousand nine hundred and ninety-nine").some
  }

  test("inRussian") {
    inRussian(-1) shouldBe None
    inRussian(1000000000000000L) shouldBe None
    inRussian(1) shouldBe "один".some
    inRussian(2) shouldBe "два".some
    inRussian(3) shouldBe "три".some
    inRussian(4) shouldBe "четыре".some
    inRussian(5) shouldBe "пять".some
    inRussian(6) shouldBe "шесть".some
    inRussian(7) shouldBe "семь".some
    inRussian(8) shouldBe "восемь".some
    inRussian(9) shouldBe "девять".some
    inRussian(10) shouldBe "десять".some
    inRussian(11) shouldBe "одиннадцать".some
    inRussian(12) shouldBe "двенадцать".some
    inRussian(13) shouldBe "тринадцать".some
    inRussian(14) shouldBe "четырнадцать".some
    inRussian(15) shouldBe "пятнадцать".some
    inRussian(16) shouldBe "шестнадцать".some
    inRussian(17) shouldBe "семнадцать".some
    inRussian(18) shouldBe "восемнадцать".some
    inRussian(19) shouldBe "девятнадцать".some
    inRussian(20) shouldBe "двадцать".some
    inRussian(21) shouldBe "двадцать один".some
    inRussian(32) shouldBe "тридцать два".some
    inRussian(111) shouldBe "сто одиннадцать".some
    inRussian(115) shouldBe "сто пятнадцать".some
    inRussian(342) shouldBe "триста сорок два".some
    inRussian(500) shouldBe "пятьсот".some
    inRussian(5000) shouldBe "пять тысяч".some
    inRussian(1435) shouldBe "одна тысяча четыреста тридцать пять".some
    inRussian(2435) shouldBe "две тысячи четыреста тридцать пять".some
    inRussian(3435) shouldBe "три тысячи четыреста тридцать пять".some
    inRussian(4435) shouldBe "четыре тысячи четыреста тридцать пять".some
    inRussian(5435) shouldBe "пять тысяч четыреста тридцать пять".some
    inRussian(11435) shouldBe "одиннадцать тысяч четыреста тридцать пять".some
    inRussian(12435) shouldBe "двенадцать тысяч четыреста тридцать пять".some
    inRussian(19435) shouldBe "девятнадцать тысяч четыреста тридцать пять".some
    inRussian(999999) shouldBe "девятьсот девяносто девять тысяч девятьсот девяносто девять".some
    inRussian(1001435) shouldBe "один миллион одна тысяча четыреста тридцать пять".some
    inRussian(2002435) shouldBe "два миллиона две тысячи четыреста тридцать пять".some
    inRussian(3003435) shouldBe "три миллиона три тысячи четыреста тридцать пять".some
    inRussian(4004435) shouldBe "четыре миллиона четыре тысячи четыреста тридцать пять".some
    inRussian(5005435) shouldBe "пять миллионов пять тысяч четыреста тридцать пять".some
    inRussian(11011435) shouldBe "одиннадцать миллионов одиннадцать тысяч четыреста тридцать пять".some
    inRussian(12012435) shouldBe "двенадцать миллионов двенадцать тысяч четыреста тридцать пять".some
    inRussian(19019435) shouldBe "девятнадцать миллионов девятнадцать тысяч четыреста тридцать пять".some
    inRussian(
      999999999999999L
    ) shouldBe ("девятьсот девяносто девять триллионов девятьсот девяносто девять миллиардов девятьсот девяносто девять миллионов " +
    "девятьсот девяносто девять тысяч девятьсот девяносто девять").some
  }
}
