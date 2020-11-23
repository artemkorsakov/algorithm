---
layout: docs
title: "Trees"
---

## {{page.title}}

The package ```com.github.artemkorsakov.trees``` contains algorithms with trees. 

You can use the package, for example, like this:
```scala mdoc
import com.github.artemkorsakov.trees.BinaryTree.Tree._
import com.github.artemkorsakov.trees.BinaryTree._
val simpleTree = Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End)))
simpleTree.nodeCount
simpleTree.height
simpleTree.leafCount
simpleTree.leafList
simpleTree.internalList
simpleTree.atLevel(3)
simpleTree.isMirrorOf(Node('a', Node('b', Node('d', End, Node('e')), End), Node('c', Node('g'), Node('f'))))
simpleTree.isSymmetric
Node('a', Node('b', Node('d', End, Node('e')), End), Node('c', End, Node('f', Node('g'), End))).isSymmetric
End.addValue(2).addValue(3).addValue(0).addValue(1).addValue(-1)
mirror(simpleTree)
Tree.fromList(List(5, 3, 18, 1, 4, 12, 21))
Tree.fromString("a(b(d,e),c(,f(g,)))")
Tree.completeBinaryTree(17, "x")
```
