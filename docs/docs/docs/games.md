---
layout: docs
title: "Games"
---

## {{page.title}}

The package ```com.github.artemkorsakov.games``` contains algorithms for different games. 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.games.dice.Dice
Dice(6).probabilities(1).zipWithIndex.map(rnwi => s"The chance of getting ${rnwi._2 + 1} in 1 steps is ${rnwi._1.toPercent}")
Dice(6).probabilities(2).zipWithIndex.map(rnwi => s"The chance of getting ${rnwi._2 + 1} in 2 steps is ${rnwi._1.toPercent}")
Dice(6).probabilities(3).zipWithIndex.map(rnwi => s"The chance of getting ${rnwi._2 + 1} in 3 steps is ${rnwi._1.toPercent}")
```
```scala mdoc
import com.github.artemkorsakov.games.darts.Darts
Darts.allDistinctWaysToCheckOut(6)
Darts.allDistinctWaysToCheckOut.values.sum
```
```scala mdoc
import com.github.artemkorsakov.games.nim.Nim
Nim.getX(1, 2, 3)
```
```scala mdoc
import com.github.artemkorsakov.games.poker.Poker
// Pair of Fives, Pair of Eights
Poker("5H 5C 6S 7S KD", "2C 3S 8S 8D TD").doesPlayer1Win
// Highest card Ace, Highest card Queen
Poker("5D 8C 9S JS AC", "2C 5C 7D 8S QH").doesPlayer1Win
// Three Aces, Flush with Diamonds
Poker("2D 9C AS AH AC", "3D 6D 7D TD QD").doesPlayer1Win
// Pair of Queens Highest card Nine, Pair of Queens Highest card Seven
Poker("4D 6S 9H QH QC", "3D 6D 7H QD QS").doesPlayer1Win
// Full House With Three Fours, Full House with Three Threes
Poker("2H 2D 4C 4D 4S", "3C 3D 3S 9S 9D").doesPlayer1Win
```
```scala mdoc
import com.github.artemkorsakov.games.sudoku.SuDoku._
var src = "003020600\n900305001\n001806400\n008102900\n700000008\n006708200\n002609500\n800203009\n005010300"
toSuDoku(src).get.result.foreach(_.foreach(row => println(row.mkString("|", "", "|"))))
```
