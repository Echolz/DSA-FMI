package EX_3_1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LinkedList {
    Node head;
    Node tail;
    int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int X, int pos) {
        Node nodeToAdd = new Node(X);

        if (head == null && tail == null) {
            head = nodeToAdd;
            tail = head;
            size++;
            if (pos != 0) {
                System.out.print("add_last");
            }
            return;
        }

        if (pos < 0 || pos >= size) {
            tail.right = nodeToAdd;
            tail = tail.right;
            if (pos != size) {
                System.out.print("add_last");
            }
            size++;
            return;
        }

        if (pos == 0) {
            nodeToAdd.right = head;
            head = nodeToAdd;
            size++;
            return;
        }

        Node addAfter = head;

        for (int i = 0; i < pos - 1; i++) {
            addAfter = addAfter.right;
        }

        Node tempNode = addAfter.right;

        addAfter.right = nodeToAdd;
        nodeToAdd.right = tempNode;

        size++;
    }

    public void remove(int pos) {
        if (size == 0 || (pos < 0 || pos >= size)) {
            System.out.print("remove_failed");
            return;
        }

        if (pos == 0) {
            if (size == 1) {
                head = null;
                tail = null;
                size--;
                return;
            }

            head = head.right;
            size--;
            return;
        }

        Node removeAfter = head;

        for (int i = 0; i < pos - 1; i++) {
            removeAfter = removeAfter.right;
        }

        // remove the last element
        if (pos == size - 1) {
            tail = removeAfter;
            tail.right = null;
            size--;
            return;
        }

        removeAfter.right = removeAfter.right.right;
        size--;
    }

    public void print() {
        Node currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.value + "#");
            currentNode = currentNode.right;
        }
    }

    public void reverse() {
        if (size == 0 || size == 1) {
            return;
        }

        Node newHead = null;

        Node temp = null;

        while (head != null) {
            if (newHead == null) {
                newHead = new Node(head.value);
                head = head.right;
                continue;
            }

            temp = new Node(head.value);
            temp.right = newHead;
            newHead = temp;
            head = head.right;
        }

        head = newHead;
        tail = head;

        while (tail.right != null) {
            tail = tail.right;
        }
    }

    public void printIsPalindrom() {
        List<Integer> arrList = new ArrayList<>();

        Node currentNode = head;

        while (currentNode != null) {
            arrList.add(currentNode.value);
            currentNode = currentNode.right;
        }


        for (int i = 0; i < arrList.size() / 2; i++) {
            if (!arrList.get(i).equals(arrList.get(arrList.size() - i - 1))) {
                System.out.print("false");
                return;
            }
        }

        System.out.print("true");
    }

    public void count(int X) {
        int count = 0;

        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.value == X) {
                count++;
            }

            currentNode = currentNode.right;
        }

        System.out.print(count);
    }

    public void removeAll(int X) {
        if (size == 0) {
            return;
        }

        int index = 0;
        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.value == X) {
                currentNode = currentNode.right;
                remove(index);
                continue;
            }

            index++;
            currentNode = currentNode.right;
        }
    }

    public void group(int posX, int posY) {
        if (posX < 0 || posX >= size) {
            System.out.print("fail_grouping");
            return;
        }

        if (posY < 0 || posY >= size) {
            System.out.print("fail_grouping");
            return;
        }

        if (posX > posY) {
            System.out.print("fail_grouping");
            return;
        }

        if (posX == posY) {
            return;
        }

        int sum = 0;
        int currentIndex = 0;

        Node currentNode = head;
        while (currentNode != null) {
            if (currentIndex >= posX && currentIndex <= posY) {
                sum += currentNode.value;
            }
            System.out.println(currentIndex + " -> " + currentNode.value);
            currentIndex++;
            currentNode = currentNode.right;
        }

        //sum is given;
        // TODO: 16.11.2018 г.

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int t = 0; t < N; t++) {
            int K = in.nextInt();
            LinkedList list = new LinkedList();
            for (int i = 0; i < K; i++) {
                String op = in.next();
                switch (op) {
                    case "add":
                        int x = in.nextInt();
                        int pos = in.nextInt();
                        list.add(x, pos);
                        break;
                    case "remove":
                        int rmPos = in.nextInt();
                        list.remove(rmPos);
                        break;
                    case "print":
                        list.print();
                        break;
                    case "reverse":
                        list.reverse();
                        break;
                    case "is_palindrom":
                        list.printIsPalindrom();
                        break;
                    case "count":
                        int numberToCount = in.nextInt();
                        list.count(numberToCount);
                        break;
                    case "remove_all":
                        int numberToRemove = in.nextInt();
                        list.removeAll(numberToRemove);
                        break;
                    case "group":
                        int posX = in.nextInt();
                        int posY = in.nextInt();
                        list.group(posX, posY);
                        break;
                }
            }
            System.out.println("");
        }
    }
}

class Node {
    int value;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}