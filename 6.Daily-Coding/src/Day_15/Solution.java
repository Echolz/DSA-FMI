package Day_15;

public class Solution {
    static int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum;

        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;

            for (int j = 0; j < arr[0].length; j++) {
                if (!isValid(i, arr.length)) {
                    flag = true;
                    break;
                }

                if (!isValid(j, arr[0].length)) {
                    break;
                }

                currentSum = getSum(i, j, arr);

                maxSum = max(maxSum, currentSum);
            }

            if (flag) {
                break;
            }
        }
        return maxSum;
    }

    private static int getSum(int i, int j, int[][] arr) {
        int[] deltaI = {0, 0, 0, 1, 2, 2, 2};
        int[] deltaJ = {0, 1, 2, 1, 0, 1, 2};
        
        int sum = 0;

        for (int k = 0; k < deltaI.length; k++) {
            int i2 = deltaI[k] + i;
            int j2 = deltaJ[k] + j;

            sum += arr[i2][j2];
        }

        return sum;
    }

    static boolean isValid(int index, int size) {
        return index + 2 < size;
    }

    static int max(int n1, int n2) {
        return n1 > n2 ? n1 : n2;
    }
}
