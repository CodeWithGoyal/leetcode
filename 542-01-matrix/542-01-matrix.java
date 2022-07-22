class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int dp[][] = new int[row][col];
        for(int arr[] : dp){
            Arrays.fill(arr,1000000);
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(mat[i][j] == 0){
                    dp[i][j] = 0;
                }
                else{
                    if(i > 0){
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1);
                    }
                    if(j > 0){
                        dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+1);
                    }
                }
            }
        }
        for(int i = row -1; i >= 0; i--){
            for(int j = col -1; j >= 0; j--){
                if(i < row -1){
                    dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + 1);
                }
                if(j < col -1){
                    dp[i][j] = Math.min(dp[i][j],dp[i][j+1] + 1);
                }
            }
        }
        return dp;
    }
}