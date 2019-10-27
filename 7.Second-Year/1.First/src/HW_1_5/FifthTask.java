package HW_1_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FifthTask {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int remainingPoints = scanner.nextInt();

        List<Point> points = new ArrayList<>();
        addPoints(points);

        recursion(remainingPoints, points, 1, false);

        System.out.println(answer);
    }

    public static void recursion(int remainingPoints, List<Point> possibleShots, int shotNumber, boolean timesTwo) {
        if (shotNumber <= 4 && remainingPoints == 0 && timesTwo) {
            answer ++;
            return;
        }

        if (shotNumber > 4) {
            return;
        }

        for (int i = 0; i < possibleShots.size(); i++) {
            Point currentShot = possibleShots.get(i);
            if (remainingPoints - currentShot.value < 0) {
                continue;
            }

            recursion(remainingPoints - currentShot.value, possibleShots, shotNumber + 1, currentShot.isTimesTwo);
        }
    }

    public static void addPoints(List<Point> points) {
        points.add(new Point(0, false));
        for (int i = 1; i < 21; i++) {
            points.add(new Point(i, false));
            points.add(new Point(i * 2, true));
            points.add(new Point(i * 3, false));
        }

        points.add(new Point(25, false));
        points.add(new Point(50, true));
    }
}

class Point {
    int value;
    boolean isTimesTwo;

    public Point(int value, boolean isTimesTwo) {
        this.value = value;
        this.isTimesTwo = isTimesTwo;
    }

    @Override
    public String toString() {
        return value + ", " + "\n";
    }
}
