package HW_10_1;

import java.util.*;

public class Solution {
    static int current;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int firstVertex = scanner.nextInt();
            int secondVertex = scanner.nextInt();

            addToGraph(graph, firstVertex, secondVertex);
        }

        Set<Integer> used = new HashSet<>();

        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;

        for (Integer vertex : graph.keySet()) {
            if (used.contains(vertex)) {
                continue;
            }

            current = 0;
            getVertices(vertex, graph, used);
            min = Integer.min(min, current);
            max = Integer.max(max, current);
        }

        System.out.println(min + " " + max);
    }

    private static void getVertices(Integer vertex, Map<Integer, Set<Integer>> graph, Set<Integer> used) {
        used.add(vertex);
        current++;
        for (Integer neighbor : graph.get(vertex)) {
            if (used.contains(neighbor)) {
                continue;
            }
            getVertices(neighbor, graph, used);
        }
    }

    private static void addToGraph(Map<Integer, Set<Integer>> graph, int firstVertex, int secondVertex) {
        if (!graph.containsKey(firstVertex)) {
            graph.put(firstVertex, new LinkedHashSet<>());
        }

        graph.get(firstVertex).add(secondVertex);

        if (!graph.containsKey(secondVertex)) {
            graph.put(secondVertex, new LinkedHashSet<>());
        }

        graph.get(secondVertex).add(firstVertex);
    }
}
