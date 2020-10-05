---
layout: docs
title: "Coins"
realization_link: ../realization/combinatorics/coins.html
---

## {{page.title}}

### countWays
In the United Kingdom the currency is made up of pound (£) and pence (p). 
There are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
It is possible to make £2 in the following way:

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p

How many different ways can £2 be made using any number of coins?

**Algorithm**
1. Let's define **ways** as an array of numbers where **ways(0) = 1**.
2. For each **coin** for each **i** from **coin** to **sum** let's calculate **ways(i)** as **ways(i) + ways(i - coin)**.
3. Return **ways(sum)**.


**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#countWays" | downcase }})

**Sources** 
- [Project Euler: Coin sums](https://projecteuler.net/problem=31)
- [Project Euler: Coin sums (overview)](https://projecteuler.net/overview=031)

**Using**
```scala mdoc
import com.github.artemkorsakov.combinatorics.Coins._
val res0 = countWays(Array(1, 2, 5, 10, 20, 50, 100, 200), 200)
```

---

### partition
In number theory and combinatorics, a [partition](https://en.wikipedia.org/wiki/Partition_(number_theory)) 
of a positive integer n, also called an integer partition, is a way of writing n as a sum of positive integers. 
Two sums that differ only in the order of their summands are considered the same partition. 
(If order matters, the sum becomes a composition.) 

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#partition" | downcase }})

**Sources** 
- [Wikipedia](https://en.wikipedia.org/wiki/Partition_(number_theory))

**Using**
```scala mdoc
import com.github.artemkorsakov.combinatorics.Coins._
val res1 = 1000.partition
```

---

### optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers
How many options to get sum as a sum of at least two positive numbers?

**Algorithm**
1. **sum.partition - 1**.

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers" | downcase }})

**Sources** 

**Using**
```scala mdoc
import com.github.artemkorsakov.combinatorics.Coins._
val res2 = optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(100)
```

---