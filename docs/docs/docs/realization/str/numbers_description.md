---
layout: docs
title: "Realization: Numbers description"
parent_link: ../../str/numbers_description.html
---

## {{page.title}}

Realizations for [Numbers description]({{ page.parent_link }}).

### inEnglish

[Algorithm]({{ page.parent_link }}{{ "#inEnglish" | downcase }})

**Realization**
```scala
import cats.implicits._
import com.github.artemkorsakov.str.NumbersDescription._

class NumbersDescription(number: Long) {
  private val hundred: Long     = 100
  private val thousand: Long    = 1000
  private val million: Long     = 1000000
  private val billion: Long     = million * thousand
  private val trillion: Long    = billion * thousand
  private val quadrillion: Long = trillion * thousand

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

}
```

---