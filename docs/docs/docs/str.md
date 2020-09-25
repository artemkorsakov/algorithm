---
layout: docs
title: "String Algorithms"
---

## {{page.title}}

The package ```com.github.artemkorsakov.str``` contains string algorithms. 

You can use the package, for example, like this:
```scala
import com.github.artemkorsakov.str.StringAlgorithms._
import com.github.artemkorsakov.str.NumbersDescription._

val res0 = sum("37107287533902102798797998220837590246510135740250", "46376937677490009712648124896970078050417018260538") 
// res0: String = 83484225211392112511446123117807668296927154000788

val res1 = "37107287533902102798797998220837590246510135740250" sum "46376937677490009712648124896970078050417018260538"
// res1: String = 83484225211392112511446123117807668296927154000788

val res2 = "37107287533902102798797998220837590246510135740250" |+| "46376937677490009712648124896970078050417018260538"
// res2: String = 83484225211392112511446123117807668296927154000788

val res3 = areAnagrams("post", "stop")
// res3: Boolean = true

val res4 = "\"COLIN\"".alphabeticalValue
// res4: Int = 53

val res5 = 1435.inEnglish
// res5: Option[String] = Some(one thousand four hundred and thirty-five)

val res6 = 999999.inEnglish
// res6: Option[String] = Some(nine hundred and ninety-nine thousand nine hundred and ninety-nine)
```