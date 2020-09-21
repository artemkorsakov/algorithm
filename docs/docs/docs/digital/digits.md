---
layout: docs
title: "Digits"
realization_link: ../realization/digital/digits.html
---

## {{page.title}}

### containTheSameDigits
Do two numbers contain the same digits?

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