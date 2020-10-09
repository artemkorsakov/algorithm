---
layout: docs
title: "Realization: Coins"
parent_link: ../../combinatorics/coins.html
---

## {{page.title}}

Realizations for [Coins]({{ page.parent_link }}).

### countWays

[Algorithm]({{ page.parent_link }}{{ "#countWays" | downcase }})

**Realization**
```scala
  def countWays(coins: Array[Int], sum: Int): Long = {
    val ways = new Array[Long](sum + 1)
    ways(0) = 1
    coins.foreach(coin => (coin to sum).foreach(i => ways(i) += ways(i - coin)))
    ways(sum)
  }
```

---

### partition

[Algorithm]({{ page.parent_link }}{{ "#partition" | downcase }})

**Realization**
```scala
class Coins(number: Int) {
  private val array = new Array[BigInt](number + 1)
  array(0) = BigInt(1)
  array(1) = BigInt(1)
  array(2) = BigInt(2)

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
```

---

### optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers

[Algorithm]({{ page.parent_link }}{{ "#optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers" | downcase }})

**Realization**
```scala
  import com.github.artemkorsakov.combinatorics.Coins._

  def optionsToGetSumAsASumOfAtLeastTwoPositiveNumbers(sum: Int): BigInt =
    sum.partition - 1
```

---