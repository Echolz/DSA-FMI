package HW_11_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int j = 0; j < t; j++) {
            int n = scanner.nextInt();

            boolean hasZeros = false;

            int ans = 0;

            List<Integer> positive = new ArrayList<>();
            List<Integer> negative = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int number = scanner.nextInt();

                if (number == 0) {
                    hasZeros = true;
                    continue;
                }

                if (number > 1) {
                    positive.add(number);
                    continue;
                }

                if (number < 0) {
                    negative.add(number);
                    continue;
                }

                ans += number;
            }

            positive.sort(((o1, o2) -> Integer.compare(o2, o1)));
            negative.sort(Integer::compareTo);

            if (hasZeros && negative.size() % 2 == 1) {
                negative.set(negative.size() - 1, 0);
            }

            ans += getSum(positive);
            ans += getSum(negative);

            System.out.println(ans);
        }
    }

    static int getSum(List<Integer> list) {
        int ans = 0;

        for (int i = 0; i < list.size(); i++) {
            int n1 = list.get(i);

            if (i + 1 < list.size()) {
                int n2 = list.get(i + 1);

//                System.out.printf("%d * %d\n", n1, n2);

                n1 *= n2;
                i = i + 1;
            }

            ans += n1;
        }

//        System.out.println(ans);

        return ans;
    }
}