package sevncz.tree;

import sevncz.TreeNode;

class SolutionTree437 {
  private int count = 0;

  public int pathSum(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }
    // 双重递归
    dfs(root, sum);
    pathSum(root.left, sum);
    pathSum(root.right, sum);
    return count;
  }

  public void dfs(TreeNode node, int sum) {
    if (node == null) {
      return;
    }
    if (sum - node.val == 0) {
      count++;
    }
    dfs(node.left, sum - node.val);
    dfs(node.right, sum - node.val);
  }
}
