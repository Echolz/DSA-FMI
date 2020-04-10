package Day_80;

public class Solution {
  public static void main(String[] args) {
    int[] arr = {2, 1, 2, 0, 1};

    System.out.println(maxProfit(arr));
  }

  public static int maxProfit(int[] prices) {
    if (prices.length == 1) {
      return 0;
    }

    Integer locMin = null;
    Integer locMax = Integer.MIN_VALUE;
    int sum = 0;

    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i] < prices[i + 1]) {
        if (locMin == null) {
          locMin = prices[i];
        }
      }

      if (prices[i] > prices[i + 1]) {
        if (locMin == null) {
          continue;
        }

        locMax = prices[i];

        sum += locMax - locMin;

        locMin = null;
        locMax = Integer.MIN_VALUE;
      }
    }

    if (locMin != null && prices[prices.length - 1] > locMax) {
      sum += prices[prices.length - 1] - locMin;
    }

    return sum;
  }
}
