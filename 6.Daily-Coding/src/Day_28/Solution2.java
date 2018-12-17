package Day_28;

public class Solution2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 4};
        System.out.println(activityNotifications(arr, 2));
    }

    static int activityNotifications(int[] expenditure, int d) {
        int[] buckets = new int[201];
        int answer = 0;

        for (int i = 0; i < expenditure.length; i++) {
            int number = expenditure[i];

            if (i >= d) {
                int median = findMedian(buckets, d);

                if (median <= number) {
                    answer++;
                }
            }

            if (i >= d) {
                buckets[expenditure[i - d]]--;
            }

            buckets[number]++;
        }

        return answer;
    }

    static int getRoundedDivision(int n) {
        if (n % 2 == 1) {
            return (n / 2) + 1;
        } else {
            return n / 2;
        }
    }

    private static int findMedian(int[] buckets, int d) {
        int size = 0;
        if (d % 2 == 1) {
            int mid = getRoundedDivision(d);
            int answer = -1;
            for (int i = 0; i < buckets.length; i++) {
                size += buckets[i];
                if (size < mid) {
                    continue;
                }
                answer = i;
                break;
            }

            return answer * 2;
        } else {
            int first = d / 2;
            int second = (d / 2) + 1;

            int firstNum = -1;
            int secondNum = -1;

            for (int i = 0; i < buckets.length; i++) {
                size += buckets[i];

                if (size >= first && firstNum == -1) {
                    firstNum = i;
                }

                if (size >= second) {
                    secondNum = i;
                    break;
                }
            }

            return firstNum + secondNum;
        }
    }
}
