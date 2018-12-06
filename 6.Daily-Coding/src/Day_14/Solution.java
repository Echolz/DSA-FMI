package Day_14;

public class Solution {
    static int jumpingOnClouds(int[] c) {
        return dfs(c, 0, 0);
    }

    private static int dfs(int[] c, int currentIndex, int currentJumps) {
        if (currentIndex == c.length - 1) {
            return currentJumps;
        }

        int nextIndex = currentIndex + 1;

        int firstDfs = Integer.MAX_VALUE;
        int secondDfs = Integer.MAX_VALUE;

        if (nextIndex < c.length && c[nextIndex] != 1) {
            firstDfs = dfs(c, nextIndex, currentJumps + 1);
        }

        nextIndex = currentIndex + 2;

        if (nextIndex < c.length && c[nextIndex] != 1) {
            secondDfs = dfs(c, nextIndex, currentJumps + 1);
        }

        return min(firstDfs, secondDfs);
    }

    private static int min(int n1, int n2) {
        return n1 < n2 ? n1 : n2;
    }
}
