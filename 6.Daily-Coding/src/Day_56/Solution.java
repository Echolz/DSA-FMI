package Day_56;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int left, int right, int target) {
        int middle = left + (right - left) / 2;

        while (left <= right) {
            middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            if (target > nums[middle]) {
                left = middle + 1;
            }

            if (target < nums[middle]) {
                right = middle - 1;
            }
        }

        return left;
    }
}
