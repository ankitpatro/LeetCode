class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minBuyPrice = prices[0];

        int n = prices.length;

        for(int i = 1; i < n; i++) {
            profit = Math.max(profit, prices[i] - minBuyPrice);
            minBuyPrice = Math.min(minBuyPrice, prices[i]);
        }

        return profit;
    }
}
