package Day_81;

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    System.out.println(groupAnagrams(new String[]{"duh", "ill"}).toString());
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
      String newString = sortString(str);

      addToMap(map, newString, str);
    }

    return createAnswer(map);
  }

  private static List<List<String>> createAnswer(Map<String, List<String>> map) {
    List<List<String>> list = new ArrayList<>();
    int i = 0;

    for (String currentList : map.keySet()) {
      list.add(new ArrayList<>());
      for (String s1 : map.get(currentList)) {
        list.get(i).add(s1);
      }
      i++;
    }
    return list;
  }

  private static void addToMap(Map<String, List<String>> map, String newString, String str) {
    if (!map.containsKey(newString)) {
      map.put(newString, new ArrayList<>());
    }
    map.get(newString).add(str);
  }

  public static String sortString(String inputString) {
    char[] tempArray = inputString.toCharArray();
    Arrays.sort(tempArray);
    return new String(tempArray);
  }
}
