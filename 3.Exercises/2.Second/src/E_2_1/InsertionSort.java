package E_2_1;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 10; i > -1 ; i--) {
            numbers.add(i);
        }

        insertionSort(numbers);

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

    static void insertionSort(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            int tempCounter = i + 1;

            while (tempCounter - 1 >= 0 && numbers.get(tempCounter) < numbers.get(tempCounter - 1)) {
                swap(numbers, tempCounter, tempCounter - 1);
                tempCounter --;
            }
        }
    }

    static void swap(List<Integer> numbers, int firstIndex, int secondIndex) {
        Integer temp = numbers.get(firstIndex);

        numbers.set(firstIndex, numbers.get(secondIndex));

        numbers.set(secondIndex, temp);
    }
}
