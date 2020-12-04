package sevncz.dp;

class Solution714_profit {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length==0 || prices.length==1) {
            return 0;
        }
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}