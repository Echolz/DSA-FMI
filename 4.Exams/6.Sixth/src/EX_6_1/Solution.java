package EX_6_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        String[] line = scanner.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        Graph<Integer> graph = new Graph<>();

        for (Integer j = 0; j < m; j++) {
            line = scanner.readLine().split(" ");

            Integer from = Integer.parseInt(line[0]);
            Integer to = Integer.parseInt(line[1]);
            Integer weight = Integer.parseInt(line[2]);
            graph.putToGraph(from, to, weight);
            graph.putToGraph(to, from, weight);
        }

        line = scanner.readLine().split(" ");

        Integer start = Integer.parseInt(line[0]);

        PathWrapper<Integer> resut = graph.shortestPath(start);

        for (int j = 1; j < n + 1; j++) {

            if (j == start) {
                continue;
            }

            if (resut.shortestPaths.get(j) == null) {
                System.out.print(-1 + " ");
                continue;
            }

            System.out.print(resut.shortestPaths.get(j) + " ");
        }
    }
}

class Graph<T> {
    Map<T, Set<Vertex<T>>> graph = new LinkedHashMap<>();
    Map<T, Integer> shortestPaths = new HashMap<>();
    Map<T, T> shortestPathFromTo = new HashMap<>();

    void putToGraph(T from, T to, Integer weight) {
        Vertex<T> vert = new Vertex<>(to, weight);

        if (!graph.containsKey(from)) {
            graph.put(from, new LinkedHashSet<>());
        }

        graph.get(from).add(vert);

        shortestPaths.put(to, -1);
    }

    PathWrapper<T> shortestPath(T startingNode) {
        PathWrapper<T> pathWrapper = new PathWrapper<>();
        pathWrapper.shortestPathFromTo = shortestPathFromTo;
        pathWrapper.shortestPaths = shortestPaths;

        shortestPathFromTo.put(startingNode, startingNode);
        shortestPaths.put(startingNode, 0);

        Set<T> visited = new HashSet<>();

        PriorityQueue<NodeWrapper<T>> pq = new PriorityQueue<>();
        pq.add(new NodeWrapper<>(startingNode, 0));

        T curretnNode;
        while (!pq.isEmpty()) {
            NodeWrapper<T> nw = pq.poll();
            int wei = nw.weight;
            curretnNode = nw.node;
            if (!graph.containsKey(curretnNode) || graph.get(curretnNode) == null) {
                continue;
            }

            if (visited.contains(curretnNode)) {
                continue;
            }

            for (Vertex<T> adj : graph.get(curretnNode)) {
                Integer weight = wei + adj.weight;

                if (visited.contains(curretnNode)) {
                    continue;
                }

                if ((shortestPaths.get(adj.toNode) == -1 || shortestPaths.get(adj.toNode) > weight)) {
                    shortestPaths.put(adj.toNode, weight);
                    shortestPathFromTo.put(adj.toNode, curretnNode);
                    pq.add(new NodeWrapper<>(adj.toNode, weight));
                }
            }

            visited.add(curretnNode);
        }


        return pathWrapper;
    }

}

class NodeWrapper<T> implements Comparable<NodeWrapper<T>> {
    T node;
    Integer weight;

    public NodeWrapper(T node, Integer weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return node + "->" + weight;
    }

    @Override
    public int compareTo(NodeWrapper<T> o) {
        return Integer.compare(weight, o.weight);
    }
}

class Vertex<T> {
    T toNode;
    Integer weight;

    public Vertex(T toNode, Integer weight) {
        this.toNode = toNode;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(toNode, vertex.toNode) && Objects.equals(weight, vertex.weight);
    }

    @Override
    public int hashCode() {

        return Objects.hash(toNode, weight);
    }
}

class PathWrapper<T> {
    Map<T, Integer> shortestPaths;
    Map<T, T> shortestPathFromTo;
}


