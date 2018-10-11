package HW_1_2;

import java.io.*;
import java.util.*;

public class SecondTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> stocksPrices = new ArrayList<>();

        int numberOfStocks = scanner.nextInt();
        int k = scanner.nextInt();

        int maxSum = 0;
        int currentStockPrice;

        for (int i = 0; i < numberOfStocks; i++) {
            currentStockPrice = scanner.nextInt();
            maxSum += currentStockPrice;

            stocksPrices.add(currentStockPrice);
        }

        Collections.sort(stocksPrices);

        int startIndex = numberOfStocks % k;

        for (int i = startIndex; i < stocksPrices.size(); i += k) {
            maxSum -= stocksPrices.get(i);
        }

        System.out.println(maxSum);

    }
}
