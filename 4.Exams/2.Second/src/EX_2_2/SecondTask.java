package EX_2_2;

import java.util.*;

public class SecondTask {

    static int currentSteps;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        int k = scanner.nextInt();

        StringBuilder firstOutput = new StringBuilder();
        StringBuilder secondOutput = new StringBuilder();

        int currentNumber;
        int index;
        for (int i = 0; i < k; i++) {
            currentNumber = scanner.nextInt();
            currentSteps = 0;
            index = binarySearch(numbers, 0, numbers.size() - 1, currentNumber);
            firstOutput.append(index).append(" ");
            secondOutput.append(currentSteps).append(" ");
        }


        System.out.println(firstOutput.toString());

        System.out.print(secondOutput.toString());

    }

    private static int binarySearch(List<Integer> list, int left, int right, Integer element) {
        if (left <= right) {
            currentSteps++;
            int mid = left + (right - left) / 2;
            if (list.get(mid).compareTo(element) == 0) {
                return mid;
            }

            if (list.get(mid) < element) {
                return binarySearch(list, mid + 1, right, element);
            }

            return binarySearch(list, left, mid - 1, element);
        }

        return -1;
    }
}
