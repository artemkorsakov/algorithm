package com.github.artemkorsakov.games.sudoku

case class SuDoku(cells: Array[Array[Array[Int]]]) {

  def result: Option[Array[Array[Int]]] = {
    var hasToRemove = true
    var isValid     = true
    while (isValid && isNotAnswer && hasToRemove) {
      hasToRemove = false
      cells.indices.foreach(i =>
        cells(i).indices
          .withFilter(j => cells(i)(j).length != 1)
          .foreach(j =>
            cells(i)(j).withFilter(!setValueWithoutChanges(i, j, _)).foreach { value =>
              hasToRemove = true
              if (!removeValue(i, j, value)) {
                isValid = false
              }
            }
          )
      )
    }

    if (isValid && !isNotAnswer) Some(cells.map(_.map(_.head)))
    else None
  }

  private def isNotAnswer: Boolean =
    cells.exists(_.exists(_.length != 1))

  /** Set the specified value in the specified field.
    */
  private def setValue(i: Int, j: Int, value: Int): Boolean = {
    val tempSuDoku = copySuDoku
    tempSuDoku.cells(i)(j) = Array(value)
    val result = tempSuDoku.removeValueFromRowColSqr(i, j, value) && tempSuDoku.isSuDokuMatrixValid
    if (result) {
      tempSuDoku.cells.indices.foreach(i => cells(i) = tempSuDoku.cells(i))
    }
    result
  }

  /** Set the specified value in the specified field but then return to the previous state of the cells regardless of the result.
    */
  private def setValueWithoutChanges(i: Int, j: Int, value: Int): Boolean = {
    val tempSuDoku = copySuDoku
    tempSuDoku.cells(i)(j) = Array(value)
    tempSuDoku.removeValueFromRowColSqr(i, j, value) && tempSuDoku.isSuDokuMatrixValid
  }

  /** Check that each row contains digits from 1 to 9 at least once.
    * Check that each column contains digits from 1 to 9 at least once.
    */
  private def isSuDokuMatrixValid: Boolean =
    !(1 to 9).exists(n => cells.exists(_.forall(c => !c.contains(n)))) &&
    !(1 to 9).exists(n => cells.head.indices.exists(j => cells.map(_(j)).forall(c => !c.contains(n))))

  /** Removes a given value from the row, column, and square to which the point belongs. */
  private def removeValueFromRowColSqr(i: Int, j: Int, value: Int): Boolean =
    (0 to 8).forall(k => k == j || removeValue(i, k, value)) && // Removes a given value from the row
    (0 to 8).forall(k => k == i || removeValue(k, j, value)) && // Removes a given value from the column
    (0 to 2).forall(k =>                                        // Removes a given value from the square
      (0 to 2).forall { l =>
        val r = (i / 3) * 3 + k
        val c = (j / 3) * 3 + l
        (r == i && c == j) || removeValue(r, c, value)
      }
    )

  /** Removes a given value from the cell (i, j). */
  private def removeValue(i: Int, j: Int, value: Int): Boolean =
    if (cells(i)(j).length == 1) {
      cells(i)(j).head != value
    } else {
      cells(i)(j) = cells(i)(j).filter(_ != value)
      cells(i)(j).length != 1 || setValue(i, j, cells(i)(j).head)
    }

  private def copySuDoku: SuDoku =
    SuDoku(cells.map(_.map(_.map(i => i))))
}

object SuDoku {
  def apply(): SuDoku = {
    val defaultCells = (0 to 8).map(_ => (0 to 8).map(_ => Array(1, 2, 3, 4, 5, 6, 7, 8, 9)).toArray).toArray
    SuDoku(defaultCells)
  }

  def toSuDoku(source: String): Option[SuDoku] = {
    val sudoku = SuDoku()
    val rows   = source.trim.split("\n")
    val isCorrect = (0 to 8).forall(i =>
      (0 to 8).forall { j =>
        val d = rows(i).charAt(j).getNumericValue
        d == 0 || sudoku.setValue(i, j, d)
      }
    )
    if (isCorrect) Some(sudoku) else None
  }
}
