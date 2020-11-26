package sevncz.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution22 {

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：n = 3
     * 输出：[
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/generate-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @description 回溯算法
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, n, n, "");
        return result;
    }

    public void dfs(List<String> res, int left, int right, String path) {
        if(left == 0 && right == 0) {
            res.add(path);
            return;
        }
        if(left > 0) {
            dfs(res, left-1, right, path + "(");
        }
        if(left < right) {
            dfs(res, left, right-1, path + ")");
        }
    }
}