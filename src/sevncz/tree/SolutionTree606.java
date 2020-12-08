package sevncz.tree;

import sevncz.TreeNode;

class SolutionTree606 {
  private StringBuilder sb = new StringBuilder();

  public String tree2str(TreeNode t) {
    before(t);
    return sb.toString();
  }

  public void before(TreeNode node) {
    if (node == null) {
      return;
    }
    sb.append(node.val);
    if (node.left != null || node.right != null) {
      sb.append("(");
      before(node.left);
      sb.append(")");
      if (node.right != null) {
        sb.append("(");
        before(node.right);
        sb.append(")");
      }
    }
  }
}
