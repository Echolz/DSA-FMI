package Day_33;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();

        System.out.println(substrCount(s));
    }

    static long substrCount(String s) {
        long answ = 0;
        Character c = s.charAt(0);
        long currentCount = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            Character nextC = s.charAt(i + 1);
            if (c == nextC) {
                currentCount++;
            } else {
                long combinations = (currentCount * (currentCount + 1)) / 2;
                answ += combinations;
                currentCount = 1;
                c = nextC;
            }
        }

        answ += (currentCount * (currentCount + 1)) / 2;

        for (int i = 1; i < s.length() - 1; i++) {
            Character curChar = s.charAt(i);
            Character lChar = s.charAt(i - 1);
            Character rChar = s.charAt(i + 1);

            if (curChar == lChar || curChar == rChar || rChar != lChar) {
                continue;
            }

            int current = 0;
            int l = i - 1;
            int r = i + 1;

            while (l >= 0 && r < s.length() && s.charAt(l) == lChar && s.charAt(r) == rChar) {
                current++;
                l--;
                r++;
            }

            answ += current;
        }

        return answ;
    }
}