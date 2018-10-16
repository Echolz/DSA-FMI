package HW_2_1;

import java.util.*;

public class FirstTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

        Collections.sort(numbers);

        for (Number number : numbers) {
            System.out.print(number.value);
        }
    }
}

class Number implements Comparable<Number> {
    int value;
    String valueStr;

    Number(int value) {
        this.value = value;
        this.valueStr = Integer.toString(value);
    }

    @Override
    public int compareTo(Number o) {
        return Integer.compare(Integer.parseInt(valueStr + o.valueStr), Integer.parseInt(o.valueStr + valueStr)) * -1;
    }
}
