class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[] {-1,-1};
        }
        int left = 0;
        int right = nums.length -1;
        int mid = (left + right)/2;
        int res[] = new int[2];
        while(left <= right){
            mid = (left + right)/2;
            if(nums[mid] == target){
                break;
            }
            if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        if(nums[mid] != target){
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        right = mid;
        while(left <= right){
            int m = (left + right) / 2;
            if(nums[m] == target){
                right = m -1;
            }
            else{
                left = m + 1;
            }
        }
        res[0] = right + 1;
        left = mid;
        right = nums.length -1;
        while(left <= right){
            int m = (left + right) / 2;
            if(nums[m] == target){
                left = m + 1;
            }
            else{
                right = m -1;
            }
        }
        res[1] = left - 1;
        return res;
    }
}