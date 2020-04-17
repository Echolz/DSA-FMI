package Day_88;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public static void main(String[] args) {
    System.out.println(findMaxLength(new int[]{0, 1}));
  }

  public static int findMaxLength(int[] nums) {
    if (nums.length == 0 || nums.length == 1) {
      return 0;
    }

    int currentSum = 0;
    int maxSum = 0;
    int currentNumber;

    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);

    for (int i = 0; i < nums.length; i++) {
      currentNumber = nums[i];

      if (currentNumber == 1) {
        currentSum++;
      }

      if (currentNumber == 0) {
        currentSum--;
      }

      if (map.containsKey(currentSum)) {
        maxSum = Math.max(i - map.get(currentSum), maxSum);
        continue;
      }

      map.put(currentSum, i);
    }

    return maxSum;
  }

}
