package nz.net.osnz.hackerrank.simpleArraySum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Kefeng Deng
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("sumProvider")
  void shouldSumArrayProperly(int[] numbers, int expectedSum) {
    assertEquals(expectedSum, Solution.simpleArraySum(numbers));
  }


  private static Stream<Arguments> sumProvider() {
    return Stream.of(
      Arguments.of(new int[]{1, 1, 2}, 4),
      Arguments.of(new int[]{1, 2, 3, 4, 10, 11}, 31)
    );
  }

}