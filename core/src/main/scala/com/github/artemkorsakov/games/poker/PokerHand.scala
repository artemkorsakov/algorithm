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
