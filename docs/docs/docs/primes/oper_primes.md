---
layout: docsplus
title: "Operations with primes"
realization: primes/Primes.scala
---

Common operations with [prime numbers](https://en.wikipedia.org/wiki/Prime_number).

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
     
**Sources** 
- [Project Euler: Problem 7](https://projecteuler.net/problem=7)
- [Project Euler: Problem 7 overview](https://projecteuler.net/overview=007)

**Using**
```scala mdoc
import com.github.artemkorsakov.primes.Primes._
isPrime(1000999)
```

---

### nextPrime
Get next prime number for the given prime number.

**Algorithm**
1. The next prime number is **3** for **2**.
2. The next prime number is **5** for **3**.
3. If the **current number % 3 is 1** then the **next candidate** is **current number + 4** else **current number + 2**.
4. If the **next candidate** is prime then return result else return to step 3.
 
**Complexity**
     
**Sources** 

**Using**
```scala mdoc
nextPrime(1000999)
```

---

### isPrimeArray
All prime numbers from 2 through n as a boolean array.

**Algorithm**
1. Create a list of consecutive integers from **2** through **n**: **(2, 3, 4, ..., n)**.
2. Initially, let **p** equal **2**, the smallest prime number.
3. Enumerate the multiples of **p** by counting in increments of **p** from **2p** to **n**, and mark them in the list (these will be **2p**, **3p**, **4p**, ...; the **p** itself should not be marked).
4. Find the smallest number in the list greater than **p** that is not marked. If there was no such number, stop. Otherwise, let **p** now equal this new number (which is the next prime), and repeat from step 3.
5. When the algorithm terminates, the numbers remaining not marked in the list are all the primes below **n**.

**Complexity** _O_(n log(log n))
     
**Sources** 
- [Sieve of Eratosthenes](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)

**Using**
```scala mdoc
isPrimeArray(5)
```

---

### primes
All prime numbers from 2 through n.

**Algorithm**
1. Take **isPrimeArray** and filter by **true**

**Complexity** _O_(n log(log n))
     
**Sources** 

**Using**
```scala mdoc
primes(30)
```

---

### generatePrimes
Get the given count of primes.

**Algorithm**
1. The result is obvious if **count** is less or equal **2**.
2. If **count** is more than **2** then start with **Array(2, 3)**
3. Starting from **5** check each number of the form **6k&#177;1** whether it is prime.
4. Add to array if it is prime.
5. If array's size is less than **count** return to step 3.

**Complexity** 
     
**Sources** 

**Using**
```scala mdoc
generatePrimes(10)
```

---

### largestPrimeFactor
Get the largest prime factor.

**Algorithm**
1. **max** start from **1**, current **prime** start from **2**.
2. If **prime** is more than **number** return **max**.
3. If **number** is divisible by **prime** then **max** takes the value of **prime**.
4. While **number** is divisible by **prime** **number** is divided by **prime**.
5. **prime** takes the value of the next prime number and return to step 2.

**Complexity** 
     
**Sources** 

**Using**
```scala mdoc
largestPrimeFactor(600851475143L)
```

---

### smallestPrimeFactor
Get the smallest prime factor.

**Algorithm**
1. For all numbers **i** from **2** to **&#8730;n** find first such as **n % i == 0** and return it.

**Complexity** _O_(&#8730;n)
     
**Sources** 

**Using**
```scala mdoc
smallestPrimeFactor(10965021787L)
```

---

### smallestPrimeFactorArray
Returns an array spf where spf(k) is the smallest prime factor of k, valid for 2 &#8804; k &#8804; n.
For example: spf = {0, 0, 2, 3, 2, 5, 2, 7, 2, 3, 2}.

**Algorithm**
1. For all numbers **i** from **2** to **k** if the **smallest prime factor** has not yet been set then set **i**.
2. For all numbers **j** from **i<sup>2</sup>** to **k** by **i** step set the **smallest prime factor** as **i**.
3. Return to step 2.

**Complexity** 
     
**Sources** 

**Using**
```scala mdoc
smallestPrimeFactorArray(10)
```

---

### primeFactorsWithPow
For a given number return all its prime factors with powers.

**Algorithm**
1. Start: **i** is equal to **2**, **n** is equal to **number**.
2. If **i** is prime and **n % i == 0** then let's define **pow** is equal to **0**.
3. While **n % i == 0**, **pow** is incremented and **n** becomes equal to **n/i**.
4. If **n > 1** then **i** is incremented and we return to step 2.

**Complexity** 
     
**Sources** 

**Using**
```scala mdoc
primeFactorsWithPow(1000)
primeFactorsWithPow(1024)
```

---

### goldbach

Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers.
E.g. 28 = 5 + 23. It is one of the most famous facts in number theory that has not been proved to be correct in the general case.
It has been numerically confirmed up to very large numbers (much larger than Scala's Int can represent).

Return the two prime numbers that sum up to a given even integer.

**Algorithm**

**Complexity** 
     
**Sources** 

**Using**
```scala mdoc
goldbach(28)
goldbach(1024)
```

---

### isKPrime
A natural number is called k-prime if it has exactly k prime factors, counted with multiplicity.

**Algorithm**

**Complexity**

**Sources**
- [Codewars: k-Primes](https://www.codewars.com/kata/5726f813c8dcebf5ed000a6b/)

**Using**
```scala mdoc
import com.github.artemkorsakov.primes.Primes._
isKPrime(2627408, 6)
```

---
