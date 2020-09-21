---
layout: docs
title: "Realization: Digits"
parent_link: ../../digital/digits.html
---

## {{page.title}}

Realizations for [Digits]({{ page.parent_link }}).

### containTheSameDigits

[Algorithm]({{ page.parent_link }}{{ "#containTheSameDigits" | downcase }})

**Realization**
```scala
  def containTheSameDigits(number1: Long, number2: Long): Boolean =
    containTheSameDigits(String.valueOf(number1), String.valueOf(number2))

  def containTheSameDigits(number1: String, number2: String): Boolean =
    (number1.length == number2.length) && number1.toCharArray.sorted.sameElements(number2.toCharArray.sorted)
```

---

### digits

[Algorithm]({{ page.parent_link }}{{ "#digits-1" | downcase }})

**Realization**
```scala
  def digits: Array[Int] = {
    val digits = new Array[Int](number.toString.length)
    var i      = 1
    var n      = number
    while (i <= digits.length) {
      digits(digits.length - i) = (n % 10).toInt
      n /= 10
      i += 1
    }
    digits
  }
```

---

### sumOfDigits

[Algorithm]({{ page.parent_link }}{{ "#sumOfDigits" | downcase }})

**Realization**
```scala
  def sumOfDigits: Int = {
    var sum = 0
    var n   = number
    while (n > 0) {
      sum += (n % 10).toInt
      n /= 10
    }
    sum
  }
```

---