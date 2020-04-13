package Day_86;


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

public class Solution {

  public static void main(String[] args) {
    TreeNode tn = new TreeNode(1);
    tn.left = new TreeNode(2);


    System.out.println(diameterOfBinaryTree(tn));
  }

  static int ans = 0;

  public static int diameterOfBinaryTree(TreeNode root) {
    ans = 0;

    if (root == null) {
      return ans;
    }

    dfs(root);

    return ans;
  }

  private static int dfs(TreeNode currentNode) {
    if (isLeaf(currentNode)) {
      return 1;
    }

    int leftDist = 0;
    if (currentNode.left != null) {
      leftDist = dfs(currentNode.left);
    }

    int rightDist = 0;
    if (currentNode.right != null) {
      rightDist = dfs(currentNode.right);
    }

    ans = Integer.max(ans, leftDist + rightDist);


    return Integer.max(leftDist, rightDist) + 1;
  }

  private static boolean isLeaf(TreeNode currentNode) {
    return currentNode.left == null && currentNode.right == null;
  }
}
