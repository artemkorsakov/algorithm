package com.github.artemkorsakov.numbers

import scala.math._

object CyclicNumbers {

  /** Triangle numbers; T<sub>n</sub>=n(n+1)/2; 1, 3, 6, 10, 15, ... */
  case class TriangleFiguralNumber(n: Long) {
    def triangleNumber: Long =
      n * (n + 1) / 2

    def isTriangle: Boolean = {
      val possible = -1.0 / 2.0 + sqrt(2.0 * n + 1.0 / 4.0)
      abs(possible - round(possible)) < 1e-10
    }
  }

  /** Square numbers; P<sub>4,n</sub>=n<sup>2</sup>; 1, 4, 9, 16, 25, ... */
  case class SquareFiguralNumber(n: Long) {
    def squareNumber: Long =
      n * n

    def isSquare: Boolean = {
      val possible = sqrt(n.toDouble)
      abs(possible - round(possible)) < 1e-10
    }
  }

  /** Pentagonal numbers; P<sub>5,n</sub>=n(3n−1)/2; 1, 5, 12, 22, 35, ... */
  case class PentagonalFiguralNumber(n: Long) {
    def pentagonalNumber: Long =
      n * (3 * n - 1) / 2

    def isPentagonal: Boolean = {
      val possible = 1.0 / 6.0 + sqrt(2.0 * n / 3.0 + 1.0 / 36.0)
      abs(possible - round(possible)) < 1e-10
    }
  }

  /** Hexagonal numbers; H<sub>n</sub>=n(2n−1); 1, 6, 15, 28, 45, ... */
  case class HexagonalFiguralNumber(n: Long) {
    def hexagonalNumber: Long =
      n * (2 * n - 1)

    def isHexagonal: Boolean = {
      val possible = 1.0 / 4.0 + sqrt(n / 2.0 + 1.0 / 16.0)
      abs(possible - round(possible)) < 1e-10
    }
  }

  /** Heptagonal numbers; P<sub>7,n</sub>=n(5n−3)/2; 1, 7, 18, 34, 55, ... */
  case class HeptagonalFiguralNumber(n: Long) {
    def heptagonalNumber: Long =
      n * (5 * n - 3) / 2

    def isHeptagonal: Boolean = {
      val possible = 3.0 / 10.0 + sqrt(2.0 * n / 5.0 + 9.0 / 100.0)
      abs(possible - round(possible)) < 1e-10
    }
  }

  /** Octagonal numbers; P<sub>8,n</sub>=n(3n−2); 1, 8, 21, 40, 65, ... */
  case class OctagonalFiguralNumber(n: Long) {
    def octagonalNumber: Long =
      n * (3 * n - 2)

    def isOctagonal: Boolean = {
      val possible = 1.0 / 3.0 + sqrt(n / 3.0 + 1.0 / 9.0)
      abs(possible - round(possible)) < 1e-10
    }
  }

  implicit def long2TriangleFiguralNumber(n: Long): TriangleFiguralNumber     = TriangleFiguralNumber(n)
  implicit def int2TriangleFiguralNumber(n: Int): TriangleFiguralNumber       = TriangleFiguralNumber(n.toLong)
  implicit def long2SquareFiguralNumber(n: Long): SquareFiguralNumber         = SquareFiguralNumber(n)
  implicit def int2SquareFiguralNumber(n: Int): SquareFiguralNumber           = SquareFiguralNumber(n.toLong)
  implicit def long2PentagonalFiguralNumber(n: Long): PentagonalFiguralNumber = PentagonalFiguralNumber(n)
  implicit def int2PentagonalFiguralNumber(n: Int): PentagonalFiguralNumber   = PentagonalFiguralNumber(n.toLong)
  implicit def long2HexagonalFiguralNumber(n: Long): HexagonalFiguralNumber   = HexagonalFiguralNumber(n)
  implicit def int2HexagonalFiguralNumber(n: Int): HexagonalFiguralNumber     = HexagonalFiguralNumber(n.toLong)
  implicit def long2HeptagonalFiguralNumber(n: Long): HeptagonalFiguralNumber = HeptagonalFiguralNumber(n)
  implicit def int2HeptagonalFiguralNumber(n: Int): HeptagonalFiguralNumber   = HeptagonalFiguralNumber(n.toLong)
  implicit def long2OctagonalFiguralNumber(n: Long): OctagonalFiguralNumber   = OctagonalFiguralNumber(n)
  implicit def int2OctagonalFiguralNumber(n: Int): OctagonalFiguralNumber     = OctagonalFiguralNumber(n.toLong)
}
