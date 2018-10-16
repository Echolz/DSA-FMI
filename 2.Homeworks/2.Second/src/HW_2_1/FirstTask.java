package HW_2_1;

import utils.*;
import utils.Number;

import java.util.*;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GenericSorter<Number> genericSorter = new GenericSorter<>();

        int n = scanner.nextInt();

        List<Number> numbers = new ArrayList<>();

        boolean onlyZeros = true;
        Integer currentNumber;
        for (int i = 0; i < n; i++) {
            currentNumber = scanner.nextInt();
            numbers.add(new Number(currentNumber));
            if (currentNumber != 0) {
                onlyZeros = false;
            }
        }

        if (onlyZeros) {
            System.out.println("0");
            return;
        }

        genericSorter.mergeSort(numbers, 0, numbers.size() - 1);

        for (Number number : numbers) {
            System.out.print(number.value);
        }
    }
}
