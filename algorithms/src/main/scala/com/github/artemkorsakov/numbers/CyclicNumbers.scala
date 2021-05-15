package com.github.artemkorsakov.numbers

import scala.math._

/** CyclicNumbers:
  *
  *   - Triangle numbers; T<sub>n</sub>=n(n+1)/2; 1, 3, 6, 10, 15, ...
  *   - Square numbers; P<sub>4,n</sub>=n<sup>2</sup>; 1, 4, 9, 16, 25, ...
  *   - Pentagonal numbers; P<sub>5,n</sub>=n(3n−1)/2; 1, 5, 12, 22, 35, ...
  *   - Hexagonal numbers; H<sub>n</sub>=n(2n−1); 1, 6, 15, 28, 45, ...
  *   - Heptagonal numbers; P<sub>7,n</sub>=n(5n−3)/2; 1, 7, 18, 34, 55, ...
  *   - Octagonal numbers; P<sub>8,n</sub>=n(3n−2); 1, 8, 21, 40, 65, ...
  */
object CyclicNumbers {

  def triangleNumber(n: Int): Long = triangleNumber(n.toLong)

  def triangleNumber(n: Long): Long = n * (n + 1) / 2

  def isTriangle(n: Int): Boolean = isTriangle(n.toLong)

  def isTriangle(n: Long): Boolean = {
    val sol = math.round(-1.0 / 2.0 + sqrt(2.0 * n + 1.0 / 4.0))
    triangleNumber(sol) == n
  }

  def squareNumber(n: Int): Long = squareNumber(n.toLong)

  def squareNumber(n: Long): Long = n * n

  def isSquare(n: Int): Boolean = isSquare(n.toLong)

  def isSquare(n: Long): Boolean = sqrt(n.toDouble).isWhole

  def pentagonalNumber(n: Int): Long = pentagonalNumber(n.toLong)

  def pentagonalNumber(n: Long): Long = n * (3 * n - 1) / 2

  def isPentagonal(n: Int): Boolean = isPentagonal(n.toLong)

  def isPentagonal(n: Long): Boolean = {
    val sol = math.round(1.0 / 6.0 + sqrt(2.0 * n / 3.0 + 1.0 / 36.0))
    pentagonalNumber(sol) == n
  }

  def hexagonalNumber(n: Int): Long = hexagonalNumber(n.toLong)

  def hexagonalNumber(n: Long): Long = n * (2 * n - 1)

  def isHexagonal(n: Int): Boolean = isHexagonal(n.toLong)

  def isHexagonal(n: Long): Boolean = {
    val sol = math.round(1.0 / 4.0 + sqrt(n / 2.0 + 1.0 / 16.0))
    hexagonalNumber(sol) == n
  }

  def heptagonalNumber(n: Int): Long = heptagonalNumber(n.toLong)

  def heptagonalNumber(n: Long): Long = n * (5 * n - 3) / 2

  def isHeptagonal(n: Int): Boolean = isHeptagonal(n.toLong)

  def isHeptagonal(n: Long): Boolean = {
    val sol = math.round(3.0 / 10.0 + sqrt(2.0 * n / 5.0 + 9.0 / 100.0))
    heptagonalNumber(sol) == n
  }

  def octagonalNumber(n: Int): Long = octagonalNumber(n.toLong)

  def octagonalNumber(n: Long): Long = n * (3 * n - 2)

  def isOctagonal(n: Int): Boolean = isOctagonal(n.toLong)

  def isOctagonal(n: Long): Boolean = {
    val sol = math.round(1.0 / 3.0 + sqrt(n / 3.0 + 1.0 / 9.0))
    octagonalNumber(sol) == n
  }

}
