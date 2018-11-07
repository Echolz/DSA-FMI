package HW_4_5;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class FifthTask {
    public static void main(String[] args) {
        List<ListC> output = new ArrayList<>();

        InputReader scanner = new InputReader();

        int q = scanner.nextInt();

        String line;

        for (int i = 0; i < q; i++) {
            line = scanner.readLine();
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

    int nextInt() {
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
                return res * Math.pow(10, nextInt());
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
                    return res * Math.pow(10, nextInt());
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
