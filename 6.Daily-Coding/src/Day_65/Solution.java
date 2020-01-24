package Day_65;

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();

    Map<Integer, Pair> map = new HashMap<>(n);
    List<Integer> nums = new ArrayList<>(n);


    for (int i = 0; i < n; i++) {
      int currentI = scanner.nextInt();

      nums.add(currentI);

      if (!map.containsKey(currentI)) {
        map.put(currentI, new Pair(i, i));
        continue;
      }

      map.get(currentI).to = i;
    }

    int k = scanner.nextInt();

    for (int i = 0; i < k; i++) {

      int currentNum = scanner.nextInt();
      Pair currentPair = map.get(currentNum);

      if (currentPair == null) {
        System.out.println(searchInsert(nums, currentNum));
        continue;
      }

      if (currentPair.to == -1) {
        System.out.println(currentPair.from);
        continue;
      }
      System.out.println(currentPair.from + " " + currentPair.to);

    }
  }

  public static int searchInsert(List<Integer> nums, int target) {
    return binarySearch(nums, 0, nums.size() - 1, target);
  }

  private static int binarySearch(List<Integer> nums, int left, int right, int target) {
    int middle;

    while (left <= right) {
      middle = left + (right - left) / 2;

      if (nums.get(middle) == target) {
        return middle;
      }

      if (target > nums.get(middle)) {
        left = middle + 1;
      }

      if (target < nums.get(middle)) {
        right = middle - 1;
      }
    }

    return left;
  }

}

class Pair {
  int from;
  int to;

  public Pair(int from, int to) {
    this.from = from;
    this.to = to;
  }
}