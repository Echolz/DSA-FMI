package Day_77;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  static int getSquare(int n) {
    int square = 0;

    while (n != 0) {
      square += (n % 10) * (n % 10);
      n = n / 10;
    }
    return square;
  }

  static boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();

    while (true) {
      set.add(n);

      n = getSquare(n);

      if (n == 1) {
        return true;
      }

      if (set.contains(n)) {
        break;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(isHappy(13));
  }
} 