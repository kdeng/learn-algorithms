package nz.net.osnz.dailycodingproblem;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 *
 * This problem was asked by Google.
 *
 * Given an array of integers and a number k,
 * where 1 <= k <= length of the array,
 * compute the maximum values of each subarray of length k.
 *
 * For example, given array = [10, 5, 2, 7, 8, 7] and k = 3,
 * we should get: [10, 7, 8, 8], since:
 *
 * 10 = max(10, 5, 2)
 * 7 = max(5, 2, 7)
 * 8 = max(2, 7, 8)
 * 8 = max(7, 8, 7)
 *
 *
 * Do this in O(n) time and O(k) space.
 * You can modify the input array in-place and you do not need to store the results.
 * You can simply print them out as you compute them.
 *
 */
public class Problem_18 {

  int[] solution(int[] input, int k) {
    List<Integer> result = new ArrayList<>();
    for (int i=0; i<=input.length-k; i++) {
      int tmp = 0;
      for (int j=i; j<i+k; j++) {
        tmp = Math.max(tmp, input[j]);
      }
      result.add(tmp);
    }
    return result.stream().mapToInt(i -> i).toArray();
  }

  @Test
  public void test() {
    int[] input = new int[]{10, 5, 2, 7, 8, 7};
    int k = 3;

    int[] expect = new int[]{10, 7, 8, 8};
    Assertions.assertArrayEquals(expect, solution(input, k));
  }

}
