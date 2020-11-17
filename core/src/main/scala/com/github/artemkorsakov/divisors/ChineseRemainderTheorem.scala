package com.github.artemkorsakov.divisors

import com.github.artemkorsakov.divisors.Divisors.gcdInverse

/** Chinese remainder theorem.
  *
  * @see <a href="https://en.wikipedia.org/wiki/Chinese_remainder_theorem">Chinese remainder theorem</a>
  */
object ChineseRemainderTheorem {

  /** Return n, such than n % a<sub>i</sub> = r<sub>i</sub>.
    */
  def solution(aArray: Array[Long], rArray: Array[Long]): BigInt = {
    val m            = aArray.product                                            // Step 1
    val mArray       = aArray.map(a => m / a)                                    // Step 2
    val mMinus1Array = mArray.indices.map(i => gcdInverse(mArray(i), aArray(i))) // Step 3
    mArray.indices.foldLeft(BigInt(0))((x, i) => x + (((rArray(i) * mArray(i)) % m) * mMinus1Array(i)) % m) // Step 4
  }
}
