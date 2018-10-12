package EX_1_1;

import java.util.*;

public class FirstTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> listOfNumbers = new ArrayList<>();
        Set<Integer> setOfNumbers = new HashSet<>();

        int currentNumber;
        for (int i = 0; i < n; i++) {
            currentNumber = scanner.nextInt();
            listOfNumbers.add(currentNumber);
            setOfNumbers.add(currentNumber);
        }

        boolean answer = false;

        int currentSum;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                currentSum = listOfNumbers.get(i) + listOfNumbers.get(j);
                if (setOfNumbers.contains(currentSum)) {
                    answer = true;
                    break;
                }
            }
        }

        if (answer) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
