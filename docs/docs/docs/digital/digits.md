---
layout: docs
title: "Digits"
realization_link: ../realization/digital/digits.html
---

## {{page.title}}

### containTheSameDigits
Do two numbers contain the same digits?

It is the same as [Operations with strings - areAnagrams](../str/string_algorithms#areanagrams)

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#containTheSameDigits" | downcase }})

**Sources** 

**Using**
```scala
import com.github.artemkorsakov.digital.Digits._

val res0 = containTheSameDigits(127035954683L, 589323567104L)
// res0: Boolean = true
```

---

### digits
Returns the digits of a number.

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#digits" | downcase }})

**Sources** 

**Using**
```scala
import com.github.artemkorsakov.digital.Digits._

val res0 = 1406357289L.digits
// res0: Array[Int] = Array(1, 4, 0, 6, 3, 5, 7, 2, 8, 9)
```

---

### sumOfDigits
Returns the sum of the digits of a number.

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#sumOfDigits" | downcase }})

**Sources** 

**Using**
```scala
import com.github.artemkorsakov.digital.Digits._

val res0 = 1406357289L.sumOfDigits
// res0: Int = 45
```

---

### hasEqualDigits
Does the number have at least two of the same digits?

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#hasEqualDigits" | downcase }})

**Sources** 

**Using**
```scala
import com.github.artemkorsakov.digital.Digits._

val res0 = 56993.hasEqualDigits
// res0: Boolean = true

val res1 = 56993.hasEqualDigits(2, 9)
// res1: Boolean = true

val res2 = 56993.hasEqualDigits(3, 9)
// res2: Boolean = false
```

---

### possibleNumbers
Returns all numbers made up of given digits.

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#possibleNumbers" | downcase }})

**Sources** 

**Using**
```scala
import com.github.artemkorsakov.digital.Digits._

val res0 = possibleNumbers(Seq(1, 1, 5, 6))
// res0: Set[String] = Set(5116, 1516, 1165, 6511, 1156, 5161, 6151, 1615, 5611, 6115, 1651, 1561)
```

---
