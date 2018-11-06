package Day_2;

import util.TextWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        TextWriter textWriter = new TextWriter();

        int n = textWriter.getRandomNumberInRange(900000, 1000000);

        List<Integer> numbers = new ArrayList<>();

        textWriter.printIn(String.valueOf(n));

        long sum = 0;

        for (int i = 0; i < n; i++) {
            numbers.add(textWriter.getRandomNumberInRange(0, 200));
            sum += numbers.get(i);
            textWriter.printIn(String.valueOf(numbers.get(i)));
        }


        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append(sum - numbers.get(i)).append(" ");
        }

        textWriter.printOut(answer.toString());

        textWriter.closeWriter();
    }
}
