---
layout: docs
title: "Realization: Roman numerals"
parent_link: ../../str/roman_numerals.html
---

## {{page.title}}

Realizations for [Roman numerals]({{ page.parent_link }}).

### toMinimalRomanNumeral

[Algorithm]({{ page.parent_link }}{{ "#toMinimalRomanNumeral" | downcase }})

**Realization**
```scala
import cats.implicits._
import com.github.artemkorsakov.str.RomanNumeralSymbol._

class RomanNumerals(roman: String) {

  lazy val toMinimalRomanNumeral: Option[String] = {
    if (roman.exists(ch => toRomanNumeralSymbol(ch.toString).isEmpty)) {
      None
    } else {
      roman.toUpperCase
        .replaceAll("IIIII", "V")
        .replaceAll("VV", "X")
        .replaceAll("XXXXX", "L")
        .replaceAll("LL", "C")
        .replaceAll("CCCCC", "D")
        .replaceAll("DD", "M")
        .replaceAll("VIIII", "IX")
        .replaceAll("IIII", "IV")
        .replaceAll("LXXXX", "XC")
        .replaceAll("XXXX", "XL")
        .replaceAll("DCCCC", "CM")
        .replaceAll("CCCC", "CD")
        .some
    }
  }
}
```

---

### toArabic

[Algorithm]({{ page.parent_link }}{{ "#toArabic" | downcase }})

**Realization**
```scala
import cats.implicits._
import com.github.artemkorsakov.str.RomanNumeralSymbol._
import com.github.artemkorsakov.str.RomanNumeralSymbol
import scala.collection.mutable

class RomanNumerals(roman: String) {

  lazy val toArabic: Option[Long] = {
    val min = toMinimalRomanNumeral
    if (min.isEmpty) {
      None
    } else {
      val temp    = min.get + "  "
      var i       = 0
      val symbols = mutable.MutableList.empty[RomanNumeralSymbol.Value]
      while (i < min.get.length) {
        val symbol = toRomanNumeralSymbol(temp.substring(i, i + 2)).get
        symbols += symbol
        i += symbol.toString.length
      }
      symbols.map(sym => sym.id.toLong).sum.some
    }
  }

  lazy val toMinimalRomanNumeral: Option[String] = {
    if (roman.exists(ch => toRomanNumeralSymbol(ch.toString).isEmpty)) {
      None
    } else {
      roman.toUpperCase
        .replaceAll("IIIII", "V")
        .replaceAll("VV", "X")
        .replaceAll("XXXXX", "L")
        .replaceAll("LL", "C")
        .replaceAll("CCCCC", "D")
        .replaceAll("DD", "M")
        .replaceAll("VIIII", "IX")
        .replaceAll("IIII", "IV")
        .replaceAll("LXXXX", "XC")
        .replaceAll("XXXX", "XL")
        .replaceAll("DCCCC", "CM")
        .replaceAll("CCCC", "CD")
        .some
    }
  }

}
```

---

### toRoman

[Algorithm]({{ page.parent_link }}{{ "#toRoman" | downcase }})

**Realization**
```scala
import cats.implicits._
import com.github.artemkorsakov.str.RomanNumeralSymbol._
import com.github.artemkorsakov.str.RomanNumeralSymbol
import com.github.artemkorsakov.str.RomanNumerals._

class ArabicNumerals(number: Long) {
  lazy val toRoman: Option[String] =
    if (number < 0) {
      None
    } else if (number == 0) {
      "".some
    } else {
      val max = RomanNumeralSymbol.values.filter(v => v.id <= number).maxBy(_.id)
      max.toString.some |+| (number - max.id).toRoman
    }
}
```

---
