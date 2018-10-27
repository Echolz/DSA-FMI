package E_3_2;

import java.util.ArrayList;
import java.util.List;

public class ExponentialSearch {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10_000; i++) {
            numbers.add(i);
        }

        System.out.println(exponentialSearch(numbers, 10));
    }

    static int exponentialSearch(List<Integer> numbers, int number) {
        if (numbers.get(0) == number) {
            return 0;
        }

        int toReturn = -1;

        for (int i = 1; i < numbers.size(); i *= 2) {
            if (numbers.get(i) == number) {
                toReturn = i;
                break;
            }

            if (numbers.get(i) > number) {
                toReturn = binarySearch(numbers, i / 2, i, number);
                break;
            }
        }

        return toReturn;
    }

    static int binarySearch(List<Integer> numbers, int left, int right, int number) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers.get(mid) == number) {
                return mid;
            }

            if (numbers.get(mid) > number) {
                return binarySearch(numbers, left, mid - 1, number);
            }

            return binarySearch(numbers, mid + 1, right, number);
        }

        return -1;
    }
}
