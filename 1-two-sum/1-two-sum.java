class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans  = new int[2];
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(mp.containsKey(target - nums[i])){
                ans[0] = mp.get(target - nums[i]);
                ans[1] = i;
            }
            else{
                mp.put(nums[i], i);
            }
        }
        return ans;
    }
}