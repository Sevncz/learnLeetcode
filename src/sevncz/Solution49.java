package sevncz;

import java.util.*;

class Solution49 {
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * <p>
     * 示例:
     * <p>
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * 说明：
     * <p>
     * 所有输入均为小写字母。
     * 不考虑答案输出的顺序。
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/group-anagrams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            List<String> subResult = null;
            if(!used[i]) {
                subResult = new ArrayList<>();
                subResult.add(s);
                for (int j = i + 1; j < strs.length; j++) {
                    String s1 = strs[j];
                    if (isAnagrams(s, s1)) {
                        used[j] = true;
                        subResult.add(s1);
                    }
                }
            }
            if (subResult != null) {
                result.add(subResult);
            }
        }

        return result;
    }

    public boolean isAnagrams(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            if (map.get(ch)==null) {
                return false;
            }
            if (map.get(ch) > 1) {
                map.put(ch, map.get(ch) - 1);
            } else {
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }
}