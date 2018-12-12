package Day_18;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 5};
        System.out.println(minimumSwaps(arr));
    }

    static int minimumSwaps(int[] arr) {
        int l = arr.length;
        Set<Integer> checked = new HashSet<>();
        Map<Integer, Integer> dict = new TreeMap<>();

        int ans = 0;

        for (int i = 0; i < l; i++) {
            int num = arr[i];
            dict.put(num, i);
        }

        for (Integer num : dict.keySet()) {
            int index = dict.get(num);

            //checked or is in the right place
            if (checked.contains(num) || index == num - 1) {
                continue;
            }

            int count = 0;
            int i = num - 1;
            checked.add(num);
            int number;
            do {
                number = arr[i];
                checked.add(number);
                i = number - 1;
                count++;
            } while (!checked.contains(arr[i]));

            ans += count;
        }

        return ans;
    }
}
