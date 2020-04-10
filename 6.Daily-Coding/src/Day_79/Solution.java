package Day_79;

public class Solution {
  public static void main(String[] args) {

  }

  public void moveZeroes(int[] nums) {
    int zeroIndex = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        continue;
      }

      nums[zeroIndex] = nums[i];
      if (zeroIndex != i) {
        nums[i] = 0;
      }
      zeroIndex++;
    }
  }
}
