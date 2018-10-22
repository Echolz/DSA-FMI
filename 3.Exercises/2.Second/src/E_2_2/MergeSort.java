package E_2_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MergeSort {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        for (int i = 10; i > 0; i--) {
            numbers.add(i);
        }

        mergeSort(numbers, 0, numbers.size() - 1);

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

    static void mergeSort(List<Integer> numbers, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(numbers, left, mid);
            mergeSort(numbers, mid + 1, right);
            merge(numbers, left, right);
        }
    }

    static void merge(List<Integer> numbers, int left, int right) {
        int leftIndex = left;
        int leftEnd = (left + right) / 2;

        int rightIndex = leftEnd + 1;
        int rightEnd = right;

        Queue<Integer> tempQueu = new LinkedList<>();

        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (numbers.get(leftIndex) <= numbers.get(rightIndex)) {
                tempQueu.offer(numbers.get(leftIndex));
                leftIndex++;
            } else {
                tempQueu.offer(numbers.get(rightIndex));
                rightIndex++;
            }
        }


        while (leftIndex <= leftEnd) {
            tempQueu.offer(numbers.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex <= rightEnd) {
            tempQueu.offer(numbers.get(rightIndex));
            rightIndex++;
        }


        leftIndex = left;

        while (!tempQueu.isEmpty()) {
            numbers.set(leftIndex, tempQueu.poll());
            leftIndex++;
        }
    }
}
