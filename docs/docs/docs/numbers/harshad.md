---
layout: docs
title: "Harshad number"
realization_link: ../realization/numbers/harshad.html
---

## {{page.title}}

[A harshad number](https://en.wikipedia.org/wiki/Harshad_number) is an integer that is divisible by the sum of its digits.

A strong Harshad number is a harshad number that, when divided by the sum of its digits, results in a prime.

### isHarshadNumber
[A harshad number](https://en.wikipedia.org/wiki/Harshad_number) is an integer that is divisible by the sum of its digits.

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#isHarshadNumber" | downcase }})

**Sources** 

**Using**
```scala mdoc
import com.github.artemkorsakov.numbers.HarshadNumber._
1728.isHarshadNumber
1729.isHarshadNumber
1730.isHarshadNumber
```

---

### isStrongHarshadNumber
A strong Harshad number is a harshad number that, when divided by the sum of its digits, results in a prime.

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#isStrongHarshadNumber" | downcase }})

**Sources** 

**Using**
```scala mdoc
198.isStrongHarshadNumber
1728.isStrongHarshadNumber
1729.isStrongHarshadNumber
```

---

### getStrongRightTruncatableHarshadPrimes
A Harshad or Niven number is a number that is divisible by the sum of its digits.
201 is a Harshad number because it is divisible by 3 (the sum of its digits.)
When we truncate the last digit from 201, we get 20, which is a Harshad number.
When we truncate the last digit from 20, we get 2, which is also a Harshad number.
Let's call a Harshad number that, while recursively truncating the last digit, always results in a Harshad number a right truncatable Harshad number.

Also:
201/3=67 which is prime.
Let's call a Harshad number that, when divided by the sum of its digits, results in a prime a strong Harshad number.

Now take the number 2011 which is prime.
When we truncate the last digit from it we get 201, a strong Harshad number that is also right truncatable.
Let's call such primes strong, right truncatable Harshad primes.

Return all strong, right truncatable Harshad primes less than 10<sup>p</sup>.

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#getStrongRightTruncatableHarshadPrimes" | downcase }})

**Sources** 
- [Project Euler. Problem 387](https://projecteuler.net/problem=387)

**Using**
```scala mdoc
getStrongRightTruncatableHarshadPrimes(3)
getStrongRightTruncatableHarshadPrimes(4).sum
```

---
