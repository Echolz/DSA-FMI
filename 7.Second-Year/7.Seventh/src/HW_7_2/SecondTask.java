package HW_7_2;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SecondTask {
    public static void main(String[] args) {
        InputReader scanner = new InputReader();

        int roomsNum = scanner.readInt();


        List<Integer> keys = new ArrayList<>();
        readInput(keys, scanner);

        List<Integer> rooms = new ArrayList<>();
        readInput(rooms, scanner);

        Map<Integer, Integer> map = new HashMap<>();

        int answer = 0;
        for (int i = 0; i < roomsNum; i++) {
            int currentKey = keys.get(i);
            int currentRoom = rooms.get(i);

            addToMap(map, currentKey);

            //if we dont have the key to the given room
            if (!tryToUnlock(currentRoom, map)) {
                answer++;
                addToMap(map, currentRoom);
            }
        }

        System.out.println(answer);
    }

    private static void readInput(List<Integer> keys, InputReader scanner) {
        String[] line = scanner.readLine().split(" ");
        for (String s : line) {
            keys.add(Integer.parseInt(s));
        }
    }

    private static boolean tryToUnlock(int currentRoom, Map<Integer, Integer> map) {
        if (map.containsKey(currentRoom)) {
            int copies = map.get(currentRoom);
            if (copies == 1) {
                map.remove(currentRoom);
                return true;
            }

            map.put(currentRoom, copies - 1);
            return true;
        }
        return false;
    }

    private static void addToMap(Map<Integer, Integer> map, int currentKey) {
        if (!map.containsKey(currentKey)) {
            map.put(currentKey, 0);
        }

        map.put(currentKey, map.get(currentKey) + 1);
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
        } while (c != '\n');
        return res.toString();
    }

    String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (c != ' ');
        return res.toString();
    }

    boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}
