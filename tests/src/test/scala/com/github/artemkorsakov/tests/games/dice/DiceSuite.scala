package com.github.artemkorsakov.tests.games.dice

import com.github.artemkorsakov.games.dice.Dice
import com.github.artemkorsakov.numbers.RationalNumber
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class DiceSuite extends AnyFunSuiteLike {
  test("probabilities") {
    val fractionsPete  = Dice(4).probabilities(9)
    val fractionsColin = Dice(6).probabilities(6)

    var fractionWin       = new RationalNumber(0, 1)
    var fractionLessColin = new RationalNumber(0, 1)

    for (i <- 1 until fractionsPete.length) {
      fractionLessColin += fractionsColin(i - 1)
      fractionWin += fractionsPete(i) * fractionLessColin
    }

    assert(math.round(fractionWin.toPercent * 10000000) / 10000000.0 === 0.5731441 +- 1e-10)
  }
}
