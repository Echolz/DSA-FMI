package HW_5_5;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
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

class Wrapper {
    Node currentNode;
    int level;

    public Wrapper(Node currentNode, int level) {
        this.currentNode = currentNode;
        this.level = level;
    }
}

public class ExamFirstTask {
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

    public void printKDistant(int k) {
        Queue<Wrapper> queue = new LinkedList<>();
        queue.add(new Wrapper(this.root, 0));
        Wrapper curN;

        while (!queue.isEmpty()) {
            curN = queue.poll();

            if (curN.level == k) {
                System.out.print(curN.currentNode.data + " ");
            }

            if (curN.currentNode.right != null) {
                queue.add(new Wrapper(curN.currentNode.right, curN.level + 1));
            }

            if (curN.currentNode.left != null) {
                queue.add(new Wrapper(curN.currentNode.left, curN.level + 1));
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ExamFirstTask tree = new ExamFirstTask();
        for (int i = 0; i < n; i++) {
            tree.insert(in.nextInt());
        }
        tree.printKDistant(in.nextInt());
    }
}