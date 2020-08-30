package nz.net.osnz.algorithms;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static nz.net.osnz.algorithms.BinaryTree.findNode;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 */
public class BinaryTreeTest {

  @Test
  public void testNewBinaryTree() {
    BinaryTree binaryTree = new BinaryTree(50);

    binaryTree.add(10);
    binaryTree.add(20);
    binaryTree.add(5);

    binaryTree.add(80);
    binaryTree.add(60);
    binaryTree.add(90);

  }


  @Test
  public void test() {
    BinaryTree.Node node = new BinaryTree.Node(1);

    node.left = new BinaryTree.Node(2);
    node.right = new BinaryTree.Node(3);

    node.left.left = new BinaryTree.Node(4);
    node.left.right = new BinaryTree.Node(5);

    node.right.left = new BinaryTree.Node(6);
    node.right.right = new BinaryTree.Node(7);

    node.left.left.left = new BinaryTree.Node(9);
    node.left.left.right = new BinaryTree.Node(10);

    node.left.right.left = new BinaryTree.Node(11);
    node.left.right.right = new BinaryTree.Node(12);

    node.right.left.left = new BinaryTree.Node(13);
    node.right.left.right = new BinaryTree.Node(14);

    node.right.right.left = new BinaryTree.Node(15);
    node.right.right.right = new BinaryTree.Node(16);

    int expect = 4;
    Assertions.assertEquals(expect, findNode(node, 1, 16));
  }

  @Test
  public void testFind() {
    BinaryTree.Node node = new BinaryTree.Node(8);

    node.left = new BinaryTree.Node(3);
    node.right = new BinaryTree.Node(10);

    node.left.left = new BinaryTree.Node(1);
    node.left.right = new BinaryTree.Node(6);

    node.right.left = null;
    node.right.right = new BinaryTree.Node(14);

    node.left.left.left = null;
    node.left.left.right = null;

    node.left.right.left = new BinaryTree.Node(4);
    node.left.right.right = new BinaryTree.Node(7);

    node.right.right.left = new BinaryTree.Node(13);
    node.right.right.right = null;

    BinaryTree.Node target = node.find(14);
    Assertions.assertEquals(14, target.data);
  }

}
