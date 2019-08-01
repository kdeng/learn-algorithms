package nz.net.osnz.algorithms;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 */
public class QueueTest {

  @Test
  public void testFirstInFirstOut() {

    Queue queue = new Queue();

    IntStream.range(0, 10).forEach(i -> queue.push(i));

    for (int i = 0; i < 10; i++) {
      Assertions.assertEquals(i, queue.pop());
    }

  }

}