package E_1_1;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        for (int i = 10; i >= 0; i--) {
            integerList.add(i);
        }

        bubbleSort(integerList);

        for (Integer number : integerList) {
            System.out.println(number);
        }
    }

    static void bubbleSort(List<Integer> integerList) {
        boolean madeSwap = false;

        for (int i = 0; i < integerList.size(); i++) {
            for (int j = 0; j < integerList.size()  - i - 1; j++) {
                if (integerList.get(j) > integerList.get(j + 1)) {
                    swap(integerList, j, j + 1);
                    madeSwap = true;
                }
            }

            if (!madeSwap) {
                break;
            }
        }
    }

    static void swap(List<Integer> integerList, int firstIndex, int secondIndex) {
        int temp;

        temp = integerList.get(firstIndex);

        integerList.set(firstIndex, integerList.get(secondIndex));

        integerList.set(secondIndex, temp);
    }
}
