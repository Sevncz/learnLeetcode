package sevncz.tree;

import sevncz.TreeNode;

class SolutionTree104 {
    /**
     * 分治算法
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private int maxDepth = 0;
    /**
     * 深度优先
     * @param root
     * @return
     */
    public int maxDepth_dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        dfs(root, 0);
        return maxDepth;
    }

    public void dfs(TreeNode node, int level) {
        if(node == null) {
            return;
        }
        if(maxDepth < level + 1) {
            maxDepth = level + 1;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}