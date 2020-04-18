package Day_90;

import java.util.Arrays;

public class Solution {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 0})));
  }

  public static int[] productExceptSelf(int[] nums) {
    int product = 1;
    int zeros = 0;


    for (int num : nums) {
      if (num == 0) {
        zeros++;
        continue;
      }

      product *= num;
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        if (zeros > 1) {
          nums[i] = 0;
          continue;
        }

        nums[i] = product;
        continue;
      }

      if (zeros >= 1) {
        nums[i] = 0;
        continue;
      }

      nums[i] = product / nums[i];
    }

    return nums;
  }
}
