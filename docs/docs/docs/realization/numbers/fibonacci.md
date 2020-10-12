---
layout: docs
title: "Realization: Fibonacci"
parent_link: ../../numbers/fibonacci.html
---

## {{page.title}}

Realizations for [Fibonacci]({{ page.parent_link }}).

### fibonacci

[Algorithm]({{ page.parent_link }}{{ "#fibonacci-1" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.objects.Matrix._

case class Fibonacci(n: Long) {
  private val PHI: BigDecimal                    = BigDecimal((1.0 + math.sqrt(5.0)) / 2.0)

  def fibonacci: BigInt =
    (PHI.pow(n.toInt) / BigDecimal(math.sqrt(5))).toBigInt
}


```

---

### fibonacciMatrix

[Algorithm]({{ page.parent_link }}{{ "#fibonacciMatrix" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.objects.Matrix._

case class Fibonacci(n: Long) {
  private val fibonacci_matrix: Seq[Seq[BigInt]] = Seq(Seq(1, 1), Seq(1, 0))

  def fibonacciMatrix: Option[Seq[Seq[BigInt]]] =
    fibonacci_matrix.power(n)

  def fibonacciMatrix(module: Long): Option[Seq[Seq[BigInt]]] =
    fibonacci_matrix.powerMod(n, module)
}
```

---
