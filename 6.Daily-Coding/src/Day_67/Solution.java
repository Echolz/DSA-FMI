package Day_67;

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int t = scanner.nextInt();

    for (int i = 0; i < t; i++) {
      solution(scanner, scanner.nextInt(), scanner.nextInt());
    }

  }

  public static void solution(Scanner scanner, int nodes, int paths) {
    Set<Integer> globalVisited = new HashSet<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();

    int answer = 0;

    for (int i = 0; i < paths; i++) {
      int from = scanner.nextInt();
      int to = scanner.nextInt();

      addToGraph(from, to, graph);
      addToGraph(to, from, graph);
    }

    for (int i = 0; i < nodes; i++) {
      if (globalVisited.contains(i)) {
        continue;
      }

      answer++;
      dfs(i, globalVisited, graph);
    }

    System.out.print(answer + " ");
  }

  private static void dfs(int i, Set<Integer> globalVisited, Map<Integer, List<Integer>> graph) {
    globalVisited.add(i);

    if (!graph.containsKey(i)) {
      return;
    }

    for (Integer integer : graph.get(i)) {
      if (!globalVisited.contains(integer)) {
        dfs(integer, globalVisited, graph);
      }
    }
  }

  private static void addToGraph(int to, int from, Map<Integer, List<Integer>> graph) {
    if (!graph.containsKey(to)) {
      graph.put(to, new ArrayList<>());
    }

    graph.get(to).add(from);
  }
}
