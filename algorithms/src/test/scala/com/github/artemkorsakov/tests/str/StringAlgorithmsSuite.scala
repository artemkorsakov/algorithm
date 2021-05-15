package com.github.artemkorsakov.tests.str

import com.github.artemkorsakov.str.StringAlgorithms._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class StringAlgorithmsSuite extends AnyFunSuiteLike {
  test("sum") {
    sum(
      "37107287533902102798797998220837590246510135740250",
      "46376937677490009712648124896970078050417018260538"
    ) shouldBe "83484225211392112511446123117807668296927154000788"
    ("37107287533902102798797998220837590246510135740250" sum "46376937677490009712648124896970078050417018260538")
      .shouldBe("83484225211392112511446123117807668296927154000788")
    ("37107287533902102798797998220837590246510135740250" |+| "46376937677490009712648124896970078050417018260538")
      .shouldBe("83484225211392112511446123117807668296927154000788")
  }

  test("areAnagrams") {
    areAnagrams("post", "stop") shouldBe true
    areAnagrams("post", "stoop") shouldBe false
    areAnagrams("post", "soop") shouldBe false
  }

  test("alphabeticalValue") {
    alphabeticalValue("test") shouldBe 64
    alphabeticalValue("COLIN") shouldBe 53
    alphabeticalValue("\"COLIN\"") shouldBe 53
    alphabeticalValue("COL'IN") shouldBe 53
    alphabeticalValue("SKY") shouldBe 55
  }

}
