---
layout: docs
title: "Realization: Matrix"
parent_link: ../../objects/matrix.html
---

## {{page.title}}

Realizations for [Matrix]({{ page.parent_link }}).

### mul

[Algorithm]({{ page.parent_link }}{{ "#mul" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.objects.GenericOperation._

class MatrixLine[T](x: Seq[T]) {
  def *(y: Seq[T]): Option[T] = mul(y)

  def mul(y: Seq[T]): Option[T] =
    if (x.length != y.length) {
      None
    } else {
      Some(x.indices.foldLeft(zeroT(x.head))((s, i) => addT(s, mulT(x(i), y(i)))))
    }
}
```

---

### mulMod

[Algorithm]({{ page.parent_link }}{{ "#mulMod" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.objects.GenericOperation._

class MatrixLine[T](x: Seq[T]) {
  def mulMod(y: Seq[T], module: T): Option[T] =
    if (x.length != y.length) {
      None
    } else {
      Some(x.indices.foldLeft(zeroT(x.head))((s, i) => modT(addT(s, mulT(x(i), y(i))), module)))
    }
}
```

---

### matrixTranspose

[Algorithm]({{ page.parent_link }}{{ "#matrixTranspose" | downcase }})

**Realization**
```scala
class Matrix[T](a: Seq[Seq[T]]) {
  def matrixTranspose: Seq[Seq[T]] =
    a.head.indices.map(i => a.indices.map(j => a(j)(i)))
}
```

---

### minorMatrix

[Algorithm]({{ page.parent_link }}{{ "#minorMatrix" | downcase }})

**Realization**
```scala
class Matrix[T](a: Seq[Seq[T]]) {
  def minorMatrix(row: Int, column: Int): Option[Seq[Seq[T]]] =
    if (a.isEmpty || a.exists(i => i.length != a.length) || row < 0 || row >= a.length || column < 0 || column >= a.head.length) {
      None
    } else {
      Some(a.indices.filter(_ != row).map(i => a.head.indices.filter(_ != column).map(j => a(i)(j))))
    }
}
```

---

### matrixDeterminant

[Algorithm]({{ page.parent_link }}{{ "#matrixDeterminant" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.objects.GenericOperation._
import com.github.artemkorsakov.objects.Matrix._

class Matrix[T](a: Seq[Seq[T]]) {
  def matrixDeterminant: Option[T] =
    if (a.isEmpty || a.exists(i => i.length != a.length)) {
      None
    } else {
      if (a.length == 1) {
        Some(a.head.head)
      } else {
        Some(a.head.indices.foldLeft(zeroT(a.head.head)) { (sum, i) =>
          val mul = mulT(a.head(i), a.minorMatrix(0, i).get.matrixDeterminant.get)
          if (i % 2 == 0) {
            addT(sum, mul)
          } else {
            subT(sum, mul)
          }
        })
      }
    }
}
```

---
