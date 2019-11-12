package HW_5_2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SecondTask {

    static int allApples = 0;
    static int[] deltaRows = {0, 0, -1, 1};
    static int[] deltaCols = {1, -1, 0, 0};
    static Set<Apple> apples = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = 0;
        int rows = 0;
        int cols = 0;
        int days = 0;
        int[][] matrix = new int[0][0];

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line == null) {
                break;
            }

            String[] nums = line.split(" ");
            if (counter == 0) {
                counter++;
                rows = Integer.parseInt(nums[0]);
                cols = Integer.parseInt(nums[1]);
                days = Integer.parseInt(nums[2]);
                matrix = new int[rows][cols];
                allApples = (rows * cols);
                continue;
            }

            if (nums.length != 2) {
                break;
            }

            int currentRow = rows - Integer.parseInt(nums[0]);
            int currentCol = Integer.parseInt(nums[1]) - 1;

            Apple currentApple = new Apple(currentRow, currentCol);
            allApples--;
            apples.add(currentApple);

            matrix[currentRow][currentCol] = 1;
        }


        for (int i = 0; i < days; i++) {
            bfs(matrix);
        }

        System.out.println(allApples);
    }

    private static void bfs(int[][] matrix) {
        Set<Apple> newApples = new HashSet<>();

        for (Apple apple : apples) {
            for (int i = 0; i < 4; i++) {
                int currentRow = apple.row + deltaRows[i];
                int currentCol = apple.col + deltaCols[i];

                if (!validateCoordinates(currentRow, currentCol, matrix)) {
                    continue;
                }

                //found new rotten apple
                if (matrix[currentRow][currentCol] == 0) {
                    Apple newApple = new Apple(currentRow, currentCol);
                    allApples--;
                    newApples.add(newApple);
                    matrix[currentRow][currentCol] += 1;
                }
            }
        }

        apples = newApples;
    }

    private static boolean validateCoordinates(int row, int col, int[][] matrix) {
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
            return true;
        }

        return false;
    }
}

class Apple {
    int row;
    int col;

    public Apple(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + row;
        hash = hash * 31 + col;

        return hash;
    }
}
