package HW_5_1;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int streets = scanner.nextInt();
        int requests = scanner.nextInt();

        BinarySearchTree tree = new BinarySearchTree();

        for (int i = 0; i < streets; i++) {
            tree.insert(scanner.nextInt());
        }

        for (int i = 0; i < requests; i++) {
            System.out.println(tree.find(scanner.nextInt()));
        }
    }
}

class BinarySearchTree {
    Node head;

    public void insert(int value) {
        if (this.head == null) {
            this.head = new Node(value);
            return;
        }

        dfsInsert(value, this.head);
    }

    private void dfsInsert(int value, Node currentNode) {
        if (currentNode.left == null && value < currentNode.value) {
            currentNode.left = new Node(value);
            return;
        }

        if (currentNode.right == null && value > currentNode.value) {
            currentNode.right = new Node(value);
            return;
        }

        if (value > currentNode.value) {
            dfsInsert(value, currentNode.right);
        }

        if (value < currentNode.value) {
            dfsInsert(value, currentNode.left);
        }
    }

    public int find(int value) {
        return dfs(value, 0, this.head);
    }

    private int dfs(int value, int currentLevel, Node currentNode) {
        if (currentNode.value == value) {
            return currentLevel;
        }

        if (currentNode.left == null && currentNode.right == null) {
            return -1;
        }

        if (currentNode.right == null && value > currentNode.value) {
            return -1;
        }

        if (currentNode.left == null && value < currentNode.value) {
            return -1;
        }

        if (value > currentNode.value) {
            return dfs(value, currentLevel + 1, currentNode.right);
        }

        return dfs(value, currentLevel + 1, currentNode.left);
    }


}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
