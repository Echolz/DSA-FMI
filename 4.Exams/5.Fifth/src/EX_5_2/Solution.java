package EX_5_2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Map<Integer, Integer> answers;
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Set<Integer>> graph;

        graph = new HashMap<>();
        answers = new HashMap<>();
        int edges = scanner.nextInt();

        for (int j = 0; j < edges; j++) {
            int firstVertex = scanner.nextInt();
            int secondVertex = scanner.nextInt();

            addToGraph(graph, firstVertex, secondVertex);
        }

        for (Integer key : graph.keySet()) {
            addToAnswers(answers, key, 0);
        }


        bfs(graph, answers, 0);


        int answer = 0;

        for (Integer key : answers.keySet()) {
            answer += answers.get(key);
        }


        System.out.println(answer);


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

                int path = answers.get(currentNode) + 1;
                set.add(neighbor);
                addToAnswers(answers, neighbor, path);
                queu.add(neighbor);
            }
        }
    }

    private static void addToAnswers(Map<Integer, Integer> answers, Integer neighbor, int path) {
        answers.put(neighbor, path);
    }

    private static void addToGraph(Map<Integer, Set<Integer>> graph, int firstVertex, int secondVertex) {
        if (!graph.containsKey(firstVertex)) {
            graph.put(firstVertex, new HashSet<>());
        }

        graph.get(firstVertex).add(secondVertex);

        if (!graph.containsKey(secondVertex)) {
            graph.put(secondVertex, new HashSet<>());
        }

        graph.get(secondVertex).add(firstVertex);
    }
}