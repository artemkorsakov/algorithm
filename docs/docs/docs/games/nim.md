---
layout: docsplus
title: "Nim"
realization: games/nim
---

[Nim](https://en.wikipedia.org/wiki/Nim) is a game played with heaps of stones, where two players take it in turn to remove any number of stones from any heap until no stones remain.

We'll consider the three-heap normal-play version of Nim, which works as follows:
- At the start of the game there are three heaps of stones.
- On each player's turn, the player may remove any positive number of stones from any single heap.
- The first player unable to move (because no stones remain) loses.

If **(n<sub>1</sub>, n<sub>2</sub>, n<sub>3</sub>)** indicates a Nim position consisting 
of heaps of size **n<sub>1</sub>**, **n<sub>2</sub>**, and **n<sub>3</sub>**, 
then there is a simple function, which you may look up 
or attempt to deduce for yourself, **X(n<sub>1</sub>, n<sub>2</sub>, n<sub>3</sub>)** that returns:
- zero if, with perfect strategy, the player about to move will eventually lose; or
- non-zero if, with perfect strategy, the player about to move will eventually win.

For example **X(1, 2, 3) = 0** because, no matter what the current player does, 
the opponent can respond with a move that leaves two heaps of equal size, 
at which point every move by the current player can be mirrored by the opponent until no stones remain; 
so the current player loses. To illustrate:
- current player moves to **(1, 2, 1)**
- opponent moves to **(1, 0, 1)** 
- current player moves to **(0, 0, 1)**
- opponent moves to **(0, 0, 0)**, and so wins.

### getX
Return **X(n<sub>1</sub>, n<sub>2</sub>, n<sub>3</sub>)**.

**Algorithm**

**Complexity**
     
**Sources** 
- [Nim](https://en.wikipedia.org/wiki/Nim)
- [Project Euler. Problem 301](https://projecteuler.net/problem=301)

**Using**
```scala mdoc
import com.github.artemkorsakov.games.nim.Nim
Nim.getX(1, 2, 3)
```

---
