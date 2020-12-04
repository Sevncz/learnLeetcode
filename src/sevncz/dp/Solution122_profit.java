package sevncz.dp;

class Solution122_profit {
    public int maxProfit(int[] prices) {
        if (prices.length==0) {
            return 0;
        }
        int cash = 0;
        int hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, prices[i] + hold);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}