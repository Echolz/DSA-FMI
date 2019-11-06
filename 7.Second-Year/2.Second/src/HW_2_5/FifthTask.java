package HW_2_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FifthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        List<Integer> answer = sort(numbers);

        StringBuilder output = new StringBuilder();

        for (Integer integer : answer) {
            output.append(integer).append(" ");
        }

        System.out.println(output.toString());
    }

    public static List<Integer> sort(List<Integer> numbers) {
        return mergeSort(numbers, 0, numbers.size() - 1);
    }

    public static List<Integer> mergeSort(List<Integer> numbers, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            List<Integer> list1 = mergeSort(numbers, left, middle);
            List<Integer> list2 = mergeSort(numbers, middle + 1, right);

            return merge(list1, list2);
        }

        List<Integer> list = new ArrayList<>();
        list.add(numbers.get(left));

        return list;
    }

    public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) > list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
                continue;
            }
            mergedList.add(list2.get(j));
            j++;
        }

        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }
}
