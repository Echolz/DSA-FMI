package HW_8_1;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int n;

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();

            String[] operations = line.split(" ");

            if (operations[0].equals("print")) {
                tree.print();
                continue;
            }

            double num = Double.parseDouble(operations[1]);

            if (operations[0].equals("contains")) {
                tree.contains(num);
                continue;
            }

            if (operations[0].equals("add")) {
                tree.add(num);
                continue;
            }

            if (operations[0].equals("remove")) {
                tree.remove(num);
            }
        }
    }
}

class Node {
    double value;
    Node left;
    Node right;

    Node(double value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

class AVLTree {
    Node root;

    AVLTree() {
        root = null;
    }

    boolean containsRecursive(Node current, double value) {
        if (current == null) {
            return false;
        }

        if (current.value == value) {
            return true;
        }

        if (value < current.value) {
            return containsRecursive(current.left, value);
        } else {
            return containsRecursive(current.right, value);
        }
    }

    void printRecursive(Node current) {
        if (current == null) {
            return;
        }

        printRecursive(current.left);
        printNumber(current.value);
        printRecursive(current.right);
    }

    void add(double value) {
        throw new UnsupportedOperationException("need to implement add");
    }

    void remove(double value) {
        throw new UnsupportedOperationException("need to implement remove");
    }

    boolean contains(double value) {
        if (root == null) {
            return false;
        }

        return containsRecursive(root, value);
    }

    void print() {
        if (root == null) {
            return;
        }

        printRecursive(root);
        System.out.println();
    }

    void printNumber(double number) {
        System.out.print(String.format("%.6f ", number));
    }
}