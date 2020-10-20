package com.github.artemkorsakov.games.nim

/** <a href="https://en.wikipedia.org/wiki/Nim">Nim</a> */
object Nim {
  def getX(params: Long*): Long =
    (1 until params.length).foldLeft(params.head)((res, i) => res ^ params(i))
}
