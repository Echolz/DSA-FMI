package HW_6_1;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class FirstTask {
    public static void main(String[] args) {
        InputReader scanner = new InputReader();

        int numberOfHouses = scanner.readInt();

        int firstNHouses = scanner.readInt();

        Queue<House> houses = new PriorityQueue<>();

        for (int i = 0; i < numberOfHouses; i++) {
            int currentX = scanner.readInt();
            int currentY = scanner.readInt();

            House currentHouse = new House(currentX, currentY);
            currentHouse.distance = calculateDistance(currentHouse.x, currentHouse.y);
            houses.add(currentHouse);
        }

        for (int i = 0; i < firstNHouses; i++) {
            System.out.println(houses.poll());
        }
    }

    private static double calculateDistance(int x, int y) {
        return Math.sqrt(pow(x) + pow(y));
    }

    private static long pow(long n) {
        return n * n;
    }
}

class House implements Comparable<House> {
    int x;
    int y;
    double distance;

    public House(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("%d %d", this.x, this.y);
    }

    @Override
    public int compareTo(House house) {
        int result = Double.compare(this.distance, house.distance);

        if (result != 0) {
            return result;
        }

        result = Integer.compare(this.x, house.x);

        if (result != 0) {
            return result;
        }

        return Integer.compare(this.y, house.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
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