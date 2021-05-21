package com.github.artemkorsakov.numbers

import com.github.artemkorsakov.divisors.Divisors.gcd

/** <a href="https://en.wikipedia.org/wiki/Rational_number">Rational number</a> or <a href="https://en.wikipedia.org/wiki/Fraction_(mathematics)">Fraction</a>
  */
case class RationalNumber(x: BigInt, y: BigInt) {
  require(y != 0, "denominator can't be 0")

  private val (n, d): (BigInt, BigInt) =
    if (x == BigInt(0)) {
      (BigInt(0), BigInt(1))
    } else if (y < 0) {
      (-x, -y)
    } else {
      (x, y)
    }
  private val g           = gcd(n, d)
  val numerator: BigInt   = n / g
  val denominator: BigInt = d / g

  def +(r: RationalNumber): RationalNumber = add(r)

  def +(r: BigInt): RationalNumber = add(RationalNumber(r))

  def add(r: RationalNumber): RationalNumber =
    RationalNumber(numerator * r.denominator + r.numerator * denominator, denominator * r.denominator)

  def -(r: RationalNumber): RationalNumber = sub(r)

  def -(r: BigInt): RationalNumber = sub(RationalNumber(r))

  def sub(r: RationalNumber): RationalNumber =
    RationalNumber(numerator * r.denominator - r.numerator * denominator, denominator * r.denominator)

  def *(r: RationalNumber): RationalNumber = mul(r)

  def *(r: BigInt): RationalNumber = mul(RationalNumber(r))

  def mul(r: RationalNumber): RationalNumber =
    RationalNumber(numerator * r.numerator, denominator * r.denominator)

  def /(r: RationalNumber): RationalNumber = div(r)

  def /(r: BigInt): RationalNumber = div(RationalNumber(r))

  def div(r: RationalNumber): RationalNumber =
    RationalNumber(numerator * r.denominator, r.numerator * denominator)

  def upend: RationalNumber = RationalNumber(denominator, numerator)

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

  def max(that: RationalNumber): RationalNumber = if (this < that) that else this

  override def toString: String = s"$numerator/$denominator"

  /** Fraction to percent. */
  def toPercent: Double =
    (BigDecimal(numerator) / BigDecimal(denominator)).rounded.toDouble

}

object RationalNumber {
  implicit def intToRational(x: Int): RationalNumber = RationalNumber(x)

  implicit def longToRational(x: Long): RationalNumber = RationalNumber(x)

  implicit def bigintToRational(x: BigInt): RationalNumber = RationalNumber(x)

  def apply(numerator: BigInt): RationalNumber = RationalNumber(numerator, BigInt(1))

  def apply(x: Int, y: Int): RationalNumber = RationalNumber(BigInt(x), BigInt(y))

  def apply(x: Int): RationalNumber = RationalNumber(BigInt(x), BigInt(1))

  def apply(x: Long, y: Long): RationalNumber = RationalNumber(BigInt(x), BigInt(y))

  def apply(x: Long): RationalNumber = RationalNumber(BigInt(x), BigInt(1))

  def apply(r: RationalNumber): RationalNumber = RationalNumber(r.numerator, r.denominator)

  val ZeroRationalNumber: RationalNumber = RationalNumber(0, 1)

  def max(r1: RationalNumber, r2: RationalNumber): RationalNumber = if (r1 < r2) r2 else r1
}
