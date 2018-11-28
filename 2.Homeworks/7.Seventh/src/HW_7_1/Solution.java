package HW_7_1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Solution {
    static Map<Integer, Level> levelToInfo = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Node head = null;

        for (int i = 0; i < n; i++) {
            int currentNumber = scanner.nextInt();
            if (head == null) {
                head = new Node(currentNumber, 0);
                continue;
            }
            addNode(head, currentNumber);
        }

        dfs(head);

        StringBuilder output = new StringBuilder();
        for (Integer level : levelToInfo.keySet()) {
            Level lvl = levelToInfo.get(level);
            double avg = (double) lvl.sum / (double) lvl.numberOfNodes;
            output.append(round(avg, 2)).append("\n");
        }

        System.out.println(output.toString());
    }

    private static void dfs(Node currentNode) {
        addToMap(currentNode);
        if (currentNode.left != null) {
            dfs(currentNode.left);
        }

        if (currentNode.right != null) {
            dfs(currentNode.right);
        }
    }

    private static void addToMap(Node currentNode) {
        if (!levelToInfo.containsKey(currentNode.level)) {
            levelToInfo.put(currentNode.level, new Level());
        }

        Level level = levelToInfo.get(currentNode.level);

        level.sum += currentNode.value;
        level.numberOfNodes++;
    }

    private static void addNode(Node currentNode, int numberToAdd) {
        if (currentNode.left == null && currentNode.value > numberToAdd) {
            currentNode.left = new Node(numberToAdd, currentNode.level + 1);
            return;
        }

        if (currentNode.right == null && currentNode.value <= numberToAdd) {
            currentNode.right = new Node(numberToAdd, currentNode.level + 1);
            return;
        }

        if (currentNode.value > numberToAdd) {
            addNode(currentNode.left, numberToAdd);
        } else {
            addNode(currentNode.right, numberToAdd);
        }
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}

class Node {
    int value;
    Node left;
    Node right;
    int level;

    public Node(int value, int level) {
        this.value = value;
        this.level = level;
    }
}

class Level {
    int sum = 0;
    int numberOfNodes = 0;

    @Override
    public String toString() {
        return String.format("sum: %d, nodes: %d", sum, numberOfNodes);
    }
}
