package sevncz.tree;

import sevncz.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class SolutionTree107 {
  /**
   * 自底向下
   *
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    // 这里用链表结构存储，从头部插入即可
    LinkedList<List<Integer>> ret = new LinkedList<>();
    if (root == null) {
      return ret;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int index = queue.size();
      List<Integer> valueList = new ArrayList<>();
      for (int i = 0; i < index; i++) {
        TreeNode node = queue.poll();
        valueList.add(node.val);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      ret.offerFirst(valueList);
    }
    return ret;
  }
}
