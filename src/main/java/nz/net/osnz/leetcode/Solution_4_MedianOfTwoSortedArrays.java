package nz.net.osnz.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 */
public class Solution_4_MedianOfTwoSortedArrays {


  public double findMedianSortedArrays(int[] A, int[] B) {
    int m = A.length;
    int n = B.length;
    if (m > n) { // to ensure m<=n
      int[] temp = A; A = B; B = temp;
      int tmp = m; m = n; n = tmp;
    }
    int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
    while (iMin <= iMax) {
      int i = (iMin + iMax) / 2;
      int j = halfLen - i;
      if (i < iMax && B[j-1] > A[i]){
        iMin = i + 1; // i is too small
      }
      else if (i > iMin && A[i-1] > B[j]) {
        iMax = i - 1; // i is too big
      }
      else { // i is perfect
        int maxLeft = 0;
        if (i == 0) { maxLeft = B[j-1]; }
        else if (j == 0) { maxLeft = A[i-1]; }
        else { maxLeft = Math.max(A[i-1], B[j-1]); }
        if ( (m + n) % 2 == 1 ) { return maxLeft; }

        int minRight = 0;
        if (i == m) { minRight = B[j]; }
        else if (j == n) { minRight = A[i]; }
        else { minRight = Math.min(B[j], A[i]); }

        return (maxLeft + minRight) / 2.0;
      }
    }
    return 0.0;
  }

  public double myFindMedianSortedArrays(int[] nums1, int[] nums2) {

    List<Integer> list1 = IntStream.of(nums1).boxed().collect(Collectors.toList());
    List<Integer> list2 = IntStream.of(nums2).boxed().collect(Collectors.toList());
    List<Integer> list = new ArrayList<>();
    list.addAll(list1);
    list.addAll(list2);
    Collections.sort(list);
    int length = list.size();

    if (length % 2 == 1) {
      return list.get(length / 2);
    }

    return (((double) list.get(length / 2 - 1)) + ((double) list.get(length / 2))) / 2;

  }


  @Test
  public void testCaseOne() {
    Assert.assertEquals(2.0, findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 0.1);
  }

  @Test
  public void testCaseTwo() {
    Assert.assertEquals(2.5, findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 0.1);
  }

  @Test
  public void testCaseThree() {
    Assert.assertEquals(16.0,
      findMedianSortedArrays(new int[]{1, 12, 15, 26, 38}, new int[]{2, 13, 17, 30, 46}),
      0.1);
  }

  @Test
  public void testCaseFour() {
    Assert.assertEquals(1.0,
      findMedianSortedArrays(new int[]{1, 1}, new int[]{1, 2}),
      0.1);
  }


}
