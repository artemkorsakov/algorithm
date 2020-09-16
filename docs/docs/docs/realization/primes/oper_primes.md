---
layout: docs
title: "Realization: Operations with primes"
parent_link: ../../primes/oper_primes.html
---

## {{page.title}}

Realizations for [Operations with primes]({{ page.parent_link }}).

### isPrime

[Algorithm]({{ page.parent_link }}{{ "#isPrime" | downcase }})

**Realization**
```scala
  def isPrime: Boolean =
    if (n < 2) false
    else if (n < 4) true
    else if (n % 2 == 0) false
    else if (n < 9) true
    else if (n % 3 == 0) false
    else {
      val sqrt      = math.sqrt(n.toDouble).toLong
      var candidate = 5
      while (candidate <= sqrt && n % candidate != 0) candidate += (if (candidate % 6 == 5) 2 else 4)
      n % candidate != 0
    }
```

---

### nextPrime

[Algorithm]({{ page.parent_link }}{{ "#nextPrime" | downcase }})

**Realization**
```scala
  def nextPrime: Long =
    if (n == 2) {
      3
    } else if (n == 3) {
      5
    } else {
      var nextPrime = if (n % 3 == 1) n + 4 else n + 2
      while (!nextPrime.isPrime) {
        nextPrime = if (nextPrime % 3 == 1) nextPrime + 4 else nextPrime + 2
      }
      nextPrime
    }
```

---

### isPrimeArray

[Algorithm]({{ page.parent_link }}{{ "#isPrimeArray" | downcase }})

**Realization**
```scala
  def isPrimeArray(n: Int): Array[Boolean] = {
    val result = Array.fill(n + 1)(true)
    result(0) = false
    result(1) = false

    var i  = 2
    var i2 = i * i
    while (i2 <= n) {
      if (result(i)) {
        (i2 to n by i).foreach(j => result(j) = false)
      }
      i += 1
      i2 = i * i
    }
    result
  }
```

---

### primes

[Algorithm]({{ page.parent_link }}{{ "#primes" | downcase }})

**Realization**
```scala
  def primes(n: Int): Array[Int] =
    isPrimeArray(n).zipWithIndex.filter(_._1).map(_._2)
```

---

### generatePrimes

[Algorithm]({{ page.parent_link }}{{ "#generatePrimes" | downcase }})

**Realization**
```scala
  def generatePrimes(count: Int): Array[Int] =
    if (count <= 0) {
      Array.empty[Int]
    } else if (count == 1) {
      Array(2)
    } else if (count == 2) {
      Array(2, 3)
    } else {
      val result = new Array[Int](count)
      result(0) = 2
      result(1) = 3

      var candidate = 5
      var tempCount = 2
      while (tempCount < count) {
        if (candidate.isPrime) {
          result(tempCount) = candidate
          tempCount += 1
        }
        candidate += 2
        if (tempCount < count && candidate.isPrime) {
          result(tempCount) = candidate
          tempCount += 1
        }
        candidate += 4
      }

      result
    }
```

---

### largestPrimeFactor

[Algorithm]({{ page.parent_link }}{{ "#largestPrimeFactor" | downcase }})

**Realization**
```scala
  def largestPrimeFactor: Long = {
    var max    = 1L
    var i      = 2L
    var number = n
    while (i <= number) {
      if (number % i == 0) {
        max = i
        while (number % i == 0) {
          number /= i
        }
      }
      i = i.nextPrime
    }

    max
  }
```

---

### smallestPrimeFactor

[Algorithm]({{ page.parent_link }}{{ "#smallestPrimeFactor" | downcase }})

**Realization**
```scala
  def smallestPrimeFactor: Long =
    (2L to math.sqrt(n.toDouble).toLong).find(n % _ == 0).getOrElse(n)
```

---

### smallestPrimeFactorArray

[Algorithm]({{ page.parent_link }}{{ "#smallestPrimeFactorArray" | downcase }})

**Realization**
```scala
  def smallestPrimeFactorArray(count: Int): Array[Int] = {
    val result = new Array[Int](count + 1)

    val limit = math.sqrt(count.toDouble).toInt
    for (i <- 2 until result.length) {
      if (result(i) == 0) {
        result(i) = i
        if (i <= limit) {
          for (j <- i * i to count by i) {
            if (result(j) == 0) {
              result(j) = i
            }
          }
        }
      }
    }

    result
  }
```

---
