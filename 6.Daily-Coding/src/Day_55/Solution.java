package Day_55;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        Queue<Long> pQ = new PriorityQueue<>();
        StringBuilder answer = new StringBuilder();
        for (long i = 0; i < n; i++) {
            long currentNumber = sc.nextLong();

            if (currentNumber != -1) {
                pQ.add(currentNumber);
                continue;
            }
            answer.append(pQ.poll()).append(" ");
        }

        System.out.println(answer.toString());
    }
}
