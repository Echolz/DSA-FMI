package HW_3_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FourthTask3 {
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

        long minPrice = Long.MAX_VALUE;


        for (int i = 0; i < n; i++) {
            long currentPrice = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                currentPrice += Math.abs(buildings.get(i) - buildings.get(j)) * prices.get(j);
            }

            minPrice = Math.min(minPrice, currentPrice);
        }

        System.out.println(minPrice);
    }
}
