package nz.net.osnz.google;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author kdeng
 * <p>
 * https://www.careercup.com/question?id=5713593060818944
 * <p>
 * Given a list L of video names and their watch rates,
 * write a function that will return the videos with the
 * top 10 watch rates. Video names may appear more than once.
 * Example:
 * <p>
 * L = [(‘abc’, 10), (‘def’, 15), (‘ghi’, 10), (‘abc’, 12), …, (‘xyz’, 100)]
 * <p>
 * The function should return [‘xyz’, ‘abc’, …, ‘def’, ‘ghi’]
 */
public class N1_Solution {

  static class Video {
    String name;
    int rate;

    Video(String n, int r) {
      this.name = n;
      this.rate = r;
    }
  }

  public static String[] solution(Video[] videos, int size) {
    String[] result = new String[size];
    for (int i = 0; i < size; i++) {
      int max = 0;
      int pos = 0;
      for (int j = 0; j < videos.length; j++) {
        if (videos[j] != null && videos[j].rate > max) {
          max = videos[j].rate;
          pos = j;
        }
      }
      result[i] = videos[pos].name;
      videos[pos] = null;
    }
    return result;
  }

  @Test
  public void testCase() {
    Video[] videos = new Video[]{
      new Video("aaa", 10),
      new Video("bbb", 15),
      new Video("ccc", 18),
      new Video("ddd", 19),
      new Video("abc", 9),
      new Video("xzy", 100)
    };
    String[] expect = new String[]{"xzy", "ddd", "ccc"};
    Assertions.assertArrayEquals(expect, solution(videos, 3));

  }


}
