---
layout: docs
title: "Primes"
---

## {{page.title}}

The package ```com.github.artemkorsakov.primes``` contains algorithms for working with [prime numbers](https://en.wikipedia.org/wiki/Prime_number). 

You can use the package, for example, like this:
```scala
import com.github.artemkorsakov.primes.Primes._
import com.github.artemkorsakov.primes.PhiFunction._
import com.github.artemkorsakov.primes.Radicals._

val res0 = 1000999.isPrime
// res0: Boolean = true

val res1 = 1000999.nextPrime
// res1: Long = 1001003

val res2 = isPrimeArray(10)
// res2: Array[Boolean] = Array(false, false, true, true, false, true, false, true, false, false, false)

val res3 = primes(30)
// res3: Array[Int] = Array(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)

val res4 = generatePrimes(10)
// res4: Array[Int] = Array(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)

val res5 = 600851475143L.largestPrimeFactor
// res5: Long = 6857

val res6 = 10965021787L.smallestPrimeFactor
// res6: Long = 104711

val res7 = smallestPrimeFactorArray(10)
// res7: Array[Int] = Array(0, 0, 2, 3, 2, 5, 2, 7, 2, 3, 2)

val res8 = 1000.primeFactorsWithPow
// res8: Map[Long,Long] = Map(2 -> 3, 5 -> 3)

val res9 = 87109.totient
// res9: Long = 79180

val res10 = totientArray(15)
// res10: Array[Long] = Array(0, 1, 1, 2, 2, 4, 2, 6, 4, 6, 4, 10, 4, 12, 6, 8)

val res11 = 504.rad
// res11: Long = 42

val res12 = allRads(20) 
// res12: Array[Int] = Array(0, 1, 2, 3, 2, 5, 6, 7, 2, 3, 10, 11, 6, 13, 14, 15, 2, 17, 6, 19, 10)

val res13 = 21.isSquareFree
// res13: Boolean = true
```