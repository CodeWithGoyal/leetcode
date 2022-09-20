class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[][] dp = new int[coins.length +1][amount +1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 100000;
        }
        for(int j = 0; j < dp[0].length; j++){
            dp[0][j] = 100000;
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j == coins[i-1]){
                    dp[i][j] = 1;
                }
                else{
                    if(j > coins[i -1])
                        dp[i][j] = Math.min(dp[i][j - coins[i-1]] + 1,dp[i-1][j]);
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length - 1] < 100000?dp[dp.length-1][dp[0].length - 1]: -1;
    }
   
}