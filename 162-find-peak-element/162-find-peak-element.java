class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int left = 0, right = nums.length -1;
        while(left <= right){
            int mid = (left + right)/2;
            int l = mid == 0?Integer.MIN_VALUE:nums[mid-1];
            int r = mid == nums.length -1?Integer.MIN_VALUE:nums[mid+1];
            if(nums[mid] > l && nums[mid] > r){
                return mid;
            }
            else if(nums[mid] < r){
                left = mid + 1;
            }
            else{
                right = mid -1;
            }
        }
        return -1;
    }
}