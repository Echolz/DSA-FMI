package Day_52;

public class Solution {
    public static void main(String[] args) {
        System.out.println(hammingWeight(-3));
    }

    public int hammWeight(int n) {
        String s = Integer.toBinaryString(n);

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);

            if (currentChar.equals('1')) {
                answer++;
            }
        }

        return answer;
    }

    public static int hammingWeight(int n) {
        int answer = 0;

        int negAnswer = 32;

        while (n != 0) {
            if (n % 2 == 1) {
                answer++;
            }

            if (n % 2 == -1) {
                negAnswer--;
            }

            n = n / 2;
        }

        if (negAnswer != 32) {
            return negAnswer + 1;
        }

        return answer;
    }

}
