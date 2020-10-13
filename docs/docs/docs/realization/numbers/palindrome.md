---
layout: docs
title: "Realization: Palindrome"
parent_link: ../../numbers/palindrome.html
---

## {{page.title}}

Realizations for [Palindrome]({{ page.parent_link }}).

### isPalindrome

[Algorithm]({{ page.parent_link }}{{ "#isPalindrome" | downcase }})

**Realization**
```scala
case class Palindrome(number: BigInt) {
  def isPalindrome: Boolean =
    isPalindrome(10)

  def isPalindrome(base: Int): Boolean =
    number == reversed(base)

  private def reversed(base: Int): BigInt = {
    var reversed = BigInt(0)
    var k        = number
    while (k > 0) {
      reversed = base * reversed + k % base
      k /= base
    }
    reversed
  }
}
```

---
