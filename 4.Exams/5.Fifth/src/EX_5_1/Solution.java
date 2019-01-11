package EX_5_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int user = scanner.nextInt();
            addToMap(map, user);
        }

        int users = 0;
        int products = 0;
        for (Integer user : map.keySet()) {
            int orders = map.get(user);

            while (orders >= 10) {
                orders = orders - 10;
            }
            map.put(user, orders);
        }

        for (Integer user : map.keySet()) {
            int orders = map.get(user);
            if (orders == 0) {
                continue;
            }
            users++;
            products += orders;
        }

        System.out.println(String.format("%d %d", users, products));

    }

    private static void addToMap(Map<Integer, Integer> map, int user) {
        if (!map.containsKey(user)) {
            map.put(user, 0);
        }

        map.put(user, map.get(user) + 1);

    }
}
