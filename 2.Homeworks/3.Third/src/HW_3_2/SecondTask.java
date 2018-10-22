package HW_3_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();

        int n = scanner.nextInt();

        List<Long> numbers = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextLong());
        }

        Collections.sort(numbers);

        int q = scanner.nextInt();

        long number;

        for (int i = 0; i < q; i++) {
            number = scanner.nextLong();

            answer.append(binarySearchMinIndex(numbers, 0, numbers.size() - 1, number, -2) + 1)
                    .append(" ")
                    .append(binarySearchMaxIndex(numbers, 0, numbers.size() - 1, number, -2) + 1)
                    .append("\n");
        }

        System.out.println(answer.toString());
    }

    static int binarySearchMinIndex(List<Long> numbers, int left, int right, Long number, int minIndex) {
        if (left <= right) {
            int mid = (left + right) / 2;

            if (numbers.get(mid).equals(number)) {
                return binarySearchMinIndex(numbers, left, mid - 1, number, mid);
            }

            if (number < numbers.get(mid)) {
                return binarySearchMinIndex(numbers, left, mid - 1, number, minIndex);
            }

            return binarySearchMinIndex(numbers, mid + 1, right, number, minIndex);
        }

        return minIndex;
    }

    static int binarySearchMaxIndex(List<Long> numbers, int left, int right, long number, int maxIndex) {
        if (left <= right) {
            int mid = (left + right) / 2;

            if (numbers.get(mid).equals(number)) {
                return binarySearchMaxIndex(numbers, mid + 1, right, number, mid);
            }

            if (number < numbers.get(mid)) {
                return binarySearchMaxIndex(numbers, left, mid - 1, number, maxIndex);
            }

            return binarySearchMaxIndex(numbers, mid + 1, right, number, maxIndex);
        }

        return maxIndex;
    }
}
