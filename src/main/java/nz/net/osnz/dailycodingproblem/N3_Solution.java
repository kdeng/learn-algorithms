package nz.net.osnz.dailycodingproblem;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 *
 * Given the root to a binary tree, implement serialize(root),
 * which serializes the tree into a string, and deserialize(s),
 * which deserializes the string back into the tree.
 *
 *
 * node = Node('root', Node('left', Node('left.left')), Node('right'))
 * assert deserialize(serialize(node)).left.left.val == 'left.left'
 *
 * @TODO
 */
public class N3_Solution {

  static class Node {
    String val;
    Node left;
    Node right;

    public Node(String v) {
      this(v, null, null);
    }

    public Node(String v, Node left) {
      this(v, left, null);
    }

    public Node(String v, Node left, Node right) {
      val = v;
      this.left = left;
      this.right = right;
    }

  }

  Node deserialize(String s) {
    return new Node("");
  }

  String serialize(Node root) {
    return "";
  }

  @Test
  public void testCase() {
    Node node = new Node("root", new Node("left", new Node("left.left")), new Node("right"));
    Assertions.assertEquals("left.left", deserialize(serialize(node)).left.left.val);
  }



}
