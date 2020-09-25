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
```scala
import com.github.artemkorsakov.str.NumbersDescription._

val res0 = 1435.inEnglish
// res0: Option[String] = Some(one thousand four hundred and thirty-five)

val res1 = 999999.inEnglish
// res1: Option[String] = Some(nine hundred and ninety-nine thousand nine hundred and ninety-nine)
```

---