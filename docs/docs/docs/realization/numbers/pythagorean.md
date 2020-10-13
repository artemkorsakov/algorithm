---
layout: docs
title: "Realization: Pythagorean triplet"
parent_link: ../../numbers/pythagorean.html
---

## {{page.title}}

Realizations for [Pythagorean triplet]({{ page.parent_link }}).

### figurateNumbers

[Algorithm]({{ page.parent_link }}{{ "#figurateNumbers" | downcase }})

**Realization**
```scala
import scala.math._

  case class TriangleFiguralNumber(n: Long) {
    def triangleNumber: Long =
      n * (n + 1) / 2

    def isTriangle: Boolean = {
      val possible = -1.0 / 2.0 + sqrt(2.0 * n + 1.0 / 4.0)
      abs(possible - round(possible)) < 1e-10
    }
  }

```

---
