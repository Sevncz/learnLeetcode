package sevncz.tree;

import sevncz.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class SolutionTree110 {
  public boolean isBalanced(TreeNode root) {
    // 后序遍历
    return height(root) >= 0;
  }

  public int height(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int left = height(node.left);
    int right = height(node.right);
    if (left >= 0 && right >= 0 && Math.abs(left - right) <= 1) {
      return Math.max(left, right) + 1;
    } else {
      return -1;
    }
  }
}
