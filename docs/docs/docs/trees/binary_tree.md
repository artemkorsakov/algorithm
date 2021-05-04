---
layout: docsplus
title: "Binary Tree"
realization: trees/BinaryTree.scala
---

### Common operations
- **nodeCount** - count of nodes in the binary tree.
- **height** - binary tree height.
- **leafCount** - count of leaf. A leaf is a node with no successors.
- **leafList** - collect leaf in a list.
- **internalList** - list of internal nodes. 
An internal node of a binary tree has either one or two non-empty successors.
- **atLevel(level: Int)** - Collect the nodes at a given level in a list. 
The root node is at level 1. 
A node of a binary tree is at level N if the path from the root to the node has length N-1.
- **isMirrorOf** - is the given tree a mirror image in the structure?
- **isSymmetric** - is the given tree a symmetric binary trees?
Let us call a binary tree symmetric if you can draw a vertical line through the root node and 
then the right subtree is the mirror image in the structure of the left subtree.
- **addValue** - add an element to a binary search tree.
- **mirror** - the mirror tree.
- **fromList** - generate tree from list.
- **fromString** - generate tree from string.
- **completeBinaryTree(nodes: Int, value: T)** - A complete binary tree.
A complete binary tree with height H is defined as follows: The levels 1,2,3,...,H-1 contain the maximum number
of nodes (i.e 2(i-1) at the level i, note that we start counting the levels from 1 at the root).
In level H, which may contain less than the maximum possible number of nodes, all the nodes are "left-adjusted".
This means that in a levelorder tree traversal all internal nodes come first, the leaves come second,
and empty successors (the Ends which are not really nodes!) come last.

**Algorithm**

**Complexity**
     
**Sources** 
- [Ninety-Nine Scala Problems](http://aperiodic.net/phil/scala/s-99/)

**Using**
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

---
