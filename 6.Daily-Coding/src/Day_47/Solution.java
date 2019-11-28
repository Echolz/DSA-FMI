package Day_47;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static Map<Integer, Integer> map = createMap();

    public static void main(String[] args) {
        System.out.println(rotatedDigits(20));
    }

    public static int rotatedDigits(int N) {
        int numbers = 0;

        for (int i = 0; i <= N; i++) {
            //no rotatable
            if (!isValid(i)) {
                continue;
            }

            if (rotateNumber(i) != i) {
                numbers++;
            }
        }

        return numbers;
    }

    private static int rotateNumber(int number) {
        int rotated = 0;
        int rotDigit;
        int i = 0;

        while (number != 0) {
            int mod = number % 10;
            number = number / 10;
            rotDigit = isRotatable(mod);
            rotated += Math.pow(10, i) * rotDigit;
            i++;
        }

        return rotated;
    }

    private static boolean isValid(int number) {
        while (number != 0) {
            int mod = number % 10;
            number = number / 10;
            if (isRotatable(mod) == -1) {
                return false;
            }
        }

        return true;
    }

    private static int isRotatable(int mod) {
        if (!map.containsKey(mod)) {
            return -1;
        }

        return map.get(mod);
    }

    private static Map<Integer, Integer> createMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8);
        map.put(2, 5);
        map.put(5, 2);
        map.put(6, 9);
        map.put(9, 6);

        return map;
    }
}
