package nz.net.osnz.sort;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 */
public class QuickSort {

  public static int[] sort(int[] input) {
    int n = input.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = n - 1; j > i; j--) {
        if (input[i] > input[j]) {
          int temp = input[j];
          input[j] = input[i];
          input[i] = temp;
        }
      }
    }
    return input;
  }

  @Test
  public void test() {
    int[] original = new int[]{9, 7, 5, 11, 12, 2, 14, 3, 10, 6};
    int[] expect = new int[]{2, 3, 5, 6, 7, 9, 10, 11, 12, 14};
    Assertions.assertArrayEquals(expect, sort(original));
  }

  @Test
  public void test2() {
    int[] original = {10, 7, 8, 9, 1, 5};
    int[] expect = {1, 5, 7, 8, 9, 10};
    Assertions.assertArrayEquals(expect, sort(original));
  }

  @Test
  public void test10() {// 9 03 83 9 2 0 1 65 2 822 9 11 22 3 3 3 47
    int[] list = {9, 03, 83, 9, 2, 0, 1, 65, 2, 822, 9, 11, 22, 3, 3, 3, 47};
    int[] result = sort(list);

    String actual = String.join(" ", IntStream.of(list).boxed().map(i -> Integer.toString(i)).collect(Collectors.toList()));

    assertEquals("0 1 2 2 3 3 3 3 9 9 9 11 22 47 65 83 822", actual);
  }

}
