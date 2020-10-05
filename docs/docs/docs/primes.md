---
layout: docs
title: "Primes"
---

## {{page.title}}

The package ```com.github.artemkorsakov.primes``` contains algorithms for working with [prime numbers](https://en.wikipedia.org/wiki/Prime_number). 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.primes.Primes._
1000999.isPrime
1000999.nextPrime
isPrimeArray(6)
primes(10)
generatePrimes(10)
600851475143L.largestPrimeFactor
10965021787L.smallestPrimeFactor
smallestPrimeFactorArray(10)
1000.primeFactorsWithPow
```
```scala mdoc
import com.github.artemkorsakov.primes.PhiFunction._
87109.totient
totientArray(10)
```
```scala mdoc
import com.github.artemkorsakov.primes.Radicals._
504.rad
allRads(10) 
21.isSquareFree
```