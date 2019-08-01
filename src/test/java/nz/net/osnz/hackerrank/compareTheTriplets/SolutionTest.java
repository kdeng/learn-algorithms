package nz.net.osnz.hackerrank.compareTheTriplets;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@DisplayName("Compare The Triplets")
class SolutionTest {

  @ParameterizedTest(name = "Alice {0}, Bob {1}, and expect {2}")
  @MethodSource("argumentsProvider")
  @DisplayName("Default test from instruction")
  public void testSolution(List<Integer> alice, List<Integer> bob, List<Integer> expect) {
    Assert.assertArrayEquals(expect.toArray(), Solution.compareTriplets(alice, bob).toArray());
  }

  private static Stream<Arguments> argumentsProvider() {
    return Stream.of(
        Arguments.of(Arrays.asList(5, 6, 7), Arrays.asList(3, 6, 10), Arrays.asList(1, 1)),
        Arguments.of(Arrays.asList(17, 28, 30), Arrays.asList(99, 16, 8), Arrays.asList(2, 1))
    );
  }

}