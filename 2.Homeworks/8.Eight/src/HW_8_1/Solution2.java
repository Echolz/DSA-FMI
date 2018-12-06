package HW_8_1;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution2 {
    public static void main(String[] args) {
        int n;

        Set<Double> tree = new TreeSet<>();

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();

            String[] operations = line.split(" ");

            if (operations[0].equals("print")) {
                for (Double num : tree) {
                    System.out.print(printNum(num) + " ");
                }
                System.out.println();
                continue;
            }

            double num = Double.parseDouble(operations[1]);

            if (operations[0].equals("contains")) {
                if (tree.contains(num)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
                continue;
            }

            if (operations[0].equals("add")) {
                if (!tree.add(num)) {
                    System.out.println(String.format("%s already added", printNum(num)));
                }
                continue;
            }

            if (operations[0].equals("remove")) {
                if (!tree.remove(num)) {
                    System.out.println(String.format("%s not found to remove", printNum(num)));
                }
            }

        }
    }

    public static String printNum(double num) {
        return String.format("%.6f", num);
    }
}
