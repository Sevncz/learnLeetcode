package sevncz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_18_foursum {
    /**
     * 给定一个包含n 个整数的数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c和 d，使得a + b + c + d的值与target相等？找出所有满足条件且不重复的四元组。
     * <p>
     * 注意：
     * <p>
     * 答案中不可以包含重复的四元组。
     * <p>
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/4sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums==null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            while (i > 0 && i < nums.length - 3 && nums[i]==nums[i - 1]) {
                i++;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                while (j > i+1 && j < nums.length - 2 && nums[j]==nums[j - 1]) {
                    j++;
                }
                int m = j + 1;
                int n = nums.length - 1;
                while (m < n) {
                    int t = (nums[i] + nums[j] + nums[m] + nums[n]) - target;
                    if (t > 0) {
                        n--;
                    } else if (t < 0) {
                        m++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        while(m<n && nums[m] == nums[m+1]){
                            m++;
                        }
                        while(m<n && nums[n] == nums[n-1]){
                            n--;
                        }
                        m++;
                        n--;
                    }
                }
            }
        }
        return res;
    }
}