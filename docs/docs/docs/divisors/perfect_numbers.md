---
layout: docs
title: "Perfect Numbers"
realization_link: ../realization/divisors/perfect_numbers.html
---

## {{page.title}}

Operations with [perfect numbers](https://en.wikipedia.org/wiki/Perfect_number).

### perfectNumbersType
Return perfectNumbersType:
- **Perfect**: a perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself.
- **Deficient**: a deficient number is a positive integer that is less to the sum of its positive divisors, excluding the number itself.
- **Abundant**: an abundant number is a positive integer that is more to the sum of its positive divisors, excluding the number itself.

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#perfectNumbersType" | downcase }})

**Sources** 
- [Perfect numbers](https://en.wikipedia.org/wiki/Perfect_number)

**Using**
```scala
import com.github.artemkorsakov.divisors.PerfectNumbers._

val res0 = 8128.perfectNumbersType
// res0: com.github.artemkorsakov.divisors.PerfectNumbers.PerfectNumbersType.Value = Perfect
```

---
