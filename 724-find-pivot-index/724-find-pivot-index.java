class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int lsum = 0;
        for(int i = 0; i < nums.length; i++){
            if(lsum * 2 == sum - nums[i]){
                return i;
            }
            lsum += nums[i];
        }
        return -1;
    }
}