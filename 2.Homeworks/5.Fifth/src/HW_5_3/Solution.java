package HW_5_3;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] lab = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int number = scanner.nextInt();
                if (number == 1) {
                    number = -1;
                }

                lab[i][j] = number;
            }
        }

        LinkedList<Position> positions = new LinkedList<>();
        int[] deltaRows = {0, 0, 1, -1};
        int[] deltaCols = {-1, 1, 0, 0};

        Position currentPosition = new Position(0, 0, 0);

        positions.addLast(currentPosition);

        while (!positions.isEmpty()) {
            currentPosition = positions.removeFirst();
            for (int i = 0; i < 4; i++) {
                Position newPosition = new Position(currentPosition.row + deltaRows[i], currentPosition.col + deltaCols[i], currentPosition.path + 1);
                if (newPosition.isValid(rows, cols) && lab[newPosition.row][newPosition.col] == 0 && !(newPosition.col == 0 && newPosition.row == 0)) {
                    lab[newPosition.row][newPosition.col] = newPosition.path;
                    positions.addLast(newPosition);
                }
            }
        }

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < k; i++) {
            int currentRow = scanner.nextInt();
            int currentCol = scanner.nextInt();

            if (currentRow == 0 && currentCol == 0) {
                output.append("0").append("\n");
                continue;
            }

            if (lab[currentRow][currentCol] == 0) {
                output.append("-1").append("\n");
                continue;
            }

            output.append(lab[currentRow][currentCol]).append("\n");
        }

        System.out.println(output.toString());
    }
}

class Position {
    int row;
    int col;
    int path;

    public Position(int row, int col, int path) {
        this.row = row;
        this.col = col;
        this.path = path;
    }

    boolean isValid(int rows, int cols) {
        return (0 <= row && row < rows) && (0 <= col && col < cols);
    }
}