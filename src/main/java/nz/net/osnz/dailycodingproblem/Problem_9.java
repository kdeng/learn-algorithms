package nz.net.osnz.dailycodingproblem;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author Kefeng Deng (deng@51any.com)
 *
 * This problem was asked by Airbnb.
 *
 * Given a list of integers, write a function that returns the
 * largest sum of non-adjacent numbers. Numbers can be 0 or negative.
 *
 * For example,
 *
 * [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5.
 * [5, 1, 1, 5] should return 10, since we pick 5 and 5.
 *
 * Follow-up: Can you do this in O(N) time and constant space?
 * @TODO :
 */
public class Problem_9 {

  public int maximumSum(int[] array) {
    int max = 0;
    for (int i=0; i<array.length; i++) {
      for (int j=2; j<array.length-i; j++) {
        int sum = array[i];
        int pos = i + j;
        while (pos < array.length) {
          sum += array[pos];
          pos += j;
        }
        if (max < sum) {
          max = sum;
        }
      }
    }
    return max;
  }

  @Test
  public void test() {
    int[] array = {2,4,6,2,5};
    int expect = 13;
    Assertions.assertEquals(expect, maximumSum(array));
  }

  @Test
  public void test1() {
    int[] array = {5,1,1,5};
    int expect = 10;
    Assertions.assertEquals(expect, maximumSum(array));
  }


}
