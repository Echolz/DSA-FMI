package HW_1_4;

import java.util.Scanner;

public class FourthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        //sock - sock, clone
        //clone - clone, clone

        for (int i = 0; i < n; i++) {
            int clSocks = scanner.nextInt();
            int nrmSocks = scanner.nextInt();

            if (nrmSocks == 1 && clSocks != 0) {
                System.out.println("no");
                continue;
            }

            if (clSocks == nrmSocks - 1) {
                System.out.println("yes");
                continue;
            }

            if (clSocks < nrmSocks - 1) {
                System.out.println("no");
                continue;
            }

            int initialClSocks = nrmSocks - 1;

            if (initialClSocks % 2 == clSocks % 2) {
                System.out.println("yes");
                continue;
            }

//            if (nrmSocks % 2 == 1 && clSocks % 2 == 0) {
//                System.out.println("yes");
//                continue;
//            }

            System.out.println("no");
        }
    }
}
