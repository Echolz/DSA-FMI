package HW_5_2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        solve(deque, scanner);
    }

    private static void solve(Deque<Integer> deque, Scanner scanner) {
        int n = scanner.nextInt();

        scanner.nextLine();

        String[] args;

        for (int i = 0; i < n; i++) {

            args = scanner.nextLine().split(" ");

            if (args[0].equals("white")) {
                deque.addLast(Integer.parseInt(args[1]));
                continue;
            }

            if (args[0].equals("green")) {
                int k = Integer.parseInt(args[1]);

                int sum = 0;

                int j = 0;

                while (!deque.isEmpty() && j < k) {
                    sum += deque.removeLast();
                    j++;
                }

                deque.addLast(sum);
                continue;
            }

            if (args[0].equals("blue")) {
                int k = Integer.parseInt(args[1]);

                int max = Integer.MIN_VALUE;

                int j = 0;

                while (!deque.isEmpty() && j < k) {
                    max = Math.max(deque.removeLast(), max);
                    j++;
                }
                deque.addLast(max);
            }
        }

        StringBuilder answer = new StringBuilder();

        for (Integer number : deque) {
            answer.append(number).append(" ");
        }

        System.out.println(answer.toString());
    }
}
