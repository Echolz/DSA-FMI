package Day_8;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    static int counter = 0;
    static Deque<Integer> currentNums = new LinkedList<>();
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        dfs(0, n, k);

        System.out.println(counter);
        System.out.print(output.toString());
    }

    private static void dfs(int sum, int n, int k) {
        if (sum >= n) {
            if (sum == n) {
                currentNums.forEach(x -> output.append(x).append(" "));
                output.setLength(output.length() - 1);
                output.append("\n");
                counter++;
            }

            return;
        }

        for (int i = 1; i <= k; i++) {
            currentNums.addLast(i);
            dfs(sum + i, n, k);
            currentNums.removeLast();
        }
    }
}
