package mst;

import java.util.*;

public class Graph {
    static Map<Integer, List<Vertex>> graph = new HashMap<>();
    static Map<Integer, Long> longestPath = new HashMap<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = scanner.nextInt();
        int vertices = scanner.nextInt();

        int start = scanner.nextInt();
        int end = scanner.nextInt();

        for (int i = 0; i < vertices; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int weight = scanner.nextInt();

            addToGraph(from, to, weight);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        longestPath.put(start, 0L);


        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();

            List<Vertex> neighbors = graph.get(currentNode);

            if (neighbors == null) {
                continue;
            }

            for (Vertex v : graph.get(currentNode)) {
                if (longestPath.get(v.to) == null || longestPath.get(v.to) < longestPath.get(currentNode) + v.weight) {
                    longestPath.put(v.to, longestPath.get(currentNode) + v.weight);
                }

                if (!visited.contains(v.to)) {
                    queue.add(v.to);
                    visited.add(v.to);
                }
            }
        }

        System.out.println(longestPath.get(end));

    }

    public static void addToGraph(Integer from, Integer to, Integer weight) {
        Vertex v = new Vertex(to, weight);
        if (!graph.containsKey(from)) {
            graph.put(from, new ArrayList<>());
        }

        graph.get(from).add(v);
        longestPath.put(from, -1L);
        longestPath.put(to, -1L);

    }
}

class Vertex {
    int to;
    int weight;

    public Vertex(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}
