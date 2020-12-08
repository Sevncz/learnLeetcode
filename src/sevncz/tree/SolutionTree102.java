package sevncz.tree;

import sevncz.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SolutionTree102 {
  /**
   * 广度优先遍历
   *
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
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
      res.add(valueList);
    }

    return res;
  }
}
