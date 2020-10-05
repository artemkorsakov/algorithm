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
"\"COLIN\"".alphabeticalValue
```
```scala mdoc:to-string
import com.github.artemkorsakov.str.NumbersDescription._
1435.inEnglish
999999.inEnglish
11011435.inRussian
999999.inRussian
```
```scala mdoc
import com.github.artemkorsakov.str.RomanNumerals._
"MCCCCCCVI".toMinimalRomanNumeral
"MCMLXXXIV".toArabic
1984.toRoman
```