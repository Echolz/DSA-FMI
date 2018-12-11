package Day_17;

public class Solution {
    static void minimumBribes(int[] q) {
        int ans = 0;

        for (int i = q.length - 1; i >= 0; i--) {
            int n = q[i];
            int nodesOvertaken = n - (i + 1);
            if (nodesOvertaken > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, n - 2); j < i; j++) {
                if (q[j] > q[i]) ans++;
            }
        }

        System.out.println(ans);
    }
}
