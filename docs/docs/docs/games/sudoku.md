---
layout: docsplus
title: "SuDoku"
realization: games/sudoku
---

Su Doku (Japanese meaning _number place_) is the name given to a popular puzzle concept. 
Its origin is unclear, but credit must be attributed to Leonhard Euler who invented a similar, 
and much more difficult, puzzle idea called Latin Squares. 
The objective of Su Doku puzzles, however, is to replace the blanks (or zeros) in a 9 by 9 grid in such 
that each row, column, and 3 by 3 box contains each of the digits 1 to 9. 
Below is an example of a typical starting puzzle grid and its solution grid.

![image 1](https://projecteuler.net/project/images/p096_1.png)
![image 2](https://projecteuler.net/project/images/p096_2.png)

A well constructed Su Doku puzzle has a unique solution and can be solved by logic, 
although it may be necessary to employ "guess and test" methods in order to eliminate options 
(there is much contested opinion over this). The complexity of the search determines the difficulty of the puzzle; 
the example above is considered easy because it can be solved by straight forward direct deduction.

### result

Returns a solution for the given SuDoku.

**Algorithm**

**Complexity**
     
**Sources** 
- [Project Euler. Problem 96](https://projecteuler.net/problem=96)

**Using**
```scala mdoc
import com.github.artemkorsakov.games.sudoku.SuDoku._
val src = "003020600\n900305001\n001806400\n008102900\n700000008\n006708200\n002609500\n800203009\n005010300"
toSuDoku(src).get.result.foreach(_.foreach(row => println(row.mkString("|", "", "|"))))
```

---
