package HW_3_3;

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

        Collections.sort(clothes);

        int answer = binarySearch(clothes, clothes.get(0), clothes.get(clothes.size() - 1), k, -1);

        System.out.println(answer);
    }

    static int binarySearch(List<Integer> clothes, int left, int right, int k, int minMinutes) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (canDry(clothes, k, mid)) {
                return binarySearch(clothes, left, mid - 1, k, mid);
            } else {
                return binarySearch(clothes, mid + 1, right, k, minMinutes);
            }
        }

        return minMinutes;
    }

    static boolean canDry(List<Integer> clothes, int k, int minutes) {
        int minutesNeededForBlower = 0;

        List<Integer> wetClothes = new ArrayList<>();

        for (Integer number : clothes) {
            if (number - minutes > 0) {
                wetClothes.add(number);
            }
        }

        for (Integer number : wetClothes) {
            minutesNeededForBlower += getDivision(number, k);
        }

        return minutesNeededForBlower <= minutes;
    }

    static int getDivision(int number, int k) {
        if (number % k == 0) {
            return number / k;
        } else {
            return (number / k) + 1;
        }
    }
}
