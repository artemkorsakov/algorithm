---
layout: docs
title: "Palindrome"
realization_link: ../realization/numbers/palindrome.html
---

## {{page.title}}

[Palindrome](https://en.wikipedia.org/wiki/Palindrome).

### isPalindrome
Is the given number a palindrome?

Is the given number a palindrome in the base **n** system?

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#isPalindrome" | downcase }})

**Sources** 

**Using**
```scala mdoc
import com.github.artemkorsakov.numbers.Palindrome._
BigInt("4668731596684224866951378664").isPalindrome
4994.isPalindrome
4994.isPalindrome(2)
15.isPalindrome(2)
26.isPalindrome(3)
63.isPalindrome(4)
```

---
