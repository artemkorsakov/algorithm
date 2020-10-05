---
layout: docs
title: "Realization: Matrix"
parent_link: ../../objects/matrix.html
---

## {{page.title}}

Realizations for [Matrix]({{ page.parent_link }}).

### dot

[Algorithm]({{ page.parent_link }}{{ "#dot" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.objects.Default

  def dot[T](x: Array[Long], y: Array[Long]): Option[Long] =
    if (x.length != y.length) {
      None
    } else {
      Some(x.indices.foldLeft(Default.value[Long])((s, i) => s + x(i) * y(i)))
    }

  def dot[T](x: Array[Double], y: Array[Double]): Option[Double] =
    if (x.length != y.length) {
      None
    } else {
      Some(x.indices.foldLeft(Default.value[Double])((s, i) => s + x(i) * y(i)))
    }

  def dot[T](x: Array[BigInt], y: Array[BigInt]): Option[BigInt] =
    if (x.length != y.length) {
      None
    } else {
      Some(x.indices.foldLeft(Default.value[BigInt])((s, i) => s + x(i) * y(i)))
    }
```

---

### dotMod

[Algorithm]({{ page.parent_link }}{{ "#dotMod" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.objects.Default

  def dotMod(x: Array[Long], y: Array[Long], module: Long): Option[Long] =
    if (x.length != y.length) {
      None
    } else {
      val res = x.indices.foldLeft(Default.value[BigInt])((s, i) => (s + BigInt(x(i)) * BigInt(y(i))) % module)
      Some(((res + module) % module).toLong)
    }
```

---
