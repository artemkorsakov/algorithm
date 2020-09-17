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

### nextPrime
Get next prime number for the given prime number.

**Algorithm**
1. The next prime number is **3** for **2**.
2. The next prime number is **5** for **3**.
3. If the **current number % 3 is 1** then the **next candidate** is **current number + 4** else **current number + 2**.
4. If the **next candidate** is prime then return result else return to step 3.
 
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
1. Create a list of consecutive integers from **2** through **n**: **(2, 3, 4, ..., n)**.
2. Initially, let **p** equal **2**, the smallest prime number.
3. Enumerate the multiples of **p** by counting in increments of **p** from **2p** to **n**, and mark them in the list (these will be **2p**, **3p**, **4p**, ...; the **p** itself should not be marked).
4. Find the smallest number in the list greater than **p** that is not marked. If there was no such number, stop. Otherwise, let **p** now equal this new number (which is the next prime), and repeat from step 3.
5. When the algorithm terminates, the numbers remaining not marked in the list are all the primes below **n**.

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

### primes
All prime numbers from 2 through n.

**Algorithm**
1. Take **isPrimeArray** and filter by **true**

**Complexity** _O_(n log(log n))
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#primes" | downcase }})

**Sources** 

**Using**
```scala
import com.github.artemkorsakov.primes.Primes._

primes(30)
// res0: Array[Int] = Array(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
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
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#generatePrimes" | downcase }})

**Sources** 

**Using**
```scala
import com.github.artemkorsakov.primes.Primes._

generatePrimes(10)
// res0: Array[Int] = Array(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
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
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#largestPrimeFactor" | downcase }})

**Sources** 

**Using**
```scala
import com.github.artemkorsakov.primes.Primes._

600851475143L.largestPrimeFactor
// res0: Long = 6857
```

---

### smallestPrimeFactor
Get the smallest prime factor.

**Algorithm**
1. For all numbers **i** from **2** to **&#8730;n** find first such as **n % i == 0** and return it.

**Complexity** _O_(&#8730;n)
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#smallestPrimeFactor" | downcase }})

**Sources** 

**Using**
```scala
import com.github.artemkorsakov.primes.Primes._

10965021787L.smallestPrimeFactor
// res0: Long = 104711
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
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#smallestPrimeFactorArray" | downcase }})

**Sources** 

**Using**
```scala
import com.github.artemkorsakov.primes.Primes._

smallestPrimeFactorArray(10)
// res0: Array[Int] = Array(0, 0, 2, 3, 2, 5, 2, 7, 2, 3, 2)
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
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#primeFactorsWithPow" | downcase }})

**Sources** 

**Using**
```scala
import com.github.artemkorsakov.primes.Primes._

1000.primeFactorsWithPow
// res0: Map[Long,Long] = Map(2 -> 3, 5 -> 3)

1024.primeFactorsWithPow
// res1: Map[Long,Long] = Map(2 -> 10)
```

---
