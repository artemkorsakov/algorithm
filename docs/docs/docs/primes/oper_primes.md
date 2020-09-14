---
layout: docs
title: "Operations with primes"
realization_link: ../realization/primes/oper_primes.html
---

## {{page.title}}

Common operations with [prime numbers](https://en.wikipedia.org/wiki/Prime_number).

### isPrime
Determines if the given integer is prime.

**Algorithm**
1. A prime number greater than 1.
2. All primes except 2 are odd.
3. All primes greater than 3 can be written in the form 6*k*&#177;1.
4. Any number n can have only one primefactor greater than &#8730;n.
5. The consequence for primality testing of a number n is: if we cannot find a number f less than
     or equal &#8730;n that divides n then n is prime: the only primefactor of n is n itself
     
**Complexity** _O(&#8730;n)_
     
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

### nextPrime
Get next prime number for the given prime number.

**Algorithm**
1. The next prime number is 3 for 2.
2. The next prime number is 5 for 3.
3. If the current number % 3 is 1 then the next candidate is current number + 4 else current number + 2.
4. If the next candidate is prime then return result else return to point 3.
 
**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#nextPrime" | downcase }})

**Sources** 

**Using**
```scala
import com.github.artemkorsakov.primes.Primes._

val res = 1000999.nextPrime
// res0: Long = 1001003
```

---

### isPrimeArray
All prime numbers from 2 through n as a boolean array.

**Algorithm**
1. Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
2. Initially, let p equal 2, the smallest prime number.
3. Enumerate the multiples of p by counting in increments of p from 2p to n, and mark them in the list (these will be 2p, 3p, 4p, ...; the p itself should not be marked).
4. Find the smallest number in the list greater than p that is not marked. If there was no such number, stop. Otherwise, let p now equal this new number (which is the next prime), and repeat from step 3.
5. When the algorithm terminates, the numbers remaining not marked in the list are all the primes below n.

**Complexity** _O_(n log(log n))
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#isPrimeArray" | downcase }})

**Sources** 
- [Sieve of Eratosthenes](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)

**Using**
```scala
import com.github.artemkorsakov.primes.Primes._

isPrimeArray(10)
// res0: Array[Boolean] = Array(false, false, true, true, false, true, false, true, false, false, false)
```

---
