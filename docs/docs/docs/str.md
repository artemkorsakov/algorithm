---
layout: docs
title: "String Algorithms"
---

## {{page.title}}

The package ```com.github.artemkorsakov.str``` contains string algorithms. 

You can use the package, for example, like this:
```scala mdoc:to-string
import com.github.artemkorsakov.str.StringAlgorithms._
import com.github.artemkorsakov.str.NumbersDescription._
import com.github.artemkorsakov.str.RomanNumerals._
val res0 = sum("37107287533902102798797998220837590246510135740250", "46376937677490009712648124896970078050417018260538") 
val res1 = "37107287533902102798797998220837590246510135740250" sum "46376937677490009712648124896970078050417018260538"
val res2 = "37107287533902102798797998220837590246510135740250" |+| "46376937677490009712648124896970078050417018260538"
val res3 = areAnagrams("post", "stop")
val res4 = "\"COLIN\"".alphabeticalValue
val res5 = 1435.inEnglish
val res6 = 999999.inEnglish
val res7 = 11011435.inRussian
val res8 = 999999.inRussian
val res9 = "MCCCCCCVI".toMinimalRomanNumeral
val res10 = "MCMLXXXIV".toArabic
val res11 = 1984.toRoman
```