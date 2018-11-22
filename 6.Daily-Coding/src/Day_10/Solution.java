package Day_10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        Node head = split(numbers, 0, numbers.size() - 1);

        int k = scanner.nextInt();

        StringBuilder output = new StringBuilder();

        int left;
        int right;
        for (int i = 0; i < k; i++) {
            left = scanner.nextInt();
            right = scanner.nextInt();
            output.append(dfs(head, left, right));
        }

        System.out.print(output.toString());
    }

    static Node split(List<Integer> numbers, int left, int right) {
        if (left < right) {
            Node currentNode = new Node(0, left, right);

            int mid = left + (right - left) / 2;
            Node leftNode = split(numbers, left, mid);
            Node rightNode = split(numbers, mid + 1, right);

            currentNode.left = leftNode;
            currentNode.right = rightNode;
            currentNode.sum = leftNode.sum + rightNode.sum;
            return currentNode;
        } else {
            return new Node(numbers.get(left), left, left);
        }
    }

    static int dfs(Node currentNode, int left, int right) {
        if (currentNode.i == left && currentNode.j == right) {
            return currentNode.sum;
        }
        int mid = currentNode.i + (currentNode.j - currentNode.i) / 2;
        int sum;
        if (right <= mid || left > mid) {
            if (right <= mid) {
                sum = dfs(currentNode.left, left, right);
            } else {
                sum = dfs(currentNode.right, left, right);
            }
        } else {
            int firstSum = dfs(currentNode.left, left, mid);
            int secondSum = dfs(currentNode.right, mid + 1, right);
            sum = firstSum + secondSum;
        }
        return sum;
    }
}

class Node {
    int sum;
    int i;
    int j;
    Node left;
    Node right;

    public Node() {

    }

    public Node(int sum, int i, int j) {
        this.sum = sum;
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d] -> %d", i, j, sum);
    }
}