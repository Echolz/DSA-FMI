package HW_3_4;

import java.util.Scanner;
import java.util.Stack;

public class FourthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();

        Stack<Integer> stack;

        boolean flag = true;

        for (int i = 0; i < q; i++) {
            int k = scanner.nextInt();

            stack = new Stack<>();

            for (int j = 0; j < k; j++) {
                int currentTruck = scanner.nextInt();

                if (currentTruck == j - stack.size() + 1) {
                    continue;
                }

                if (stack.size() == 0) {
                    stack.push(currentTruck);
                    continue;
                }

                if (stack.peek() < currentTruck) {
                    flag = false;
                    continue;
                }

                stack.push(currentTruck);
            }

            if (flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }


    }
}
