---
layout: docsplus
title: "Operations with strings"
realization: str/StringAlgorithms.scala
---

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
     
**Sources** 

**Using**
```scala mdoc
import com.github.artemkorsakov.str.StringAlgorithms._
sum("37107287533902102798797998220837590246510135740250", "46376937677490009712648124896970078050417018260538") 
"37107287533902102798797998220837590246510135740250" sum "46376937677490009712648124896970078050417018260538"
"37107287533902102798797998220837590246510135740250" |+| "46376937677490009712648124896970078050417018260538"
```

---

### areAnagrams
Are two words anagrams? 

It is the same as [Digits - containTheSameDigits](../digital/digits#containthesamedigits)

**Algorithm**

**Complexity**
     
**Sources** 

**Using**
```scala mdoc
areAnagrams("post", "stop")
```

---

### alphabeticalValue
[Project Euler Problem 22](https://projecteuler.net/problem=22).

**Algorithm**

**Complexity**
     
**Sources** 
- [Project Euler Problem 22](https://projecteuler.net/problem=22)

**Using**
```scala mdoc
"\"COLIN\"".alphabeticalValue
```

---
