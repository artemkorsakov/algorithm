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
