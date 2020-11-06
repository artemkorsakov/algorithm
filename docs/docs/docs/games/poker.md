---
layout: docsplus
title: "Poker"
realization: games/poker
---

In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:
- **High Card**: Highest value card.
- **One Pair**: Two cards of the same value.
- **Two Pairs**: Two different pairs.
- **Three of a Kind**: Three cards of the same value.
- **Straight**: All cards are consecutive values.
- **Flush**: All cards of the same suit.
- **Full House**: Three of a kind and a pair.
- **Four of a Kind**: Four cards of the same value.
- **Straight Flush**: All cards are consecutive values of same suit.
- **Royal Flush**: Ten, Jack, Queen, King, Ace, in same suit.

The cards are valued in the order:
<br>2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.

If two players have the same ranked hands then the rank made up of the highest value wins; 
for example, a pair of eights beats a pair of fives (see example 1 below). 
But if two ranks tie, for example, both players have a pair of queens, 
then highest cards in each hand are compared (see example 4 below); 
if the highest cards tie then the next highest cards are compared, and so on.

Consider the following five hands dealt to two players:

Hand | Player 1 | Player 2 | Who is a winner?
--- | --- | --- | ---
**1** | _5H 5C 6S 7S KD (Pair of Fives)_ | _2C 3S 8S 8D TD (Pair of Eights)_ | **Player 2**
**2** | _5D 8C 9S JS AC (Highest card Ace)_ | _2C 5C 7D 8S QH (Highest card Queen)_ | **Player 1**
**3** | _2D 9C AS AH AC (Three Aces)_ | _3D 6D 7D TD QD (Flush with Diamonds)_ | **Player 2**
**4** | _4D 6S 9H QH QC (Pair of Queens, Highest card Nine)_ | _3D 6D 7H QD QS (Pair of Queens, Highest card Seven)_ | **Player 1**
**5** | _2H 2D 4C 4D 4S (Full House with Three Fours)_ | _3C 3D 3S 9S 9D (Full House with Three Threes)_ | **Player 1**

### doesPlayer1Win
Does first player win?

**Algorithm**

**Complexity**
     
**Sources** 
- [Project Euler. Problem 54](https://projecteuler.net/problem=54)

**Using**
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

---
