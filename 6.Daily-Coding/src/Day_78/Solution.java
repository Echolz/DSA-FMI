package Day_78;

public class Solution {
  public static void main(String[] args) {
    int[] arr = {1, -3, 4, -1, 2, 1};

    System.out.println(maxSubArray(arr));
  }

  public static int maxSubArray(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    int prevSum = 0;

    for (Integer number : nums) {
      prevSum = Integer.max(prevSum + number, number);
      maxSum = Integer.max(maxSum, prevSum);
    }
    return maxSum;
  }
}
