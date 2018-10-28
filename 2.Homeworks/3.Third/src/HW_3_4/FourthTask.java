package HW_3_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FourthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> buildings = new ArrayList<>();
        List<Integer> prices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            buildings.add(scanner.nextInt());
        }

        for (int i = 0; i < n; i++) {
            prices.add(scanner.nextInt());
        }

        int[] numberOfBuildings = new int[10_001];
        long[] priceOfBuildings = new long[10_001];

        for (int i = 0; i < n; i++) {
            int currentBuildingHeight = buildings.get(i);
            int currentBuildingPrice = prices.get(i);

            numberOfBuildings[currentBuildingHeight] += 1;
            priceOfBuildings[currentBuildingHeight] += currentBuildingPrice;
        }

        long lowestPrice = Long.MAX_VALUE;

        for (int i = 0; i < 10_001; i++) {
            if (numberOfBuildings[i] == 0) {
                continue;
            }

            long currentSum = 0;
            for (int j = 0; j < 10_001; j++) {
                if (j == i || numberOfBuildings[j] == 0) {
                    continue;
                }

                currentSum += Math.abs(j - i) * priceOfBuildings[j];
            }

            if (currentSum < lowestPrice) {
                lowestPrice = currentSum;
            }
        }

        System.out.println(lowestPrice);
    }
}
