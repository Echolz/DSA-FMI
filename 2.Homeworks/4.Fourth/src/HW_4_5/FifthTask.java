package HW_4_5;

import java.util.*;

public class FifthTask {
    public static void main(String[] args) {
        List<ListC> output = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();

        String line;

        scanner.nextLine();

        for (int i = 0; i < q; i++) {
            line = scanner.nextLine();
            output.add(new ListC());
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '[') {
                    output.get(i).switchToHead();
                    continue;
                }

                if (line.charAt(j) == ']') {
                    output.get(i).switchToTail();
                    continue;
                }


                output.get(i).addLast(line.charAt(j));
            }
        }

        for (ListC currentOutput : output) {
            System.out.println(currentOutput.getStringValue());
        }
    }
}

class Node {
    Character value;
    Node left;
    Node right;

    Node(Character value) {
        this.value = value;
    }
}

class ListC {
    Node fakeHead;
    Node tail;
    Node addAfter;
    int size;

    ListC() {
        fakeHead = new Node('-');
        size = 0;
    }

    void addLast(Character value) {
        size++;

        Node currentNode = new Node(value);
        if (fakeHead.right == null) {
            fakeHead.right = currentNode;
            currentNode.left = fakeHead;

            tail = currentNode;
            addAfter = tail;
            return;
        }

        if (addAfter == tail) {
            currentNode.left = tail;
            tail.right = currentNode;

            tail = currentNode;
            addAfter = tail;
            return;
        }

        currentNode.right = addAfter.right;
        currentNode.left = addAfter;

        Node rightNode = addAfter.right;

        rightNode.left = currentNode;
        addAfter.right = currentNode;
        addAfter = currentNode;
    }

    void switchToTail() {
        addAfter = tail;
    }

    void switchToHead() {
        addAfter = fakeHead;
    }

    String getStringValue() {
        Node currentNode = fakeHead.right;

        StringBuilder toReturn = new StringBuilder();
        while(currentNode != null) {
            toReturn.append(currentNode.value);
            currentNode = currentNode.right;
        }

        return toReturn.toString();
    }
}
