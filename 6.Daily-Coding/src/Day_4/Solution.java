package Day_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        System.out.println(solution(numbers));
    }

    private static String solution(List<Integer> numbers) {
        int sizeOfPositivePart = partition(numbers);

        int currentNumber;
        for (int i = 0; i < sizeOfPositivePart; i++) {
            currentNumber = Math.abs(numbers.get(i));

            if (currentNumber > sizeOfPositivePart) {
                continue;
            }

            int toSet = getNegative(numbers.get(currentNumber - 1));
            numbers.set(currentNumber - 1, toSet);
        }

        boolean foundPositive = false;
        int answer = -1;
        for (int i = 0; i < sizeOfPositivePart; i++) {
            if (numbers.get(i) > 0) {
                answer = i + 1;
                foundPositive = true;
                break;
            }
        }

        if (!foundPositive) {
            answer = sizeOfPositivePart + 1;
        }

        return String.valueOf(answer);
    }

    private static int getNegative(int number) {
        if (number < 0) {
            return number;
        } else {
            return number * -1;
        }
    }

    private static int partition(List<Integer> numbers) {
        int lastPositiveIndex = -1;
        int positivePart = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) <= 0) {
                continue;
            }

            positivePart++;
            lastPositiveIndex++;
            if (lastPositiveIndex + 1 == i) {
                continue;
            }
            swap(numbers, lastPositiveIndex, i);
        }

        return positivePart;
    }

    private static void swap(List<Integer> numbers, int i, int j) {
        int temp = numbers.get(i);

        numbers.set(i, numbers.get(j));

        numbers.set(j, temp);
    }
}