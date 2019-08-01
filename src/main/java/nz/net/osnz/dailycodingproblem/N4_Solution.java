package nz.net.osnz.dailycodingproblem;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.stream.IntStream;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 * @TODO <p>
 * This problem was asked by Stripe.
 * <p>
 * Given an array of integers, find the first missing
 * positive integer in linear time and constant space.
 * In other words, find the lowest positive integer
 * that does not exist in the array. The array can contain
 * duplicates and negative numbers as well.
 * <p>
 * <p>
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 * <p>
 * You can modify the input array in-place.
 */
public class N4_Solution {

  int solution(int[] input) {
    int[] temp = IntStream.generate(() -> -1).limit(input.length).toArray();
    for (int i = 0; i < input.length; i++) {
      if (input[i] > 0 && input[i] < input.length) {
        temp[input[i] - 1] = input[i];
      }
    }
    for (int i = 0; i < input.length; i++) {
      if (temp[i] == -1) {
        return i + 1;
      }
    }
    return temp[temp.length - 1] + 1;
  }

  int solution2(int[] input) {
    return 0;
  }

  @Test
  public void testCase() {
    Assertions.assertEquals(2, solution2(new int[]{3, 4, -1, 1}));
    Assertions.assertEquals(3, solution2(new int[]{1, 2, 0}));
  }


}
