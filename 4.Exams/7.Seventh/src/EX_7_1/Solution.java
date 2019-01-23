package EX_7_1;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> added = new HashSet<>();
        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : list) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }

            map.put(num, map.get(num) + 1);
        }

        List<Integer> output = new ArrayList<>();

        for (Integer number : list) {
            if (map.get(number) != 1) {
                continue;
            }

            output.add(number);
        }

        for (Integer number : list) {
            if (map.get(number) == 1) {
                continue;
            }

            if (added.contains(number)) {
                continue;
            }

            added.add(number);
            output.add(number);
        }

        for (Integer number : output) {
            System.out.print(number + " ");
        }
    }
}