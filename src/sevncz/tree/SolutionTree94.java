package sevncz.tree;

import sevncz.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class SolutionTree94 {
  private List<Integer> ret = new LinkedList<>();

  /**
   * 中序遍历 递归
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) {
      return ret;
    }
    inorderTraversal(root.left);
    ret.add(root.val);
    inorderTraversal(root.right);
    return ret;
  }

  /**
   * 迭代
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal_loop(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        ret.add(root.val);
        root = root.right;
      }
    }

    return ret;
  }
}
