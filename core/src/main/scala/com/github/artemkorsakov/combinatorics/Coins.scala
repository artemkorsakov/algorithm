package com.github.artemkorsakov.combinatorics

class Coins(number: Int) {
  private val array = new Array[BigInt](number + 1)
  array(0) = BigInt(1)
  array(1) = BigInt(1)
  array(2) = BigInt(2)

  /** A way of writing n as a sum of positive integers.
    *
    * @see <a href="https://en.wikipedia.org/wiki/Partition_(number_theory)">detailed description</a>
    */
  val partition: BigInt = {
    for (n <- 3 to number) {
      val p = partitionPart(1, n, BigInt(0))
      array(n) = partitionPart(-1, n, p)
    }
    array(number)
  }

  private def partitionPart(s: Int, n: Int, pS: BigInt): BigInt = {
    var k  = s
    var op = k * (3 * k - 1) / 2
    var p  = pS
    while (op <= n) {
      if ((k + 1) % 2 == 0) {
        p += array(n - op)
      } else {
        p -= array(n - op)
      }
      k += s
      op = k * (3 * k - 1) / 2
    }
    p
  }
}

object Coins {
  implicit def int2Coins(n: Int): Coins = new Coins(n)

  /** How many options to get a given sum from given coins?
    *
    * @see <a href="https://projecteuler.net/overview=031">detailed description</a>
    */
  def countWays(coins: Array[Int], sum: Int): Long = {
    val ways = new Array[Long](sum + 1)
    ways(0) = 1
    coins.foreach(coin => (coin to sum).foreach(i => ways(i) += ways(i - coin)))
    ways(sum)
  }

  /** How many options to get sum as a sum of at least two positive numbers?
    */
  def optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(sum: Int): BigInt =
    sum.partition - 1
}
