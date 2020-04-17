package Day_89;

public class Solution {
  public static void main(String[] args) {
    System.out.println(newString("abc", 1));
  }

  public static String stringShift(String s, int[][] shift) {
    int lastSum = 0;
    int dir;
    int sum;

    for (int[] ints : shift) {
      dir = ints[0];
      sum = ints[1];

      lastSum += calculateDistance(dir, sum);
    }

    if (lastSum == 0) {
      return s;
    }

    return newString(s, lastSum % s.length());
  }

  private static String newString(String s, int lastSum) {
    char[] arr = s.toCharArray();

    for (int i = 0; i < s.length(); i++) {
      int newIndex = calculateIndex(i, lastSum, s.length());
      arr[newIndex] = s.charAt(i);
    }

    return String.valueOf(arr);
  }

  private static int calculateIndex(int index, int sum, int length) {
    int newIndex = index + sum;

    if (newIndex >= 0 && newIndex < length) {
      return newIndex;
    }

    if (newIndex < 0) {
      return length + newIndex;
    }

    return newIndex - length;
  }

  private static int calculateDistance(int dir, int sum) {
    if (dir == 1) {
      return sum;
    }

    return sum * -1;
  }
}
