---
layout: docs
title: "Roman numerals"
realization_link: ../realization/str/roman_numerals.html
---

## {{page.title}}

[About Roman Numerals](https://projecteuler.net/about=roman_numerals).

### toMinimalRomanNumeral
Roman number in its minimum notation.

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#toMinimalRomanNumeral" | downcase }})

**Sources** 
- [Roman Numerals](https://en.wikipedia.org/wiki/Roman_numerals)
- [About Roman Numerals](https://projecteuler.net/about=roman_numerals)

**Using**
```scala mdoc
import com.github.artemkorsakov.str.RomanNumerals._
"MCCCCCCVI".toMinimalRomanNumeral
```

---

### toArabic
Roman number to Arabic.

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#toArabic" | downcase }})

**Sources** 

**Using**
```scala mdoc
"MCMLXXXIV".toArabic
```

---

### toRoman
Arabic number to Roman.

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#toRoman" | downcase }})

**Sources** 

**Using**
```scala mdoc
1984.toRoman
```

---
