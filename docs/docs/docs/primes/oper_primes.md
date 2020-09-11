---
layout: docs
title: "Operations with primes"
---

## {{page.title}}

Description {{page.title}}.

#### isPrime
##### Determines if the given integer is prime.

Source of the algorithm - https://projecteuler.net/problem=7, https://projecteuler.net/overview=007 

Some useful facts:
  - A prime number greater than 1.
  - All primes except 2 are odd.
  - All primes greater than 3 can be written in the form 6k+/-1.
  - Any number n can have only one primefactor greater than &#8730;n.
  - The consequence for primality testing of a number n is: if we cannot find a number f less than
     or equal &#8730;n that divides n then n is prime: the only primefactor of n is n itself
    

Using:
```scala
import com.github.artemkorsakov.primes.Primes._

val res = 1000999.isPrime
// res: Boolean = true
```
