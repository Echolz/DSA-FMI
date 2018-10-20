package HW_3_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextLong();

        if (k == 0) {
            k++;
        }

        List<Long> numbers = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextLong());
        }

        long counter = 0;

        if (allZeros(numbers) || numbers.size() == 0) {
            System.out.println("0");
            return;
        }

        int maxIndex;
        while (!allZeros(numbers)) {
            maxIndex = findMaxIndex(numbers);

            numbers.set(maxIndex, numbers.get(maxIndex) - k);

            tickMinute(numbers, maxIndex);
            counter ++;
        }

        System.out.println(counter);
    }

    private static boolean allZeros(List<Long> numbers) {
        boolean allzeros = true;

        for (Long number : numbers) {
            if (number > 0) {
                return false;
            }
        }

        return allzeros;
    }

    private static void tickMinute(List<Long> numbers, int index) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i == index) {
                continue;
            }
            numbers.set(i, numbers.get(i) - 1);
        }
    }

    private static int findMaxIndex(List<Long> numbers) {
        if (numbers.size() == 0) {
            return -1;
        }

        if (numbers.size() == 1) {
            return 0;
        }

        int maxIndex = 0;

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(maxIndex) < numbers.get(i)) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
