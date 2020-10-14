---
layout: docs
title: "Realization: Harshad number"
parent_link: ../../numbers/harshad.html
---

## {{page.title}}

Realizations for [Harshad number]({{ page.parent_link }}).

### isHarshadNumber

[Algorithm]({{ page.parent_link }}{{ "#isHarshadNumber" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.digital.Digits._

case class HarshadNumber(number: Long) {
  def isHarshadNumber: Boolean =
    number % number.sumOfDigits == 0
}
```

---

### isStrongHarshadNumber

[Algorithm]({{ page.parent_link }}{{ "#isStrongHarshadNumber" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.digital.Digits._
import com.github.artemkorsakov.primes.Primes._

case class HarshadNumber(number: Long) {
  def isStrongHarshadNumber: Boolean = {
    val sumOfDigits = number.sumOfDigits
    number % sumOfDigits == 0 && (number / sumOfDigits).isPrime
  }
}
```

---

### getStrongRightTruncatableHarshadPrimes

[Algorithm]({{ page.parent_link }}{{ "#getStrongRightTruncatableHarshadPrimes" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.digital.Digits._
import com.github.artemkorsakov.primes.Primes._
import com.github.artemkorsakov.numbers.HarshadNumber._

object HarshadNumber {
  def getStrongRightTruncatableHarshadPrimes(p: Int): Seq[Long] = {
    var harshadNumbers = Seq(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L)
    (1 until p - 1).flatMap { _ =>
      harshadNumbers = rightTruncatableHarshadNumbers(harshadNumbers)
      harshadNumbers.withFilter(_.isStrongHarshadNumber).flatMap(strongRightTruncatableHarshadPrimes)
    }
  }

  private def strongRightTruncatableHarshadPrimes(strongHarshadNumber: Long): Seq[Long] =
    (1 to 9 by 2).withFilter(i => (strongHarshadNumber * 10 + i).isPrime).map(strongHarshadNumber * 10 + _)

  private def rightTruncatableHarshadNumbers(harshadNumbers: Seq[Long]): Seq[Long] =
    harshadNumbers.flatMap(rightTruncatableHarshadNumbers)

  private def rightTruncatableHarshadNumbers(harshadNumber: Long): Seq[Long] = {
    val sumOfDigits = harshadNumber.sumOfDigits
    val newNumber   = harshadNumber * 10
    (0 to 9).withFilter(i => (newNumber + i) % (sumOfDigits + i) == 0).map(newNumber + _)
  }
}
```

---
