package HW_4_2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Node head = null;
        Node currentNode = null;

        for (int i = 0; i < n; i++) {
            if (head != null) {
                currentNode.nextNode = new Node(scanner.nextInt());
                currentNode = currentNode.nextNode;
                continue;
            }

            head = new Node(scanner.nextInt());
            currentNode = head;
        }


        int p = scanner.nextInt();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < p; i++) {
            set.add(scanner.nextInt());
        }

        currentNode = head;

        Set<Pair> pairs = new HashSet<>();

        int answer = 0;
        while (currentNode.nextNode != null) {
            if (set.contains(currentNode.value) && set.contains(currentNode.nextNode.value)) {
                Pair currentPair = new Pair(currentNode.value, currentNode.nextNode.value);

                if (!(pairs.contains(currentPair))) {
                    answer ++;
                    pairs.add(currentPair);
                }
            }

            currentNode = currentNode.nextNode;
        }

        System.out.println(answer);
    }
}

class Pair {
    int firstNumber;
    int secondNumber;

    Pair(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public boolean equals(Object o) {
        Pair pair = (Pair) o;
        return (firstNumber == pair.firstNumber && secondNumber == pair.secondNumber) || (firstNumber == pair.secondNumber && secondNumber == pair.firstNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNumber, secondNumber);
    }

}

class Node {
    int value;
    Node nextNode;

    Node(int value) {
        this.value = value;
    }
}
