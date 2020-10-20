package com.github.artemkorsakov.games.poker

case class Poker(player1: String, player2: String) {
  private val player1Hands: PokerHand = new PokerHand(player1)
  private val player2Hands: PokerHand = new PokerHand(player2)

  val doesPlayer1Win: Boolean = player1Hands.compareTo(player2Hands) <= 0
}
