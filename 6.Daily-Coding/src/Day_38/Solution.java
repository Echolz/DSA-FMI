package Day_38;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {2147483647};

        System.out.println(firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }

        Set<Integer> set = new HashSet<>();

        int maxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            set.add(currentNumber);
            if (currentNumber > maxNumber) {
                maxNumber = currentNumber;
            }
        }

        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }

}
