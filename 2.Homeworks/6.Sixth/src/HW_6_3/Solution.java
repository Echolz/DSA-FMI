package HW_6_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Map<Integer, Node> map = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int first;
        int second;

        for (int i = 0; i < n - 1; i++) {
            first = scanner.nextInt();
            second = scanner.nextInt();

            map.put(second, new Node(first));
            map.put(first, new Node(second));
        }

        int k = scanner.nextInt();

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < k; i++) {
            int node = scanner.nextInt();
            int parents = scanner.nextInt();

            int answer = node;

            for (int j = 0; j < parents - 1; j++) {
                answer = map.get(answer).parent;
            }
            output.append(answer).append("\n");
        }

        System.out.println(output.toString());


    }
}

class Node {
    Integer parent;
    Integer left;
    Integer right;

    public Node() {

    }

    public Node(int parent) {
        this.parent = parent;
    }
}
