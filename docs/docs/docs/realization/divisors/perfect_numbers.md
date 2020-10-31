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
import com.github.artemkorsakov.divisors.PerfectNumbers._

class PerfectNumbers(n: Long) {
  def perfectNumbersType: PerfectNumbersType = {
    val sum = n.sumOfDivisors - n
    if (sum == n)
      Perfect
    else if (sum < n)
      Deficient
    else
      Abundant
  }
}
```

---
