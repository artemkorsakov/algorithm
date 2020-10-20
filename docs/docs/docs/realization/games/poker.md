---
layout: docs
title: "Realization: Poker"
parent_link: ../../games/poker.html
---

## {{page.title}}

Realizations for [Poker]({{ page.parent_link }}).

### doesPlayer1Win

[Algorithm]({{ page.parent_link }}{{ "#doesPlayer1Win" | downcase }})

**Realization**
```scala
package com.github.artemkorsakov.games.poker

case class Poker(player1: String, player2: String) {
  private val player1Hands: PokerHand = new PokerHand(player1)
  private val player2Hands: PokerHand = new PokerHand(player2)

  val doesPlayer1Win: Boolean = player1Hands.compareTo(player2Hands) <= 0
}
```
```scala
package com.github.artemkorsakov.games.poker

import com.github.artemkorsakov.games.poker.PokerCard._

class PokerHand(hand: String) {
  private val split: Array[String] = hand.split(" ")
  require(split.length == 5)
  private val cards: Array[PokerCard] = split.flatMap(string2PokerCard)
  private val sortedRanks             = cards.map(card => card.pokerRank).sortWith((pr1, pr2) => pr2.id - pr1.id < 0)
  private val sortedDistinctRanks     = sortedRanks.distinct

  private def isFiveOfAKind: Boolean =
    sortedDistinctRanks.length == 1
  private def fiveOfAKind: (PokerHandsType.Value, Seq[PokerRank.Value]) =
    (
      PokerHandsType.FIVE_OF_A_KIND,
      Seq(cards.head.pokerRank, PokerRank.TWO, PokerRank.TWO, PokerRank.TWO, PokerRank.TWO)
    )

  private def isStraightFlush: Boolean =
    isStraight && isFlush
  private def straightFlush: (PokerHandsType.Value, Seq[PokerRank.Value]) =
    (PokerHandsType.STRAIGHT_FLUSH, straight._2)

  private def isStraight: Boolean =
    sortedRanks.sameElements(
      Array(PokerRank.FIVE, PokerRank.FOUR, PokerRank.THREE, PokerRank.TWO, PokerRank.A)
    ) || (0 until sortedRanks.length - 1).forall(i => sortedRanks(i).id - sortedRanks(i + 1).id == 1)
  private def straight: (PokerHandsType.Value, Seq[PokerRank.Value]) = {
    val pokerRank =
      if (sortedRanks.head == PokerRank.A && sortedRanks(1) == PokerRank.FIVE) PokerRank.FIVE
      else sortedRanks.head
    (PokerHandsType.STRAIGHT, Seq(pokerRank, PokerRank.TWO, PokerRank.TWO, PokerRank.TWO, PokerRank.TWO))
  }

  private def isFlush: Boolean =
    cards.map(_.pokerSuit.id).distinct.length == 1
  private def flush: (PokerHandsType.Value, Seq[PokerRank.Value]) =
    (PokerHandsType.FLUSH, sortedRanks)

  private def isFourOfAKind: Boolean = {
    val countOfRank      = sortedDistinctRanks.length
    val countOfFirstCard = cards.count(c => c.pokerRank == cards.head.pokerRank)
    countOfRank == 2 && (countOfFirstCard == 1 || countOfFirstCard == 4)
  }
  private def fourOfAKind: (PokerHandsType.Value, Seq[PokerRank.Value]) = {
    val isFirstEqualSecond = sortedRanks.head.id == sortedRanks(1).id
    val pokerRank1         = if (isFirstEqualSecond) sortedRanks.head else sortedRanks(1)
    val pokerRank2         = if (isFirstEqualSecond) sortedRanks(4) else sortedRanks.head
    (PokerHandsType.FOUR_OF_A_KIND, Seq(pokerRank1, pokerRank2, PokerRank.TWO, PokerRank.TWO, PokerRank.TWO))
  }

  private def isFullHouse: Boolean = {
    val countOfRank      = sortedDistinctRanks.length
    val countOfFirstCard = cards.count(c => c.pokerRank == cards.head.pokerRank)
    countOfRank == 2 && (countOfFirstCard == 2 || countOfFirstCard == 3)
  }
  private def fullHouse: (PokerHandsType.Value, Seq[PokerRank.Value]) = {
    val pokerRank1 = sortedRanks(2)
    val pokerRank2 = if (sortedRanks(1).id == sortedRanks(2).id) sortedRanks(3) else sortedRanks(1)
    (PokerHandsType.FULL_HOUSE, Seq(pokerRank1, pokerRank2, PokerRank.TWO, PokerRank.TWO, PokerRank.TWO))
  }

  private def isThreeOfAKind: Boolean =
    sortedDistinctRanks.length == 3 && {
      val countOfFirstCard = cards.count(c => c.pokerRank == sortedRanks.head)
      val countOfLastCard  = cards.count(c => c.pokerRank == sortedRanks.last)
      (countOfFirstCard == 1 && countOfLastCard == 1) || (countOfFirstCard == 3 && countOfLastCard == 1) || (countOfFirstCard == 1 && countOfLastCard == 3)
    }
  private def threeOfAKind: (PokerHandsType.Value, Seq[PokerRank.Value]) = {
    val indexThreeOfAKind = (0 until sortedRanks.length - 2)
      .find(i => sortedRanks(i).id == sortedRanks(i + 1).id && sortedRanks(i + 1).id == sortedRanks(i + 2).id)
      .getOrElse(0)
    (
      PokerHandsType.THREE_OF_A_KIND,
      Seq(
        sortedRanks(2),
        sortedRanks(if (indexThreeOfAKind == 0) 3 else 0),
        sortedRanks(if (indexThreeOfAKind == 2) 1 else 4),
        PokerRank.TWO,
        PokerRank.TWO
      )
    )
  }

  private def isTwoPair: Boolean =
    sortedDistinctRanks.length == 3 && {
      val countOfFirstCard = cards.count(c => c.pokerRank == sortedRanks.head)
      val countOfLastCard  = cards.count(c => c.pokerRank == sortedRanks.last)
      (countOfFirstCard == 2 && countOfLastCard == 2) || (countOfFirstCard == 2 && countOfLastCard == 1) || (countOfFirstCard == 1 && countOfLastCard == 2)
    }
  private def twoPair: (PokerHandsType.Value, Seq[PokerRank.Value]) = {
    val isFirstEqualSecond = sortedRanks(0).id == sortedRanks(1).id
    val isThirdEqualFourth = sortedRanks(2).id == sortedRanks(3).id
    val thirdIndex         = if (isFirstEqualSecond && isThirdEqualFourth) 4 else if (isFirstEqualSecond) 2 else 0
    (
      PokerHandsType.TWO_PAIR,
      Seq(sortedRanks(1), sortedRanks(3), sortedRanks(thirdIndex), PokerRank.TWO, PokerRank.TWO)
    )
  }

  private def isOnePair: Boolean =
    sortedDistinctRanks.length == 4
  private def onePair: (PokerHandsType.Value, Seq[PokerRank.Value]) = {
    val index = (0 until sortedRanks.length - 1)
      .find(i => sortedRanks(i).id == sortedRanks(i + 1).id)
      .getOrElse(0)
    (
      PokerHandsType.ONE_PAIR,
      Seq(
        sortedRanks(index),
        sortedRanks(if (index == 0) 2 else 0),
        sortedRanks(if (index < 2) 3 else 1),
        sortedRanks(if (index == 3) 2 else 4),
        PokerRank.TWO
      )
    )
  }

  private def highCard: (PokerHandsType.Value, Seq[PokerRank.Value]) =
    (PokerHandsType.HIGH_CARD, sortedRanks)

  val (pokerHandsType: PokerHandsType.Value, ranks: Seq[PokerRank.Value]) =
    if (isFiveOfAKind)
      fiveOfAKind
    else if (isStraightFlush)
      straightFlush
    else if (isFourOfAKind)
      fourOfAKind
    else if (isFullHouse)
      fullHouse
    else if (isFlush)
      flush
    else if (isStraight)
      straight
    else if (isThreeOfAKind)
      threeOfAKind
    else if (isTwoPair)
      twoPair
    else if (isOnePair)
      onePair
    else
      highCard

  def compareTo(pokerHand: PokerHand): Int = {
    val diff = pokerHandsType.id.compareTo(pokerHand.pokerHandsType.id)
    if (diff != 0) diff
    else
      ranks.indices
        .map(i => pokerHand.ranks(i).id.compareTo(ranks(i).id))
        .find(r => r != 0)
        .getOrElse(0)
  }

  def ==(pokerHand: PokerHand): Boolean    = this.equal(pokerHand)
  def equal(pokerHand: PokerHand): Boolean = compareTo(pokerHand) == 0
}
```
```scala
package com.github.artemkorsakov.games.poker

case class PokerCard(pokerRank: PokerRank.Value, pokerSuit: PokerSuit.Value) {}

object PokerCard {
  def string2PokerCard(card: String): Option[PokerCard] =
    if (card.length < 2 || card.length > 3)
      None
    else
      (PokerRank.withNameOpt(card.dropRight(1)), PokerSuit.withNameOpt(card.last)) match {
        case (Some(pokerRank), Some(pokerSuit)) => Some(PokerCard(pokerRank, pokerSuit))
        case _                                  => None
      }
}
```
```scala
package com.github.artemkorsakov.games.poker

object PokerHandsType extends Enumeration {
  type PokerHands = Value
  val FIVE_OF_A_KIND, // All cards are equal
  STRAIGHT_FLUSH,     // A straight flush is a hand that contains five cards of sequential rank, all of the same suit
  FOUR_OF_A_KIND,     // Four of a kind is a hand that contains four cards of one rank and one card of another rank
  FULL_HOUSE,         // A full house is a hand that contains three cards of one rank and two cards of another rank
  FLUSH,              // A flush is a hand that contains five cards all of the same suit, not all of sequential rank
  STRAIGHT,           // A straight is a hand that contains five cards of sequential rank, not all of the same suit
  THREE_OF_A_KIND,    // Three of a kind is a hand that contains three cards of one rank and two cards of two other ranks (the kickers)
  TWO_PAIR,           // Two pair is a hand that contains two cards of one rank, two cards of another rank and one card of a third rank (the kicker)
  ONE_PAIR,           // One pair is a hand that contains two cards of one rank and three cards of three other ranks (the kickers)
  HIGH_CARD = Value // High card is a hand that does not fall into any other category
}
```
```scala
package com.github.artemkorsakov.games.poker

object PokerRank extends Enumeration {
  val A: PokerRank.Value     = Value(14)
  val K: PokerRank.Value     = Value(13)
  val Q: PokerRank.Value     = Value(12)
  val J: PokerRank.Value     = Value(11)
  val TEN: PokerRank.Value   = Value(10)
  val NINE: PokerRank.Value  = Value(9)
  val EIGHT: PokerRank.Value = Value(8)
  val SEVEN: PokerRank.Value = Value(7)
  val SIX: PokerRank.Value   = Value(6)
  val FIVE: PokerRank.Value  = Value(5)
  val FOUR: PokerRank.Value  = Value(4)
  val THREE: PokerRank.Value = Value(3)
  val TWO: PokerRank.Value   = Value(2)

  def withNameOpt(s: String): Option[Value] =
    s match {
      case "A"        => Some(PokerRank.A)
      case "K"        => Some(PokerRank.K)
      case "Q"        => Some(PokerRank.Q)
      case "J"        => Some(PokerRank.J)
      case "10" | "T" => Some(PokerRank.TEN)
      case "9"        => Some(PokerRank.NINE)
      case "8"        => Some(PokerRank.EIGHT)
      case "7"        => Some(PokerRank.SEVEN)
      case "6"        => Some(PokerRank.SIX)
      case "5"        => Some(PokerRank.FIVE)
      case "4"        => Some(PokerRank.FOUR)
      case "3"        => Some(PokerRank.THREE)
      case "2"        => Some(PokerRank.TWO)
      case _          => None
    }
}
```
```scala
package com.github.artemkorsakov.games.poker

import com.github.artemkorsakov.games.poker

object PokerSuit extends Enumeration {
  type PokerSuit = Value
  val D: poker.PokerSuit.Value = Value // Diamonds
  val S: poker.PokerSuit.Value = Value // Spades
  val C: poker.PokerSuit.Value = Value // Clubs
  val H: poker.PokerSuit.Value = Value // Hearts = Value

  def withNameOpt(s: String): Option[Value] = values.find(_.toString == s)
  def withNameOpt(s: Char): Option[Value]   = values.find(_.toString == s.toString)
}
```

---
