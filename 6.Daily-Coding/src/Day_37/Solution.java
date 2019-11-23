package Day_37;

import java.util.*;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> scores = readScores();

        List<Integer> compScores = readCompScores();

        for (Integer compScore : compScores) {
            int place = findPlace(compScore, scores);
            System.out.println(place);
        }
    }

    private static int findPlace(Integer compScore, List<Integer> scores) {
        if (compScore >= scores.get(0)) {
            return 1;
        }

        int lastIndex = scores.size() - 1;

        if (compScore < scores.get(lastIndex)) {
            return lastIndex + 2;
        }

        if (compScore.equals(scores.get(lastIndex))) {
            return lastIndex + 1;
        }

        return binarySearch(compScore, 0, lastIndex, scores);
    }

    private static int binarySearch(Integer compScore, int left, int right, List<Integer> scores) {
        if (left <= right) {
            int middle = left + (right - left) / 2;

            if (compScore.equals(scores.get(middle))) {
                return middle + 1;
            }

            if (compScore > scores.get(middle)) {
                return binarySearch(compScore, left, middle - 1, scores);
            }

            return binarySearch(compScore, middle + 1, right, scores);
        }

        if (compScore > scores.get(left)) {
            return left + 1;
        }

        return left;
    }

    private static List<Integer> readScores() {
        int n = scanner.nextInt();

        Set<Integer> set = new HashSet<>();

        List<Integer> ladder = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int currentScore = scanner.nextInt();
            if (set.add(currentScore)) {
                ladder.add(currentScore);
            }
        }

        return ladder;
    }

    private static List<Integer> readCompScores() {
        int n = scanner.nextInt();

        List<Integer> compScores = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int currentScore = scanner.nextInt();
            compScores.add(currentScore);
        }

        return compScores;
    }

}
