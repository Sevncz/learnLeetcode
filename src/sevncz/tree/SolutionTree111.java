package sevncz.tree;

import sevncz.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionTree111 {
    /**
     * 写出结束条件
     * 不要把树复杂化，就当做树是三个节点，根节点，左子节点，右子节点
     * 只考虑当前做什么，不用考虑下次应该做什么
     * 每次调用应该返回什么
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        if(root.right == null && root.left != null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}