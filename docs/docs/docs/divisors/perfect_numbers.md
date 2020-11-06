---
layout: docsplus
title: "Perfect Numbers"
realization: divisors/PerfectNumbers.scala
---

Operations with [perfect numbers](https://en.wikipedia.org/wiki/Perfect_number).

### perfectNumbersType
Return perfectNumbersType:
- **Perfect**: a perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself.
- **Deficient**: a deficient number is a positive integer that is less to the sum of its positive divisors, excluding the number itself.
- **Abundant**: an abundant number is a positive integer that is more to the sum of its positive divisors, excluding the number itself.

**Algorithm**

**Complexity**
     
**Sources** 
- [Perfect numbers](https://en.wikipedia.org/wiki/Perfect_number)

**Using**
```scala mdoc
import com.github.artemkorsakov.divisors.PerfectNumbers._
8128.perfectNumbersType
```

---
