class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][] = new int[k+1][prices.length +1];
        for(int i = 1; i <= k; i++){
            for(int j = 2; j <= prices.length; j++){
                dp[i][j] = dp[i][j-1];
                for(int m = j - 1; m >= 1; m--){
                    if(prices[j - 1] > prices[m-1]){
                        dp[i][j] = Math.max(dp[i][j] , dp[i-1][m] + prices[j - 1] - prices[m - 1]);
                    }
                }
                // System.out.print(dp[i][j] + " ");
            }
            // System.out.println();
        }
        return dp[k][prices.length];
    }
}