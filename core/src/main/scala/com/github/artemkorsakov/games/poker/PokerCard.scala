package com.github.artemkorsakov.games.poker

case class PokerCard(pokerRank: PokerRank.Value, pokerSuit: PokerSuit.Value) {}

object PokerCard {
  def string2PokerCard(card: String): Option[PokerCard] =
    if (card.length < 2 || card.length > 3) {
      None
    } else {
      (PokerRank.withNameOpt(card.dropRight(1)), PokerSuit.withNameOpt(card.last)) match {
        case (Some(pokerRank), Some(pokerSuit)) => Some(PokerCard(pokerRank, pokerSuit))
        case _                                  => None
      }
    }
}
