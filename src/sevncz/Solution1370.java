package sevncz;

import java.util.Arrays;

class Solution1370 {

    public String sortString(String s) {
        if ("".equals(s) || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int[] counter = new int[26];
        for (char c : chars) {
            counter[c - 'a']++;
        }
        //存储计算的结果
        char[] res = new char[s.length()];
        int count = 0;
        while (count < chars.length) {
            for (int i = 0; i < counter.length; i++) {
                if (counter[i] > 0) {
                    res[count] = (char) (i + 'a');
                    counter[i]--;
                    count++;
                }
            }
            for (int i = counter.length - 1; i >= 0; i--) {
                if (counter[i] > 0) {
                    res[count] = (char) (i + 'a');
                    counter[i]--;
                    count++;
                }
            }
        }
        return new String(res);
    }
}