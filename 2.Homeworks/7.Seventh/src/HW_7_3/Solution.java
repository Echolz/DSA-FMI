package HW_7_3;

import java.util.*;

public class Solution {
    static Map<Integer, List<Integer>> connections = new HashMap<>();
    static Set<Integer> nodesWithCaffees = new HashSet<>();
    static int maxCaffees = -1;
    static int n = -1;
    static int answers = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        maxCaffees = scanner.nextInt();

        for (int i = 1; i < n + 1; i++) {
            int state = scanner.nextInt();
            if (state == 0) {
                continue;
            }
            nodesWithCaffees.add(i);
        }

        for (int i = 0; i < n - 1; i++) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();

            addConnection(n1, n2);
            addConnection(n2, n1);
        }

        dfs(1, 0, new HashSet<>());
        System.out.println(answers);
    }

    static void dfs(int currentNode, int currentSum, Set<Integer> visitedNodes) {
        if (nodesWithCaffees.contains(currentNode)) {
            currentSum++;
        }
        visitedNodes.add(currentNode);

        boolean isLeaf = true;
        List<Integer> children = connections.get(currentNode);

        for (Integer child : children) {
            if (visitedNodes.contains(child)) {
                continue;
            }

            isLeaf = false;
            dfs(child, currentSum, visitedNodes);
            visitedNodes.remove(child);
        }

        if (isLeaf && currentSum <= maxCaffees) {
            answers++;
        }
    }

    static void addConnection(int n1, int n2) {
        if (!connections.containsKey(n1)) {
            connections.put(n1, new ArrayList<>());
        }

        connections.get(n1).add(n2);
    }
}
