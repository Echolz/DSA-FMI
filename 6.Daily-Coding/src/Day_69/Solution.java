package Day_69;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public static void main(String[] args) {
    System.out.println(networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1));
  }

  static int n = 0;

  public static int networkDelayTime(int[][] times, int N, int K) {
    n = 0;
    Map<Integer, List<Path>> map = initMap(times);

    int w = dfs(map, K, 0);

    System.out.println(n);

    if (n != N) {
      return -1;
    }

    return w;
  }

  private static int dfs(Map<Integer, List<Path>> map, int currentNode, int currentW) {
    n++;
    if (!map.containsKey(currentNode)) {
      return currentW;
    }

    int maxW = -1;

    for (Path path : map.get(currentNode)) {
      maxW = Integer.max(dfs(map, path.to, currentW + path.w), maxW);
    }

    return maxW;
  }

  private static Map<Integer, List<Path>> initMap(int[][] times) {
    Map<Integer, List<Path>> map = new HashMap<>();

    for (int[] connection : times) {
      addToMap(connection[0], connection[1], connection[2], map);
    }

    return map;
  }

  private static void addToMap(int f, int t, int w, Map<Integer, List<Path>> map) {
    if (!map.containsKey(f)) {
      map.put(f, new ArrayList<>());
    }

    map.get(f).add(new Path(t, w));
  }
}

class Path {
  Integer to;
  Integer w;

  public Path(Integer to, Integer w) {
    this.to = to;
    this.w = w;
  }
}
