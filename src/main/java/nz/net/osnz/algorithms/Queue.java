package nz.net.osnz.algorithms;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 */
public class Queue {

  static class Node {
    int data;
    Node next;

    Node(int v) {
      this.data = v;
    }
  }

  private Node header;
  private Node tail;

  public void push(int v) {
    Node node = new Node(v);

    if (header == null) {
      header = node;
    }

    if (tail != null) {
      tail.next = node;
    }

    tail = node;

  }

  public int pop() {
    if (header == null) {
      throw new IndexOutOfBoundsException("Queue is empty");
    }

    int value = header.data;
    header = header.next;

    if (header == null) {
      tail = null;
    }

    return value;
  }


}
