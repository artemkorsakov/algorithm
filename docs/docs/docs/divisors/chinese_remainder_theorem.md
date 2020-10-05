---
layout: docs
title: "Chinese Remainder T."
full_title: "Chinese Remainder Theorem"
realization_link: ../realization/divisors/chinese_remainder_theorem.html
---

## {{page.full_title}}

[Chinese Remainder Theorem](https://en.wikipedia.org/wiki/Chinese_remainder_theorem).

### solution
Return **n**, such than **n % a<sub>i</sub> = r<sub>i</sub>**.

**Algorithm**
1. Calculate ![formula](http://latex.codecogs.com/svg.latex?M=%7B%5Cdisplaystyle%20%5Cprod%20_%7B%7Bi=1%7D%7D%5E%7Bn%7Da_%7Bi%7D%7D).
2. For all ![f](http://latex.codecogs.com/svg.latex?i%5Cin%20%5C%7B1,2,%5Cdots%20,n%5C%7D) 
find ![f](http://latex.codecogs.com/svg.latex?M_%7Bi%7D=%7B%5Cfrac%20%20M%7Ba_%7Bi%7D%7D%7D).
3. Find ![f](http://latex.codecogs.com/svg.latex?M_%7Bi%7D%5E%7B%7B-1%7D%7D=%7B%5Cfrac%20%201%7BM_%7Bi%7D%7D%7D%7B%5Cbmod%20%20%7Ba_%7Bi%7D%7D%7D).
4. Return result ![f](http://latex.codecogs.com/svg.latex?x=%5Csum%20_%7B%7Bi=1%7D%7D%5E%7Bn%7Dr_%7Bi%7DM_%7Bi%7DM_%7Bi%7D%5E%7B%7B-1%7D%7D%5Cmod%20M).
     
**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#solution" | downcase }})

**Sources** 
- [Chinese Remainder Theorem](https://en.wikipedia.org/wiki/Chinese_remainder_theorem)

**Using**
```scala mdoc
import com.github.artemkorsakov.divisors.ChineseRemainderTheorem._
solution(Array(707, 527), Array(0, 5))
```

---
