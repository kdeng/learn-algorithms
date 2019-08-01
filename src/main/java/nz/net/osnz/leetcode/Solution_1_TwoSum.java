package nz.net.osnz.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 */
public class Solution_1_TwoSum {

  static class Solution {
    public static int[] twoSum(int[] nums, int target) {
      for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
          if (nums[j] == target - nums[i]) {
            return new int[] { i, j };
          }
        }
      }
      throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] myTwoSum(int[] nums, int target) {
      for (int idx = 0; idx < nums.length - 1; idx++) {
        List<Integer> subArray = Arrays.stream(Arrays.copyOfRange(nums, idx+1, nums.length)).boxed().collect(Collectors.toList());
        int expectResult = target - nums[idx];
        int expectPosition = subArray.indexOf(expectResult);
        if (expectPosition >= 0) {
          return new int[]{idx, idx + expectPosition + 1};
        }
      }
      throw new IllegalArgumentException("Cannot find solution");
    }

  }

  @Test
  public void testSolution() {
    Assert.assertArrayEquals(new int[]{0, 1}, Solution.twoSum(new int[]{2, 7, 11, 15}, 9));
    Assert.assertArrayEquals(new int[]{1, 2}, Solution.twoSum(new int[]{3, 2, 4}, 6));
  }

}
