package nz.net.osnz.dailycodingproblem;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 *
 * Given an array of integers, return a new array such that each element at
 * index i of the new array is the product of all the numbers in the original
 * array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5],
 * the expected output would be [120, 60, 40, 30, 24].
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *
 */
public class N2_Solution {

  public int[] solution(int[] input) {
    int[] result = new int[input.length];
    int multiple = 1;
    for (int i=0; i<input.length; i++) {
      multiple *= input[i];
    }

    for (int i=0; i<input.length; i++) {
      result[i] = multiple / input[i];
    }

    return result;
  }

  public int[] solution2(int[] input) {
    multiple(input, 1, 0);
    return input;
  }

  public int multiple(int[] input, int m, int p) {
    if (p >= input.length - 1) {
      int temp = input[p];
      input[p] = m;
      return temp;
    }
    int next = multiple(input, m * input[p], p+1);
    int temp = input[p];
    input[p] = next * m;
    return next * temp;
  }


  @Test
  public void testCaseOne() {
    Assertions.assertArrayEquals(new int[]{120, 60, 40, 30, 24}, solution2(new int[]{1,2,3,4,5}));
    Assertions.assertArrayEquals(new int[]{2,3,6}, solution2(new int[]{3,2,1}));
  }


}
