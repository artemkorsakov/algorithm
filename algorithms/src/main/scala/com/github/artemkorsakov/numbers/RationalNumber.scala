package com.github.artemkorsakov.numbers

import com.github.artemkorsakov.divisors.Divisors.gcd

/** <a href="https://en.wikipedia.org/wiki/Rational_number">Rational number</a> or <a href="https://en.wikipedia.org/wiki/Fraction_(mathematics)">Fraction</a>
  */
case class RationalNumber(x: BigInt, y: BigInt) {
  require(y != 0, "denominator can't be 0")

  val tuple: (BigInt, BigInt) =
    if (x == BigInt(0)) {
      (BigInt(0), BigInt(1))
    } else if (y < 0) {
      (-x, -y)
    } else {
      (x, y)
    }
  private val g           = gcd(tuple._1, tuple._2)
  val numerator: BigInt   = tuple._1 / g
  val denominator: BigInt = tuple._2 / g

  def this(numerator: BigInt) = this(numerator, BigInt(1))
  def this(x: Int, y: Int) = this(BigInt(x), BigInt(y))
  def this(x: Int) = this(BigInt(x), BigInt(1))
  def this(x: Long, y: Long) = this(BigInt(x), BigInt(y))
  def this(x: Long) = this(BigInt(x), BigInt(1))
  def this(r: RationalNumber) = this(r.numerator, r.denominator)

  def +(r: RationalNumber): RationalNumber = add(r)
  def add(r: RationalNumber): RationalNumber =
    new RationalNumber(numerator * r.denominator + r.numerator * denominator, denominator * r.denominator)
  def -(r: RationalNumber): RationalNumber = sub(r)
  def sub(r: RationalNumber): RationalNumber =
    new RationalNumber(numerator * r.denominator - r.numerator * denominator, denominator * r.denominator)
  def *(r: RationalNumber): RationalNumber = mul(r)
  def mul(r: RationalNumber): RationalNumber =
    new RationalNumber(numerator * r.numerator, denominator * r.denominator)
  def /(r: RationalNumber): RationalNumber = div(r)
  def div(r: RationalNumber): RationalNumber =
    new RationalNumber(numerator * r.denominator, r.numerator * denominator)

  def upend: RationalNumber =
    new RationalNumber(denominator, numerator)

  def ==(r: RationalNumber): Boolean = this.equal(r)
  def equal(r: RationalNumber): Boolean =
    (numerator * r.denominator).equals(denominator * r.numerator)

  def <(r: RationalNumber): Boolean =
    numerator * r.denominator < r.numerator * denominator
  def <=(r: RationalNumber): Boolean =
    numerator * r.denominator <= r.numerator * denominator
  def >(r: RationalNumber): Boolean =
    numerator * r.denominator > r.numerator * denominator
  def >=(r: RationalNumber): Boolean =
    numerator * r.denominator >= r.numerator * denominator

  override def toString: String = s"$numerator/$denominator"

  /** Fraction to percent. */
  def toPercent: Double =
    (BigDecimal(numerator) / BigDecimal(denominator)).rounded.toDouble

}

object RationalNumber {
  def apply(x: Int, y: Int): RationalNumber   = new RationalNumber(BigInt(x), BigInt(y))
  def apply(x: Long, y: Long): RationalNumber = new RationalNumber(BigInt(x), BigInt(y))

  val ZeroRationalNumber: RationalNumber = new RationalNumber(0, 1)

  def max(r1: RationalNumber, r2: RationalNumber): RationalNumber =
    if (r1 < r2) r2 else r1
}
