package Day_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        long currentsum;

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {
            currentsum = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                currentsum += numbers.get(j);
            }

            output.append(currentsum).append(" ");
        }

        System.out.println(output.toString());
    }
}
