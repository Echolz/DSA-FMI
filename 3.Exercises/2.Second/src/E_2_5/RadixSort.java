package E_2_5;

import java.util.*;

public class RadixSort {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1_000; i > 0; i--) {
            numbers.add(i);
        }

        radixSort(numbers);

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

    static void radixSort(List<Integer> numbers) {
        int max = findMax(numbers);

        int loops = findDigitsCount(max);


        List<Queue<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            matrix.add(new LinkedList<>());
        }

        for (int i = 0; i < loops; i++) {
            for (Integer number : numbers) {
                matrix.get((int) (number / Math.pow(10, i)) % 10).add(number);
            }

            int listCounter = 0;

            for (int j = 0; j < 10; j++) {

                Queue<Integer> queue = matrix.get(j);

                while (!(queue.isEmpty())) {
                    numbers.set(listCounter, queue.poll());
                    listCounter ++;
                }
            }
        }
    }

    static int findMax(List<Integer> numbers) {
        if (numbers.size() == 1) {
            return numbers.get(0);
        }

        int maxElement = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > maxElement) {
                maxElement = numbers.get(i);
            }
        }

        return maxElement;
    }

    static int findDigitsCount(int number) {
        int digitsCount = 0;

        while (number != 0) {
            digitsCount ++;
            number = number / 10;
        }

        return digitsCount;
    }
}
