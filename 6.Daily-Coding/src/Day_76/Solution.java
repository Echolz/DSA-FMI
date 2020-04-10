package Day_76;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public static void main(String[] args) {

  }

  public int singleNumber(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      addToMap(map, nums[i]);
    }

    for (Integer integer : map.keySet()) {
      if (map.get(integer) == 1) {
        return integer;
      }
    }


    return -1;
  }

  private void addToMap(Map<Integer, Integer> map, int num) {
    if (!map.containsKey(num)) {
      map.put(num, 0);
    }

    map.put(num, map.get(num) + 1);
  }
}