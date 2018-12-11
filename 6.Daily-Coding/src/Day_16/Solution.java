package Day_16;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int d = 4;

        System.out.println(Arrays.toString(rotLeft(a, 4)));
    }

    static int[] rotLeft(int[] a, int d) {
        int[] toReturn = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            int indexToAdd = i - d;

            if (indexToAdd < 0) {
                indexToAdd = a.length + indexToAdd;
            }

            toReturn[indexToAdd] = a[i];
        }

        return toReturn;
    }
}
