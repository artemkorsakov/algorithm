---
layout: docs
title: "Realization: Rational number/Fraction"
parent_link: ../../numbers/rational.html
---

## {{page.title}}

Realizations for [Rational number/Fraction]({{ page.parent_link }}).

### addSubMulDiv

[Algorithm]({{ page.parent_link }}{{ "#addSubMulDiv" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.divisors.Divisors.gcd

class RationalNumber(x: BigInt, y: BigInt) {
  require(y != 0, "denominator can't be 0")

  val tuple: (BigInt, BigInt) =
    if (x == BigInt(0))
      (BigInt(0), BigInt(1))
    else if (y < 0)
      (-x, -y)
    else
      (x, y)
  private val g           = gcd(tuple._1, tuple._2)
  val numerator: BigInt   = tuple._1 / g
  val denominator: BigInt = tuple._2 / g

  def +(r: RationalNumber): RationalNumber = add(r)
  def add(r: RationalNumber) =
    new RationalNumber(numerator * r.denominator + r.numerator * denominator, denominator * r.denominator)
  def -(r: RationalNumber): RationalNumber = sub(r)
  def sub(r: RationalNumber) =
    new RationalNumber(numerator * r.denominator - r.numerator * denominator, denominator * r.denominator)
  def *(r: RationalNumber): RationalNumber = mul(r)
  def mul(r: RationalNumber) =
    new RationalNumber(numerator * r.numerator, denominator * r.denominator)
  def /(r: RationalNumber): RationalNumber = div(r)
  def div(r: RationalNumber) =
    new RationalNumber(numerator * r.denominator, r.numerator * denominator)
  def upend: RationalNumber =
    new RationalNumber(denominator, numerator)
}
```

---

### equal

[Algorithm]({{ page.parent_link }}{{ "#equal" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.divisors.Divisors.gcd

class RationalNumber(x: BigInt, y: BigInt) {
  require(y != 0, "denominator can't be 0")

  val tuple: (BigInt, BigInt) =
    if (x == BigInt(0))
      (BigInt(0), BigInt(1))
    else if (y < 0)
      (-x, -y)
    else
      (x, y)
  private val g           = gcd(tuple._1, tuple._2)
  val numerator: BigInt   = tuple._1 / g
  val denominator: BigInt = tuple._2 / g

  def ==(r: RationalNumber): Boolean = this.equal(r)
  def equal(r: RationalNumber): Boolean =
    (numerator * r.denominator).equals(denominator * r.numerator)
}
```

---

### compare

[Algorithm]({{ page.parent_link }}{{ "#compare" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.divisors.Divisors.gcd

class RationalNumber(x: BigInt, y: BigInt) {
  require(y != 0, "denominator can't be 0")

  val tuple: (BigInt, BigInt) =
    if (x == BigInt(0))
      (BigInt(0), BigInt(1))
    else if (y < 0)
      (-x, -y)
    else
      (x, y)
  private val g           = gcd(tuple._1, tuple._2)
  val numerator: BigInt   = tuple._1 / g
  val denominator: BigInt = tuple._2 / g

  def <(r: RationalNumber): Boolean =
    numerator * r.denominator < r.numerator * denominator
  def <=(r: RationalNumber): Boolean =
    numerator * r.denominator <= r.numerator * denominator
  def >(r: RationalNumber): Boolean =
    numerator * r.denominator > r.numerator * denominator
  def >=(r: RationalNumber): Boolean =
    numerator * r.denominator >= r.numerator * denominator
}

object RationalNumber {
  def max(r1: RationalNumber, r2: RationalNumber): RationalNumber =
    if (r1 < r2) r2 else r1
}
```

---

### toPercent

[Algorithm]({{ page.parent_link }}{{ "#toPercent" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.divisors.Divisors.gcd

class RationalNumber(x: BigInt, y: BigInt) {
  require(y != 0, "denominator can't be 0")

  val tuple: (BigInt, BigInt) =
    if (x == BigInt(0))
      (BigInt(0), BigInt(1))
    else if (y < 0)
      (-x, -y)
    else
      (x, y)
  private val g           = gcd(tuple._1, tuple._2)
  val numerator: BigInt   = tuple._1 / g
  val denominator: BigInt = tuple._2 / g

  def toPercent: Double =
    (BigDecimal(numerator) / BigDecimal(denominator)).rounded.toDouble
}
```

---
