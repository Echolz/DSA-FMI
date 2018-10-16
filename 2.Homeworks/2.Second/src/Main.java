import utils.*;
import utils.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GenericSorter<Number> genericSorter = new GenericSorter<>();
        Scanner scanner = new Scanner(System.in);

        List<Number> numbers = new ArrayList<>();

        int n = scanner.nextInt();

        int currentVal;

        for (int i = 0; i < n; i++) {
            currentVal = scanner.nextInt();

            numbers.add(new Number(currentVal));
        }

        genericSorter.mergeSort(numbers, 0, numbers.size() - 1);

        for (Number number : numbers) {
            System.out.print(number.value);
        }
    }
}