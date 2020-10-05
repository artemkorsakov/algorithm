---
layout: docs
title: "Primes"
---

## {{page.title}}

The package ```com.github.artemkorsakov.primes``` contains algorithms for working with [prime numbers](https://en.wikipedia.org/wiki/Prime_number). 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.primes.Primes._
import com.github.artemkorsakov.primes.PhiFunction._
import com.github.artemkorsakov.primes.Radicals._
val res0 = 1000999.isPrime
val res1 = 1000999.nextPrime
val res2 = isPrimeArray(6)
val res3 = primes(10)
val res4 = generatePrimes(10)
val res5 = 600851475143L.largestPrimeFactor
val res6 = 10965021787L.smallestPrimeFactor
val res7 = smallestPrimeFactorArray(10)
val res8 = 1000.primeFactorsWithPow
val res9 = 87109.totient
val res10 = totientArray(10)
val res11 = 504.rad
val res12 = allRads(10) 
val res13 = 21.isSquareFree
```