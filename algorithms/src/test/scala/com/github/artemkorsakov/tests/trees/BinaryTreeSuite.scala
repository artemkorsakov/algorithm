package com.github.artemkorsakov.tests.trees

import com.github.artemkorsakov.trees.BinaryTree.Tree._
import com.github.artemkorsakov.trees.BinaryTree._
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers._

class BinaryTreeSuite extends AnyFunSuiteLike {
  private val simpleTree = Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End)))

  test("BinaryTree.nodeCount") {
    Node('b', Node('d'), Node('e')).nodeCount shouldBe 3
    simpleTree.nodeCount shouldBe 7
  }

  test("BinaryTree.height") {
    simpleTree.height shouldBe 4
  }

  test("BinaryTree.leafCount") {
    simpleTree.leafCount shouldBe 3
    Node('x', Node('x'), End).leafCount shouldBe 1
  }

  test("BinaryTree.leafList") {
    simpleTree.leafList shouldBe List('d', 'e', 'g')
    Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList shouldBe List('b', 'd', 'e')
  }

  test("BinaryTree.internalList") {
    simpleTree.internalList shouldBe List('a', 'b', 'c', 'f')
    Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList shouldBe List('a', 'c')
  }

  test("BinaryTree.atLevel") {
    simpleTree.atLevel(1) shouldBe List('a')
    simpleTree.atLevel(2) shouldBe List('b', 'c')
    simpleTree.atLevel(3) shouldBe List('d', 'e', 'f')
    simpleTree.atLevel(4) shouldBe List('g')

    Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(1) shouldBe List('a')
    Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(2) shouldBe List('b', 'c')
    Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(3) shouldBe List('d', 'e')
  }

  test("BinaryTree.isMirrorOf") {
    simpleTree.isMirrorOf(
      Node('a', Node('b', Node('d', End, Node('e')), End), Node('c', Node('g'), Node('f')))
    )
  }

  test("BinaryTree.isSymmetric") {
    assert(!simpleTree.isSymmetric)
    assert(Node('a', Node('b', Node('d', End, Node('e')), End), Node('c', End, Node('f', Node('g'), End))).isSymmetric)
  }

  test("BinaryTree.addValue") {
    var tree = End.addValue(2)
    tree shouldBe Node(2)
    tree = tree.addValue(3)
    tree shouldBe Node(2, End, Node(3))
    tree = tree.addValue(0)
    tree shouldBe Node(2, Node(0), Node(3))
    tree = tree.addValue(1)
    tree shouldBe Node(2, Node(0, End, Node(1)), Node(3))
    tree = tree.addValue(-1)
    tree shouldBe Node(2, Node(0, Node(-1), Node(1)), Node(3))
  }

  test("BinaryTree.toString") {
    End.toString shouldBe ""
    Node('e').toString shouldBe "e"
    simpleTree.toString shouldBe "a(b(d,e),c(,f(g,)))"
  }

  test("Tree.mirror") {
    mirror(simpleTree) shouldBe Node('a', Node('c', Node('f', End, Node('g')), End), Node('b', Node('e'), Node('d')))
    mirror(Node('a', Node('b'), Node('c'))) shouldBe Node('a', Node('c'), Node('b'))
  }

  test("Tree.fromList") {
    Tree.fromList(List(3, 2, 5, 7, 1)) shouldBe Node(3, Node(2, Node(1), End), Node(5, End, Node(7)))

    Tree.fromList(List(5, 3, 18, 1, 4, 12, 21)).isSymmetric shouldBe true

    Tree.fromList(List(3, 2, 5, 7, 4)).isSymmetric shouldBe false
  }

  test("Tree.fromString") {
    Tree.fromString("a(b(d,e),c(,f(g,)))") shouldBe simpleTree
  }

  test("Tree.completeBinaryTree") {
    Tree.completeBinaryTree(6, "x") shouldBe Node("x", Node("x", Node("x"), Node("x")), Node("x", Node("x"), End))
  }

}
