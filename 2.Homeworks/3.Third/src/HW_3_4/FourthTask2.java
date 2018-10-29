package HW_3_4;

import java.util.*;

public class FourthTask2 {

    static long bestPrice = Long.MAX_VALUE;

    static Map<Integer, Long> memorizationMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> heights = new ArrayList<>();

        Map<Integer, Long> heightToPrice = new HashMap<>();

        for (int i = 0; i < n; i++) {
            heights.add(scanner.nextInt());
        }

        List<Integer> uniqueHeights = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int currentPrice = scanner.nextInt();
            int priceHeight = heights.get(i);

            if (!heightToPrice.containsKey(priceHeight)) {
                heightToPrice.put(priceHeight, 0L);
                uniqueHeights.add(priceHeight);
            }

            heightToPrice.put(priceHeight, heightToPrice.get(priceHeight) + currentPrice);
        }

        Collections.sort(uniqueHeights);

        findPeak(uniqueHeights, heightToPrice, 0, uniqueHeights.size() - 1);

        System.out.println(bestPrice);
    }

    static void findPeak(List<Integer> heights, Map<Integer, Long> prices, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            int currentHeight = heights.get(mid);

            long firstSum = Long.MAX_VALUE;
            if (mid - 1 >= 0) {
                int firstHeight = heights.get(mid - 1);

                if (memorizationMap.containsKey(firstHeight)) {
                    firstSum = memorizationMap.get(firstHeight);
                } else {
                    firstSum = calculateSum(heights, prices, firstHeight);
                    memorizationMap.put(firstHeight, firstSum);
                }
            }

            long secondSum = Long.MAX_VALUE;
            if (mid + 1 < heights.size()) {
                int secondHeight = heights.get(mid + 1);

                if (memorizationMap.containsKey(secondHeight)) {
                    secondSum = memorizationMap.get(secondHeight);
                } else {
                    secondSum = calculateSum(heights, prices, secondHeight);
                    memorizationMap.put(secondHeight, secondSum);
                }
            }

            long currentSum = calculateSum(heights, prices, currentHeight);

            if (firstSum < currentSum) {
                findPeak(heights, prices, left, mid - 1);
                return;
            }

            if (currentSum > secondSum) {
                findPeak(heights, prices, mid + 1, right);
                return;
            }

            bestPrice = currentSum;
        }
    }

    private static long calculateSum(List<Integer> uniqueHeights, Map<Integer, Long> heightToPrice, int currentHeight) {
        long currentSum = 0;

        for (Integer height : uniqueHeights) {
            if (height == currentHeight) {
                continue;
            }

            currentSum += Math.abs(height - currentHeight) * heightToPrice.get(height);
        }
        return currentSum;
    }
}
