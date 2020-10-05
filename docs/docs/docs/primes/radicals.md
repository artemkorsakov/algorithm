---
layout: docs
title: "Radicals"
realization_link: ../realization/primes/radicals.html
---

## {{page.title}}

In number theory, [the radical of a positive integer n](https://en.wikipedia.org/wiki/Radical_of_an_integer) is defined as the product of the distinct prime numbers dividing n. Each prime factor of n occurs exactly once as a factor of this product:

![formula](http://latex.codecogs.com/svg.latex?%5Cdisplaystyle%20%7B%5Cmathrm%20%20%7Brad%7D%7D(n)=%5Cprod%20_%7B%7B%5Cscriptstyle%20p%5Cmid%20n%20%5Catop%20p%7B%5Ctext%7B%20prime%7D%7D%7D%7Dp)

For example, 504 = 2<sup>3</sup> × 3<sup>2</sup> × 7, so rad(504) = 2 × 3 × 7 = 42.

### rad
Return the product of distinct prime factors of n.

**Algorithm**
1. Formula: ![formula](http://latex.codecogs.com/svg.latex?%5Cdisplaystyle%20%7B%5Cmathrm%20%20%7Brad%7D%7D(n)=%5Cprod%20_%7B%7B%5Cscriptstyle%20p%5Cmid%20n%20%5Catop%20p%7B%5Ctext%7B%20prime%7D%7D%7D%7Dp)
     
**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#rad" | downcase }})

**Sources** 
- [wiki: Radical of an integer](https://en.wikipedia.org/wiki/Radical_of_an_integer)

**Using**
```scala mdoc
import com.github.artemkorsakov.primes.Radicals._
val res = 504.rad
```

---

### allRads
Return array of products of distinct prime factors of any n not more limit.

**Algorithm**
1. Let's take an array of all prime numbers not exceeding the **limit**.
2. For each prime number **p** take all numbers from **1** to **limit / p**.
3. For each number **i** use formula: ![formula](http://latex.codecogs.com/svg.latex?%7B%5Cdisplaystyle%20rads%20(i*p)=%7B%5Cbegin%7Bcases%7Dp&%7B%5Ctext%7B%20if%20%7D%7Drads(i%20*%20p)%20=%200%5C%5Crads(i%20*%20p)%20*%20p&%7B%5Ctext%7B%20else%20%7D%7D%5Cend%7Bcases%7D%7D%7D)
   
**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#allRads" | downcase }})

**Sources** 

**Using**
```scala mdoc:reset
import com.github.artemkorsakov.primes.Radicals._
val res = allRads(10) 
```

---

### isSquareFree
Return `true` if number is [a square-free integer](https://en.wikipedia.org/wiki/Square-free_integer).

**Algorithm**
1. Find first prime number **p** from **2** to **&#8730;n** such as **n % p<sup>2</sup> = 0**.
   
**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#isSquareFree" | downcase }})

**Sources** 

**Using**
```scala mdoc
import com.github.artemkorsakov.primes.Radicals._
val res0 = 20.isSquareFree
val res1 = 21.isSquareFree
```

---