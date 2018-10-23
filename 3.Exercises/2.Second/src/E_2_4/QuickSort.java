package E_2_4;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1000; i > -1; i--) {
            numbers.add(i);
        }

        quickSort(numbers, 0, numbers.size() - 1);

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

    static void quickSort(List<Integer> numbers, int left, int right) {
        if (left < right) {
            int pivotLocation = partition(numbers, left, right);
            quickSort(numbers, left, pivotLocation - 1);
            quickSort(numbers, pivotLocation + 1, right);
        }
    }

    static int partition(List<Integer> numbers, int left, int right) {
        int pivotElement = numbers.get(right);

        int j = left - 1;

        for (int i = left; i < right; i++) {
            if (numbers.get(i) <= pivotElement) {
                j ++;
                swap(numbers, i, j);
            }
        }

        swap(numbers, j + 1, right);

        return j + 1;
    }

    static void swap(List<Integer> numbers, int firstIndex, int secondIndex) {
        int temp = numbers.get(firstIndex);

        numbers.set(firstIndex, numbers.get(secondIndex));
        numbers.set(secondIndex, temp);
    }
}
