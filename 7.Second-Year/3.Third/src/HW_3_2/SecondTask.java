package HW_3_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hutsSize = scanner.nextInt();

        int cows = scanner.nextInt();

        List<Long> huts = readHuts(scanner, hutsSize);

        huts.sort(Long::compareTo);

        Long answer = solve(huts, cows);

//        System.out.println(checkAnswer(huts, 32, cows));

        System.out.println(answer);
    }

    private static Long solve(List<Long> huts, int cows) {
        return binarySearch(huts, -1L, huts.get(0), huts.get(huts.size() - 1), cows);
    }

    private static Long binarySearch(List<Long> huts, Long answer, Long left, Long right, int cows) {
        if (left <= right) {
            Long middle = left + (right - left) / 2;

            if (checkAnswer(huts, middle, cows)) {
                return Math.max(middle, binarySearch(huts, answer, middle + 1, right, cows));
            }

            return binarySearch(huts, answer, left, middle - 1, cows);
        }

        return -1L;
    }

    private static boolean checkAnswer(List<Long> huts, Long currentLength, int cows) {
        Long currentPosition = huts.get(0);

        int cowsInHuts = 1;

        for (int i = 1; i < huts.size(); i++) {
            if (huts.get(i) - currentPosition < currentLength) {
                continue;
            }

            currentPosition = huts.get(i);
            cowsInHuts++;
            if (cowsInHuts == cows) {
                return true;
            }
        }

        return false;
    }

    private static List<Long> readHuts(Scanner scanner, int hutsSize) {
        List<Long> huts = new ArrayList<>();

        for (int i = 0; i < hutsSize; i++) {
            huts.add(scanner.nextLong());
        }

        return huts;
    }
}
