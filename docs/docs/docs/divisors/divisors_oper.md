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
```scala mdoc
import com.github.artemkorsakov.divisors.Divisors._
val res0 = gcd(12121212L, 23422344L)
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
```scala mdoc
import com.github.artemkorsakov.divisors.Divisors._
val res1 = gcdex(12121212L, 23422344L)
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
```scala mdoc
import com.github.artemkorsakov.divisors.Divisors._
val res2 = gcdInverse(111, 10)
```

---

### divisors
Returns all divisors of n (more than 1 and less than n).

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#divisors" | downcase }})

**Sources** 

**Using**
```scala mdoc
import com.github.artemkorsakov.divisors.Divisors._
val res3 = 30.divisors
```

---

### sumOfDivisors
Return the sum of the divisors of n.

**Algorithm**
1. If we write 
![formula](http://latex.codecogs.com/svg.latex?n%20=%20%5Cprod_%7Bi=1%7D%5Er%20p_i%5E%7Ba_i%7D) 
where **r = ω(n)** is the number of distinct prime factors of **n**, **p<sub>i</sub>** is the **i**th prime factor, 
and **a<sub>i</sub>** is the maximum power of **p<sub>i</sub>** by which **n** is divisible, then we have:
![formula](http://latex.codecogs.com/svg.latex?%7B%5Cdisplaystyle%20%5Csigma%20_%7B1%7D(n)=%5Cprod%20_%7Bi=1%7D%5E%7Br%7D%7B%5Cfrac%20%7Bp_%7Bi%7D%5E%7B(a_%7Bi%7D&plus;1)%7D-1%7D%7Bp_%7Bi%7D-1%7D%7D.%7D)

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#sumOfDivisors" | downcase }})

**Sources** 
- [Divisor function](https://en.wikipedia.org/wiki/Divisor_function)

**Using**
```scala mdoc
import com.github.artemkorsakov.divisors.Divisors._
val res4 = 220.sumOfDivisors
```

---

### countOfDivisors
Return the count of divisors of n.

**Algorithm**
1. If we write 
![formula](http://latex.codecogs.com/svg.latex?n%20=%20%5Cprod_%7Bi=1%7D%5Er%20p_i%5E%7Ba_i%7D) 
where **r = ω(n)** is the number of distinct prime factors of **n**, **p<sub>i</sub>** is the **i**th prime factor, 
and **a<sub>i</sub>** is the maximum power of **p<sub>i</sub>** by which **n** is divisible, then we have:
![formula](http://latex.codecogs.com/svg.latex?%5Csigma_0(n)=%5Cprod_%7Bi=1%7D%5Er%20(a_i&plus;1)) 

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#countOfDivisors" | downcase }})

**Sources** 
- [Divisor function](https://en.wikipedia.org/wiki/Divisor_function)

**Using**
```scala mdoc
import com.github.artemkorsakov.divisors.Divisors._
val res5 = 100.countOfDivisors
```

---
