package sevncz.tree;

import sevncz.ListNode;
import sevncz.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SolutionTree_0403 {
    /**
     * 层次遍历
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> listNodes = new LinkedList<ListNode>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        while (!queue.isEmpty()) {
            int index = queue.size();
            ListNode listNode = new ListNode(0);
            ListNode curr = listNode;
            for (int i = 0; i < index; i++) {
                TreeNode node = queue.poll();
                curr.next = new ListNode(node.val);
                curr = curr.next;
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            listNodes.add(listNode.next);
        }

        return listNodes.toArray(new ListNode[0]);
    }
}