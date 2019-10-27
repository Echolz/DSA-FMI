package HW_1_1;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        if (str.length() == 0) {
            return;
        }

        char ch = str.charAt(0);

        int counter = 1;

        StringBuilder output = new StringBuilder();

        for (int i = 1; i < str.length(); i++) {
            if (ch == str.charAt(i)) {
                counter++;
                continue;
            }

            output.append(counter).append(ch);
            ch = str.charAt(i);
            counter = 1;
        }

        output.append(counter).append(ch);


        System.out.println(output.toString());
    }
}
