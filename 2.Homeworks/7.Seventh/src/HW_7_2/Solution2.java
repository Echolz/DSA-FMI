package HW_7_2;

import java.util.*;

public class Solution2 {
    static Map<Integer, Integer> numberToSize = new TreeMap<>();
    static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        StringBuilder ouput = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int currentNumber = scanner.nextInt();
            insert(currentNumber);
            if (numbers.size() % 2 == 1) {
                ouput.append(String.format("%.1f", (double) numbers.get(numbers.size() / 2))).append("\n");
            } else {
                int size = numbers.size();
                int firstNum = numbers.get(size / 2);
                int secondNum = numbers.get(size / 2 - 1);

                ouput.append(String.format("%.1f", (double) (firstNum + secondNum) / 2.0)).append("\n");
            }
        }

        System.out.println(ouput.toString());
    }

    private static void insert(int currentNumber) {
        if (numbers.size() == 0) {
            numbers.add(currentNumber);
            return;
        }

        int i = numbers.size() - 1;

        while (i >= 0 && numbers.get(i) > currentNumber) {
            i--;
        }

        numbers.add(i + 1, currentNumber);

    }

    private static void addToMap(int currentNumber) {
        if (!numberToSize.containsKey(currentNumber)) {
            numberToSize.put(currentNumber, 0);
        }

        numberToSize.put(currentNumber, numberToSize.get(currentNumber) + 1);
    }

}
