package nz.net.osnz.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author Kefeng Deng (https://bit.ly/2JFoCO1)
 */
public class Solution_2_AddTwoNumbers {


  public static class Solution {

    public static class ListNode {
      int val;
      ListNode next;

      ListNode(int x) {
        val = x;
      }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummyHead = new ListNode(0);
      ListNode p = l1, q = l2, curr = dummyHead;
      int carry = 0;
      while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
      }
      if (carry > 0) {
        curr.next = new ListNode(carry);
      }
      return dummyHead.next;
    }

    public static ListNode myAddTwoNumbers(ListNode l1, ListNode l2) {
      ListNode result = new ListNode(0);

      int carry = 0;
      ListNode p1 = l1;
      ListNode p2 = l2;
      ListNode currentNode = result;

      while (p1 != null || p2 != null) {

        int val1 = p1 == null ? 0 : p1.val;
        int val2 = p2 == null ? 0 : p2.val;
        int sum = carry + val1 + val2;

        currentNode.val = sum % 10;

        carry = sum / 10;
        p1 = p1 == null ? p1 : p1.next;
        p2 = p2 == null ? p2 : p2.next;

        if (p1 != null || p2 != null) {
          currentNode.next = new ListNode(0);
          currentNode = currentNode.next;
        }
      }

      if (carry > 0) {
        currentNode.next = new ListNode(carry);
      }

      return result;
    }

  }

  @Test
  public void testSolution() {
    Solution.ListNode firstListNode = createListNode(2, 4, 3);
    Solution.ListNode secondListNode = createListNode(5, 6, 4);
    Solution.ListNode result = Solution.addTwoNumbers(firstListNode, secondListNode);
    Assert.assertEquals(7, result.val);
    Assert.assertEquals(0, result.next.val);
    Assert.assertEquals(8, result.next.next.val);
    Assert.assertNull(result.next.next.next);

  }


  @Test
  public void testSolution1() {
    Solution.ListNode firstListNode = createListNode(0);
    Solution.ListNode secondListNode = createListNode(7, 3);
    Solution.ListNode result = Solution.addTwoNumbers(firstListNode, secondListNode);
    Assert.assertEquals(7, result.val);
    Assert.assertEquals(3, result.next.val);
    Assert.assertNull(result.next.next);

  }

  public Solution.ListNode createListNode(int... numbers) {
    if (numbers != null && numbers.length > 0) {
      Solution.ListNode listNodeHeader = new Solution.ListNode(numbers[0]);
      Solution.ListNode currentNode = listNodeHeader;
      for (int idx = 1; idx < numbers.length; idx++) {
        currentNode.next = new Solution.ListNode(numbers[idx]);
        currentNode = currentNode.next;
      }
      return listNodeHeader;
    }

    return null;
  }

  @Test
  public void testCreateListNode() {
    Solution.ListNode listHeader = createListNode(1, 4, 2, 7);
    Assert.assertEquals(1, listHeader.val);
    Assert.assertEquals(4, listHeader.next.val);
    Assert.assertEquals(2, listHeader.next.next.val);
    Assert.assertEquals(7, listHeader.next.next.next.val);
  }


}
