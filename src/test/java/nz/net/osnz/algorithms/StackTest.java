package nz.net.osnz.algorithms;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.stream.IntStream;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 */
public class StackTest {

  @Test
  public void shouldFirstInLastOut() {
    Stack stack = new Stack();

    IntStream.range(0, 10).forEach(i -> stack.push(i));

    for (int i = 9; i >= 0; i--) {
      Assertions.assertEquals(i, stack.pop());
    }
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void popShouldThrowException() {
    Stack stack = new Stack();
    stack.pop();
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void peekShouldThrowException() {
    Stack stack = new Stack();
    stack.peek();
  }

}