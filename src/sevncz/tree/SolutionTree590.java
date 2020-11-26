package sevncz.tree;

import sevncz.Node;

import java.util.ArrayList;
import java.util.List;

class SolutionTree590 {
    private List<Integer> ret = new ArrayList<>();
    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        if(root == null) {
            return ret;
        }
        if(root.children != null && !root.children.isEmpty()) {
            for (Node child : root.children) {
                postorder(child);
            }
        }
        ret.add(root.val);
        return ret;
    }
}