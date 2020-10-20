---
layout: docs
title: "Realization: Dice game"
parent_link: ../../games/dice.html
---

## {{page.title}}

Realizations for [Dice game]({{ page.parent_link }}).

### probabilities

[Algorithm]({{ page.parent_link }}{{ "#probabilities" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.numbers.RationalNumber

case class Dice(maxCube: Int) {
  def probabilities(step: Int): Seq[RationalNumber] = {
    val sums  = (1 to maxCube * step).map(i => cubeCount(step, i))
    val total = sums.sum
    sums.map(RationalNumber(_, total))
  }

  private def cubeCount(steps: Int, sum: Int): Int =
    if (steps < 0 || sum < steps)
      0
    else if (steps == sum)
      1
    else if (steps == 0)
      0
    else
      (1 to maxCube).map(i => cubeCount(steps - 1, sum - i)).sum
}
```

---
