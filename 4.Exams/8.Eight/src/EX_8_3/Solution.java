package EX_8_3;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> answers = new TreeSet<>();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (String s : scanner.nextLine().split(" ")) {
            addToMap(map1, s);
        }

        for (String s : scanner.nextLine().split(" ")) {
            addToMap(map2, s);
        }

        for (String s : map1.keySet()) {
            if (map1.get(s) == 1 && !map2.containsKey(s)) {
                answers.add(s);
            }
        }


        for (String s : map2.keySet()) {
            if (map2.get(s) == 1 && !map1.containsKey(s)) {
                answers.add(s);
            }
        }

        for (String s : answers) {
            System.out.println(s);
        }

    }

    private static void addToMap(Map<String, Integer> map1, String s) {
        if (!map1.containsKey(s)) {
            map1.put(s, 0);
        }

        map1.put(s, map1.get(s) + 1);
    }
}
