---
layout: docs
title: "Realization: Collatz number"
parent_link: ../../numbers/collatz.html
---

## {{page.title}}

Realizations for [Collatz number]({{ page.parent_link }}).

### collatz

[Algorithm]({{ page.parent_link }}{{ "#collatz" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.numbers.CollatzNumber._
import scala.collection.mutable

case class CollatzNumber(n: Int) {
  private val memorize: mutable.Map[Int, Int] = mutable.Map(1 -> 0)

  def collatz: Int = {
    if (!memorize.contains(n)) {
      val steps = if (n % 2 == 0) (n / 2).collatz + 1 else ((3 * n + 1) / 2).collatz + 2
      memorize += (n -> steps)
    }
    memorize(n)
  }
}
```

---
