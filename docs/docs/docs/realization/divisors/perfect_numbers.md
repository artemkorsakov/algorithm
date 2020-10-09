---
layout: docs
title: "Realization: Perfect Numbers"
parent_link: ../../divisors/perfect_numbers.html
---

## {{page.title}}

Realizations for [Perfect Numbers]({{ page.parent_link }}).

### perfectNumbersType

[Algorithm]({{ page.parent_link }}{{ "#perfectNumbersType" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.divisors.Divisors._
import com.github.artemkorsakov.divisors.PerfectNumbers.PerfectNumbersType

class PerfectNumbers(n: Long) {

  def perfectNumbersType: PerfectNumbersType.Value = {
    val sum = n.sumOfDivisors - n
    if (sum == n) {
      PerfectNumbersType.Perfect
    } else if (sum < n) {
      PerfectNumbersType.Deficient
    } else {
      PerfectNumbersType.Abundant
    }
  }
}
```

---
