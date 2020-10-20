package com.github.artemkorsakov.tests.games.poker

import com.github.artemkorsakov.games.poker.Poker
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

import scala.io.Source

class PokerSuite extends AnyFunSuiteLike {
  test("doesPlayer1Win") {
    // Pair of Fives, Pair of Eights
    Poker("5H 5C 6S 7S KD", "2C 3S 8S 8D TD").doesPlayer1Win shouldBe false

    // Highest card Ace, Highest card Queen
    Poker("5D 8C 9S JS AC", "2C 5C 7D 8S QH").doesPlayer1Win shouldBe true

    // Three Aces, Flush with Diamonds
    Poker("2D 9C AS AH AC", "3D 6D 7D TD QD").doesPlayer1Win shouldBe false

    // Pair of Queens Highest card Nine, Pair of Queens Highest card Seven
    Poker("4D 6S 9H QH QC", "3D 6D 7H QD QS").doesPlayer1Win shouldBe true

    // Full House With Three Fours, Full House with Three Threes
    Poker("2H 2D 4C 4D 4S", "3C 3D 3S 9S 9D").doesPlayer1Win shouldBe true

    val rows  = Source.fromResource("p054_poker.txt").getLines
    val count = rows.count(row => Poker(row.substring(0, 14), row.substring(15)).doesPlayer1Win)
    count shouldBe 376
  }
}
