package com.github.artemkorsakov.str

object NumbersDescription {
  private val hundred: Long     = 100
  private val thousand: Long    = 1000
  private val million: Long     = 1000000
  private val billion: Long     = million * thousand
  private val trillion: Long    = billion * thousand
  private val quadrillion: Long = trillion * thousand

  /** @see <a href="https://en.wikipedia.org/wiki/English_numerals">English numerals</a>
    */
  def inEnglish(number: Long): Option[String] =
    number match {
      case n if n < 21 || (n < hundred && n % 10 == 0) => toEnglishBase(n)
      case n if n < hundred && n            % 10 > 0 =>
        toEnglishBase((number / 10) * 10).flatMap(f => toEnglishBase(number % 10).map(s => s"$f-$s"))
      case n if n < thousand    => constructEnglish(n, hundred)
      case n if n < million     => constructEnglish(n, thousand)
      case n if n < billion     => constructEnglish(n, million)
      case n if n < trillion    => constructEnglish(n, billion)
      case n if n < quadrillion => constructEnglish(n, trillion)
      case _                    => None
    }

  private def constructEnglish(n: Long, base: Long): Option[String] = {
    val first  = inEnglish(n / base).flatMap(f => toEnglishBase(base).map(s => s"$f $s"))
    val rest   = n % base
    val art    = if (base == hundred) " and " else " "
    val second = if (rest == 0) Some("") else inEnglish(rest).map(str => s"$art$str")
    first.flatMap(f => second.map(s => s"$f$s"))
  }

  private def toEnglishBase(n: Long): Option[String] =
    n match {
      case 0              => Some("")
      case 1              => Some("one")
      case 2              => Some("two")
      case 3              => Some("three")
      case 4              => Some("four")
      case 5              => Some("five")
      case 6              => Some("six")
      case 7              => Some("seven")
      case 8              => Some("eight")
      case 9              => Some("nine")
      case 10             => Some("ten")
      case 11             => Some("eleven")
      case 12             => Some("twelve")
      case 13             => Some("thirteen")
      case 14             => Some("fourteen")
      case 15             => Some("fifteen")
      case 16             => Some("sixteen")
      case 17             => Some("seventeen")
      case 18             => Some("eighteen")
      case 19             => Some("nineteen")
      case 20             => Some("twenty")
      case 30             => Some("thirty")
      case 40             => Some("forty")
      case 50             => Some("fifty")
      case 60             => Some("sixty")
      case 70             => Some("seventy")
      case 80             => Some("eighty")
      case 90             => Some("ninety")
      case 100            => Some("hundred")
      case 1000           => Some("thousand")
      case 1000000        => Some("million")
      case 1000000000     => Some("billion")
      case 1000000000000L => Some("trillion")
      case _              => None
    }

  def inRussian(number: Long): Option[String] =
    (number match {
      case n if n < 21 => toRussianBase(n)
      case n if n < hundred =>
        toRussianBase((number / 10) * 10).flatMap(f => inRussian(number % 10).map(s => s"$f $s"))
      case n if n < thousand =>
        toRussianBase((number / hundred) * hundred).flatMap(f => inRussian(number % hundred).map(s => s"$f $s"))
      case n if n < million =>
        val first = number / thousand
        val firstInRussian =
          if (first % 10 == 1 && (first % hundred) / 10 != 1) {
            inRussian((first / 10) * 10).map(s => s"$s одна тысяча")
          } else if (first % 10 == 2 && (first % hundred) / 10 != 1) {
            inRussian((first / 10) * 10).map(s => s"$s две тысячи")
          } else if (3 <= first % 10 && first % 10 <= 4 && (first % hundred) / 10 != 1) {
            inRussian(first).map(f => f + " тысячи")
          } else {
            inRussian(first).map(f => f + " тысяч")
          }
        firstInRussian.flatMap(f => inRussian(number % thousand).map(s => s"$f $s"))
      case n if n < billion     => constructRussian(n, million)
      case n if n < trillion    => constructRussian(n, billion)
      case n if n < quadrillion => constructRussian(n, trillion)
      case _                    => None
    }).map(ans => ans.trim)

  private def constructRussian(n: Long, base: Long): Option[String] = {
    val first = n / base
    val firstInRussian =
      if (first % 10 == 1 && (first % base) / 10 != 1) {
        inRussian(first).flatMap(f => toRussianBase(base).map(s => s"$f $s"))
      } else if (2 <= first % 10 && first % 10 <= 4 && (first % base) / 10 != 1) {
        inRussian(first).flatMap(f => toRussianBase(base).map(s => s"$f ${s}а"))
      } else {
        inRussian(first).flatMap(f => toRussianBase(base).map(s => s"$f ${s}ов"))
      }
    firstInRussian.flatMap(f => inRussian(n % base).map(s => s"$f $s"))
  }

  private def toRussianBase(n: Long): Option[String] =
    n match {
      case 0              => Some("")
      case 1              => Some("один")
      case 2              => Some("два")
      case 3              => Some("три")
      case 4              => Some("четыре")
      case 5              => Some("пять")
      case 6              => Some("шесть")
      case 7              => Some("семь")
      case 8              => Some("восемь")
      case 9              => Some("девять")
      case 10             => Some("десять")
      case 11             => Some("одиннадцать")
      case 12             => Some("двенадцать")
      case 13             => Some("тринадцать")
      case 14             => Some("четырнадцать")
      case 15             => Some("пятнадцать")
      case 16             => Some("шестнадцать")
      case 17             => Some("семнадцать")
      case 18             => Some("восемнадцать")
      case 19             => Some("девятнадцать")
      case 20             => Some("двадцать")
      case 30             => Some("тридцать")
      case 40             => Some("сорок")
      case 50             => Some("пятьдесят")
      case 60             => Some("шестьдесят")
      case 70             => Some("семьдесят")
      case 80             => Some("восемьдесят")
      case 90             => Some("девяносто")
      case 100            => Some("сто")
      case 200            => Some("двести")
      case 300            => Some("триста")
      case 400            => Some("четыреста")
      case 500            => Some("пятьсот")
      case 600            => Some("шестьсот")
      case 700            => Some("семьсот")
      case 800            => Some("восемьсот")
      case 900            => Some("девятьсот")
      case 1000000        => Some("миллион")
      case 1000000000     => Some("миллиард")
      case 1000000000000L => Some("триллион")
      case _              => None
    }
}
