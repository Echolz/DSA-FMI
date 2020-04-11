package Day_82;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public static void main(String[] args) {

  }

  public static int countElements(int[] arr) {
    int answer = 0;

    Set<Integer> set = new HashSet<>();

    for (int i : arr) {
      set.add(i);
    }

    for (int i : arr) {
      if (set.contains(i + 1)) {
        answer++;
      }
    }

    return answer;
  }
}
