package EX_2_1;

import java.util.*;

public class FirstTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        mergeSort(numbers, 0, numbers.size() - 1);
        printNumbers(numbers, 0, numbers.size() - 1);
    }

    private static void mergeSort(List<Integer> list, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(list, left, middle);
            printNumbers(list, left, middle);
            mergeSort(list, middle + 1, right);
            printNumbers(list, middle + 1, right);
            merge(list, left, right);
        }
    }

    private static void merge(List<Integer> list, int left, int right) {
        int leftIndex = left;
        int leftEnd = (left + right) / 2;
        int rightIndex = leftEnd + 1;
        int rightEnd = right;

        List<Integer> tempArray = new ArrayList<>();

        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (list.get(leftIndex).compareTo(list.get(rightIndex)) <= 0) {
                tempArray.add(list.get(leftIndex));
                leftIndex++;
            } else {
                tempArray.add(list.get(rightIndex));
                rightIndex++;
            }
        }

        while (leftIndex <= leftEnd) {
            tempArray.add(list.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex <= rightEnd) {
            tempArray.add(list.get(rightIndex));
            rightIndex++;
        }

        int index = left;

        for (Integer element : tempArray) {
            list.set(index, element);
            index++;
        }
    }

    private static void printNumbers(List<Integer> numbers, int left, int right) {
        for (int i = left; i < right + 1; i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }
}