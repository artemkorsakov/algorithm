---
layout: docs
title: "Operations with strings"
realization_link: ../realization/str/string_algorithms.html
---

## {{page.title}}

### sum
Returns the sum of two numbers given as a string.

**Algorithm**
1. Given two numbers: **first** and **second**.
2. If one of these numbers is empty return the other number.
3. Define **sumLast** as sum of last symbols of the numbers.
4. Define **sumFirst** as **sum(first0, second0)** where **first0** and **second0** are the numbers without last symbol.
5. If **sumLast** is more than **9** define **sumFirst = sum(sumFirst, "1")** and **sumLast = sumLast - 10**.
6. Return **sumFirst + sumLast**.

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#sum" | downcase }})

**Sources** 

**Using**
```scala
import com.github.artemkorsakov.str.StringAlgorithms._

val res0 = sum("37107287533902102798797998220837590246510135740250", "46376937677490009712648124896970078050417018260538") 
// res0: String = 83484225211392112511446123117807668296927154000788

val res1 = "37107287533902102798797998220837590246510135740250" sum "46376937677490009712648124896970078050417018260538"
// res1: String = 83484225211392112511446123117807668296927154000788

val res2 = "37107287533902102798797998220837590246510135740250" |+| "46376937677490009712648124896970078050417018260538"
// res2: String = 83484225211392112511446123117807668296927154000788
```

---

### areAnagrams
Are two words anagrams? 

It is the same as [Digits#containTheSameDigits](../digital/digits.html#containthesamedigits)

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#areAnagrams" | downcase }})

**Sources** 

**Using**
```scala
import com.github.artemkorsakov.str.StringAlgorithms._

val res0 = areAnagrams("post", "stop")
// res0: Boolean = true
```

---

### alphabeticalValue
[Project Euler Problem 22](https://projecteuler.net/problem=22).

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#alphabeticalValue" | downcase }})

**Sources** 
- [Project Euler Problem 22](https://projecteuler.net/problem=22)

**Using**
```scala
import com.github.artemkorsakov.str.StringAlgorithms._

val res0 = "\"COLIN\"".alphabeticalValue
// res0: Int = 53
```

---
