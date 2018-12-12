package Day_22;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String logo = scanner.nextLine();
        String pattern = "(g|G)(o|O|0|\\[]|\\(\\)|<>)(o|O|0|\\[]|\\(\\)|<>)(g|G)(l|L|I)(e|E|3)";
        if (logo.matches(pattern)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}