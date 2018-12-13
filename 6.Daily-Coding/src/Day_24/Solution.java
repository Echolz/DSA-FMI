package Day_24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Long[] arr = {1L, 1L, 1L,};
        System.out.println(countTriplets(Arrays.asList(arr), 1));
    }

    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> map1 = new HashMap<>();
        Map<Long, Long> map2 = new HashMap<>();
        long count = 0;
        for (int i = arr.size() - 1; i >= 0; i--) {
            long a = arr.get(i);
            if (map2.containsKey(a * r)) {
                count += map2.get(a * r);
            }
            if (map1.containsKey(a * r)) {
                long c = map1.get(a * r);
                map2.put(a, map2.getOrDefault(a, 0L) + c);
            }


            map1.put(a, map1.getOrDefault(a, 0L) + 1);
        }
        return count;
    }
}
