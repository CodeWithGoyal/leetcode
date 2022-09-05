class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if(n < 3) return ans;
        for(int i = 0; i < n; i++){
            int j = i+1; 
            int k = n - 1;
            if(i ==0 || nums[i] != nums[i-1] ){
                while(j < k){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum < 0) j++;
                    else if(sum > 0) k--;
                    else{
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[i]);
                        ans.add(temp);
                        while(j < k && nums[k - 1] == nums[k]) k--;
                        while(j < k && nums[j + 1] == nums[j]) j++;
                        j++;
                        k--;
                    }
                }
            }
            
        }
        return ans;
    }
}