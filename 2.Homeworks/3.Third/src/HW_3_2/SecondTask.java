package HW_3_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder answer = new StringBuilder();

        int n = scanner.nextInt();

        List<Long> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextLong());
        }

        int q = scanner.nextInt();

        long p;
        int currentIndex;
        int lowestIndex;
        int highestIndex;
        for (int i = 0; i < q; i++) {
            p = scanner.nextLong();

            currentIndex = binarySearch(numbers, 0, numbers.size() - 1, p);

            if (currentIndex == -1) {
                answer.append("-1 -1\n");
                continue;
            }
            lowestIndex = findLowestIndex(numbers, currentIndex);
            highestIndex = findHighestIndex(numbers, currentIndex);
            answer.append(lowestIndex + 1).append(" ").append(highestIndex + 1).append("\n");
        }

        System.out.println(answer.toString());
    }


    static int binarySearch(List<Long> numbers, int left, int right, long numberToFind) {
        if (left <= right) {
            int currentIndex = left + (right - left) / 2;
            long currentNumber = numbers.get(currentIndex);

            if (currentNumber == numberToFind) {
                return currentIndex;
            }

            if (currentNumber >= numberToFind) {
                return binarySearch(numbers, left, currentIndex - 1, numberToFind);
            } else {
                return binarySearch(numbers, currentIndex + 1, right, numberToFind);
            }
        }

        return -1;
    }

    static int findLowestIndex(List<Long> numbers, int currentIndex) {
        long currentNumber = numbers.get(currentIndex);
        int indexToReturn = currentIndex;

        while (indexToReturn - 1 >= 0 && numbers.get(indexToReturn - 1) == currentNumber) {
            indexToReturn --;
        }

        return indexToReturn;
    }

    static int findHighestIndex(List<Long> numbers, int currentIndex) {
        long currentNumber = numbers.get(currentIndex);
        int indexToReturn = currentIndex;

        while (indexToReturn + 1 <= numbers.size() - 1 && numbers.get(indexToReturn + 1) == currentNumber) {
            indexToReturn ++;
        }

        return indexToReturn;
    }
}
