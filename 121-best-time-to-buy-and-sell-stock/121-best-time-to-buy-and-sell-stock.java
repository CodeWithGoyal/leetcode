class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] maxToRight = new int[n];
        maxToRight[n-1] = prices[n-1];
        int max = prices[n-1];
        for(int i = n-2; i >= 0; i--){
            max = Math.max(max, prices[i]);
            maxToRight[i] = max;
        }
        int profit = 0;
        for(int i = 0; i < n; i++){
            profit = Math.max(profit, maxToRight[i] - prices[i]);
        }
        return profit;
    }
}