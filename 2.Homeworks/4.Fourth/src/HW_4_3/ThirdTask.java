package HW_4_3;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        InputReader scanner = new InputReader();

        int n = scanner.nextInt();

        Map<Integer, SnowMan> indexToSnowman = new HashMap<>();

        indexToSnowman.put(0, new SnowMan(0, 0, null));

        int snowManIndex;
        int ball;

        long sum = 0;

        for (int i = 1; i < n + 1; i++) {
            snowManIndex = scanner.nextInt();
            ball = scanner.nextInt();

            SnowMan parentSnowman = indexToSnowman.get(snowManIndex);

            SnowMan newSnowman;

            if (ball != 0) {
                newSnowman = new SnowMan(parentSnowman.sum + ball, ball, new Query(snowManIndex, ball));
            } else {
                int newSnowmanSum = parentSnowman.sum - parentSnowman.lastBall;
                parentSnowman = indexToSnowman.get(parentSnowman.builtQuery.snowmanIndex);
                newSnowman = new SnowMan(newSnowmanSum, parentSnowman.lastBall, parentSnowman.builtQuery);
            }

            indexToSnowman.put(i, newSnowman);
            sum += newSnowman.sum;

        }

        System.out.println(sum);
    }
}

class SnowMan {
    int sum;
    int lastBall;
    Query builtQuery;

    public SnowMan(int sum, int lastBall, Query builtQuery) {
        this.sum = sum;
        this.lastBall = lastBall;
        this.builtQuery = builtQuery;
    }
}

class Query {
    int snowmanIndex;
    int addedBall;

    public Query(int snowmanIndex, int addedBall) {
        this.snowmanIndex = snowmanIndex;
        this.addedBall = addedBall;
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
