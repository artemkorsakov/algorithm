---
layout: docs
title: "Realization: Common operations"
parent_link: ../../operations/common_operations.html
---

## {{page.title}}

Realizations for [Common operations]({{ page.parent_link }}).

### sumToGiven

[Algorithm]({{ page.parent_link }}{{ "#sumToGiven" | downcase }})

**Realization**
```scala
  def sumToGiven(n: Long): Long =
    n * (n + 1) / 2
```

---

### sumOfSquaresTo

[Algorithm]({{ page.parent_link }}{{ "#sumOfSquaresTo" | downcase }})

**Realization**
```scala
  def sumOfSquaresTo(n: Long): Long =
    n * (n + 1) * (2 * n + 1) / 6
```

---

### sumOfCubesTo

[Algorithm]({{ page.parent_link }}{{ "#sumOfCubesTo" | downcase }})

**Realization**
```scala
  def sumOfCubesTo(n: Long): Long = {
    val sum = sumToGiven(n)
    sum * sum
  }

  def sumToGiven(n: Long): Long =
    n * (n + 1) / 2
```

---

### sqrt

[Algorithm]({{ page.parent_link }}{{ "#sqrt" | downcase }})

**Realization**
```scala
import scala.annotation.tailrec
import scala.math.abs

class CommonOperations(x: Double) {
  def sqrt: Double = {
    @tailrec
    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)

    def improve(guess: Double, x: Double) =
      (guess + x / guess) / 2

    def square(guess: Double) = guess * guess

    def isGoodEnough(guess: Double, x: Double) =
      abs(square(guess) - x) < 1e-10

    sqrtIter(1.0, x)
  }

}
```

---

### isSquare

[Algorithm]({{ page.parent_link }}{{ "#isSquare" | downcase }})

**Realization**
```scala
import scala.math._

class CommonOperations(x: Double) {
  def isSquare: Boolean = {
    val s = sqrt(x).toLong
    abs(s * s - x) < 1e-10
  }

}
```

---

### allSquares

[Algorithm]({{ page.parent_link }}{{ "#allSquares" | downcase }})

**Realization**
```scala
import scala.math._
import com.github.artemkorsakov.operations.CommonOperations._

  def allSquares(countOfDigits: Int): List[Int] = {
    val start  = pow(10.0, countOfDigits - 1.0).toInt
    val finish = start * 10 - 1
    allSquares(start, finish)
  }

  def allSquares(start: Int, finish: Int): List[Int] = {
    val first = if (start.toDouble.isSquare) sqrt(start.toDouble).toInt else sqrt(start.toDouble).toInt + 1
    (first to sqrt(finish.toDouble).toInt).map(i => i * i).toList
  }
```

---

### allNumbersVariants

[Algorithm]({{ page.parent_link }}{{ "#allNumbersVariants" | downcase }})

**Realization**
```scala
  def allNumbersVariants(numbers: Set[Int]): Set[Set[Int]] =
    if (numbers.size <= 1) {
      Set(numbers)
    } else {
      val number                = numbers.head
      val allNumbersVariantTemp = allNumbersVariants(numbers.tail)
      Set(Set(number)) ++ allNumbersVariantTemp ++ allNumbersVariantTemp.map(tempVariant => tempVariant + number)
    }
```

---
