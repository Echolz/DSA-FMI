package EX_4_1;

import java.util.Scanner;

public class Solution {

    static StringBuilder output = new StringBuilder();

    public static void print(Node root) {
        dfs(root);
        output.setLength(output.length() - 1);
        System.out.println(output.toString());
    }

    public static void dfs(Node root) {
        if (root.rightNode == null && root.leftNode == null) {
            output.append(root.data).append(";");
            return;
        }

        if (root.rightNode != null) {
            dfs(root.rightNode);

        }
        if (root.leftNode != null) {
            dfs(root.leftNode);
        }

        output.append(root.data).append(";");

    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.leftNode, data);
                root.leftNode = cur;
            } else {
                cur = insert(root.rightNode, data);
                root.rightNode = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        print(root);
    }
}

class Node {
    Node leftNode;
    Node rightNode;
    int data;

    Node(int data) {
        this.data = data;
        leftNode = null;
        rightNode = null;
    }
}