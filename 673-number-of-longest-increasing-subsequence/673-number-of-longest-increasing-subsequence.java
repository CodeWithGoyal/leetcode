class Solution {
    public int findNumberOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int count[] = new int[nums.length];
        count[0] = 1;
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < nums.length; i++){
            int m = -1;
            for(int j = i -1; j >= 0; j--){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    m = Math.max(m,dp[j]);
                }
            }
            dp[i] = Math.max(dp[i],1);
            max = Math.max(dp[i],max);
            if(m + 1 == dp[i]){
                int c = 0;
                for(int j = i - 1; j >= 0; j--){
                    if(nums[j] < nums[i] && dp[j] == m){
                        c += count[j];
                    }
                }
                count[i] = c;
            }
            else{
                count[i] = 1;
            }
        }
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(dp[i] == max){
                ans += count[i];
            }
        }
        System.out.println(max);
        return ans;
    }
}