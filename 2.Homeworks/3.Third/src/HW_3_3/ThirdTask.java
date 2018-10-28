package HW_3_3;

import java.io.*;
import java.util.*;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> clothes = new ArrayList<>(n);

        int k = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            clothes.add(scanner.nextInt());
        }

        if (k == 1 || k == 0) {
            System.out.println(findMax(clothes));
            return;
        }

        int minTime = binarySearch(clothes, 0, 1_000_000_000, k, 0);

        System.out.println(minTime);
    }

    static int binarySearch(List<Integer> clothes, int left, int right, int k, int minIndex) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (canDry(clothes, k, mid)) {
                return binarySearch(clothes, left, mid - 1, k, mid);
            } else {
                return binarySearch(clothes, mid + 1, right, k, minIndex);
            }
        }

        return minIndex;
    }

    static int findMax(List<Integer> clothes) {
        int max = clothes.get(0);

        for (int i = 1; i < clothes.size(); i++) {
            if (clothes.get(i) > max) {
                max = clothes.get(i);
            }
        }

        return max;
    }

    static boolean canDry(List<Integer> clothes, int k, int minutes) {
        int minutesNeededForBlower = minutes;

        int num;
        for (Integer clothe : clothes) {
            num = clothe - minutes;
            if (num <= 0) {
                continue;
            }

            minutesNeededForBlower -= getDivision(num, k - 1);
            if (minutesNeededForBlower < 0) {
                return false;
            }
        }

        return true;
    }

    static int getDivision(int number, int k) {
        if (number % k == 0) {
            return number / k;
        } else {
            return (number / k) + 1;
        }
    }
}