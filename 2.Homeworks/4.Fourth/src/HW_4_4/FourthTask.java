package HW_4_4;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class FourthTask {
    public static void main(String[] args) {
        InputReader scanner = new InputReader();

        int n = scanner.readInt();

        String[] inputArr;

        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < n; i++) {
            inputArr = scanner.readLine().split(" ");

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

class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    InputReader() {
        this.stream = System.in;
    }

    int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    int readInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    long readLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    double readDouble() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.' && c != ',') {
            if (c == 'e' || c == 'E') {
                return res * Math.pow(10, readInt());
            }
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.' || c == ',') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }

    String readLine() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    boolean isSpaceChar(int c) {
        return c == '\n';
    }
}