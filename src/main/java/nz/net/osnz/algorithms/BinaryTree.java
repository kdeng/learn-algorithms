package nz.net.osnz.algorithms;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 */
public class BinaryTree {

  static class Node {
    int data;
    Node left;
    Node right;

    Node(int v) {
      this.data = v;
    }

    Node find(int value) {

      if (value == data) {
        return this;
      }

      if (left == null && right == null) {
        return null;
      }

      Node result = null;
      if (left != null) {
        result = left.find(value);
      }

      if (result != null && result.data == value) {
        return result;
      }

      return right.find(value);

    }

  }

  Node root;

  public BinaryTree(int v) {
    root = new Node(v);
  }

  void add(int v) {
    root = createNewNode(root, v);
  }

  private Node createNewNode(Node node, int v) {
    if (node == null) {
      return new Node(v);
    }
    if (v < node.data) {
      node.left = createNewNode(node.left, v);
    }
    if (v > node.data) {
      node.right = createNewNode(node.right, v);
    }
    return node;
  }

  static int findNode(Node root, int level, int target) {
    if (root == null) {
      return -1;
    }

    if (target == root.data) {
      return level; // last level + 1
    }

    int leftResult = findNode(root.left, level+1, target); // O(2n)
    if (leftResult > level) {
      return leftResult;
    }

    int rightResult = findNode(root.right, level+1, target); //
    if (rightResult > level) {
      return rightResult;
    }

    return -1;
  }


}
