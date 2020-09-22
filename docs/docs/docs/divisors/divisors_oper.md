---
layout: docs
title: "Operations with divisors"
realization_link: ../realization/divisors/divisors_oper.html
---

## {{page.title}}

Common operations with divisors.

### gcd
Return the [greatest common divisor](https://en.wikipedia.org/wiki/Greatest_common_divisor).

**Algorithm**
1. **gcd(0, v) = v**, because everything divides zero, and **v** is the largest number that divides **v**. 
Similarly, **gcd(u, 0) = u**.
2. **gcd(2u, 2v) = 2·gcd(u, v)**
3. **gcd(2u, v) = gcd(u, v)**, if **v** is odd (**2** is not a common divisor). 
Similarly, **gcd(u, 2v) = gcd(u, v)** if **u** is odd.
4. **gcd(u, v) = gcd(abs(u − v), min(u, v))**, if **u** and **v** are both odd.

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#gcd" | downcase }})

**Sources** 
- [Binary GCD algorithm](https://en.wikipedia.org/wiki/Binary_GCD_algorithm)

**Using**
```scala
import com.github.artemkorsakov.divisors.Divisors._

val res0 = gcd(12121212L, 23422344L)
// res0: Long = 12
```

---
