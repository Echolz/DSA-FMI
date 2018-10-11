package HW_1_4;

import java.io.*;
import java.util.*;

public class FourthTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSocks = scanner.nextInt();

        int day = scanner.nextInt();

        List<Integer> socks = new ArrayList<>();

        for (int i = 0; i < numberOfSocks; i++) {
            socks.add(scanner.nextInt());
        }

        List<SockPair> sockPairs = new ArrayList<>();

        SockPair sockPair;

        for (int i = 0; i < numberOfSocks - 1; i++) {
            for (int j = i + 1; j < numberOfSocks; j++) {
                sockPair = new SockPair();
                sockPair.firstSock = socks.get(i);
                sockPair.secondSock = socks.get(j);
                sockPairs.add(sockPair);
            }
        }

        Collections.sort(sockPairs);

        System.out.println(sockPairs.get(day - 1).firstSock + " " + sockPairs.get(day - 1).secondSock);
    }

}

class SockPair implements Comparable<SockPair> {
    int firstSock;
    int secondSock;


    @Override
    public int compareTo(SockPair o) {
        int firstSubtr = (firstSock - secondSock) * -1;
        int secondSubtr = (o.firstSock - o.secondSock) * -1;

        if (firstSubtr < secondSubtr) {
            return -1;
        } else if (firstSubtr > secondSubtr) {
            return 1;
        } else {
            return firstSock - o.firstSock;
        }
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", firstSock, secondSock);
    }
}
