package Day_43;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);

        System.out.println(rightSideView(node));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        return bfs(root);
    }

    private static List<Integer> bfs(TreeNode currentNode) {
        Queue<Wrapper> queue = new LinkedList<>();

        Map<Integer, TreeNode> map = new HashMap<>();

        queue.add(new Wrapper(currentNode, 0));

        Wrapper curNode;

        int i = 0;

        while (!queue.isEmpty()) {
            curNode = queue.poll();

            if (!map.containsKey(curNode.level)) {
                map.put(curNode.level, curNode.node);
                i++;
            }

            if (curNode.node.right != null) {
                queue.add(new Wrapper(curNode.node.right, curNode.level + 1));
            }

            if (curNode.node.left != null) {
                queue.add(new Wrapper(curNode.node.left, curNode.level + 1));
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (int j = 0; j < i; j++) {
            answer.add(map.get(j).val);
        }

        return answer;
    }
}

class Wrapper {
    TreeNode node;
    int level;

    public Wrapper(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
