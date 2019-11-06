package HW_4_3;

import java.io.BufferedWriter;
import java.io.IOException;

public class ThirdTask {

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

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode head = null;
        SinglyLinkedListNode currentNode = null;

        SinglyLinkedListNode currentNode1 = head1;
        SinglyLinkedListNode currentNode2 = head2;

        while (currentNode1 != null && currentNode2 != null) {
            if (head == null) {
                if (currentNode1.data < currentNode2.data) {
                    head = new SinglyLinkedListNode(currentNode1.data);
                    currentNode1 = currentNode1.next;
                } else {
                    head = new SinglyLinkedListNode(currentNode2.data);
                    currentNode2 = currentNode2.next;
                }
                currentNode = head;
                continue;
            }

            if (currentNode1.data < currentNode2.data) {
                currentNode.next = new SinglyLinkedListNode(currentNode1.data);
                currentNode1 = currentNode1.next;
            } else {
                currentNode.next = new SinglyLinkedListNode(currentNode2.data);
                currentNode2 = currentNode2.next;
            }

            currentNode = currentNode.next;

        }

        while (currentNode1 != null) {
            currentNode.next = new SinglyLinkedListNode(currentNode1.data);

            currentNode1 = currentNode1.next;
            currentNode = currentNode.next;
        }

        while (currentNode2 != null) {
            currentNode.next = new SinglyLinkedListNode(currentNode2.data);

            currentNode2 = currentNode2.next;
            currentNode = currentNode.next;
        }

        return head;
    }
}