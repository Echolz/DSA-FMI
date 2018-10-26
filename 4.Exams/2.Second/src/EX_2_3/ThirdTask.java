package EX_2_3;

import java.util.*;

public class ThirdTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        int[] array = new int[10001];

        for (Integer number : numbers) {
            array[number] ++;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                continue;
            }

            System.out.print(i + " ");
        }
    }


}
