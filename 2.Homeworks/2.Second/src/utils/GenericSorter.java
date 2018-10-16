package utils;

import java.util.ArrayList;
import java.util.List;

public class GenericSorter <T extends Comparable<T>> {
    public void mergeSort(List<T> list, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;

        mergeSort(list, left, middle);
        mergeSort(list, middle + 1, right);
        merge(list, left, right);
    }

    public void merge(List<T> list, int left, int right) {
        int leftIndex= left;
        int leftEnd = (left + right) / 2;
        int rightIndex = leftEnd + 1;
        int rightEnd = right;

        List<T> tempArray = new ArrayList<>();

        while(leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (list.get(leftIndex).compareTo(list.get(rightIndex)) <= 0) {
                tempArray.add(list.get(leftIndex));
                leftIndex ++;
            } else {
                tempArray.add(list.get(rightIndex));
                rightIndex ++;
            }
        }

        while (leftIndex <= leftEnd) {
            tempArray.add(list.get(leftIndex));
            leftIndex ++;
        }

        while (rightIndex <= rightEnd) {
            tempArray.add(list.get(rightIndex));
            rightIndex ++;
        }

        int index = left;

        for (T element : tempArray) {
            list.set(index, element);
            index ++;
        }

    }
}
