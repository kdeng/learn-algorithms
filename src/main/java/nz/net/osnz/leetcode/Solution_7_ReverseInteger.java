package nz.net.osnz.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 */
public class Solution_7_ReverseInteger {


  public int reverse(int x) {
    String input = Integer.toString(x);
    boolean isNegative = input.charAt(0) == '-';
    if (isNegative) {
      input = input.substring(1);
    }
    StringBuilder sb = new StringBuilder();
    for (int i = input.length() - 1; i >= 0; i--) {
      sb.append(input.charAt(i));
    }
    try {
      int result = Integer.parseInt(sb.toString());
      if (isNegative) {
        return (-1) * result;
      }
      return result;
    } catch (Exception ex) {
      return 0;
    }
  }

  @Test
  public void testCase1() {
    Assert.assertEquals(reverse(123), 321);
  }

  @Test
  public void testCase2() {
    Assert.assertEquals(reverse(-123), -321);
  }

  @Test
  public void testCase3() {
    Assert.assertEquals(reverse(120), 21);
  }

}
