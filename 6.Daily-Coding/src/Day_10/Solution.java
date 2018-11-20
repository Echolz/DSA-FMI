package Day_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        int k = scanner.nextInt();

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < k; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();

            answer.append(mergeSum(numbers, 0, numbers.size() - 1, left, right)).append("\n");
        }

        System.out.println(answer.toString());
    }

    private static int mergeSum(List<Integer> numbers, int l, int r, int maxL, int maxR) {
        if (l < r) {
            int mid = l + (r - l) / 2;

            int sum = 0;
            sum += mergeSum(numbers, l, mid, maxL, maxR);
            sum += mergeSum(numbers, mid + 1, r, maxL, maxR);
            return sum;
        }

        if (inRange(l, maxL, maxR)) {
            return numbers.get(l);
        } else {
            return 0;
        }
    }

    private static boolean inRange(int pos, int l, int r) {
        return l <= pos && pos <= r;
    }
}
