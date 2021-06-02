package com.github.artemkorsakov.tests.str

import com.github.artemkorsakov.str.NumbersDescription._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class NumbersDescriptionSuite extends AnyFunSuiteLike {
  test("inEnglish") {
    inEnglish(-1) shouldBe None
    inEnglish(1000000000000000L) shouldBe None
    inEnglish(11) shouldBe Some("eleven")
    inEnglish(32) shouldBe Some("thirty-two")
    inEnglish(111) shouldBe Some("one hundred and eleven")
    inEnglish(115) shouldBe Some("one hundred and fifteen")
    inEnglish(342) shouldBe Some("three hundred and forty-two")
    inEnglish(500) shouldBe Some("five hundred")
    inEnglish(5000) shouldBe Some("five thousand")
    inEnglish(1435) shouldBe Some("one thousand four hundred and thirty-five")
    inEnglish(999999) shouldBe Some("nine hundred and ninety-nine thousand nine hundred and ninety-nine")
    inEnglish(
      999999999999999L
    ) shouldBe Some(
      "nine hundred and ninety-nine trillion nine hundred and ninety-nine billion nine hundred and " +
      "ninety-nine million nine hundred and ninety-nine thousand nine hundred and ninety-nine"
    )
  }

  test("inRussian") {
    inRussian(-1) shouldBe None
    inRussian(1000000000000000L) shouldBe None
    inRussian(1) shouldBe Some("один")
    inRussian(2) shouldBe Some("два")
    inRussian(3) shouldBe Some("три")
    inRussian(4) shouldBe Some("четыре")
    inRussian(5) shouldBe Some("пять")
    inRussian(6) shouldBe Some("шесть")
    inRussian(7) shouldBe Some("семь")
    inRussian(8) shouldBe Some("восемь")
    inRussian(9) shouldBe Some("девять")
    inRussian(10) shouldBe Some("десять")
    inRussian(11) shouldBe Some("одиннадцать")
    inRussian(12) shouldBe Some("двенадцать")
    inRussian(13) shouldBe Some("тринадцать")
    inRussian(14) shouldBe Some("четырнадцать")
    inRussian(15) shouldBe Some("пятнадцать")
    inRussian(16) shouldBe Some("шестнадцать")
    inRussian(17) shouldBe Some("семнадцать")
    inRussian(18) shouldBe Some("восемнадцать")
    inRussian(19) shouldBe Some("девятнадцать")
    inRussian(20) shouldBe Some("двадцать")
    inRussian(21) shouldBe Some("двадцать один")
    inRussian(32) shouldBe Some("тридцать два")
    inRussian(111) shouldBe Some("сто одиннадцать")
    inRussian(115) shouldBe Some("сто пятнадцать")
    inRussian(342) shouldBe Some("триста сорок два")
    inRussian(500) shouldBe Some("пятьсот")
    inRussian(5000) shouldBe Some("пять тысяч")
    inRussian(1435) shouldBe Some("одна тысяча четыреста тридцать пять")
    inRussian(2435) shouldBe Some("две тысячи четыреста тридцать пять")
    inRussian(3435) shouldBe Some("три тысячи четыреста тридцать пять")
    inRussian(4435) shouldBe Some("четыре тысячи четыреста тридцать пять")
    inRussian(5435) shouldBe Some("пять тысяч четыреста тридцать пять")
    inRussian(11435) shouldBe Some("одиннадцать тысяч четыреста тридцать пять")
    inRussian(12435) shouldBe Some("двенадцать тысяч четыреста тридцать пять")
    inRussian(19435) shouldBe Some("девятнадцать тысяч четыреста тридцать пять")
    inRussian(999999) shouldBe Some("девятьсот девяносто девять тысяч девятьсот девяносто девять")
    inRussian(1001435) shouldBe Some("один миллион одна тысяча четыреста тридцать пять")
    inRussian(2002435) shouldBe Some("два миллиона две тысячи четыреста тридцать пять")
    inRussian(3003435) shouldBe Some("три миллиона три тысячи четыреста тридцать пять")
    inRussian(4004435) shouldBe Some("четыре миллиона четыре тысячи четыреста тридцать пять")
    inRussian(5005435) shouldBe Some("пять миллионов пять тысяч четыреста тридцать пять")
    inRussian(11011435) shouldBe Some("одиннадцать миллионов одиннадцать тысяч четыреста тридцать пять")
    inRussian(12012435) shouldBe Some("двенадцать миллионов двенадцать тысяч четыреста тридцать пять")
    inRussian(19019435) shouldBe Some("девятнадцать миллионов девятнадцать тысяч четыреста тридцать пять")
    inRussian(
      999999999999999L
    ) shouldBe Some(
      "девятьсот девяносто девять триллионов девятьсот девяносто девять миллиардов девятьсот девяносто девять миллионов " +
      "девятьсот девяносто девять тысяч девятьсот девяносто девять"
    )
  }
}
