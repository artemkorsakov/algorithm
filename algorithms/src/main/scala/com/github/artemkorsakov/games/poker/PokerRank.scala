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
