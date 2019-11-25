package Day_40;

public class Solution {
    public static void main(String[] args) {
        System.out.println(numRollsToTarget(30, 30, 500));
    }

    public static int numRollsToTarget(int dices, int faces, int target) {
        return dfs(dices, faces, target, 0, 0);
    }

    public static int dfs(int dices, int faces, int target, int currentSum, int currentDice) {
        if (currentDice == dices) {
            if (currentSum == target) {
                return 1;
            }

            return 0;
        }

        int answer = 0;

        for (int i = 1; i < faces + 1; i++) {
            answer += dfs(dices, faces, target, currentSum + i, currentDice + 1);
        }

        return answer;
    }
}
