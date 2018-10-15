package E_1_2;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        for (int i = 10; i >= 0; i--) {
            integerList.add(i);
        }

        selectionSort(integerList);

        for (Integer number : integerList) {
            System.out.println(number);
        }
    }

    static void selectionSort(List<Integer> integerList) {
        int minElementIndex;

        for (int i = 0; i < integerList.size(); i++) {
            minElementIndex = i;

            for (int j = i + 1; j < integerList.size(); j++) {
                if (integerList.get(minElementIndex) > integerList.get(j)) {
                    minElementIndex = j;
                }
            }

            if (minElementIndex == i) {
                continue;
            }

            swap(integerList, minElementIndex, i);
        }
    }

    static void swap(List<Integer> integerList, int firstIndex, int secondIndex) {
        int temp;

        temp = integerList.get(firstIndex);

        integerList.set(firstIndex, integerList.get(secondIndex));

        integerList.set(secondIndex, temp);
    }
}
