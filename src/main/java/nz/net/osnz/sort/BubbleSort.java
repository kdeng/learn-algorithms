package nz.net.osnz.sort;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Kefeng Deng (deng@51any.com)
 */
public class BubbleSort {

  public void sort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - i - 1; j++) {
        if (array[j] > array[j+1]) {
          int temp = array[j];
          array[j] = array[j+1];
          array[j+1] = temp;
        }
      }
    }
  }

  @Test
  public void test() {
    int[] original = new int[]{9, 7, 5, 11, 12, 2, 14, 3, 10, 6};
    sort(original);
    int[] expect = new int[]{2, 3, 5, 6, 7, 9, 10, 11, 12, 14};
    Assertions.assertArrayEquals(expect, original);
  }

  @Test
  public void test2() {
    int[] original = {10, 7, 8, 9, 1, 5};
    sort(original);
    int[] expect = {1, 5, 7, 8, 9, 10};
    Assertions.assertArrayEquals(expect, original);
  }

  @Test
  public void test10() {// 9 03 83 9 2 0 1 65 2 822 9 11 22 3 3 3 47
    int[] list = {9, 03, 83, 9, 2, 0, 1, 65, 2, 822, 9, 11, 22, 3, 3, 3, 47};
    sort(list);
    String actual = String.join(" ", IntStream.of(list).boxed().map(i -> Integer.toString(i)).collect(Collectors.toList()));
    assertEquals("0 1 2 2 3 3 3 3 9 9 9 11 22 47 65 83 822", actual);
  }

}
