package sevncz.tree;

import sevncz.TreeNode;

import java.util.ArrayList;
import java.util.List;

class SolutionTree897 {
  List<TreeNode> list = new ArrayList<>();

  public TreeNode increasingBST(TreeNode root) {
    bstTree(root);
    TreeNode ret = new TreeNode();
    TreeNode dummy = ret;
    for (TreeNode node : list) {
      dummy.right = new TreeNode(node.val);
      dummy = dummy.right;
    }
    return ret.right;
  }

  private void bstTree(TreeNode node) {
    if (node == null) {
      return;
    }
    bstTree(node.left);
    list.add(node);
    bstTree(node.right);
  }
}
