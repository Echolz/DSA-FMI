package Day_54;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer, Stack<TreeNode>> map = new HashMap<>();

        dfs(root, 0, map);

        return findMax(map);
    }

    private int findMax(Map<Integer, Stack<TreeNode>> map) {
        int max = 0;

        for (Integer integer : map.keySet()) {
            Stack<TreeNode> stack = map.get(integer);

            while (!stack.isEmpty() && stack.peek() == null) {
                stack.pop();
            }

            max = Integer.max(max, stack.size());
        }

        return max;
    }

    public static void dfs(TreeNode currentNode, int currentLevel, Map<Integer, Stack<TreeNode>> map) {
        if (!map.containsKey(currentLevel)) {
            map.put(currentLevel, new Stack<>());
        }

        map.get(currentLevel).add(currentNode);

        if (currentNode == null) {
            return;
        }

        dfs(currentNode.left, currentLevel + 1, map);
        dfs(currentNode.right, currentLevel + 1, map);
    }
}