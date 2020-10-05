---
layout: docs
title: "Numbers description"
realization_link: ../realization/str/numbers_description.html
---

## {{page.title}}

Number description in different languages.

### inEnglish
Number description [in English](https://en.wikipedia.org/wiki/English_numerals).

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#inEnglish" | downcase }})

**Sources** 
- [English numerals](https://en.wikipedia.org/wiki/English_numerals)

**Using**
```scala mdoc
import com.github.artemkorsakov.str.NumbersDescription._
val res0 = 1435.inEnglish
val res1 = 999999.inEnglish
```

---

### inRussian
Number description in Russian.

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#inRussian" | downcase }})

**Sources** 

**Using**
```scala mdoc:to-string
import com.github.artemkorsakov.str.NumbersDescription._
val res2 = 11011435.inRussian
val res3 = 999999.inRussian
```

---
