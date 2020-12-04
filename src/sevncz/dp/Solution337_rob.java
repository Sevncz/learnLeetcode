package sevncz.dp;

import sevncz.TreeNode;


class Solution337_rob {
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    public int[] helper(TreeNode node) {
        int[] money = new int[2];
        if (node==null) {
            return money;
        }
        int[] leftMoney = helper(node.left);
        int[] rightMoney = helper(node.right);
        // 不偷根节点，那么就可以偷儿子节点，这里就是【偷左儿子】和【不偷左儿子】的最大值 + 【偷右儿子】和【不偷右儿子】的最大值
        money[0] = Math.max(leftMoney[0], leftMoney[1]) + Math.max(rightMoney[0], rightMoney[1]);
        // 偷根节点，偷左儿子+偷右儿子+根节点本身之和
        money[1] = node.val + leftMoney[0] + rightMoney[0];
        return money;
    }
}