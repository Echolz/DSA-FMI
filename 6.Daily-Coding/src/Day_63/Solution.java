package Day_63;

import java.util.*;

public class Solution {
  static Set<Integer> v = new HashSet<>();

  static int answer = 0;

  static Map<Integer, Set<Integer>> g = new HashMap<>();


  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    s.nextInt();
    int v = s.nextInt();

    for (int i = 0; i < v; i++) {
      int first = s.nextInt();
      int second = s.nextInt();

      addV(first, second);


      addV(second, first);
    }

    depthFirst(1);
    System.out.println(answer);
  }

  private static int depthFirst(int node) {
    v.add(node);
    int vert = 0;
    for (Integer adj : g.get(node)) {
      if (!v.contains(adj)) {
        int nodes = depthFirst(adj);
        if (nodes % 2 != 0) {
          vert += nodes;
        } else {
          answer++;
        }
      }
    }
    return vert + 1;
  }

  private static void addV(int from, int to) {
    if (!g.containsKey(from)) {
      g.put(from, new LinkedHashSet<>());
    }

    g.get(from).add(to);
  }
}