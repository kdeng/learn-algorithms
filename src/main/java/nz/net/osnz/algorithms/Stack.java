package nz.net.osnz.algorithms;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 */
public class Stack {

  static class Node {
    int data;
    Node next;

    Node(int v) {
      this.data = v;
    }
  }

  Node header = null;

  public void push(int value) {
    Node top = new Node(value);
    if (header == null) {
      header = top;
    } else {
      top.next = header;
      header = top;
    }
  }

  public int peek() {
    if (header == null) {
      throw new IndexOutOfBoundsException("Stack is empty");
    }

    return header.data;
  }

  public int pop() {
    if (header == null) {
      throw new IndexOutOfBoundsException("Stack is empty");
    }

    int value = header.data;
    header = header.next;
    return value;
  }

}
