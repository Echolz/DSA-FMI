package Day_48;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{1, 1, 0, 0, 1, 0, 0, 0, 0}));
    }

    public static int maxDistToClosest(int[] seats) {
        int maxLength = 0;
        int i = 0;
        int currentLength = 0;

        while (i < seats.length && seats[i] != 1) {
            currentLength++;
            i++;
        }

        if (currentLength > maxLength) {
            maxLength = currentLength;
        }

        //here we have the first 1
        for (; i < seats.length; i++) {
            if (seats[i] == 1) {
                continue;
            }

            currentLength = 0;

            while (i < seats.length && seats[i] != 1) {
                currentLength++;
                i++;
            }

            if (i == seats.length) {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            }

            if (currentLength % 2 == 1) {
                currentLength++;
            }
            currentLength = currentLength / 2;

            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        return maxLength;
    }


}
