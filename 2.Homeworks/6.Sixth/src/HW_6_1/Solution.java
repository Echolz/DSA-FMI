package HW_6_1;

public class Solution {

    public static int height(Node root) {
        return dfs(root, 0);
    }

    public static int dfs(Node currentNode, int level) {
        if (currentNode == null) {
            return level;
        }

        int leftSubtree = dfs(currentNode.left, level + 1);
        int rightSubtree = dfs(currentNode.right, level + 1);

        return Math.max(leftSubtree, rightSubtree);
    }
}

class Node {
    int data;
    Node left;
    Node right;
}
