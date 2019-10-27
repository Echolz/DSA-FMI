package HW_1_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long requiredGrade = scanner.nextLong();

        long numberOfStudents = scanner.nextInt();

        List<Long> students = new ArrayList<>();

        for (int i = 0; i < numberOfStudents; i++) {
            students.add(scanner.nextLong());
        }

        long min = Long.MAX_VALUE;

        for (int i = 0; i < students.size(); i++) {
            if (min > students.get(i)) {
                min = students.get(i);
            }
        }

        if (min > requiredGrade) {
            System.out.println("yes");
            return;
        }

        long excessGrades = 0;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) > requiredGrade) {
                if (students.get(i) < 0 && requiredGrade < 0 || students.get(i) > 0 && requiredGrade > 0) {
                    excessGrades += Math.abs(requiredGrade - students.get(i));
                } else {
                    excessGrades += students.get(i) + Math.abs(requiredGrade);
                }
            }
        }

        if (min + excessGrades >= requiredGrade) {
            System.out.println("yes");
            return;
        }

        System.out.println("no");

    }
}
