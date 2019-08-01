package nz.net.osnz.dailycodingproblem;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 *
 * Question: return a new sorted merged list from K sorted lists, each with size N.
 *
 * Expect: [[10, 15, 30], [12, 15, 20], [17, 20, 32]], the result should be [10, 12, 15, 15, 17, 20, 20, 30, 32]
 *
 *
 */
public class N7_Solution {

  int[] solution(int[][] input) {
    int[] result = input[0];
    for (int i=1; i<input.length; i++) {
      result = merge(result, input[i]);
    }
    return result;
  }

  int[] merge(int[] array1, int[] array2) {
    int[] result = new int[array1.length + array2.length];

    for (int i=0, j=0, k=0; i<array1.length+array2.length; i++) {
      if (j < array1.length && k < array2.length) {
        if (array1[j] <= array2[k]) {
          result[i] = array1[j];
          j++;
        } else {
          result[i] = array2[k];
          k++;
        }
      } else if (j < array1.length) {
        result[i] = array1[j];
        j++;
      } else {
        result[i] = array2[k];
        k++;
      }
    }

    return result;
  }


  @Test
  public void testSolution() {
    int[][] input = {
      {10, 15, 30},
      {12, 15, 20},
      {17, 20, 32}
    };
    int[] expect = new int[]{10, 12, 15, 15, 17, 20, 20, 30, 32};
    Assertions.assertArrayEquals(expect, solution(input));
  }

}
