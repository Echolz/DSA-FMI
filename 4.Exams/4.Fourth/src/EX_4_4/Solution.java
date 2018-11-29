package EX_4_4;

import java.util.*;

class Solution {
    static Map<Integer, Integer> map = new TreeMap<>();

    static void count(Node root) {
        Wrapper rot = new Wrapper(root, 0);

        Queue<Wrapper> queu = new LinkedList<>();

        queu.add(rot);

        while (!queu.isEmpty()) {
            rot = queu.poll();

            increaseMap(rot.level);

            if (rot.node.leftNode != null) {
                queu.add(new Wrapper(rot.node.leftNode, rot.level + 1));
            }

            if (rot.node.rightNode != null) {
                queu.add(new Wrapper(rot.node.rightNode, rot.level + 1));
            }
        }

        StringBuilder output = new StringBuilder();

        for (Integer level : map.keySet()) {
            output.append(map.get(level)).append(";");
        }

        output.setLength(output.length() - 1);
        System.out.println(output.toString());
    }

    public static void increaseMap(int level) {
        if (!map.containsKey(level)) {
            map.put(level, 0);
        }

        map.put(level, map.get(level) + 1);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.leftNode, data);
                root.leftNode = cur;
            } else {
                cur = insert(root.rightNode, data);
                root.rightNode = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        count(root);
    }
}

class Wrapper {
    Node node;
    int level;

    public Wrapper(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Node {
    Node leftNode;
    Node rightNode;
    int data;

    Node(int data) {
        this.data = data;
        leftNode = null;
        rightNode = null;
    }
}