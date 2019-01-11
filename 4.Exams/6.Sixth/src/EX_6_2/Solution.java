package EX_6_2;

import java.util.*;

class Solution {
    static Map<Integer, Set<Integer>> graph = new HashMap<>();
    static Set<Integer> visited = new HashSet<>();
    static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = scanner.nextInt();
        int vert = scanner.nextInt();

        for (int i = 0; i < vert; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();

            addToGraph(from, to);
            addToGraph(to, from);
        }

        dfs(1);
        System.out.println(ans);
    }

    private static void addToGraph(int from, int to) {
        if (!graph.containsKey(from)) {
            graph.put(from, new LinkedHashSet<>());
        }

        graph.get(from).add(to);
    }

    private static int dfs(int node) {
        visited.add(node);
        int num_vertex = 0;
        for (Integer adj : graph.get(node)) {
            if (!visited.contains(adj)) {
                int num_nodes = dfs(adj);
                if (num_nodes % 2 == 0)
                    ans++;
                else
                    num_vertex += num_nodes;
            }
        }
        return num_vertex + 1;
    }
}