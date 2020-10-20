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
