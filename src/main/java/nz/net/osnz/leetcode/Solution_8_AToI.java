package nz.net.osnz.leetcode;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 *
 * https://leetcode.com/problems/string-to-integer-atoi/submissions/
 *
 */
public class Solution_8_AToI {

  public int myAtoi(String str) {

    if (str == null) {
      return 0;
    }

    int i = 0;
    int answer = 0;
    boolean isPositive = true;

    for (; i < str.length() && str.charAt(i) == ' '; i++) ;

    if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
      if (str.charAt(i) == '-') {
        isPositive = false;
      }
      i++;
    }

    for (; i < str.length() && Character.isDigit(str.charAt(i)); i++) {
      int digit = str.charAt(i) - '0';
      if (isPositive) {
        if (answer > Integer.MAX_VALUE / 10)
          return Integer.MAX_VALUE;
        answer *= 10;
        if (answer > Integer.MAX_VALUE - digit)
          return Integer.MAX_VALUE;
        answer += digit;
      } else {
        if (-answer < Integer.MIN_VALUE / 10)
          return Integer.MIN_VALUE;
        answer *= 10;
        if (-answer < Integer.MIN_VALUE + digit)
          return Integer.MIN_VALUE;
        answer += digit;
      }
    }
    return isPositive ? answer : -1 * answer;
  }


  @Test
  public void test() {
    Assertions.assertEquals(4193,  myAtoi("4193 with words"));
    Assertions.assertEquals(0,  myAtoi("workd 4193 with words"));
  }


}
