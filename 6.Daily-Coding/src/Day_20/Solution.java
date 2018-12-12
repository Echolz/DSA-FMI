package Day_20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : magazine) {
            if (!map.containsKey(word)) {
                map.put(word, 0);
            }

            map.put(word, map.get(word) + 1);
        }

        for (String word : note) {
            if (!map.containsKey(word) || map.get(word) - 1 < 0) {
                System.out.println("No");
                return;
            }

            map.put(word, map.get(word) - 1);
        }

        System.out.println("Yes");
    }
}
