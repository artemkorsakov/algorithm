---
layout: docs
title: "Realization: Operations with strings"
parent_link: ../../str/string_algorithms.html
---

## {{page.title}}

Realizations for [Operations with strings]({{ page.parent_link }}).

### sum

[Algorithm]({{ page.parent_link }}{{ "#sum" | downcase }})

**Realization**
```scala
  def sum(first: String, second: String): String = {
    val first0  = first.replaceAll("\\D", "")
    val second0 = second.replaceAll("\\D", "")
    if (first0.isEmpty || second0.isEmpty) {
      first0 + second0
    } else {
      var sumLast  = first0.last.toString.toInt + second0.last.toString.toInt
      var sumFirst = sum(first0.dropRight(1).mkString, second0.dropRight(1).mkString)
      if (sumLast > 9) {
        sumFirst = sum(sumFirst, "1")
        sumLast -= 10
      }
      sumFirst + sumLast.toString
    }
  }
```

---

### areAnagrams

[Algorithm]({{ page.parent_link }}{{ "#areAnagrams" | downcase }})

**Realization**
```scala
  def areAnagrams(word1: String, word2: String): Boolean =
    (word1.length == word2.length) && word1.toCharArray.sorted.sameElements(word2.toCharArray.sorted)

```

---

### alphabeticalValue

[Algorithm]({{ page.parent_link }}{{ "#alphabeticalValue" | downcase }})

**Realization**
```scala
class StringAlgorithms(str: String) {
  def alphabeticalValue: Int =
    str.replaceAll("\\W", "").toUpperCase().foldLeft(0)((sum, aChar) => sum + (aChar - 'A') + 1)
}
```

---
