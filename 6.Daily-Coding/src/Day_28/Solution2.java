package Day_28;

import java.util.List;

public class Solution2 {
    public static void main(String[] args) {

    }

    static int activityNotifications(int[] expenditure, int d) {
        int[] buckets = new int[201];

        int answer = 0;

        for (int i = 0; i < expenditure.length; i++) {
            int number = expenditure[i];

            if (i < d) {
                buckets[number]++;
                continue;
            }

            if (i == 0) {
                int median = findMedian(buckets);
            }
        }
    }

    private static int findMedian(int[] buckets) {
        List<Integer>

        for (int i = 0; i < buckets.length; i++) {

        }
    }
}
