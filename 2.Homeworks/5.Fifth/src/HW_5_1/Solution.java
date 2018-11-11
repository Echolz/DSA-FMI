package HW_5_1;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n == 1) {
            System.out.println("1");
            return;
        }

        Node head = new Node(1);
        Node lastNode = head;

        for (int i = 3; i <= n; i += 2) {
            Node currentNode = new Node(i);
            lastNode.right = currentNode;
            lastNode = currentNode;
        }

        lastNode.right = head;

        Node currentNode = head;

        while (currentNode.right != currentNode) {
            if (currentNode.right.right == currentNode) {
                break;
            }

            currentNode.right = currentNode.right.right;
            currentNode = currentNode.right;
        }

        System.out.println(currentNode.value);
    }
}

class Node {
    int value;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}