package sevncz.dp;

class Solution213_rob {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        // 不抢第一家
        int[] meno1 = new int[nums.length];
        // 第一家放弃
        meno1[0] = 0;
        meno1[1] = nums[1];
        for(int i=2; i<nums.length;i++) {
            meno1[i] = Math.max(meno1[i-1], meno1[i-2] + nums[i]);
        }
        // 不抢最后一家
        int[] meno2 = new int[nums.length];
        meno2[0] = nums[0];
        meno2[1] = Math.max(nums[1], nums[0]);
        for(int i=2; i<nums.length - 1;i++) {
            meno2[i] = Math.max(meno2[i-1], meno2[i-2] + nums[i]);
        }
        // 最后一家不抢，所以length - 2
        return Math.max(meno1[nums.length - 1], meno2[nums.length - 2]);
    }
}