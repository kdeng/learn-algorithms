package nz.net.osnz.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 */
public class Solution_5_LongestPalindromicSubstring {


  /**
   * This is the solution from official website
   */
  static class OfficialSolution {

    public static String theirLongestPalindrome(String s) {
      if (s == null || s.length() < 1) return "";
      int start = 0, end = 0;
      for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
          start = i - (len - 1) / 2;
          end = i + len / 2;
        }
      }
      return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
      int L = left, R = right;
      while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
      }
      return R - L - 1;
    }
  }

  /**
   * This is my first solution, but the performance is not good enough
   * This solution takes about 3893ms runtime and 40M memory
   */
  static class Solution1 {

    public static String longestPalindrome(String s) {

      if (s == null || s.length() < 1) {
        return "";
      }

      if (s.length() > 1000) {
        throw new IllegalArgumentException("String is too long");
      }

      int longest = 0;
      String result = "";
      for (int i = 0; i < s.length(); i++) {
        String headSubString = s.substring(i);

        for (int j = headSubString.length(); j >= 0; j--) {
          String subString = headSubString.substring(0, j);
          String reservedSubString = new StringBuilder(subString).reverse().toString();
          int length = j + 1;
          if (length > longest && reservedSubString.contains(subString)) {
            result = subString;
            longest = length;
          }
        }
      }

      return result;
    }
  }

  /**
   * This is my second solution done in next day, and performance is better
   * It takes 2348 ms, and uses 39.1 MB memory
   */
  static class Solution2 {

    public static String longestPalindrome(String s) {

      if (s.length() > 1000) {
        throw new IllegalArgumentException("String is too long");
      }

      int stringLength = s.length();
      int longest = 0;
      String result = "";

      for (int start = 0; start < stringLength; start++) {

        if ((stringLength - start) <= longest) {
          break;
        }

        for (int end = stringLength; end >= start; end--) {

          int length = end - start;
          if (length <= longest) {
            break;
          }

          String subString = s.substring(start, end);
          String reserveSubString = new StringBuilder(subString).reverse().toString();

          if (subString.equals(reserveSubString)) {
            longest = length;
            result = subString;
          }

        }
      }
      return result;
    }
  }

  /**
   * This is my third solution, but it perform even worth than the second one.
   * <p>
   * Now, I realised string.contains() method is pretty expensive.
   * <p>
   * Runtime is 5943 ms, and memory is 39.5 MB
   */
  static class Solution3 {

    public static String longestPalindrome(String s) {

      if (s.length() > 1000) {
        throw new IllegalArgumentException("String is too long");
      }

      int stringLength = s.length();
      int longest = 0;
      String result = "";

      String reserveString = new StringBuilder(s).reverse().toString();

      for (int start = 0; start < stringLength; start++) {

        if ((stringLength - start) <= longest) {
          break;
        }

        for (int end = stringLength; end >= start; end--) {
          int length = end - start;
          if (length <= longest) {
            break;
          }

          String subString = s.substring(start, end);

          if (reserveString.contains(subString)) {
            String reserveSubString = new StringBuilder(subString).reverse().toString();
            if (subString.equals(reserveSubString)) {
              longest = length;
              result = subString;
            }
          }
        }
      }

      return result;
    }
  }


  @Test
  public void testCaseOne() {
    Assert.assertEquals("bab", Solution1.longestPalindrome("babad"));
  }

  @Test
  public void testCaseTwo() {
    Assert.assertEquals("bb", Solution1.longestPalindrome("cbbd"));
  }

  @Test
  public void testCaseThree() {
    Assert.assertEquals("anana", Solution1.longestPalindrome("bananas"));
  }

  @Test
  public void testCaseFour() {
    long startTime = System.currentTimeMillis();
    System.out.println("started : " + startTime);
    Assert.assertEquals("sooos", Solution1.longestPalindrome("azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc"));
    long endTime = System.currentTimeMillis();
    System.out.println("End : " + endTime);
    System.out.println("Cost : " + (endTime - startTime));
  }

  @Test
  public void testCaseFive() {
    Assert.assertEquals("aa", Solution1.longestPalindrome("aacdefcaa"));
  }

  @Test
  public void testCaseSix() {
    Assert.assertEquals("a", Solution1.longestPalindrome("a"));
  }



}
