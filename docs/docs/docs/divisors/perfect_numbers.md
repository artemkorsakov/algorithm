---
layout: docs
title: "Perfect Numbers"
realization_link: ../realization/divisors/perfect_numbers.html
---

## {{page.title}}

Operations with [perfect numbers](https://en.wikipedia.org/wiki/Perfect_number).

### isPrime
Determines if the given integer is prime.

**Algorithm**
1. A prime number greater than **1**.
2. All primes except **2** are odd.
3. All primes greater than **3** can be written in the form **6k&#177;1**.
4. Any number **n** can have only one primefactor greater than **&#8730;n**.
5. The consequence for primality testing of a number **n** is: if we cannot find a number **f** less than
     or equal **&#8730;n** that divides **n** then **n** is prime: the only primefactor of **n** is **n** itself
     
**Complexity** _O_(&#8730;n)
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#isPrime" | downcase }})

**Sources** 
- [Project Euler: Problem 7](https://projecteuler.net/problem=7)
- [Project Euler: Problem 7 overview](https://projecteuler.net/overview=007)

**Using**
```scala
import com.github.artemkorsakov.primes.Primes._

val res = 1000999.isPrime
// res0: Boolean = true
```

---
