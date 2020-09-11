---
layout: docs
title: "Operations with primes"
---

# {{page.title}}

Common operations with prime numbers.

### isPrime
_Determines if the given integer is prime._

**Sources** 
- [Project Euler: Problem 7](https://projecteuler.net/problem=7)
- [Project Euler: Problem 7 overview](https://projecteuler.net/overview=007)

**Algorithm**
- A prime number greater than 1.
- All primes except 2 are odd.
- All primes greater than 3 can be written in the form 6*k*&#177;1.
- Any number n can have only one primefactor greater than &#8730;n.
- The consequence for primality testing of a number n is: if we cannot find a number f less than
     or equal &#8730;n that divides n then n is prime: the only primefactor of n is n itself
    
**Using:**
```scala
import com.github.artemkorsakov.primes.Primes._

val res = 1000999.isPrime
// res: Boolean = true
```
