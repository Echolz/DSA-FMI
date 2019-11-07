package HW_4_4;

import java.io.BufferedWriter;
import java.io.IOException;

public class FourthTask {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode newHead = new SinglyLinkedListNode(head.data);
        SinglyLinkedListNode currentNode = head;
        SinglyLinkedListNode currentNode2 = head;

        currentNode = currentNode.next;

        while (currentNode != null) {
            currentNode2 = new SinglyLinkedListNode(currentNode.data);
            currentNode2.next = newHead;
            newHead = currentNode2;

            currentNode = currentNode.next;
        }

        return newHead;
    }

}
