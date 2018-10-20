package HW_3_1;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int t = scanner.nextInt();

        int n;
        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            sb.append(solve(n)).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int solve(int number) {
        int answer = 0;

        while (number != 0) {
            number = number - getDivision(number);
            answer ++;
        }

        return answer;
    }

    private static int getDivision(int number) {
        if (number % 2 == 1) {
            return number/2 + 1;
        } else {
            return number/2;
        }
    }
}
