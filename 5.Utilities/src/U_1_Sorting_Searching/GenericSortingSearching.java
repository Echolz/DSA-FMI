package U_1_Sorting_Searching;

import java.util.ArrayList;
import java.util.List;

public class GenericSortingSearching<T extends Comparable<T>> {

    public void sort(List<T> list) {
        if (list.size() <= 64) {
            insertionSort(list);
        } else {
            mergeSort(list, 0, list.size() - 1);
        }
    }

    public int binarySearch(List<T> list, T element) {
        return binarySearchHelper(list, 0, list.size() - 1, element);
    }

    public int linearSearch(List<T> list, T element) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(element) == 0) {
                return i;
            }
        }

        return -1;
    }

    private int binarySearchHelper(List<T> list, int left, int right, T element) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).compareTo(element) == 0) {
                return mid;
            }

            if (list.get(mid).compareTo(element) < 0) {
                return binarySearchHelper(list, mid + 1, right, element);
            }

            return binarySearchHelper(list, left, mid - 1, element);
        }

        return -1;
    }

    private void insertionSort(List<T> list) {
        if (list.size() == 1 || list.size() == 0) {
            return;
        }

        for (int i = 1; i < list.size(); i++) {
            T tempElement = list.get(i);

            int j = i - 1;

            while (j >= 0 && list.get(j).compareTo(tempElement) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, tempElement);
        }
    }

    private void mergeSort(List<T> list, int left, int right) {
        if (left < right) {
            if (right - left + 1 <= 64) {
                insertionSort(list.subList(left, right + 1));
            } else {
                int middle = (left + right) / 2;
                mergeSort(list, left, middle);
                mergeSort(list, middle + 1, right);
                merge(list, left, right);
            }
        }
    }

    private void merge(List<T> list, int left, int right) {
        int leftIndex = left;
        int leftEnd = (left + right) / 2;
        int rightIndex = leftEnd + 1;
        int rightEnd = right;

        List<T> tempArray = new ArrayList<>();

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

        for (T element : tempArray) {
            list.set(index, element);
            index++;
        }
    }
}
