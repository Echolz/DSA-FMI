package HW_10_2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Map<Integer, Integer> answers;
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Set<Integer>> graph;
        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            graph = new HashMap<>();
            answers = new LinkedHashMap<>();
            int nodes = scanner.nextInt();
            int edges = scanner.nextInt();

            for (int j = 0; j < edges; j++) {
                int firstVertex = scanner.nextInt();
                int secondVertex = scanner.nextInt();

                addToGraph(graph, firstVertex, secondVertex);
            }

            int startingNode = scanner.nextInt();

            for (int j = 1; j < nodes + 1; j++) {
                answers.put(j, -1);
                if (j == startingNode) {
                    answers.put(j, 0);
                }
            }

            if (graph.containsKey(startingNode)) {
                bfs(graph, answers, startingNode);
            }


            for (int j = 1; j < nodes + 1; j++) {
                if (j == startingNode) {
                    continue;
                }
                System.out.print(answers.get(j) + " ");
            }
            System.out.println();
        }

    }

    private static void bfs(Map<Integer, Set<Integer>> graph, Map<Integer, Integer> answers, int startingNode) {
        Queue<Integer> queu = new LinkedList<>();
        Integer currentNode = startingNode;

        Set<Integer> set = new HashSet<>();
        set.add(currentNode);
        queu.add(currentNode);

        while (!queu.isEmpty()) {
            currentNode = queu.poll();

            for (Integer neighbor : graph.get(currentNode)) {
                if (set.contains(neighbor)) {
                    continue;
                }

                set.add(neighbor);
                answers.put(neighbor, answers.get(currentNode) + 6);
                queu.add(neighbor);
            }
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
