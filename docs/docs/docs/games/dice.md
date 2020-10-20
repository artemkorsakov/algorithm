---
layout: docs
title: "Dice game"
realization_link: ../realization/games/dice.html
---

## {{page.title}}

[List of dice games](https://en.wikipedia.org/wiki/List_of_dice_games)

### probabilities
An array of probabilities to get the given sums from the cube with the maximum face maxCube and for a given count of steps.

**Algorithm**

**Complexity**
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#probabilities" | downcase }})

**Sources** 
- [Project Euler. Problem 205](https://projecteuler.net/problem=205)

**Using**
```scala mdoc
import com.github.artemkorsakov.games.dice.Dice
Dice(6).probabilities(1).zipWithIndex.map(rnwi => s"The chance of getting ${rnwi._2 + 1} in 1 steps is ${rnwi._1.toPercent}")
Dice(6).probabilities(2).zipWithIndex.map(rnwi => s"The chance of getting ${rnwi._2 + 1} in 2 steps is ${rnwi._1.toPercent}")
Dice(6).probabilities(3).zipWithIndex.map(rnwi => s"The chance of getting ${rnwi._2 + 1} in 3 steps is ${rnwi._1.toPercent}")
```

---
