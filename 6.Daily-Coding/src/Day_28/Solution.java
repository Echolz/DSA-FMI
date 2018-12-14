package Day_28;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4};
        int[] arr2 = {2, 3, 4, 2, 3, 6, 8, 4, 5};

        System.out.println(activityNotifications(arr, 4));
        System.out.println(activityNotifications(arr2, 5));
    }

    static int activityNotifications(int[] expenditure, int d) {
        Queue<Integer> belowMedian = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        Queue<Integer> aboveMedian = new PriorityQueue<>();

        int answer = 0;

        for (int i = 0; i < expenditure.length; i++) {
            int n = expenditure[i];

            if (i >= d) {
                if (i > d) {
                    int numberToRemove = expenditure[i - d];
                    removeNumber(belowMedian, aboveMedian, numberToRemove);
                }

                int median = calculateMedian(belowMedian, aboveMedian);
                if (median * 2 <= n) {
                    answer++;
                }
            }

            addToMedians(belowMedian, aboveMedian, n);
        }

        return answer;
    }

    private static void removeNumber(Queue<Integer> belowMedian, Queue<Integer> aboveMedian, int numberToRemove) {
        if (belowMedian.size() == 0 || aboveMedian.size() == 0) {
            throw new IllegalArgumentException("empty queues");
        }

        if (belowMedian.peek() >= numberToRemove) {
            belowMedian.remove(numberToRemove);
        }

        if (aboveMedian.peek() <= numberToRemove) {
            aboveMedian.remove(numberToRemove);
        }

        balanceQueues(belowMedian, aboveMedian);
    }

    private static int calculateMedian(Queue<Integer> belowMedian, Queue<Integer> aboveMedian) {
        if (belowMedian.size() == 0 || aboveMedian.size() == 0) {
            throw new IllegalArgumentException("empty queues");
        }

        if (belowMedian.size() - aboveMedian.size() == 1) {
            return belowMedian.peek();
        }

        if (aboveMedian.size() - belowMedian.size() == 1) {
            return aboveMedian.peek();
        }

        return roundUp(aboveMedian.peek(), belowMedian.peek());
    }

    private static int roundUp(Integer peek, Integer peek1) {
        int sum = peek + peek1;

        if (sum % 2 == 0) {
            return sum / 2;
        } else {
            return (sum / 2) + 1;
        }
    }

    private static void addToMedians(Queue<Integer> belowMedian, Queue<Integer> aboveMedian, int n) {
        if (belowMedian.size() == 0) {
            belowMedian.add(n);
            return;
        }

        if (aboveMedian.size() == 0) {
            if (belowMedian.peek() > n) {
                aboveMedian.add(belowMedian.poll());
                belowMedian.add(n);
                return;
            }
            aboveMedian.add(n);
            return;
        }

        if (belowMedian.peek() >= n) {
            belowMedian.add(n);
        } else if (aboveMedian.peek() <= n) {
            aboveMedian.add(n);
        }

        balanceQueues(belowMedian, aboveMedian);
    }

    private static void balanceQueues(Queue<Integer> belowMedian, Queue<Integer> aboveMedian) {
        if (belowMedian.size() - aboveMedian.size() == 2) {
            aboveMedian.add(belowMedian.poll());
        }

        if (aboveMedian.size() - belowMedian.size() == 2) {
            belowMedian.add(aboveMedian.poll());
        }
    }
}
