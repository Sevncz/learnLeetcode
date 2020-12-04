package sevncz.dp;

class Solution123_profit {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE;
        int cash1 = 0;
        int hold2 = Integer.MIN_VALUE;
        int cash2 = 0;

        for(int p : prices) {
            // 第一次这里买入永远都是-p，所以不是cash-p
            hold1 = Math.max(hold1, -p);
            cash1 = Math.max(cash1, hold1 + p);
            hold2 = Math.max(hold2, cash1 - p);
            cash2 = Math.max(cash2, hold2 + p);
        }
        return cash2;
    }
}