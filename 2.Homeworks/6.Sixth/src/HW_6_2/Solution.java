package HW_6_2;

import java.util.*;

public class Solution {
    public static Map<Integer, List<Node>> verticalOrder;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.left.right = new Node(8);
        root.right.left.right.right = new Node(10);
        root.right.left.right.right.right = new Node(11);
        root.right.left.right.right.right.right = new Node(12);
        root.right.right = new Node(7);
        root.right.right.right = new Node(9);

        topView(root);
    }

    public static void topView(Node root) {
        initMap();

        bfs(root);

        for (Integer key : verticalOrder.keySet()) {
            System.out.print(verticalOrder.get(key).get(0) + " ");
        }
    }

    public static void bfs(Node root) {
        Wrapper currentWrapper = new Wrapper(0, root);
        Node currentNode;
        int currVertOrder;
        Queue<Wrapper> queue = new LinkedList<>();
        queue.add(currentWrapper);

        while (!queue.isEmpty()) {
            currentWrapper = queue.poll();
            currentNode = currentWrapper.currentNode;
            currVertOrder = currentWrapper.vertOrder;
            if (currentNode.left != null) {
                queue.add(new Wrapper(currVertOrder - 1, currentNode.left));
            }

            if (currentNode.right != null) {
                queue.add(new Wrapper(currVertOrder + 1, currentNode.right));
            }

            initElement(currVertOrder, currentNode);
        }
    }

    private static void initMap() {
        verticalOrder = new TreeMap<>();
    }

    private static void initElement(int vertOrder, Node node) {
        if (!verticalOrder.containsKey(vertOrder)) {
            verticalOrder.put(vertOrder, new ArrayList<>());
        }

        verticalOrder.get(vertOrder).add(node);
    }

    static class Wrapper {
        int vertOrder;
        Node currentNode;

        public Wrapper(int vertOrder, Node currentNode) {
            this.vertOrder = vertOrder;
            this.currentNode = currentNode;
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
