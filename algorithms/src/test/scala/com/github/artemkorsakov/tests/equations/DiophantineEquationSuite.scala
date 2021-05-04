package com.github.artemkorsakov.tests.equations

import com.github.artemkorsakov.equations.DiophantineEquation
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class DiophantineEquationSuite extends AnyFunSuiteLike {
  test("minimalEquation and isSuccess") {
    DiophantineEquation(67).minimalEquation shouldBe Some((BigInt(48842), BigInt(5967)))
    DiophantineEquation(13).minimalEquation shouldBe Some((BigInt(649), BigInt(180)))
    DiophantineEquation(2).minimalEquation shouldBe Some((BigInt(3), BigInt(2)))
    DiophantineEquation(3).minimalEquation shouldBe Some((BigInt(2), BigInt(1)))
    DiophantineEquation(5).minimalEquation shouldBe Some((BigInt(9), BigInt(4)))
    DiophantineEquation(6).minimalEquation shouldBe Some((BigInt(5), BigInt(2)))
    DiophantineEquation(7).minimalEquation shouldBe Some((BigInt(8), BigInt(3)))
    DiophantineEquation(4).minimalEquation shouldBe None
    DiophantineEquation(9).minimalEquation shouldBe None
    DiophantineEquation(61).minimalEquation shouldBe Some((BigInt(1766319049), BigInt(226153980)))
    DiophantineEquation(73).minimalEquation shouldBe Some((BigInt(2281249), BigInt(267000)))
    DiophantineEquation(94).minimalEquation shouldBe Some((BigInt(2143295), BigInt(221064)))
    DiophantineEquation(109).minimalEquation shouldBe Some((BigInt(158070671986249L), BigInt(15140424455100L)))
    DiophantineEquation(110).minimalEquation shouldBe Some((BigInt(21), BigInt(2)))
    DiophantineEquation(61).isSuccess(BigInt(1766319049), BigInt(226153980)) shouldBe true
  }

}
