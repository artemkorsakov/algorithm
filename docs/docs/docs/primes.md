---
layout: docs
title: "Primes"
---

## {{page.title}}

The package ```com.github.artemkorsakov.primes``` contains algorithms for working with [prime numbers](https://en.wikipedia.org/wiki/Prime_number). 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.primes.Primes._
isPrime(1000999)
nextPrime(1000999)
isPrimeArray(6)
primes(10)
generatePrimes(10)
largestPrimeFactor(600851475143L)
smallestPrimeFactor(10965021787L)
smallestPrimeFactorArray(10)
primeFactorsWithPow(1000)
goldbach(1024)
isKPrime(2627408, 6)
```
```scala mdoc
import com.github.artemkorsakov.primes.PhiFunction._
totient(87109)
totientArray(10)
```
```scala mdoc
import com.github.artemkorsakov.primes.Radicals._
rad(504)
allRads(10) 
isSquareFree(21)
```