package HW_6_2;

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.println(canWinNim(4));
    }

    public static boolean canWinNim(int n) {
        if (n % 4 == 0) {
            return false;
        }

        return true;
    }
}
