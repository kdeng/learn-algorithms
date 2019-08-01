package nz.net.osnz.sort;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Kefeng Deng (deng@51any.com)
 */
public class MergeSort {


  public void sort(int[] array) {
    mergeSort(array, array.length);
  }

  public void mergeSort(int[] array, int n) {
    if (n < 2) {
      return;
    }

    int mid = n / 2;
    int[] left = new int[mid];
    int[] right = new int[n - mid];

    for (int i = 0; i < mid; i++) {
      left[i] = array[i];
    }

    for (int i = mid; i < n; i++) {
      right[i - mid] = array[i];
    }

    mergeSort(left, mid);
    mergeSort(right, n - mid);

    merge(array, left, right, mid, n - mid);
  }

  public void merge(int[] array, int[] left, int[] right, int leftCount, int rightCount) {
    int i = 0, j = 0, k = 0;

    for (; i < leftCount && j < rightCount; ) {
      if (left[i] < right[j]) {
        array[k++] = left[i++];
      } else {
        array[k++] = right[j++];
      }
    }

    if (i < leftCount) {
      for (; i < leftCount; ) {
        array[k++] = left[i++];
      }
    }

    if (j < rightCount) {
      for (; j < rightCount; ) {
        array[k++] = right[j++];
      }
    }

  }

  @Test
  public void positiveTest() {
    int[] actual = { 5, 1, 6, 2, 3, 4 };
    int[] expected = { 1, 2, 3, 4, 5, 6 };
    sort(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void test() {
    int[] original = new int[]{9, 7, 5, 11, 12, 2, 14, 3, 10, 6};
    sort(original);
    int[] expect = new int[]{2, 3, 5, 6, 7, 9, 10, 11, 12, 14};
    assertArrayEquals(expect, original);
  }

  @Test
  public void test2() {
    int[] original = {10, 7, 8, 9, 1, 5};
    sort(original);
    int[] expect = {1, 5, 7, 8, 9, 10};
    assertArrayEquals(expect, original);
  }

  @Test
  public void test10() {// 9 03 83 9 2 0 1 65 2 822 9 11 22 3 3 3 47
    int[] list = {9, 03, 83, 9, 2, 0, 1, 65, 2, 822, 9, 11, 22, 3, 3, 3, 47};
    sort(list);
    String actual = String.join(" ", IntStream.of(list).boxed().map(i -> Integer.toString(i)).collect(Collectors.toList()));
    assertEquals("0 1 2 2 3 3 3 3 9 9 9 11 22 47 65 83 822", actual);
  }

}
