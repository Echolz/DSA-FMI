package Day_13;

public class Solution {
    public static void main(String[] args) {
        System.out.println(repeatedString("gfcaaaecbg", 547602));
    }

    static long repeatedString(String s, long n) {
        long answer = 0;

        // n <= 10^12

        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                k++;
            }
        }

        if (k == 0) {
            return 0;
        }


        answer = (n / s.length()) * k;

        for (int i = 0; i < n % s.length(); i++) {
            if (s.charAt(i) == 'a') {
                answer++;
            }
        }

        return answer;
    }
}
