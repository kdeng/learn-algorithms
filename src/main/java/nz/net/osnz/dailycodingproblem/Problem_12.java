package nz.net.osnz.dailycodingproblem;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kefeng Deng (deng@51any.com)
 * <p>
 * This problem was asked by Amazon.
 * <p>
 * There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
 * Given N, write a function that returns the number of unique ways you can climb the staircase.
 * <p>
 * The order of the steps matters.
 * <p>
 * For example, if N is 4, then there are 5 unique ways:
 * <p>
 * 1, 1, 1, 1
 * 2, 1, 1
 * 1, 2, 1
 * 1, 1, 2
 * 2, 2
 * <p>
 * What if, instead of being able to climb 1 or 2 steps at a time,
 * you could climb any number from a set of positive integers X?
 * <p>
 * For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 */
public class Problem_12 {

  public static int totalWays(int n) {
    if (n <= 1) {
      return 1;
    }

    // base case: 1 way (with no steps)
    int a = 1;

    // There is only 1 way to reach the 1st stair
    int b = 1;

    for (int i = 2; i <= n; i++) {
      int result = a + b;
      a = b;
      b = result;
    }
    return b;
  }

  @Test
  public void testTotalWays() {
    int n = 4;
    System.out.printf("Total ways to reach the %d'th stair are %d", n, totalWays(n));
  }

  public List<List<Integer>> findWays(int number, int[] steps) {
    List<List<Integer>> solutions = new ArrayList<>();
    findWay(solutions, null, number, steps);
    return solutions;
  }

  public void findWay(List<List<Integer>> solutions, List<Integer> way, int remains, int[] steps) {
    if (remains < 0) {
      return;
    }

    if (remains == 0) {
      solutions.add(way);
      return;
    }

    for (int i = 0; i < steps.length; i++) {
      List<Integer> newWay = new ArrayList<>();
      if (way != null) {
        newWay.addAll(way);
      }
      newWay.add(steps[i]);
      findWay(solutions, newWay, remains - steps[i], steps);
    }

  }


  @Test
  public void test() {
    int stairs = 4;
    int[][] expect = {
      {1, 1, 1, 1},
      {1, 1, 2},
      {1, 2, 1},
      {2, 1, 1},
      {2, 2}
    };

    List<List<Integer>> ways = findWays(4, new int[]{1, 2});

    Assertions.assertEquals(5, ways.size());
  }


}
