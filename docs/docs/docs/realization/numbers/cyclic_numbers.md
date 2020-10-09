---
layout: docs
title: "Realization: Cyclic numbers"
parent_link: ../../numbers/cyclic_numbers.html
---

## {{page.title}}

Realizations for [Cyclic numbers]({{ page.parent_link }}).

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

  case class SquareFiguralNumber(n: Long) {
    def squareNumber: Long =
      n * n

    def isSquare: Boolean = {
      val possible = sqrt(n.toDouble)
      abs(possible - round(possible)) < 1e-10
    }
  }

  case class PentagonalFiguralNumber(n: Long) {
    def pentagonalNumber: Long =
      n * (3 * n - 1) / 2

    def isPentagonal: Boolean = {
      val possible = 1.0 / 6.0 + sqrt(2.0 * n / 3.0 + 1.0 / 36.0)
      abs(possible - round(possible)) < 1e-10
    }
  }

  case class HexagonalFiguralNumber(n: Long) {
    def hexagonalNumber: Long =
      n * (2 * n - 1)

    def isHexagonal: Boolean = {
      val possible = 1.0 / 4.0 + sqrt(n / 2.0 + 1.0 / 16.0)
      abs(possible - round(possible)) < 1e-10
    }
  }

  case class HeptagonalFiguralNumber(n: Long) {
    def heptagonalNumber: Long =
      n * (5 * n - 3) / 2

    def isHeptagonal: Boolean = {
      val possible = 3.0 / 10.0 + sqrt(2.0 * n / 5.0 + 9.0 / 100.0)
      abs(possible - round(possible)) < 1e-10
    }
  }

  case class OctagonalFiguralNumber(n: Long) {
    def octagonalNumber: Long =
      n * (3 * n - 2)

    def isOctagonal: Boolean = {
      val possible = 1.0 / 3.0 + sqrt(n / 3.0 + 1.0 / 9.0)
      abs(possible - round(possible)) < 1e-10
    }
  }
```

---
