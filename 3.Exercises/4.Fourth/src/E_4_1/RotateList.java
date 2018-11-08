package E_4_1;

import utils.LinkedList;
import utils.Node;

public class RotateList {
    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        node.setRight(new Node<>(2));
        node.getRight().setRight(new Node<>(3));
        node.getRight().getRight().setRight(new Node<>(4));

        node = rotate(node);

        printList(node);
    }

    private static void printList(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.getValue() + " ");
            head = head.getRight();
        }
    }

    private static Node<Integer> rotate(Node<Integer> head) {
        Node<Integer> newHead = null;
        Node<Integer> temp = null;

        while (head != null) {
            if (newHead == null) {
                newHead = new Node<>(head.getValue());
                head = head.getRight();
                continue;
            }

            temp = new Node<>(head.getValue());
            temp.setRight(newHead);
            newHead = temp;
            head = head.getRight();
        }
        return newHead;
    }
}
