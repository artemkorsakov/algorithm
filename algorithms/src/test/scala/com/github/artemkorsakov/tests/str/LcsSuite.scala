package com.github.artemkorsakov.tests.str

import com.github.artemkorsakov.str.Lcs
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class LcsSuite extends AnyFunSuiteLike {
  test("lcs") {
    Lcs.lcs("", "") shouldBe ""
    Lcs.lcs("abc", "") shouldBe ""
    Lcs.lcs("", "abc") shouldBe ""
    Lcs.lcs("a", "b") shouldBe ""
    Lcs.lcs("a", "a") shouldBe "a"
    Lcs.lcs("abc", "ac") shouldBe "ac"
    Lcs.lcs("abcdef", "abc") shouldBe "abc"
    Lcs.lcs("abcdef", "acf") shouldBe "acf"
    Lcs.lcs("anothertest", "notatest") shouldBe "nottest"
    Lcs.lcs("132535365", "123456789") shouldBe "12356"
    Lcs.lcs("nothardlythefinaltest", "zzzfinallyzzz") shouldBe "final"
    Lcs.lcs("abcdefghijklmnopq", "apcdefghijklmnobq") shouldBe "acdefghijklmnoq"
  }

}
