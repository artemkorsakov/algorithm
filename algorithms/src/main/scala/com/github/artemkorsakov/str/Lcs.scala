package com.github.artemkorsakov.str

object Lcs {

  /** <a href="https://en.wikipedia.org/wiki/Longest_common_subsequence_problem">Longest common subsequence problem</a> */
  def lcs(a: String, b: String): String = {
    val C: Array[Array[Int]] = lcsLength(a, b)
    backtrack(C, a, b, a.length, b.length)
  }

  private def backtrack(C: Array[Array[Int]], aStr: String, bStr: String, x: Int, y: Int): String =
    if (x == 0 | y == 0) {
      ""
    } else if (aStr(x - 1) == bStr(y - 1)) {
      backtrack(C, aStr, bStr, x - 1, y - 1) + aStr(x - 1)
    } else if (C(x)(y - 1) > C(x - 1)(y)) {
      backtrack(C, aStr, bStr, x, y - 1)
    } else {
      backtrack(C, aStr, bStr, x - 1, y)
    }

  private def lcsLength(a: String, b: String): Array[Array[Int]] = {
    val C = new Array[Array[Int]](a.length + 1)
    C.indices.foreach(i => C(i) = new Array[Int](b.length + 1))
    a.indices.foreach(i => C(i)(0) = 0)
    b.indices.foreach(j => C(0)(j) = 0)
    a.indices.foreach(i =>
      b.indices.foreach { j =>
        C(i + 1)(j + 1) = if (a(i) == b(j)) C(i)(j) + 1 else math.max(C(i + 1)(j), C(i)(j + 1))
      }
    )
    C
  }

}
