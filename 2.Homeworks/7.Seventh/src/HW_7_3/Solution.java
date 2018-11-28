package HW_7_3;

import java.util.*;

public class Solution {
    static Map<Integer, List<Integer>> connections = new HashMap<>();
    static Map<Integer, Integer> nodesWithCaffees = new HashMap<>();
    static int maxCaffees = -1;
    static int n = -1;
    static int answers = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        maxCaffees = scanner.nextInt();

        for (int i = 1; i < n + 1; i++) {
            int state = scanner.nextInt();
            nodesWithCaffees.put(i, state);
        }

        for (int i = 0; i < n - 1; i++) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();

            addConnection(n1, n2);
            addConnection(n2, n1);
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        dfs(1, nodesWithCaffees.get(1), visited);
        System.out.println(answers);
    }

    static void dfs(int currentNode, int currentSum, Set<Integer> visitedNodes) {
        if (currentSum > maxCaffees) {
            return;
        }

        List<Integer> children = connections.get(currentNode);
        boolean isLeaf = true;
        List<Integer> notVisited = new ArrayList<>();

        for (Integer child : children) {
            if (visitedNodes.contains(child)) {
                continue;
            }
            isLeaf = false;
            notVisited.add(child);
        }

        if (isLeaf) {
            answers++;
            return;
        }

        for (Integer child : notVisited) {
            visitedNodes.add(child);
            dfs(child, currentSum + nodesWithCaffees.get(child), visitedNodes);
        }
    }

    static void addConnection(int n1, int n2) {
        if (!connections.containsKey(n1)) {
            connections.put(n1, new ArrayList<>());
        }

        connections.get(n1).add(n2);
    }
}
