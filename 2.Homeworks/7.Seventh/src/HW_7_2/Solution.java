package HW_7_2;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    static Queue<Integer> belowMedian = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2, o1)));
    static Queue<Integer> aboveMedian = new PriorityQueue<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int currentNum = scanner.nextInt();
            if (belowMedian.isEmpty()) {
                belowMedian.add(currentNum);
                output.append(getAvg(belowMedian.peek(), 0, 1)).append("\n");
                continue;
            }

            if (aboveMedian.isEmpty()) {
                aboveMedian.add(currentNum);
                output.append(getAvg(belowMedian.peek(), aboveMedian.peek(), 2)).append("\n");
                continue;
            }

            aboveMedian.add(currentNum);

            if (aboveMedian.size() - belowMedian.size() == 2) {
                belowMedian.add(aboveMedian.poll());
            }

            if (i % 2 == 1) {
                output.append(getAvg(aboveMedian.peek(), 0, 1)).append("\n");
            } else {
                output.append(getAvg(belowMedian.peek(), aboveMedian.peek(), 2)).append("\n");
            }
        }

        System.out.println(output.toString());
    }

    public static String getAvg(int n1, int n2, double k) {
        return String.format("%.1f", (double) (n1 + n2) / k);
    }
}
