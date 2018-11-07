package Day_3;

import java.util.*;

public class Solution {

    static int currentIndex = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();

        scanner.nextLine();

        String input = scanner.nextLine();

        List<Integer> numbers = new ArrayList<>();

        for (String number : input.split(" ")) {
            numbers.add(Integer.parseInt(number));
        }

        System.out.println(solution(numbers, k));
    }

    static int solution(List<Integer> numbers, int k) {
        Node root = new Node(numbers.get(0));

        dfsInOrder(root, numbers);

        int answer = -1;


        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Node currentNode;
        int i = 1;

        while(!(queue.isEmpty())) {
            currentNode = queue.poll();
            if (i == k) {
                answer = currentNode.value;
                break;
            }

            i ++;

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }


        return answer;
    }

    static void dfsInOrder(Node currentNode, List<Integer> numbers) {
        if (currentNode == null) {
            currentIndex++;
            return;
        }

        if (currentIndex < numbers.size() && numbers.get(currentIndex) < 0) {
            currentNode.left = new Node(numbers.get(currentIndex) * -1);
            currentIndex++;
        }

        dfsInOrder(currentNode.left, numbers);

        if (currentIndex < numbers.size() && numbers.get(currentIndex) > 0){
            currentNode.right = new Node(numbers.get(currentIndex));
            currentIndex++;
        }

        dfsInOrder(currentNode.right, numbers);
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
