---
layout: docs
title: "String Algorithms"
---

## {{page.title}}

The package ```com.github.artemkorsakov.str``` contains string algorithms. 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.str.StringAlgorithms._
sum("37107287533902102798797998220837590246510135740250", "46376937677490009712648124896970078050417018260538") 
"37107287533902102798797998220837590246510135740250" sum "46376937677490009712648124896970078050417018260538"
"37107287533902102798797998220837590246510135740250" |+| "46376937677490009712648124896970078050417018260538"
areAnagrams("post", "stop")
alphabeticalValue("\"COLIN\"")
```
```scala mdoc:to-string
import com.github.artemkorsakov.str.NumbersDescription._
inEnglish(1435)
inEnglish(999999)
inRussian(11011435)
inRussian(999999)
```
```scala mdoc
import com.github.artemkorsakov.str.RomanNumerals._
toMinimalRomanNumeral("MCCCCCCVI")
toArabic("MCMLXXXIV")
toRoman(1984)
```
```scala mdoc
import com.github.artemkorsakov.str.Lcs
Lcs.lcs("nothardlythefinaltest", "zzzfinallyzzz")
```