package com.github.artemkorsakov.str

class StringAlgorithms(str: String) {
  def sum(second: String): String = StringAlgorithms.sum(str, second)
  def |+|(second: String): String = sum(second)
}

object StringAlgorithms {
  implicit def str2StringAlgorithms(str: String): StringAlgorithms = new StringAlgorithms(str)

  /** Sum of two big numbers.
    */
  def sum(first: String, second: String): String = {
    val first0  = first.replaceAll("\\D", "")
    val second0 = second.replaceAll("\\D", "")
    if (first0.isEmpty || second0.isEmpty) {
      first0 + second0
    } else {
      var sumLast  = first0.last.toString.toInt + second0.last.toString.toInt
      var sumFirst = sum(first0.dropRight(1).mkString, second0.dropRight(1).mkString)
      if (sumLast > 9) {
        sumFirst = sum(sumFirst, "1")
        sumLast -= 10
      }
      sumFirst + sumLast.toString
    }
  }

  /** Are two words anagrams?
    */
  def areAnagrams(word1: String, word2: String): Boolean =
    (word1.length == word2.length) && word1.toCharArray.sorted.sameElements(word2.toCharArray.sorted)

  /** Gets the alphabetical value.
    *
    * @see <a href="https://projecteuler.net/problem=22">Project Euler Problem 22</a>
    */
  def alphabeticalValue(str: String): Int =
    str.replaceAll("\\W", "").toUpperCase().foldLeft(0)((sum, aChar) => sum + (aChar - 'A') + 1)

}
