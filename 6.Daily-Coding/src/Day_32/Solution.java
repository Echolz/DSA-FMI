package Day_32;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isValid("aabbc"));
    }

    static String isValid(String s) {
        Map<Character, Integer> map = new HashMap<>();

        if (s.length() == 1) {
            return "YES";
        }

        for (int i = 0; i < s.length(); i++) {
            Character letter = s.charAt(i);
            if (!map.containsKey(letter)) {
                map.put(letter, 0);
            }

            map.put(letter, map.get(letter) + 1);
        }

        int min = map.values().stream().min(Integer::compareTo).orElse(-1);
        int max = map.values().stream().max(Integer::compareTo).orElse(-1);

        int minAnswer = 0;
        int maxAnswer = 0;

        for (Integer x : map.values()) {
            minAnswer += Math.abs(x - min);
            maxAnswer += Math.abs(x - max);
        }

        if (minAnswer <= 1 || maxAnswer == max - 1 || maxAnswer == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
