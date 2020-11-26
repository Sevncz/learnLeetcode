package sevncz.dp;

class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length==0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int numsOf0 = 0;
            int numsOf1 = 0;
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j)=='0') {
                    numsOf0++;
                } else {
                    numsOf1++;
                }
            }
            for (int j = m; j >= numsOf0; j--) {
                for (int k = n; k >= numsOf1; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - numsOf0][k - numsOf1] + 1);
                }
            }
        }
        return dp[m][n];
    }


    public int findMaxForm_0(String[] strs, int m, int n) {
        if (strs.length==0 || m==0 || n==0) {
            return 0;
        }

        return tryFindMax(strs, strs.length - 1, m, n);
    }

    private int tryFindMax(String[] strs, int i, int m, int n) {
        if (i < 0) {
            return 0;
        }
        int numsOf0 = 0;
        int numsOf1 = 0;
        String str = strs[i];
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j)=='0') {
                numsOf0++;
            } else {
                numsOf1++;
            }
        }
        if (m >= numsOf0 && n >= numsOf1) {
            return Math.max(tryFindMax(strs, i - 1, m, n), tryFindMax(strs, i - 1, m - numsOf0, n - numsOf1) + 1);
        } else {
            return tryFindMax(strs, i - 1, m, n);
        }
    }

}