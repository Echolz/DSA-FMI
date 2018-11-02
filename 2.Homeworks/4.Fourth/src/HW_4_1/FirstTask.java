package HW_4_1;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class FirstTask {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0;
        int currentNumber;

        Node head = null;
        Node currentNode = null;

        while (true) {
            try {
                currentNumber = inputReader.readInt();
                if (head == null) {
                    head = new Node(currentNumber);
                    currentNode = head;
                    continue;
                }
                currentNode.nextNode = new Node(currentNumber);
                currentNode = currentNode.nextNode;
            } catch (InputMismatchException e) {
                break;
            }
        }

        currentNode = head;

        while (currentNode != null) {
            min = Math.min(currentNode.value, min);
            max = Math.max(currentNode.value, max);
            sum += currentNode.value;
            currentNode = currentNode.nextNode;
        }

        System.out.println(min + " " + max + " " + sum);
    }
}

class Node {
    int value;
    Node nextNode;

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
        int i = 0;
        while (isSpaceChar(c)) {
            i++;
            if (i > 5) {
                throw new InputMismatchException();
            }
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            i++;
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
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}