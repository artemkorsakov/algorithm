---
layout: docs
title: "Realization: Hamming number"
parent_link: ../../numbers/hamming.html
---

## {{page.title}}

Realizations for [Hamming number]({{ page.parent_link }}).

### isHammingNumber

[Algorithm]({{ page.parent_link }}{{ "#isHammingNumber" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.primes.Primes.primes

 case class HammingNumber(number: Long) {
   def isHammingNumber(n: Int): Boolean =
     if (number < 2 || number <= n)
       true
     else if (n < 2)
       false
     else {
       var temp       = number
       val primesList = primes(n)
       var isHamming  = false
       var i          = 0
       while (i < primesList.length && !isHamming) {
         val prime = primesList(i)
         while (temp % prime == 0)
           temp /= prime
         if (temp == 1)
           isHamming = true
         i += 1
       }
       isHamming
     }
 }
```

---
