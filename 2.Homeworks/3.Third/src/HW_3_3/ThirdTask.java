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

        List<Integer> potentialTimes = new ArrayList<>();

        int min = findMin(clothes);
        int max = findMax(clothes);


        for (int i = min; i < max + 1; i++) {
            potentialTimes.add(i);
        }

        int minIndex = binarySearch(clothes, potentialTimes, 0, potentialTimes.size() - 1, k, -1);

        System.out.println(potentialTimes.get(minIndex));
    }

    static int binarySearch(List<Integer> clothes, List<Integer> potentialTimes, int left, int right, int k, int minIndex) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (canDry(clothes, k, potentialTimes.get(mid))) {
                return binarySearch(clothes, potentialTimes, left, mid - 1, k, mid);
            } else {
                return binarySearch(clothes, potentialTimes, mid + 1, right, k, minIndex);
            }
        }

        return minIndex;
    }

    static int findMax(List<Integer> clothes) {
        if (clothes.size() == 1) {
            return clothes.get(0);
        }

        int max = clothes.get(0);

        for (int i = 1; i < clothes.size(); i++) {
            if (clothes.get(i) > max) {
                max = clothes.get(i);
            }
        }

        return max;
    }

    static int findMin(List<Integer> clothes) {
        if (clothes.size() == 1) {
            return clothes.get(0);
        }

        int min = clothes.get(0);

        for (int i = 1; i < clothes.size(); i++) {
            if (clothes.get(i) < min) {
                min = clothes.get(i);
            }
        }

        return min;
    }

    static boolean canDry(List<Integer> clothes, int k, int minutes) {
        int minutesNeededForBlower = 0;

        List<Integer> wetClothes = new ArrayList<>();

        for (Integer number : clothes) {
            if (number - minutes > 0) {
                wetClothes.add(number - minutes);
            }
        }

        for (Integer number : wetClothes) {
            minutesNeededForBlower += getDivision(number, k - 1);
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
