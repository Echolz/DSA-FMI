package Day_62;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int cities = scanner.nextInt();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(scanner.next(), scanner.nextInt());
        }

        long answer = 0;

        for (int i = 0; i < cities; i++) {
            String currentCity = scanner.next();

            answer += map.get(currentCity);
        }

        System.out.println(answer);
    }
}
