package Day_57;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] matrix) {
        int circles = 0;

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (visited.contains(i)) {
                    continue;
                }
                circles++;
                dfs(matrix, visited, i);
            }
        }


        return circles;
    }

    private void dfs(int[][] matrix, Set<Integer> visited, int i) {
        visited.add(i);

        for (int j = 0; j < matrix.length; j++) {
            if (matrix[i][j] == 0) {
                continue;
            }

            if (matrix[i][j] == 1 && !visited.contains(j)) {
                dfs(matrix, visited, j);
            }
        }
    }
}
