package nz.net.osnz.dailycodingproblem;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 *
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 *
 * Given the root to a binary tree, count the number of unival subtrees.
 *
 * For example, the following tree has 5 unival subtrees:
 *
 *    0
 *   / \
 *  1   0
 *     / \
 *    1   0
 *   / \
 *  1   1
 *
 */
public class Problem_8 {

  static class Node {

    int data;
    Node left;
    Node right;

    Node(int v) {
      this.data = v;
    }

  }

  public int countUnivalTree(Node root) {
    if (root == null) {
      return 0;
    }

    int count = isUnivalNode(root) ? 1 : 0;
    count += countUnivalTree(root.left);
    count += countUnivalTree(root.right);
    return count;
  }

  public boolean isUnivalNode(Node root) {
    boolean isUnival = true;

    if (root.left != null && root.left.data != root.data) {
      isUnival = false;
    }

    if (root.right != null && root.right.data != root.data) {
      isUnival = false;
    }

    return isUnival;
  }

  @Test
  public void test() {
    Node root = new Node(0);
    root.left = new Node(1);
    root.right = new Node(0);
    root.right.left = new Node(1);
    root.right.right = new Node(0);
    root.right.left.left = new Node(1);
    root.right.left.right = new Node(1);


    Assertions.assertEquals(5, countUnivalTree(root));

  }

}
