package Day_64;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {
  static HashMap<Integer, HashMap<Integer, Integer>> g = new HashMap<>();

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    s.nextInt();
    int p = s.nextInt();

    for (int i = 0; i < p; i++) {
      int v1 = s.nextInt();
      int v2 = s.nextInt();
      int w = s.nextInt();
      add(v1, v2, w);
      add(v2, v1, w);
    }

    int k = s.nextInt();
    int a = 0;

    List<Integer> pa = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      pa.add(s.nextInt());
    }

    for (int i = 1; i < k; i++) {
      HashMap<Integer, Integer> adj = g.get(pa.get(i - 1));
      if (!adj.containsKey(pa.get(i))) {
        System.out.println(-1);
        return;
      }

      a += adj.get(pa.get(i));
    }

    System.out.println(a);
  }

  private static void add(int from, int to, int w) {
    if (!g.containsKey(from)) {
      g.put(from, new HashMap<>());
    }

    g.get(from).put(to, w);
  }
}
