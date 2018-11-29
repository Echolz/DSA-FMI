package EX_4_3;

import java.util.Scanner;

class Solution {
    static int counter = 0;

    public static void leaves(Node root) {
        dfs(root);
        System.out.println(counter);
    }

    private static void dfs(Node root) {
        if (root.leftNode == null && root.rightNode == null) {
            if (root.data % 2 == 1) {
                counter += root.data;
            }
            return;
        }

        if (root.leftNode != null) {
            dfs(root.leftNode);
        }

        if (root.rightNode != null) {
            dfs(root.rightNode);
        }
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
        leaves(root);
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