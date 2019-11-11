package HW_3_4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FourthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] trucks = new int[20001];

        Set<Integer> usedHeights = new HashSet<>();


        for (int i = 0; i < n; i++) {
            int currentTruckDelta = scanner.nextInt();
            int currentTruckNeededPower = scanner.nextInt();
            trucks[currentTruckDelta + 10000] += currentTruckNeededPower;
            usedHeights.add(currentTruckDelta + 10000);
        }

        Long min = Long.MAX_VALUE;
        Long current = 0L;

        for (Integer usedHeight : usedHeights) {
            for (Integer uh : usedHeights) {
                if (uh == usedHeight) {
                    continue;
                }
                current += Math.abs(usedHeight - uh) * trucks[uh];
            }
            if (current < min) {
                min = current;
            }

            current = 0L;
        }
//        for (int i = 0; i < 20001; i++) {
//            for (int j = 0; j < 20001; j++) {
//                if (i == j) {
//                    continue;
//                }
//
//                current += Math.abs(i - j) * trucks[j];
//
//            }
//            if (current < min) {
//                min = current;
//            }
//
//            current = 0L;
//        }

        System.out.println(min);
    }
}
