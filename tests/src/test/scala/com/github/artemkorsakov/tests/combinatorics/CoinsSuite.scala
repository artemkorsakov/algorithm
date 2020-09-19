package com.github.artemkorsakov.tests.combinatorics

import com.github.artemkorsakov.combinatorics.Coins._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class CoinsSuite extends AnyFunSuiteLike {
  test("countWays") {
    countWays(Array(200), 200) shouldBe 1
    countWays(Array(200), 199) shouldBe 0
    countWays(Array(1, 2, 5), 10) shouldBe 10
    countWays(Array(1, 2, 5, 10), 10) shouldBe 11
    countWays(Array(1, 2, 5, 10, 20, 50, 100, 200), 200) shouldBe 73682
  }

  test("partition") {
    10.partition shouldBe 42
    100.partition shouldBe 190569292
    1000.partition shouldBe BigInt("24061467864032622473692149727991")
  }

  test("optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers") {
    optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(2) shouldBe 1
    optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(3) shouldBe 2
    optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(4) shouldBe 4
    optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(5) shouldBe 6
    optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(6) shouldBe 10
    optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(7) shouldBe 14
    optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(8) shouldBe 21
    optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(9) shouldBe 29
    optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(10) shouldBe 41
    optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(11) shouldBe 55
    optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(20) shouldBe 626
    optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(25) shouldBe 1957
    optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(100) shouldBe 190569291
  }
}
