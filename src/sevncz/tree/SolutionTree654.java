package sevncz.tree;

import sevncz.TreeNode;

class SolutionTree654 {
  /**
   * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
   *
   * <p>二叉树的根是数组中的最大元素。 左子树是通过数组中最大值左边部分构造出的最大二叉树。 右子树是通过数组中最大值右边部分构造出的最大二叉树。
   * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
   *
   * <p>
   *
   * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-binary-tree
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return maxTreeNode(nums, 0, nums.length - 1);
  }

  public TreeNode maxTreeNode(int[] nums, int left, int right) {
    if (left > right) {
      return null;
    }

    int maxIndex = maxIndex(nums, left, right);
    TreeNode root = new TreeNode(nums[maxIndex]);
    root.left = maxTreeNode(nums, left, maxIndex - 1);
    root.right = maxTreeNode(nums, maxIndex + 1, right);
    return root;
  }

  public int maxIndex(int[] nums, int left, int right) {
    int maxValue = nums[left];
    int maxIndex = left;
    for (int i = left; i <= right; i++) {
      if (maxValue < nums[i]) {
        maxIndex = i;
        maxValue = nums[i];
      }
    }
    return maxIndex;
  }
}
