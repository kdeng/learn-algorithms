package nz.net.osnz.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 */
public class Solution_3_LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int ans = 0;
    for (int i = 0; i < n; i++)
      for (int j = i + 1; j <= n; j++)
        if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
    return ans;
  }

  public boolean allUnique(String s, int start, int end) {
    Set<Character> set = new HashSet<>();
    for (int i = start; i < end; i++) {
      Character ch = s.charAt(i);
      if (set.contains(ch)) return false;
      set.add(ch);
    }
    return true;
  }

  public int myLengthOfLongestSubstring(String s) {
    int longestLength = 0;
    for (int idx = 0; idx < s.length(); idx++) {
      Set<Character> substring = new HashSet<>();
      substring.add(s.charAt(idx));
      for (int jumper = idx+1; jumper < s.length(); jumper ++) {
        if (substring.contains(s.charAt(jumper))) {
          break;
        }
        substring.add(s.charAt(jumper));
      }
      longestLength = Math.max(longestLength, substring.size());
    }
    return longestLength;
  }
  
  /**
   * another solution at 21/12/2021
   */
  public int lengthOfLongestSubstring3(String s) {
    int max = 0;
    String temp = "";
    for (int i=0; i<s.length(); i++) {
      int idx = temp.indexOf(s.charAt(i));
      if (idx >= 0) {                
        temp = temp.substring(idx+1);
      }
      temp += s.charAt(i);
      max = temp.length() > max ? temp.length() : max;
    }
    return max;
  }


  @Test
  public void testCaseOne() {
    Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
  }

  @Test
  public void testCaseTwo() {
    Assert.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
  }

  @Test
  public void testCaseThree() {
    Assert.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
  }

  @Test
  public void testCaseFour() {
    Assert.assertEquals(0, lengthOfLongestSubstring(""));
  }

  @Test
  public void testCaseFive() {
    Assert.assertEquals(1, lengthOfLongestSubstring(" "));
  }

  @Test
  public void testCaseSix() {
    Assert.assertEquals(1, lengthOfLongestSubstring("aa"));
  }

  @Test
  public void testCaseSeven() {
    Assert.assertEquals(2, lengthOfLongestSubstring("au"));
  }



}
