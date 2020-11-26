package sevncz.tree;

import sevncz.Node;

import java.util.*;

class SolutionTree589 {
    private List<Integer> ret = new ArrayList<>();

    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if (root==null) {
            return ret;
        }
        ret.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }
        return ret;
    }

    /**
     * stack
     * @param root
     * @return
     */
    public List<Integer> preorder_stack(Node root) {
        if (root==null) {
            return ret;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ret.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return ret;
    }
}