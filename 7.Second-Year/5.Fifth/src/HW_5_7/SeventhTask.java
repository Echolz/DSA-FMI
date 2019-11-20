package HW_5_7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

public class SeventhTask {
    private Node root;

    public void insert(int value) {
        root = insertHelper(root, value);
    }

    private Node insertHelper(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        } else if (node.data > value) {
            node.left = insertHelper(node.left, value);
        } else if (node.data < value) {
            node.right = insertHelper(node.right, value);
        }
        return node;
    }

    public void deletePenultimateAndPrint() {
        dfs(this.root);
        print(this.root);
    }

    private void print(Node currentNode) {
        if (currentNode == null) {
            return;
        }
        print(currentNode.left);
        System.out.print(currentNode.data + " ");
        print(currentNode.right);
    }

    private void dfs(Node currentNode) {

        if (isLeaf(currentNode.left) && currentNode.right == null) {
            currentNode.data = currentNode.left.data;
            currentNode.left = null;
            return;
        }

        if (isLeaf(currentNode.right) && currentNode.left == null) {
            currentNode.data = currentNode.right.data;
            currentNode.right = null;
            return;
        }

        if (isLeaf(currentNode.left) && isLeaf(currentNode.right)) {
            currentNode.data = currentNode.right.data;
            currentNode.right = null;
            return;
        }

        //the node does not have to be removed
        if (currentNode.left != null) {
            dfs(currentNode.left);
        }

        if (currentNode.right != null) {
            dfs(currentNode.right);
        }
    }

    private boolean isLeaf(Node node) {
        return node != null && node.right == null && node.left == null;
    }

    public static void main(String[] args) throws FileNotFoundException {
        InputReader in = new InputReader();
        int n = in.readInt();
        SeventhTask tree = new SeventhTask();
        for (int i = 0; i < n; i++) {
            tree.insert(in.readInt());
        }
        tree.deletePenultimateAndPrint();
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
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}

