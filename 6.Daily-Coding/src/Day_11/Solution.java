package Day_11;

public class Solution {
    static int sockMerchant(int n, int[] ar) {
        int[] socks = new int[101];

        for (Integer sock : ar) {
            socks[sock]++;
        }

        int answer = 0;

        for (Integer sock : socks) {
            answer += sock / 2;
        }

        return answer;
    }
}
