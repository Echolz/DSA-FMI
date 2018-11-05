package Day_1;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();

        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        Set<Integer> set = new HashSet<>();

        boolean answer = false;

        for (Integer number : numbers) {
            if (set.contains(k - number)) {
                answer = true;
                break;
            } else {
                set.add(number);
            }
        }

        if (answer) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
