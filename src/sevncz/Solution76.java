package sevncz;

import java.util.HashMap;
import java.util.Map;

class Solution76 {
    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * <p>
     * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 示例 2：
     * <p>
     * 输入：s = "a", t = "a"
     * 输出："a"
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length, t.length <= 105
     * s 和 t 由英文字母组成
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-window-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }


    }
}