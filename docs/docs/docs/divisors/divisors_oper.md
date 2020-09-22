---
layout: docs
title: "Operations with divisors"
realization_link: ../realization/divisors/divisors_oper.html
---

## {{page.title}}

Common operations with divisors.

### gcd
Return the [greatest common divisor](https://en.wikipedia.org/wiki/Greatest_common_divisor).

**Algorithm**
1. **gcd(0, v) = v**, because everything divides zero, and **v** is the largest number that divides **v**. 
Similarly, **gcd(u, 0) = u**.
2. **gcd(2u, 2v) = 2·gcd(u, v)**
3. **gcd(2u, v) = gcd(u, v)**, if **v** is odd (**2** is not a common divisor). 
Similarly, **gcd(u, 2v) = gcd(u, v)** if **u** is odd.
4. **gcd(u, v) = gcd(abs(u − v), min(u, v))**, if **u** and **v** are both odd.

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#gcd" | downcase }})

**Sources** 
- [Binary GCD algorithm](https://en.wikipedia.org/wiki/Binary_GCD_algorithm)

**Using**
```scala
import com.github.artemkorsakov.divisors.Divisors._

val res0 = gcd(12121212L, 23422344L)
// res0: Long = 12
```

---

### gcdex
In arithmetic and computer programming, 
[the extended Euclidean algorithm](https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm) is an extension 
to the Euclidean algorithm, and computes, in addition to the greatest common divisor of integers a and b, 
also the coefficients of Bézout's identity, which are integers x and y such that
![formula](http://latex.codecogs.com/svg.latex?ax&plus;by=%5Cgcd(a,b).)

The result is a tuple **(gcd(a,b), x, y)**

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#gcdex" | downcase }})

**Sources** 
- [Extended Euclidean algorithm](https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm)

**Using**
```scala
import com.github.artemkorsakov.divisors.Divisors._

val res0 = gcdex(12121212L, 23422344L)
// res0: (Long, Long, Long) = (12,347845,-180012)
// 347845*12121212 + (-180012)*23422344 = 12
```

---

### gcdInverse
In mathematics, particularly in the area of number theory, 
[a modular multiplicative inverse](https://en.wikipedia.org/wiki/Modular_multiplicative_inverse) 
of an integer **a** is an integer **x** such that the product **ax** is congruent to 1 with respect to the modulus **m**.
In the standard notation of modular arithmetic this congruence is written as
![formula](http://latex.codecogs.com/svg.latex?ax%20%5Cequiv%201%20%5Cpmod%7Bm%7D)

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#gcdInverse" | downcase }})

**Sources** 
- [Modular multiplicative inverse](https://en.wikipedia.org/wiki/Modular_multiplicative_inverse)

**Using**
```scala
import com.github.artemkorsakov.divisors.Divisors._

val res0 = gcdInverse(111, 10)
// res0: Long = 1
```

---

