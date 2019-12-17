package Day_61;

import java.util.*;

public class Solution {

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cities = scanner.nextInt();
        int paths = scanner.nextInt();
        int k = scanner.nextInt();

        Map<Integer, List<Integer>> graph = readInput(paths, scanner);

        List<Integer> answers = solve(graph, k, max);

        Collections.sort(answers);

        if (answers.size() == 0) {
            System.out.println("-1");
            return;
        }

        for (int i = 0; i < answers.size(); i++) {
            System.out.println(answers.get(i) + " ");
        }
    }

    private static List<Integer> solve(Map<Integer, List<Integer>> graph, int k, int start) {
        List<Integer> answers = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        Map<Integer, Integer> distances = new HashMap<>();
        distances.put(start, 0);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (Integer v : graph.get(current)) {
                if (!visited.contains(v)) {
                    queue.add(v);
                    visited.add(v);

                    int currentDistance = distances.get(current) + 1;
                    distances.put(v, currentDistance);

                    if (currentDistance == k) {
                        answers.add(v);
                    }
                }
            }
        }
        return answers;
    }

    private static Map<Integer, List<Integer>> readInput(int paths, Scanner scanner) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < paths; i++) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();

            max = Integer.max(max, n1);
            max = Integer.max(max, n2);

            addToGraph(n1, n2, graph);
            addToGraph(n2, n1, graph);
        }

        return graph;
    }

    private static void addToGraph(int n1, int n2, Map<Integer, List<Integer>> graph) {
        if (!graph.containsKey(n1)) {
            graph.put(n1, new ArrayList<>());
        }

        graph.get(n1).add(n2);
    }
}