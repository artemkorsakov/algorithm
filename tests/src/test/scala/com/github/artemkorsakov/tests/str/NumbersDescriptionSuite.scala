package com.github.artemkorsakov.tests.str

import cats.implicits._
import com.github.artemkorsakov.str.NumbersDescription._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class NumbersDescriptionSuite extends AnyFunSuiteLike {
  test("inEnglish") {
    -1.inEnglish shouldBe None
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

  test("inRussian") {
    -1.inRussian shouldBe None
    1000000000000000L.inRussian shouldBe None
    1.inRussian shouldBe "один".some
    2.inRussian shouldBe "два".some
    3.inRussian shouldBe "три".some
    4.inRussian shouldBe "четыре".some
    5.inRussian shouldBe "пять".some
    6.inRussian shouldBe "шесть".some
    7.inRussian shouldBe "семь".some
    8.inRussian shouldBe "восемь".some
    9.inRussian shouldBe "девять".some
    10.inRussian shouldBe "десять".some
    11.inRussian shouldBe "одиннадцать".some
    12.inRussian shouldBe "двенадцать".some
    13.inRussian shouldBe "тринадцать".some
    14.inRussian shouldBe "четырнадцать".some
    15.inRussian shouldBe "пятнадцать".some
    16.inRussian shouldBe "шестнадцать".some
    17.inRussian shouldBe "семнадцать".some
    18.inRussian shouldBe "восемнадцать".some
    19.inRussian shouldBe "девятнадцать".some
    20.inRussian shouldBe "двадцать".some
    21.inRussian shouldBe "двадцать один".some
    32.inRussian shouldBe "тридцать два".some
    111.inRussian shouldBe "сто одиннадцать".some
    115.inRussian shouldBe "сто пятнадцать".some
    342.inRussian shouldBe "триста сорок два".some
    500.inRussian shouldBe "пятьсот".some
    5000.inRussian shouldBe "пять тысяч".some
    1435.inRussian shouldBe "одна тысяча четыреста тридцать пять".some
    2435.inRussian shouldBe "две тысячи четыреста тридцать пять".some
    3435.inRussian shouldBe "три тысячи четыреста тридцать пять".some
    4435.inRussian shouldBe "четыре тысячи четыреста тридцать пять".some
    5435.inRussian shouldBe "пять тысяч четыреста тридцать пять".some
    11435.inRussian shouldBe "одиннадцать тысяч четыреста тридцать пять".some
    12435.inRussian shouldBe "двенадцать тысяч четыреста тридцать пять".some
    19435.inRussian shouldBe "девятнадцать тысяч четыреста тридцать пять".some
    999999.inRussian shouldBe "девятьсот девяносто девять тысяч девятьсот девяносто девять".some
    1001435.inRussian shouldBe "один миллион одна тысяча четыреста тридцать пять".some
    2002435.inRussian shouldBe "два миллиона две тысячи четыреста тридцать пять".some
    3003435.inRussian shouldBe "три миллиона три тысячи четыреста тридцать пять".some
    4004435.inRussian shouldBe "четыре миллиона четыре тысячи четыреста тридцать пять".some
    5005435.inRussian shouldBe "пять миллионов пять тысяч четыреста тридцать пять".some
    11011435.inRussian shouldBe "одиннадцать миллионов одиннадцать тысяч четыреста тридцать пять".some
    12012435.inRussian shouldBe "двенадцать миллионов двенадцать тысяч четыреста тридцать пять".some
    19019435.inRussian shouldBe "девятнадцать миллионов девятнадцать тысяч четыреста тридцать пять".some
    999999999999999L.inRussian shouldBe "девятьсот девяносто девять триллионов девятьсот девяносто девять миллиардов девятьсот девяносто девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять".some
  }
}
