package Day_50;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int[] deltax = {0, 0, 1, -1};
    static int[] deltay = {-1, 1, 0, 0};

    public int[][] updateMatrix(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;

        int[][] updated = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }

                updated[i][j] = bfs(new Position(i, j, 0), x, y, matrix);
            }
        }


        return updated;
    }

    private int bfs(Position position, int x, int y, int[][] matrix) {
        Queue<Position> positions = new LinkedList<>();
        positions.add(position);

        Position currentPosition;
        while (!positions.isEmpty()) {
            currentPosition = positions.poll();

            for (int i = 0; i < 4; i++) {
                int currentX = currentPosition.x + deltax[i];
                int currentY = currentPosition.y + deltay[i];

                if (!inRange(currentX, x, currentY, y)) {
                    continue;
                }

                if (matrix[currentX][currentY] == 0) {
                    return currentPosition.length + 1;
                }

                positions.add(new Position(currentX, currentY, currentPosition.length + 1));
            }
        }
        return -1;
    }

    private boolean inRange(int currentX, int x, int currentY, int y) {
        return 0 <= currentX && currentX < x && 0 <= currentY && currentY < y;
    }
}

class Position {
    int x;
    int y;
    int length;

    public Position(int x, int y, int length) {
        this.x = x;
        this.y = y;
        this.length = length;
    }
}
