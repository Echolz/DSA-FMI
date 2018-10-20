package HW_3_3;

import java.util.*;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextLong();

        if (k == 0) {
            k++;
        }

        List<Long> numbers = new ArrayList<>(n);

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(o -> o * -1));

        for (int i = 0; i < n; i++) {
            priorityQueue.add(scanner.nextLong());
        }

        int answer = 0;
        Long currentNumber;
        while (priorityQueue.peek() > answer) {
            currentNumber = priorityQueue.poll() - k;

            answer ++;

            if (currentNumber < answer) {
                continue;
            }

            priorityQueue.add(currentNumber);

        }

        System.out.println(answer - 1);
    }
}
