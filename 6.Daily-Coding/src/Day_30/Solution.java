package Day_30;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static int makeAnagram(String a, String b) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        int answer = 0;

        for (int i = 0; i < a.length(); i++) {
            Character letter = a.charAt(i);
            if (!map1.containsKey(letter)) {
                map1.put(letter, 0);
            }

            map1.put(letter, map1.get(letter) + 1);
        }

        for (int i = 0; i < b.length(); i++) {
            Character letter = b.charAt(i);
            if (!map2.containsKey(letter)) {
                map2.put(letter, 0);
            }

            map2.put(letter, map2.get(letter) + 1);
        }

        for (Character c : map1.keySet()) {
            if (!map2.containsKey(c)) {
                answer += map1.get(c);
                continue;
            }

            answer += Math.abs(map1.get(c) - map2.get(c));
        }

        for (Character c : map2.keySet()) {
            if (map1.containsKey(c)) {
                continue;
            }

            answer += map2.get(c);
        }

        return answer;
    }
}
