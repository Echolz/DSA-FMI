package EX_8_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        BinaryTree tree = new BinaryTree();

        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String command[] = scanner.nextLine().split(" ");

            if (command[0].equals("add")) {
                Integer v = Integer.parseInt(command[1]);
                tree.add(v);
                continue;
            }

            if (command[0].equals("remove")) {
                Integer v = Integer.parseInt(command[1]);
                tree.delete(v);
                continue;
            }

            if (command[0].equals("print_odd_layers")) {
                tree.traverseOdd();
                continue;
            }

            tree.traverseDfs();
        }
    }
}

class BinaryTree {

    Node root;

    public void add(int v) {
        root = addRecursive(root, v);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    public void delete(int v) {
        root = deleteRecursive(root, v);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            int sv =findSmallestValue(current.right);

            current.value = sv;
            current.right = deleteRecursive(current.right, sv);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void traverseOdd() {
        traverseBFS(root);
    }

    public void traverseDfs() {
        traverseInOrder(root);
    }

    public void traverseBFS(Node root) {
        if (root == null) {
            return;
        }

        Queue<Wrapper> q = new LinkedList<>();
        q.add(new Wrapper(root, 1));
        while (!q.isEmpty()) {
            Wrapper cW = q.poll();
            if (cW == null) {
                continue;
            }
            Node cNode = cW.node;

            if (cNode.left != null) {
                q.add(new Wrapper(cNode.left, cW.level + 1));
            }

            if (cNode.right != null) {
                q.add(new Wrapper(cNode.right, cW.level + 1));
            }

            if (cW.level % 2 == 1) {
                System.out.print(cW.node.value + " ");
            }

        }
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            traverseInOrder(node.left);
            traverseInOrder(node.right);
        }
    }

}

class Wrapper {
    Node node;
    Integer level;

    public Wrapper(Node node, Integer level) {
        this.node = node;
        this.level = level;
    }
}

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}