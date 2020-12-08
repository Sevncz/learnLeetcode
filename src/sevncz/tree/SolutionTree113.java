package sevncz.tree;

import sevncz.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class SolutionTree113 {
  private List<List<Integer>> res = new ArrayList<>();
  private LinkedList<Integer> list = new LinkedList<>();

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    dfs(root, sum);
    return res;
  }

  public void dfs(TreeNode node, int sum) {
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null && sum - node.val == 0) {
      // 加入路径
      list.offer(node.val);
      // 复制一个新的
      res.add(new LinkedList<>(list));
      // 恢复现场
      list.removeLast();
    }
    // 记录路径
    list.offer(node.val);
    dfs(node.left, sum - node.val);
    dfs(node.right, sum - node.val);
    // 清理现场
    list.removeLast();
  }
}
