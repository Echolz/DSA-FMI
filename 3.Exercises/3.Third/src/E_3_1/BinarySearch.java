package E_3_1;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10000 + 1; i++) {
            for (int j = 0; j < 10; j++) {
                numbers.add(i);
            }
        }


        System.out.println(binarySearchLeftIndex(numbers, 0, numbers.size() - 1, 10000, -1));
        System.out.println(binarySearch(numbers, 0, numbers.size() - 1, 10000));
        System.out.println(binarySearchRightIndex(numbers, 0, numbers.size() - 1, 10000, -1));
    }

    static int binarySearch(List<Integer> numbers, int left, int right, int number) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers.get(mid) == number) {
                return mid;
            }

            if (numbers.get(mid) < number) {
                return binarySearch(numbers, mid + 1, right, number);
            }

            return binarySearch(numbers, left, mid - 1, number);
        }

        return -1;
    }

    static int binarySearchLeftIndex(List<Integer> numbers, int left, int right, int number, int lastFoundIndex) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers.get(mid) == number) {
                return binarySearchLeftIndex(numbers, left, mid - 1, number, mid);
            }

            if (numbers.get(mid) > number) {
                return binarySearchLeftIndex(numbers, left, mid - 1, number, lastFoundIndex);
            }

            return binarySearchLeftIndex(numbers, mid + 1, right, number, lastFoundIndex);
        }

        return lastFoundIndex;
    }

    static int binarySearchRightIndex(List<Integer> numbers, int left, int right, int number, int lastFoundIndex) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers.get(mid) == number) {
                return binarySearchRightIndex(numbers, mid + 1, right, number, mid);
            }

            if (numbers.get(mid) < number) {
                return binarySearchRightIndex(numbers, mid + 1, right, number, lastFoundIndex);
            }

            return binarySearchRightIndex(numbers, left, mid - 1, number, lastFoundIndex);
        }

        return lastFoundIndex;
    }
}
