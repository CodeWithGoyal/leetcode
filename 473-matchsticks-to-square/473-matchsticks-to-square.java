class Solution {
    public boolean makesquare(int[] matchsticks) {
        long sum = 0l;
        for(int i : matchsticks) sum += i;
        Arrays.sort(matchsticks);
        if(sum % 4 != 0) return false;
        long arr[] = new long[4];
        Arrays.fill(arr,sum/4);
        return solve(arr,matchsticks,matchsticks.length - 1);
    }
    boolean solve(long arr[], int nums[], int j){
        if(j < 0) return true;
        for(int i = 0; i < 4; i++){
            if(nums[j] <= arr[i]){
                arr[i] -= nums[j];
                if(solve(arr,nums,j-1)) return true;
                arr[i] += nums[j];
            }
        }
        return false;
    }
}