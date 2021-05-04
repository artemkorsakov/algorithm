package com.github.artemkorsakov.numbers

import scala.collection.mutable
import scala.math.BigInt

object OtherNumbers {
  private val padovanMap: mutable.Map[Int, BigInt]    = mutable.Map((0, 1), (1, 0), (2, 0))
  private val jacobsthalMap: mutable.Map[Int, BigInt] = mutable.Map((0, 0), (1, 1))
  private val pellMap: mutable.Map[Int, BigInt]       = mutable.Map((0, 0), (1, 1))
  private val tribonacciMap: mutable.Map[Int, BigInt] = mutable.Map((0, 0), (1, 0), (2, 1))
  private val tetranacciMap: mutable.Map[Int, BigInt] = mutable.Map((0, 0), (1, 0), (2, 0), (3, 1))

  /** <a href="https://oeis.org/A000931">Padovan sequence (or Padovan numbers)</a>
    * : a<sub>n</sub> = a<sub>n-2</sub> + a<sub>n-3</sub> with a<sub>0</sub> = 1, a<sub>1</sub> = a<sub>2</sub> = 0.
    */
  def padovan(i: Int): BigInt =
    padovanMap.getOrElseUpdate(i, padovan(i - 2) + padovan(i - 3))

  /** <a href="https://oeis.org/A001045">Jacobsthal sequence (or Jacobsthal numbers)</a>:
    * a<sub>n</sub> = a<sub>n-1</sub> + 2*a<sub>n-2</sub> with a<sub>0</sub> = 0, a<sub>1</sub> = 1.
    *
    * Also a<sub>n</sub> = nearest integer to 2<sup>n</sup>/3.
    */
  def jacobsthal(i: Int): BigInt =
    jacobsthalMap.getOrElseUpdate(i, jacobsthal(i - 1) + 2 * jacobsthal(i - 2))

  /** <a href="https://oeis.org/A000129">Pell numbers</a>
    * : a<sub>n</sub> = 2*a<sub>n-1</sub> + a<sub>n-2</sub> with a<sub>0</sub> = 0, a<sub>1</sub> = 1.
    */
  def pell(i: Int): BigInt =
    pellMap.getOrElseUpdate(i, 2 * pell(i - 1) + pell(i - 2))

  /** <a href="https://oeis.org/A000073">Tribonacci numbers</a>
    * : a<sub>n</sub> = a<sub>n-1</sub> + a<sub>n-2</sub> + a<sub>n-3</sub>
    * with a<sub>0</sub> = a<sub>1</sub> = 0, a<sub>2</sub> = 1.
    */
  def tribonacci(i: Int): BigInt =
    tribonacciMap.getOrElseUpdate(i, tribonacci(i - 1) + tribonacci(i - 2) + tribonacci(i - 3))

  /** <a href="https://oeis.org/A000078">Tetranacci numbers</a>
    * : a<sub>n</sub> = a<sub>n-1</sub> + a<sub>n-2</sub> + a<sub>n-3</sub> + a<sub>n-4</sub>
    * with a<sub>0</sub> = a<sub>1</sub> = a<sub>2</sub> = 0, a<sub>3</sub> = 1.
    */
  def tetranacci(i: Int): BigInt =
    tetranacciMap.getOrElseUpdate(i, tetranacci(i - 1) + tetranacci(i - 2) + tetranacci(i - 3) + tetranacci(i - 4))

}
