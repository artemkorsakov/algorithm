---
layout: docs
title: "Realization: Quadratic equation"
parent_link: ../../equations/quadratic_equation.html
---

## {{page.title}}

Realizations for [Quadratic equation]({{ page.parent_link }}).

### solutionsInIntegers

[Algorithm]({{ page.parent_link }}{{ "#solutionsInIntegers" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.operations.CommonOperations._

case class QuadraticEquation(a: Double, b: Double, c: Double) {
  def solutionsInIntegers: Seq[Long] = {
    val d = b * b - 4 * a * c
    if (d < 0 || !d.isSquare)
      Seq.empty[Long]
    else {
      val sqrt = math.round(d.sqrt)
      val den  = 2 * a
      if (sqrt == 0)
        if (b % den == 0) Seq((-b / den).toLong) else Seq.empty[Long]
      else
        ((-b + sqrt) % den == 0, (-b - sqrt) % den == 0) match {
          case (true, true)   => Seq(((-b + sqrt) / den).toLong, ((-b - sqrt) / den).toLong)
          case (true, false)  => Seq(((-b + sqrt) / den).toLong)
          case (false, true)  => Seq(((-b - sqrt) / den).toLong)
          case (false, false) => Seq.empty[Long]
        }
    }
  }
}
```

---

### solutions

[Algorithm]({{ page.parent_link }}{{ "#solutions" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.operations.CommonOperations._

case class QuadraticEquation(a: Double, b: Double, c: Double) {
  def solutions: Seq[Double] = {
    val d = b * b - 4 * a * c
    if (d < 0)
      Seq.empty[Double]
    else {
      val sqrt = math.sqrt(d)
      val den  = 2 * a
      if (sqrt == 0)
        Seq(-b / den)
      else
        Seq((-b + sqrt) / den, (-b - sqrt) / den)
    }
  }
}
```

---

### solutionsInComplexNumbers

[Algorithm]({{ page.parent_link }}{{ "#solutionsInComplexNumbers" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.operations.CommonOperations._
import com.github.artemkorsakov.numbers.ComplexNumber

case class QuadraticEquation(a: Double, b: Double, c: Double) {
  def solutionsInComplexNumbers: Seq[ComplexNumber] = {
    val d = b * b - 4 * a * c
    if (d >= 0)
      solutions.map(ComplexNumber(_, 0.0))
    else {
      val sqrt = math.sqrt(-d)
      val den  = 2 * a
      Seq(ComplexNumber(-b / den, sqrt / den), ComplexNumber(-b / den, -sqrt / den))
    }
  }

  def solutions: Seq[Double] = {
    val d = b * b - 4 * a * c
    if (d < 0)
      Seq.empty[Double]
    else {
      val sqrt = math.sqrt(d)
      val den  = 2 * a
      if (sqrt == 0)
        Seq(-b / den)
      else
        Seq((-b + sqrt) / den, (-b - sqrt) / den)
    }
  }
}
```

---
