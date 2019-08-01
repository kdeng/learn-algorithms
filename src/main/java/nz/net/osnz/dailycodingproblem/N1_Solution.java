package nz.net.osnz.dailycodingproblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 */
public class N1_Solution {


  public boolean twoSum(int[] input, int target) {
    for (int i = 0; i < input.length - 1; i++) {
      int expect = target - input[i];
      for (int j = i + 1; j < input.length; j++) {
        if (expect == input[j]) {
          return true;
        }
      }
    }
    return false;
  }


  @Test
  public void testCaseOne() {
    Assertions.assertEquals(true, twoSum(new int[]{10, 15, 3, 7}, 17));
    Assertions.assertEquals(true, twoSum(new int[]{2, 7, 11, 15}, 9));
    Assertions.assertEquals(true, twoSum(new int[]{3, 2, 4}, 6));
  }


}
