package com.github.artemkorsakov.str

import cats.implicits._
import com.github.artemkorsakov.str.NumbersDescription._

class NumbersDescription(number: Long) {
  private val hundred: Long     = 100
  private val thousand: Long    = 1000
  private val million: Long     = 1000000
  private val billion: Long     = million * thousand
  private val trillion: Long    = billion * thousand
  private val quadrillion: Long = trillion * thousand

  /** @see <a href="https://en.wikipedia.org/wiki/English_numerals">English numerals</a>
    */
  def inEnglish: Option[String] =
    number match {
      case n if n < 21 || (n < hundred && n % 10 == 0) => toEnglishBase(n)
      case n if n < hundred && n            % 10 > 0 =>
        toEnglishBase((number / 10) * 10) |+| "-".some |+| toEnglishBase(number % 10)
      case n if n < thousand    => constructEnglish(n, hundred)
      case n if n < million     => constructEnglish(n, thousand)
      case n if n < billion     => constructEnglish(n, million)
      case n if n < trillion    => constructEnglish(n, billion)
      case n if n < quadrillion => constructEnglish(n, trillion)
      case _                    => None
    }

  private def constructEnglish(n: Long, base: Long): Option[String] = {
    val first  = (n / base).inEnglish |+| " ".some |+| toEnglishBase(base)
    val rest   = n % base
    val art    = if (base == hundred) " and " else " "
    val second = if (rest == 0) "".some else art.some |+| rest.inEnglish
    first |+| second
  }

  private def toEnglishBase(n: Long): Option[String] =
    n match {
      case 0              => "".some
      case 1              => "one".some
      case 2              => "two".some
      case 3              => "three".some
      case 4              => "four".some
      case 5              => "five".some
      case 6              => "six".some
      case 7              => "seven".some
      case 8              => "eight".some
      case 9              => "nine".some
      case 10             => "ten".some
      case 11             => "eleven".some
      case 12             => "twelve".some
      case 13             => "thirteen".some
      case 14             => "fourteen".some
      case 15             => "fifteen".some
      case 16             => "sixteen".some
      case 17             => "seventeen".some
      case 18             => "eighteen".some
      case 19             => "nineteen".some
      case 20             => "twenty".some
      case 30             => "thirty".some
      case 40             => "forty".some
      case 50             => "fifty".some
      case 60             => "sixty".some
      case 70             => "seventy".some
      case 80             => "eighty".some
      case 90             => "ninety".some
      case 100            => "hundred".some
      case 1000           => "thousand".some
      case 1000000        => "million".some
      case 1000000000     => "billion".some
      case 1000000000000L => "trillion".some
      case _              => None
    }

  def inRussian: Option[String] =
    (number match {
      case n if n < 21 => toRussianBase(n)
      case n if n < hundred =>
        toRussianBase((number / 10) * 10) |+| " ".some |+| (number % 10).inRussian
      case n if n < thousand =>
        toRussianBase((number / hundred) * hundred) |+| " ".some |+| (number % hundred).inRussian
      case n if n < million =>
        val first = number / thousand
        val firstInRussian =
          if (first % 10 == 1 && (first % hundred) / 10 != 1) {
            ((first / 10) * 10).inRussian |+| " одна тысяча".some
          } else if (first % 10 == 2 && (first % hundred) / 10 != 1) {
            ((first / 10) * 10).inRussian |+| " две тысячи".some
          } else if (3 <= first % 10 && first % 10 <= 4 && (first % hundred) / 10 != 1) {
            first.inRussian.map(f => f + " тысячи")
          } else {
            first.inRussian.map(f => f + " тысяч")
          }
        firstInRussian |+| " ".some |+| (number % thousand).inRussian
      case n if n < billion     => constructRussian(n, million)
      case n if n < trillion    => constructRussian(n, billion)
      case n if n < quadrillion => constructRussian(n, trillion)
      case _                    => None
    }).map(ans => ans.trim)

  private def constructRussian(n: Long, base: Long): Option[String] = {
    val first = n / base
    val firstInRussian =
      if (first % 10 == 1 && (first % base) / 10 != 1) {
        first.inRussian |+| " ".some |+| toRussianBase(base)
      } else if (2 <= first % 10 && first % 10 <= 4 && (first % base) / 10 != 1) {
        first.inRussian |+| " ".some |+| toRussianBase(base) |+| "а".some
      } else {
        first.inRussian |+| " ".some |+| toRussianBase(base) |+| "ов".some
      }
    firstInRussian |+| " ".some |+| (n % base).inRussian
  }

  private def toRussianBase(n: Long): Option[String] =
    n match {
      case 0              => "".some
      case 1              => "один".some
      case 2              => "два".some
      case 3              => "три".some
      case 4              => "четыре".some
      case 5              => "пять".some
      case 6              => "шесть".some
      case 7              => "семь".some
      case 8              => "восемь".some
      case 9              => "девять".some
      case 10             => "десять".some
      case 11             => "одиннадцать".some
      case 12             => "двенадцать".some
      case 13             => "тринадцать".some
      case 14             => "четырнадцать".some
      case 15             => "пятнадцать".some
      case 16             => "шестнадцать".some
      case 17             => "семнадцать".some
      case 18             => "восемнадцать".some
      case 19             => "девятнадцать".some
      case 20             => "двадцать".some
      case 30             => "тридцать".some
      case 40             => "сорок".some
      case 50             => "пятьдесят".some
      case 60             => "шестьдесят".some
      case 70             => "семьдесят".some
      case 80             => "восемьдесят".some
      case 90             => "девяносто".some
      case 100            => "сто".some
      case 200            => "двести".some
      case 300            => "триста".some
      case 400            => "четыреста".some
      case 500            => "пятьсот".some
      case 600            => "шестьсот".some
      case 700            => "семьсот".some
      case 800            => "восемьсот".some
      case 900            => "девятьсот".some
      case 1000000        => "миллион".some
      case 1000000000     => "миллиард".some
      case 1000000000000L => "триллион".some
      case _              => None
    }
}

object NumbersDescription {
  implicit def int2NumbersDescription(number: Int): NumbersDescription   = new NumbersDescription(number.toLong)
  implicit def long2NumbersDescription(number: Long): NumbersDescription = new NumbersDescription(number)
}
