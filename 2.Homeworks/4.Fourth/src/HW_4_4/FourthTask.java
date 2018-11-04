package HW_4_4;

import java.util.Scanner;

public class FourthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        scanner.nextLine();

        String[] inputArr;

        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < n; i++) {
            inputArr = scanner.nextLine().split(" ");

            if (inputArr[0].equals("add")) {
                linkedList.add(Integer.parseInt(inputArr[1]));
                continue;
            }

            if (inputArr[0].equals("gun")) {
                linkedList.removeLast();
                continue;
            }

            if (inputArr[0].equals("milen")) {
                linkedList.split();
            }
        }

        linkedList.print();
    }
}

class LinkedList {
    Node head;
    Node tail;
    int size;
    int transferredMiddle;

    Node middle;

    LinkedList() {
        head = null;
        tail = null;
        size = 0;
        transferredMiddle = 0;
    }

    void add(int value) {
        size ++;
        Node currentNode = new Node(value);

        if (head == null) {
            head = currentNode;
            tail = head;
            middle = head;
            transferredMiddle = 1;
            return;
        }

        if (size / 2 > transferredMiddle) {
            middle = middle.right;
            transferredMiddle ++;
        }

        tail.right = currentNode;
        currentNode.left = tail;
        tail = currentNode;
    }

    void removeLast() {

        if (size == 0) {
            return;
        }

        if (size == 1) {
            head = null;
            tail = null;
            middle = null;
            size = 0;
            transferredMiddle = 0;
            return;
        }

        size --;

        if (size / 2 < transferredMiddle) {
            middle = middle.left;
            transferredMiddle --;
        }

        tail = tail.left;
        tail.right = null;
    }

    void split() {

        if (size == 0 || size == 1) {
            return;
        }

        Node newMid;

        if (size % 2 == 0) {
            newMid = tail;
        } else {
            newMid = tail.left;
        }
        Node newHead = middle.right;
        newHead.left = null;
        middle.right = null;

        tail.right = head;
        head.left = tail;

        head = newHead;
        tail = middle;
        middle = newMid;
    }

    void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\n");

        Node currentNode = head;

        while(currentNode != null) {
            sb.append(currentNode.value).append(" ");
            currentNode = currentNode.right;
        }

        if (sb.length() == 0) {
            return;
        }

        sb.setLength(sb.length() - 1);


        System.out.println(sb.toString());
    }
}

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
    }
}