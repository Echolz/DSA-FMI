package Day_26;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = {5, 6, 1, 2, 10, -1};
        countSwaps(a);

        System.out.println(Arrays.toString(a));
    }

    static void countSwaps(int[] a) {
        int swaps = 0;
        int firstElement;
        int lastElement;
        for (int i = 0; i < a.length - 1; i++) {
            boolean madeSwap = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swaps++;
                    madeSwap = true;
                }
            }
            if (!madeSwap) {
                break;
            }
        }

        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);

    }

    private static void swap(int[] a, int j, int i) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
