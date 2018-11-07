package Day_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        System.out.println(solve(numbers));
    }

    private static String solve(List<Integer> numbers) {
        StringBuilder answer = new StringBuilder();
        long sum = 0;

        for (Integer number : numbers) {
            sum += number;
        }

        for (Integer number : numbers) {
            answer.append(sum - number).append(" ");
        }

        return answer.toString();
    }
}
