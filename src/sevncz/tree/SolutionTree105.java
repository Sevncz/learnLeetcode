package sevncz.tree;

import sevncz.TreeNode;

import java.util.Arrays;
import java.util.TreeMap;

class SolutionTree105 {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[0]);
    if (preorder.length == 1) {
      return root;
    }
    int index = -1;
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == preorder[0]) {
        index = i;
        break;
      }
    }
    root.left =
        buildTree(
            Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
    root.right =
        buildTree(
            Arrays.copyOfRange(preorder, index + 1, preorder.length),
            Arrays.copyOfRange(inorder, index + 1, inorder.length));
    return root;
  }

  public static void main(String[] args) {
    int[] a1 = new int[] {3, 9, 20, 15, 7};
    int[] a2 = new int[] {9, 3, 15, 20, 7};
    new SolutionTree105().buildTree(a1, a2);
  }
}
