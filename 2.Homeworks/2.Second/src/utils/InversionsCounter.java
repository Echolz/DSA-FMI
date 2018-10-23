package utils;

import java.util.ArrayList;
import java.util.List;

public class InversionsCounter<T extends Comparable<T>> {
    public long mergeSort(List<T> list, int left, int right) {
        long inversions = 0;
        if (left < right) {
            int middle = (left + right) / 2;
            inversions += mergeSort(list, left, middle);
            inversions += mergeSort(list, middle + 1, right);
            inversions += merge(list, left, right);
        }
        return inversions;
    }

    public long merge(List<T> list, int left, int right) {
        int leftIndex = left;
        int leftEnd = (left + right) / 2;
        int rightIndex = leftEnd + 1;
        int rightEnd = right;

        long inversions = 0;

        List<T> tempArray = new ArrayList<>();

        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (list.get(leftIndex).compareTo(list.get(rightIndex)) <= 0) {
                tempArray.add(list.get(leftIndex));
                leftIndex++;
            } else {
                inversions += leftEnd - leftIndex + 1;
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

        for (T element : tempArray) {
            list.set(index, element);
            index++;
        }

        return inversions;

    }
}
