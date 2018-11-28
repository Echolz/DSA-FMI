package HW_7_2;

import java.util.*;

public class Solution {

    static Queue<Integer> belowMedian = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2, o1)));
    static Queue<Integer> aboveMedian = new PriorityQueue<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        StringBuilder output = new StringBuilder();

        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();

        output.append(getAvg(firstNum));
        output.append(getAvg(firstNum, secondNum));

        belowMedian.add(Math.min(firstNum, secondNum));
        aboveMedian.add(Math.max(firstNum, secondNum));

        for (int i = 2; i < n; i++) {
            int currentNumber = scanner.nextInt();
            if (currentNumber < belowMedian.peek()) {
                belowMedian.add(currentNumber);
            } else {
                aboveMedian.add(currentNumber);
            }

            int sizeDiff = belowMedian.size() - aboveMedian.size();

            if (sizeDiff == 2) {
                aboveMedian.add(belowMedian.poll());
            }

            if (sizeDiff == -2) {
                belowMedian.add(aboveMedian.poll());
            }

            int sizeOfHeaps = i + 1;

            if (sizeOfHeaps % 2 == 0) {
                output.append(getAvg(belowMedian.peek(), aboveMedian.peek()));
                continue;
            }

            if (belowMedian.size() > aboveMedian.size()) {
                output.append(getAvg(belowMedian.peek()));
                continue;
            }

            output.append(getAvg(aboveMedian.peek()));
        }

        System.out.println(output.toString());
    }

    public static String getAvg(int... numbers) {
        if (numbers.length == 1) {
            return String.format("%.1f\n", (double) numbers[0]);
        } else {
            int sum = numbers[0] + numbers[1];

            return String.format("%.1f\n", (double) sum / 2.0d);
        }
    }
}
