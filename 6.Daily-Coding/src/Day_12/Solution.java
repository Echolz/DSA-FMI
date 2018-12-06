package Day_12;

public class Solution {
    static int countingValleys(int n, String s) {
        int answer = 0;

        int currentLevel = 0;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (c == 'U') {
                currentLevel++;
                answer = currentLevel == 0 ? ++answer : answer;
            }

            if (c == 'D') {
                currentLevel--;
            }
        }

        return answer;
    }
}
