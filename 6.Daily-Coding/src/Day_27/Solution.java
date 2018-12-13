package Day_27;

import java.util.Arrays;

public class Solution {
    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);

        int toysPrice = 0;
        int i = 0;
        while (i < prices.length && prices[i] + toysPrice <= k) {
            toysPrice += prices[i];
            i++;
        }

        return i;
    }
}
