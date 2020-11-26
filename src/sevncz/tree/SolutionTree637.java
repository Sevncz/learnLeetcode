package sevncz.tree;

import sevncz.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SolutionTree637 {
    /**
     * 层次遍历求值
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int index = queue.size();
            Double value = 0.0;
            for (int i = 0; i < index; i++) {
                TreeNode node = queue.poll();
                value += node.val;
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }

            ret.add(value / index);
        }

        return ret;
    }
}