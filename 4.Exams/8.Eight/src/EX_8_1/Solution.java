package EX_8_1;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Node head = null;

        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String command[] = scanner.nextLine().split(" ");

            if (command[0].equals("add")) {
                Integer v = Integer.parseInt(command[1]);

                if (head == null) {
                    head = new Node(v);
                    continue;
                }

                add(head, v);
                continue;
            }

            print(head);
        }
    }

    static void add(Node cNode, Integer v) {
        if (cNode.value > v) {
            if (cNode.left == null) {
                cNode.left = new Node(v);
            } else {
                add(cNode.left, v);
            }
        }

        if (cNode.value < v) {
            if (cNode.right == null) {
                cNode.right = new Node(v);
            } else {
                add(cNode.right, v);
            }
        }
    }

    static void print(Node cNode) {
        if (cNode == null) {
            return;
        }

        System.out.print(cNode.value + " ");
        print(cNode.left);
        print(cNode.right);
    }
}

class Node {
    Node left;
    Node right;
    int value;

    public Node(int value) {
        this.value = value;
    }
}
