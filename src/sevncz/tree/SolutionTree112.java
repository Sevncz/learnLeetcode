package sevncz.tree;

import sevncz.TreeNode;

class SolutionTree112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        // 叶子节点
        if(root.left == null && root.right == null  ) {
            return sum - root.val == 0;
        }
        boolean l = hasPathSum(root.left, sum - root.val);
        boolean r = hasPathSum(root.right, sum - root.val);
        return l || r;
    }
}