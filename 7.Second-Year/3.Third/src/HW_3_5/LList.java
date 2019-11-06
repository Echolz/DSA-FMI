package HW_3_5;

import java.util.Scanner;

class Node {
    Node(Node _next, int _data) {
        next = _next;
        data = _data;
    }

    Node next;
    int data;
}

public class LList {
    private Node head;

    public LList() {
        head = null;
    }

    public void add(int number) {
        Node node = new Node(head, number);
        head = node;
    }

    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.printf("%d ", curr.data);
            curr = curr.next;
        }
    }

    public void removeComplex(int devidedBy) {
        Node pN = head;
        Node cN = head.next;
        while (head != null) {
            if (head.data % devidedBy != 0) {
                break;
            }

            head = head.next;
        }
        while (cN != null) {
            if (cN.data % devidedBy == 0) {
                cN = cN.next;
                pN.next = cN;
                continue;
            }
            pN = cN;
            cN = cN.next;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LList l = new LList();

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            l.add(in.nextInt());
        }
        int k = in.nextInt();
        l.removeComplex(k);
        l.print();
    }

}