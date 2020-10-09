---
layout: docs
title: "Realization: Matrix"
parent_link: ../../objects/matrix.html
---

## {{page.title}}

Realizations for [Matrix]({{ page.parent_link }}).

### mulRows

[Algorithm]({{ page.parent_link }}{{ "#mulRows" | downcase }})

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

### add

[Algorithm]({{ page.parent_link }}{{ "#add" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.objects.GenericOperation._

class Matrix[T](a: Seq[Seq[T]]) {
  def +(b: Seq[Seq[T]]): Option[Seq[Seq[T]]] = add(b)

  def add(b: Seq[Seq[T]]): Option[Seq[Seq[T]]] =
    if (a.length != b.length || a.indices.exists(i => a(i).length != b(i).length))
      None
    else
      Some(a.indices.map(i => a(i).indices.map(j => addT(a(i)(j), b(i)(j)))))
}
```

---

### mulByNum

[Algorithm]({{ page.parent_link }}{{ "#mulByNum" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.objects.GenericOperation._

class Matrix[T](a: Seq[Seq[T]]) {
  def *(b: T): Seq[Seq[T]] = mul(b)

  def mul(b: T): Seq[Seq[T]] =
    a.indices.map(i => a(i).indices.map(j => mulT(a(i)(j), b)))
    
  def mulMod(b: T, module: T): Seq[Seq[T]] =
    a.indices.map(i => a(i).indices.map(j => modT(mulT(a(i)(j), b), module)))
}
```

---

### mulMatrix

[Algorithm]({{ page.parent_link }}{{ "#mulMatrix" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.objects.GenericOperation._
import com.github.artemkorsakov.objects.MatrixLine._
import com.github.artemkorsakov.objects.Matrix._
import cats.implicits._

class Matrix[T](a: Seq[Seq[T]]) {
  def *(b: Seq[Seq[T]]): Option[Seq[Seq[T]]] = mul(b)

  def mul(b: Seq[Seq[T]]): Option[Seq[Seq[T]]] =
    if (
      a.isEmpty || b.isEmpty || a
        .exists(_.length != a.head.length) || b.exists(_.length != b.head.length) || a.head.length != b.length
    )
      None
    else
      a.indices
        .map(i => b.head.indices.map(j => a(i).mul(b.indices.map(k => b(k)(j)))).toList.traverse(identity))
        .toList
        .traverse(identity)
        
  def mulMod(b: Seq[Seq[T]], module: T): Option[Seq[Seq[T]]] =
    if (
      a.isEmpty || b.isEmpty || a
        .exists(_.length != a.head.length) || b.exists(_.length != b.head.length) || a.head.length != b.length
    )
      None
    else
      a.indices
        .map(i => b.head.indices.map(j => a(i).mulMod(b.indices.map(k => b(k)(j)), module)).toList.traverse(identity))
        .toList
        .traverse(identity)
}
```

---

### mulMatrixByRow

[Algorithm]({{ page.parent_link }}{{ "#mulMatrixByRow" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.objects.Matrix._
import com.github.artemkorsakov.objects.MatrixLine._
import cats.implicits._

class Matrix[T](a: Seq[Seq[T]]) {
  def *(b: MatrixLine[T]): Option[Seq[T]] = mul(b)

  def mul(b: MatrixLine[T]): Option[Seq[T]] =
    for {
      seq <- mul(b.x.map(Seq(_)))
    } yield seq.map(s => s.head)

  def mulMod(b: MatrixLine[T], module: T): Option[Seq[T]] =
    for {
      seq <- mulMod(b.x.map(Seq(_)), module)
    } yield seq.map(s => s.head)
    
  def mul(b: Seq[Seq[T]]): Option[Seq[Seq[T]]] =
    if (
      a.isEmpty || b.isEmpty || a
        .exists(_.length != a.head.length) || b.exists(_.length != b.head.length) || a.head.length != b.length
    )
      None
    else
      a.indices
        .map(i => b.head.indices.map(j => a(i).mul(b.indices.map(k => b(k)(j)))).toList.traverse(identity))
        .toList
        .traverse(identity)
        
  def mulMod(b: Seq[Seq[T]], module: T): Option[Seq[Seq[T]]] =
    if (
      a.isEmpty || b.isEmpty || a
        .exists(_.length != a.head.length) || b.exists(_.length != b.head.length) || a.head.length != b.length
    )
      None
    else
      a.indices
        .map(i => b.head.indices.map(j => a(i).mulMod(b.indices.map(k => b(k)(j)), module)).toList.traverse(identity))
        .toList
        .traverse(identity)
}

case class MatrixLine[T](x: Seq[T]) {
  def *(b: Matrix[T]): Option[Seq[T]] = mul(b)

  def mul(b: Matrix[T]): Option[Seq[T]] =
    for {
      seq <- toMatrix.mul(Seq(x))
    } yield seq.head

  def mulMod(b: Matrix[T], module: T): Option[Seq[T]] =
    for {
      seq <- toMatrix.mulMod(Seq(x), module)
    } yield seq.head
    
  def toMatrix: Matrix[T] = new Matrix[T](Seq(x))
}
```

---

### power

[Algorithm]({{ page.parent_link }}{{ "#power" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.objects.Matrix._
import com.github.artemkorsakov.objects.MatrixLine._
import cats.implicits._
import com.github.artemkorsakov.objects.GenericOperation._

class Matrix[T](a: Seq[Seq[T]]) {
  def power(b: Long): Option[Seq[Seq[T]]] =
    if (b < 1)
      None
    else if (b == 1)
      Some(a)
    else {
      val powers  = b.toBinaryString
      val powersC = new Array[Seq[Seq[T]]](powers.length)
      powersC(0) = a
      (1 until powers.length).foreach { i =>
        for {
          mul <- powersC(i - 1) * powersC(i - 1)
        } yield powersC(i) = mul
      }
      var c = powersC.last
      (1 until powers.length).filter(powers(_) == '1').foreach { i =>
        for {
          mul <- c * powersC(powersC.length - 1 - i)
        } yield c = mul
      }
      Some(c)
    }

  def powerMod(b: Long, module: T): Option[Seq[Seq[T]]] =
    if (b < 1)
      None
    else if (b == 1)
      Some(a.map(_.map(modT(_, module))))
    else {
      val powers  = b.toBinaryString
      val powersC = new Array[Seq[Seq[T]]](powers.length)
      powersC(0) = a
      (1 until powers.length).foreach { i =>
        for {
          mul <- powersC(i - 1).mulMod(powersC(i - 1), module)
        } yield powersC(i) = mul
      }
      var c = powersC.last
      (1 until powers.length).filter(powers(_) == '1').foreach { i =>
        for {
          mul <- c.mulMod(powersC(powersC.length - 1 - i), module)
        } yield c = mul
      }
      Some(c)
    }
}
```

---