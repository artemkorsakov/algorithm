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
class Digits(number: BigInt) {
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
}
```

---

### sumOfDigits

[Algorithm]({{ page.parent_link }}{{ "#sumOfDigits" | downcase }})

**Realization**
```scala
class Digits(number: BigInt) {
  def sumOfDigits: Int = {
    var sum = 0
    var n   = number
    while (n > 0) {
      sum += (n % 10).toInt
      n /= 10
    }
    sum
  }
}
```

---

### hasEqualDigits

[Algorithm]({{ page.parent_link }}{{ "#hasEqualDigits" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.digital.Digits._

class Digits(number: BigInt) {
  def hasEqualDigits(countOfEqual: Int, digit: Int): Boolean =
    digits.count(d => d == digit) >= countOfEqual

  def hasEqualDigits: Boolean = {
    val dgs = digits
    dgs.length != dgs.distinct.length
  }

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
}
```

---

### possibleNumbers

[Algorithm]({{ page.parent_link }}{{ "#possibleNumbers" | downcase }})

**Realization**
```scala
  def possibleNumbers(digits: Seq[Int]): Set[String] =
    if (digits.length == 1) {
      Set(digits.head.toString)
    } else {
      var products = Set.empty[String]
      for (i <- digits.indices) {
        val digit       = digits(i).toString
        val tmpDigits   = digits.take(i) ++ digits.takeRight(digits.length - i - 1)
        val tmpVariants = possibleNumbers(tmpDigits)
        for (tmpVariant <- tmpVariants) {
          val newProduct = digit + tmpVariant
          products += newProduct
        }
      }
      products
    }
```

---
