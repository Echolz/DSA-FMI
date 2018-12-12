package HW_9_2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            boolean added = false;
            String toString;
            for (int j = 0; j < name.length() - 1; j++) {
                stringBuilder.append(name.charAt(j));
                toString = stringBuilder.toString();
                if (set.add(toString) && !added) {
                    System.out.println(toString);
                    added = true;
                }
            }
            set.add(name);
            if (added) {
                if (!map.containsKey(name)) {
                    map.put(name, 1);
                }
            }

            if (!added) {
                if (!map.containsKey(name)) {
                    map.put(name, 0);
                }
                int repetitions = map.get(name) + 1;
                map.put(name, repetitions);
                if (repetitions == 1) {
                    System.out.println(name);
                } else {
                    System.out.println(name + " " + repetitions);
                }
            }
        }
    }
}
