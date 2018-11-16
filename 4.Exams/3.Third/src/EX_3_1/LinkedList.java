package EX_3_1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LinkedList {
    Node head;

    public LinkedList() {
        head = null;
    }

    public void add(int X, int pos) {
        Node nodeToAdd = new Node(X);
        if (head == null || pos == 0) {
            nodeToAdd.right = head;
            head = nodeToAdd;
            if (pos != 0) {
                System.out.print("add_last");
            }
            return;
        }

        Node addAfter = head;
        int currentIndex = 0;


        while (addAfter.right != null && currentIndex < pos - 1) {
            currentIndex++;
            addAfter = addAfter.right;
        }

        if (addAfter.right == null) {
            addAfter.right = nodeToAdd;
            if (currentIndex + 1 != pos) {
                System.out.print("add_last");
            }
            return;
        }

        Node tempNode = addAfter.right;
        addAfter.right = nodeToAdd;
        nodeToAdd.right = tempNode;
    }

    public void remove(int pos) {
        if (pos < 0) {
            System.out.print("remove_failed");
            return;
        }

        if (pos == 0) {
            if (head == null) {
                System.out.print("remove_failed");
                return;
            }
            head = head.right;
            return;
        }

        Node removeAfter = head;
        int currentIndex = 0;

        while (removeAfter.right != null && currentIndex < pos - 1) {
            currentIndex++;
            removeAfter = removeAfter.right;
        }

        if (removeAfter.right == null || currentIndex != pos - 1) {
            System.out.print("remove_failed");
            return;
        }

        removeAfter.right = removeAfter.right.right;
    }

    public void print() {
        Node currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.value + "#");
            currentNode = currentNode.right;
        }
    }

    public void reverse() {
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
        if (head == null) {
            return;
        }
        
        while (head != null) {
            if (head.value == X) {
                head = head.right;
                continue;
            }
            break;
        }

        Node currentNode = head;

        if (currentNode == null) {
            return;
        }

        while (currentNode.right != null) {
            if (currentNode.right.value == X) {
                currentNode.right = currentNode.right.right;
                continue;
            }

            currentNode = currentNode.right;
        }
    }

    public void group(int posX, int posY) {
        if (posX < 0 || posY < posX) {
            System.out.print("fail_grouping");
            return;
        }

        if (posX == posY) {
            return;
        }


        int sum = 0;
        int currentIndex = 0;

        Node currentNode = head;
        Node addAfter = head;
        while (currentNode != null && currentIndex <= posY) {
            if (currentIndex == posX - 1) {
                addAfter = currentNode;
            }

            if (currentIndex >= posX) {
                sum += currentNode.value;
            }
            currentIndex++;
            currentNode = currentNode.right;
        }

        if (currentIndex != posY + 1) {
            System.out.print("fail_grouping");
            return;
        }

        addAfter.value = sum;
        for (int i = 0; i < posY - posX; i++) {
            addAfter.right = addAfter.right.right;
        }
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