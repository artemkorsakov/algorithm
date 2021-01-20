package com.github.artemkorsakov.trees

/** A binary tree is either empty or it is composed of a root element and two successors, which are binary trees themselves.
  * An End is equivalent to an empty tree.
  * A Branch has a value, and two descendant trees.
  * A tree with only a root node would be Node('a').
  */
object BinaryTree {
  sealed abstract class Tree[+T] {

    /** Count of nodes. */
    def nodeCount: Int

    /** Binary tree height. */
    def height: Int

    /** Count of leaf. A leaf is a node with no successors. */
    def leafCount: Int

    /** Collect leaf in a list. */
    def leafList: List[T]

    /** List of internal nodes. An internal node of a binary tree has either one or two non-empty successors. */
    def internalList: List[T]

    /** Collect the nodes at a given level in a list. The root node is at level 1.
      * A node of a binary tree is at level N if the path from the root to the node has length N-1.
      */
    def atLevel(level: Int): List[T]

    /** Is the given tree a mirror image in the structure? */
    def isMirrorOf[V](tree: Tree[V]): Boolean

    /** Symmetric binary trees.
      * Let us call a binary tree symmetric if you can draw a vertical line through the root node and
      * then the right subtree is the mirror image in the structure of the left subtree.
      *
      * Node('a', Node('b'), Node('c')).isSymmetric is true
      */
    def isSymmetric: Boolean

    /** Add an element to a binary search tree. */
    def addValue[U >: T](x: U)(implicit ev: U => Ordered[U]): Tree[U]
  }

  case object End extends Tree[Nothing] {
    override def nodeCount: Int                                                      = 0
    override def height: Int                                                         = 0
    override def leafCount: Int                                                      = 0
    override def leafList: List[Nothing]                                             = Nil
    override def internalList: List[Nothing]                                         = Nil
    override def atLevel(level: Int): List[Nothing]                                  = Nil
    override def isMirrorOf[V](tree: Tree[V]): Boolean                               = tree == End
    override def isSymmetric: Boolean                                                = true
    override def addValue[U >: Nothing](x: U)(implicit ev: U => Ordered[U]): Tree[U] = Node(x)
    override def toString: String                                                    = ""
  }

  case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
    override def nodeCount: Int = 1 + left.nodeCount + right.nodeCount

    override def height: Int = 1 + math.max(left.height, right.height)

    override def leafCount: Int = (left, right) match {
      case (End, End) => 1
      case _          => left.leafCount + right.leafCount
    }

    override def leafList: List[T] = (left, right) match {
      case (End, End) => List(value)
      case _          => left.leafList ::: right.leafList
    }

    override def internalList: List[T] = (left, right) match {
      case (End, End) => Nil
      case _          => value :: left.internalList ::: right.internalList
    }

    override def atLevel(level: Int): List[T] = level match {
      case n if n < 1 => Nil
      case 1          => List(value)
      case l          => left.atLevel(l - 1) ::: right.atLevel(l - 1)
    }

    def isMirrorOf[V](tree: Tree[V]): Boolean = tree match {
      case t: Node[V] => left.isMirrorOf(t.right) && right.isMirrorOf(t.left)
      case _          => false
    }

    def isSymmetric: Boolean = left.isMirrorOf(right)

    override def addValue[U >: T](x: U)(implicit ev: U => Ordered[U]): Tree[U] =
      if (x < value) {
        Node(value, left.addValue(x), right)
      } else {
        Node(value, left, right.addValue(x))
      }

    override def toString: String = (left, right) match {
      case (End, End) => value.toString
      case _          => value.toString + "(" + left + "," + right + ")"
    }
  }

  object Node {
    def apply[T](value: T): Node[T] = Node(value, End, End)
  }

  object Tree {

    /** The mirror tree. */
    def mirror[T](tree: Tree[T]): Tree[T] = tree match {
      case End                      => End
      case Node(value, left, right) => Node(value, mirror(right), mirror(left))
    }

    def fromList[T](list: List[T])(implicit ev: T => Ordered[T]): Tree[T] =
      list.foldLeft(End: Tree[T])((r, e) => r.addValue(e))

    def fromString(input: String): Tree[Char] = input.length match {
      case 0 => End
      case 1 => Node(input.head)
      case _ =>
        val value = input.head
        val index = {
          var c = 0
          var i = 2
          while (input(i) != ',' || c != 0) {
            if (input(i) == '(') {
              c += 1
            } else if (input(i) == ')') {
              c -= 1
            }
            i += 1
          }
          i
        }
        val left  = fromString(input.substring(2, index))
        val right = fromString(input.substring(index + 1, input.length - 1))
        Node(value, left, right)
    }

    /** A complete binary tree.
      *
      * A complete binary tree with height H is defined as follows: The levels 1,2,3,...,H-1 contain the maximum number
      * of nodes (i.e 2(i-1) at the level i, note that we start counting the levels from 1 at the root).
      * In level H, which may contain less than the maximum possible number of nodes, all the nodes are "left-adjusted".
      * This means that in a levelorder tree traversal all internal nodes come first, the leaves come second,
      * and empty successors (the Ends which are not really nodes!) come last.
      */
    def completeBinaryTree[T](nodes: Int, value: T): Tree[T] = {
      def generateTree(addr: Int): Tree[T] =
        if (addr > nodes) End
        else Node(value, generateTree(2 * addr), generateTree(2 * addr + 1))
      generateTree(1)
    }
  }
}
