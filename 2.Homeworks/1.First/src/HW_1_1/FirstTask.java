package HW_1_1;

import java.io.*;
import java.util.*;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] hoursMatrix = new int[3][4];
        int[][] answersMatrix = new int[3][2];

        for (int i = 0; i < 3; i++) {
            hoursMatrix[i][0] = scanner.nextInt();
            hoursMatrix[i][1] = scanner.nextInt();
            hoursMatrix[i][2] = scanner.nextInt();
            hoursMatrix[i][3] = scanner.nextInt();
        }

        List<Integer> currentAnswers;

        for (int i = 0; i < 3; i++) {
            currentAnswers = getHours(hoursMatrix[i][0], hoursMatrix[i][1], hoursMatrix[i][2], hoursMatrix[i][3]);
            answersMatrix[i][0] = currentAnswers.get(0);
            answersMatrix[i][1] = currentAnswers.get(1);
        }

        int minIndex = getMinIndex(answersMatrix);
        int maxIndex = getMaxIndex(answersMatrix);

        printHours(answersMatrix[minIndex][0], answersMatrix[minIndex][1]);
        printHours(answersMatrix[maxIndex][0], answersMatrix[maxIndex][1]);
    }

    public static void printHours(int hours, int minutes) {
        StringBuilder sb = new StringBuilder();

        sb.append(hours).append(":");

        if (minutes < 10) {
            sb.append("0").append(minutes);
        } else {
            sb.append(minutes);
        }

        System.out.println(sb.toString());
    }

    public static int getMinIndex(int[][] hoursMatrix) {
        int minIndex = 0;

        for (int i = 1; i < hoursMatrix.length; i++) {
            int minHours = hoursMatrix[minIndex][0];
            int minMinutes = hoursMatrix[minIndex][1];

            int currentHours = hoursMatrix[i][0];
            int currentMinutes = hoursMatrix[i][1];

            if (currentHours > minHours) {
                continue;
            }

            if (minHours > currentHours) {
                minIndex = i;
                continue;
            }

            // equal hours

            if (minMinutes > currentMinutes) {
                minIndex = i;
            }
        }

        return minIndex;

    }

    public static int getMaxIndex(int[][] hoursMatrix) {
        int maxIndex = 0;

        for (int i = 1; i < hoursMatrix.length; i++) {
            int maxHours = hoursMatrix[maxIndex][0];
            int maxMinutes = hoursMatrix[maxIndex][1];

            int currentHours = hoursMatrix[i][0];
            int currentMinutes = hoursMatrix[i][1];

            if (maxHours > currentHours) {
                continue;
            }

            if (maxHours < currentHours) {
                maxIndex = i;
                continue;
            }

            // equal hours

            if (maxMinutes < currentMinutes) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static List<Integer> getHours(int firstHours, int firstMinutes, int secondHours, int secondMinutes) {
        List<Integer> hours = new ArrayList<>();

        Integer hour = -1;
        Integer minutes = -1;

        if (firstHours <= secondHours) {
            hour = secondHours - firstHours;
            if (firstMinutes > secondMinutes) {
                minutes = 60 - (firstMinutes - secondMinutes);
                hour--;
            } else {
                minutes = secondMinutes - firstMinutes;
            }
        } else {
            hour = (24 - firstHours) + secondHours;
            if (firstMinutes > secondMinutes) {
                minutes = 60 - (firstMinutes - secondMinutes);
                hour--;
            } else {
                minutes = secondMinutes - firstMinutes;
            }
        }

        hours.add(hour);
        hours.add(minutes);

        return hours;
    }
}
