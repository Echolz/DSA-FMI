package HW_5_6;

import java.io.FileNotFoundException;
import java.util.Scanner;

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

public class ExamSecondTask {
    private Node root;

    public void insert(int value) {
        root = insertHelper(root, value);
    }

    private Node insertHelper(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        } else if (node.data > value) {
            node.left = insertHelper(node.left, value);
        } else if (node.data < value) {
            node.right = insertHelper(node.right, value);
        }
        return node;
    }

    public void printSpecific(int dividedBy) {
        if (this.root == null) {
            return;
        }
        printer(this.root, dividedBy);
    }

    public void printer(Node curN, int k) {
        if (curN.left == null && curN.right == null) {
            return;
        }

        if (curN.data % k == 0) {
            System.out.print(curN.data + " ");
        }

        if (curN.left != null) {
            printer(curN.left, k);
        }

        if (curN.right != null) {
            printer(curN.right, k);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ExamSecondTask tree = new ExamSecondTask();
        for (int i = 0; i < n; i++) {
            tree.insert(in.nextInt());
        }
        tree.printSpecific(in.nextInt());
    }
}