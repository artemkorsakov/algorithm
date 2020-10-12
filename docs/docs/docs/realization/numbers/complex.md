---
layout: docs
title: "Realization: Complex number"
parent_link: ../../numbers/complex.html
---

## {{page.title}}

Realizations for [Complex number]({{ page.parent_link }}).

### complexOperations

[Algorithm]({{ page.parent_link }}{{ "#complexOperations" | downcase }})

**Realization**
```scala
case class ComplexNumber(a: Double, b: Double) {
  def this(x: Int, y: Int) = this(x.toDouble, y.toDouble)
  def this(x: Int) = this(x.toDouble, 0.0)
  def this(x: Long, y: Long) = this(x.toDouble, y.toDouble)
  def this(x: Long) = this(x.toDouble, 0.0)
  def this(r: ComplexNumber) = this(r.a, r.b)

  def +(cn: ComplexNumber): ComplexNumber = add(cn)
  def add(cn: ComplexNumber): ComplexNumber =
    ComplexNumber(a + cn.a, b + cn.b)

  def -(cn: ComplexNumber): ComplexNumber = sub(cn)
  def sub(cn: ComplexNumber): ComplexNumber =
    ComplexNumber(a - cn.a, b - cn.b)

  def *(cn: ComplexNumber): ComplexNumber = mul(cn)
  def mul(cn: ComplexNumber): ComplexNumber =
    ComplexNumber(a * cn.a - b * cn.b, a * cn.b + b * cn.a)

  def /(cn: ComplexNumber): ComplexNumber = div(cn)
  def div(cn: ComplexNumber): ComplexNumber = {
    val den = cn.productWithConjugate
    require(den != 0, "Can't divide by 0")
    val c = a * cn.a + b * cn.b
    val d = b * cn.a - a * cn.b
    ComplexNumber(c / den, d / den)
  }

  def abs: ComplexNumber =
    ComplexNumber(math.abs(a), math.abs(b))

  def conjugate: ComplexNumber =
    ComplexNumber(a, -b)

  def productWithConjugate: Double =
    a * a + b * b

  def sqrt: Array[ComplexNumber] = {
    val sqrtProd = math.sqrt(productWithConjugate)
    val c        = math.sqrt((sqrtProd + a) / 2.0)
    val d        = math.sqrt((sqrtProd - a) / 2.0)
    Array(ComplexNumber(c, d), ComplexNumber(c, -d))
  }

  def power2: ComplexNumber = {
    val c = a * a - b * b
    val d = 2 * a * b
    ComplexNumber(c, d)
  }

  def power(p: Int): ComplexNumber = {
    require(p >= 1)
    if (p == 1)
      ComplexNumber(a, b)
    else {
      val powers  = p.toBinaryString
      val powersC = new Array[ComplexNumber](powers.length)
      powersC(0) = ComplexNumber(a, b)
      (1 until powersC.length).foreach(i => powersC(i) = new ComplexNumber(powersC(i - 1)).power2)
      (1 until powersC.length)
        .filter(powers(_) == '1')
        .foldLeft(powersC.last)((cn, i) => cn * powersC(powersC.length - 1 - i))
    }
  }
}
```

---
