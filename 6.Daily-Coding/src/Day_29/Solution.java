package Day_29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    static long countInversions(int[] arr) {
        List<Integer> list = new ArrayList<>();

        Arrays.stream(arr).forEach(list::add);

        return mergeSort(list, 0, list.size() - 1);

    }

    public static long mergeSort(List<Integer> list, int left, int right) {
        long inversions = 0;
        if (left < right) {
            int middle = (left + right) / 2;
            inversions += mergeSort(list, left, middle);
            inversions += mergeSort(list, middle + 1, right);
            inversions += merge(list, left, right);
        }
        return inversions;
    }

    public static long merge(List<Integer> list, int left, int right) {
        int leftIndex = left;
        int leftEnd = (left + right) / 2;
        int rightIndex = leftEnd + 1;
        int rightEnd = right;

        long inversions = 0;

        List<Integer> tempArray = new ArrayList<>();

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

        for (Integer element : tempArray) {
            list.set(index, element);
            index++;
        }

        return inversions;
    }
}
