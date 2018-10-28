package HW_3_4;

import java.util.*;

public class FourthTask2 {

    static long bestPrice = Long.MAX_VALUE;

    static Map<Integer, Long> memorizationMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> heights = new ArrayList<>();
        List<Integer> prices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            heights.add(scanner.nextInt());
        }

        for (int i = 0; i < n; i++) {
            prices.add(scanner.nextInt());
        }

        findPeak(heights, prices, 0, heights.size() - 1);

        System.out.println(bestPrice);
    }

    static void findPeak(List<Integer> heights, List<Integer> prices, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            int currentHeight = heights.get(mid);

            long firstSum = Long.MAX_VALUE;
            if (mid - 1 >= 0) {
                if (memorizationMap.containsKey(mid - 1)) {
                    firstSum = memorizationMap.get(mid - 1);
                } else {
                    firstSum = calculateSum(heights, prices, mid - 1);
                    memorizationMap.put(mid - 1, firstSum);
                }
            }

            long secondSum = Long.MAX_VALUE;
            if (mid + 1 < heights.size()) {
                if (memorizationMap.containsKey(mid + 1)) {
                    secondSum = memorizationMap.get(mid + 1);
                } else {
                    secondSum = calculateSum(heights, prices, mid + 1);
                    memorizationMap.put(mid + 1, secondSum);
                }
            }

            long currentSum = calculateSum(heights, prices, currentHeight);

            if (firstSum >= currentSum && currentSum <= secondSum) {
                bestPrice = Math.min(bestPrice, currentSum);
            }

            findPeak(heights, prices, left, mid - 1);
            findPeak(heights, prices, mid + 1, right);

        }
    }

    private static long calculateSum(List<Integer> heights, List<Integer> prices, int currentHeight) {
        long currentSum = 0;

        for (int i = 0; i < heights.size(); i++) {
            if (heights.get(i) == currentHeight) {
                continue;
            }

            currentSum += Math.abs(heights.get(i) - currentHeight) * prices.get(i);
        }
        return currentSum;
    }
}
