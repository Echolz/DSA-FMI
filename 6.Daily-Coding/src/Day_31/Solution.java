package Day_31;

public class Solution {
    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AAABBB"));
    }

    static int alternatingCharacters(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            int j = i + 1;
            Character currentChar = s.charAt(i);
            while (j < s.length() && s.charAt(j) == currentChar) {
                j++;
                answer++;
            }

            if (i + 1 != j) {
                i = j - 1;
            }
        }
        return answer;
    }
}
