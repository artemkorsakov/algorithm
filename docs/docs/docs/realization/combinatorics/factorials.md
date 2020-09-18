---
layout: docs
title: "Realization: Factorials"
parent_link: ../../combinatorics/factorials.html
---

## {{page.title}}

Realizations for [Factorials]({{ page.parent_link }}).

### factorial

[Algorithm]({{ page.parent_link }}{{ "#factorial" | downcase }})

**Realization**
```scala
  def factorial: BigInt = (2 to n).foldLeft(BigInt(1))((f, i) => f * BigInt(i))
```

---