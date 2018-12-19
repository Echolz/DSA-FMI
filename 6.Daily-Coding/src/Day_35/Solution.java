package Day_35;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> priorityQueue = new PriorityQueue<>();

        int numberOfContest = scanner.nextInt();
        int k = scanner.nextInt();
        int impNumber = 0;
        int maxLuck = 0;



        for (int i = 0; i < numberOfContest; i++) {
            int luck = scanner.nextInt();
            int imp = scanner.nextInt();
            if (imp == 0) {
                maxLuck += luck;
                continue;
            }

            priorityQueue.add(luck);
            impNumber++;
        }

        for (int i = 0; i < impNumber - k; i++) {
            maxLuck -= priorityQueue.poll();
        }

        while(!priorityQueue.isEmpty()) {
            maxLuck += priorityQueue.poll();
        }

        System.out.println(maxLuck);
    }
}
