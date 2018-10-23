package E_2_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TimSort {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1000; i > -1 ; i--) {
            numbers.add(i);
        }

        timSort(numbers, 0, numbers.size() - 1);

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

    static void timSort(List<Integer> numbers, int left, int right) {
        if (left < right) {
            if (right - left + 1 <= 64) {
                insertionSort(numbers, left, right);
            } else {

                int mid = getMid(left, right);

                timSort(numbers, left, mid);
                timSort(numbers, mid + 1, right);
                merge(numbers, left, right);
            }
        }
    }

    static void merge(List<Integer> numbers, int left, int right) {
        int leftIndex = left;
        int leftEnd = getMid(left, right);

        int rightIndex = leftEnd + 1;
        int rightEnd = right;

        Queue<Integer> queu = new LinkedList<>();

        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (numbers.get(leftIndex) <= numbers.get(rightIndex)) {
                queu.add(numbers.get(leftIndex));
                leftIndex++;
            } else {
                queu.add(numbers.get(rightIndex));
                rightIndex++;
            }
        }

        while (leftIndex <= leftEnd) {
            queu.add(numbers.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex <= rightEnd) {
            queu.add(numbers.get(rightIndex));
            rightIndex++;
        }

        leftIndex = left;

        while (!(queu.isEmpty())) {
            numbers.set(leftIndex, queu.poll());
            leftIndex++;
        }
    }

    static void insertionSort(List<Integer> numbers, int left, int right) {
        for (int i = left; i < right + 1; i++) {
            int j = i - 1;

            int currentNumber = numbers.get(i);

            while (j >= 0 && numbers.get(j) > currentNumber) {
                numbers.set(j + 1, numbers.get(j));
                j --;
            }

            numbers.set(j + 1, currentNumber);
        }
    }

    static void swap(List<Integer> numbers, int firstIndex, int secondIndex) {
        int temp = numbers.get(firstIndex);

        numbers.set(firstIndex, numbers.get(secondIndex));

        numbers.set(secondIndex, temp);
    }

    static int getMid(int left, int right) {
        return left + (right - left) / 2;
    }
}
