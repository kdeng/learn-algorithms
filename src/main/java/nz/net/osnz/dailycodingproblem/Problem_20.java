package nz.net.osnz.dailycodingproblem;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashSet;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 * <p>
 * This problem was asked by Google.
 * <p>
 * Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
 * <p>
 * For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
 * <p>
 * In this example, assume nodes with the same value are the exact same node objects.
 * <p>
 * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 */
public class Problem_20 {

  class Node {
    int data;
    Node next;

    Node(int v) {
      this.data = v;
    }

    Node createNewNode(int v) {
      return new Node(v);
    }
  }

  class SinglyLinkedList {
    Node root;

    SinglyLinkedList(int data) {
      root = new Node(data);
    }

    public void push(int v) {
      append(root, v);
    }

    private void append(Node node, int v) {
      if (node.next == null) {
        node.next = new Node(v);
      } else {
        append(node.next, v);
      }
    }

  }

  // time cost: O(n*m)
  public int solution1(SinglyLinkedList list1, SinglyLinkedList list2) {
    Node left = list1.root;
    while (left != null) {
      Node right = list2.root;
      while (right != null) {
        if (left.data == right.data) {
          return left.data;
        }
        right = right.next;
      }
      left = left.next;
    }
    return -1;
  }

  // time cost: O(n+m)
  public int solution2(SinglyLinkedList list1, SinglyLinkedList list2) {
    HashSet<Integer> set = new HashSet<>();

    for (Node node = list1.root; node != null; node = node.next) {
      set.add(node.data);
    }

    for (Node node = list2.root; node != null; node = node.next) {
      if (set.contains(node.data)) {
        return node.data;
      }
    }
    return -1;
  }

  @Test
  public void test() {
    SinglyLinkedList list1 = new SinglyLinkedList(3);
    list1.push(7);
    list1.push(8);
    list1.push(10);

    SinglyLinkedList list2 = new SinglyLinkedList(99);
    list2.push(1);
    list2.push(8);
    list2.push(10);

    int expect = 8;
    int actual = solution2(list1, list2);

    Assertions.assertEquals(expect, actual);

  }


}
